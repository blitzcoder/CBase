# Set file paths
$keywordsPath = "$env:BLASTPATH/bin/keywords.ps1"
$srcPath = $args[0]

# Read keywords into an array
$keywords = Get-Content $keywordsPath

$syntax = "While","Wend","For","If","ElseIf","EndIf","Next","Type","End Type","Function","EndFunction","Field","Include"

$prevline = ""
$defer = $false

# Read source file and replace matching keywords
(Get-Content $srcPath) | ForEach-Object {
	$line = $_  

	# Add let string to variables
	$pattern = '[a-zA-Z_]\w*(\s*\[\s*(\d+|\w+)\s*(,\s*(\d+|\w+)\s*)*\]\s*|\s*\(\s*(\w+\s*,\s*)*\w*\s*\)\s*)?\s*\$\s*=\s*'
	if ($line -match $pattern) {		
		if ($line -notmatch "^\s*($($syntax -join '|'))\b") {
			$line = $line -replace '(^\s*)(\S)', '$1let $2'
		}
	}	

	# Add let float to variables
	$pattern = '[a-zA-Z_]\w*(\s*\[\s*(\d+|\w+)\s*(,\s*(\d+|\w+)\s*)*\]\s*|\s*\(\s*(\w+\s*,\s*)*\w*\s*\)\s*)?\s*#\s*=\s*'
	if ($line -match $pattern) {		
		if ($line -notmatch "^\s*($($syntax -join '|'))\b") {
			$line = $line -replace '(^\s*)(\S)', '$1let $2'
		}
	}

	# Add let int to variables
	$pattern = '^[^$#]*$'
	if ($line -match $pattern) {
		# Add let to variables
		$pattern = '[a-zA-Z_]\w*(\s*\[\s*(\d+|\w+)\s*(,\s*(\d+|\w+)\s*)*\]\s*|\s*\(\s*(\w+\s*,\s*)*\w*\s*\)\s*)?\s*=\s*'
		if ($line -match $pattern) {		
			if ($line -notmatch "^\s*($($syntax -join '|'))\b") {
			$line = $line -replace '(^\s*)(\S)', '$1let $2'
			}
		}		    	
	}

	# This symbol removals should be done first for functions names encoded with # suffix
	# Remove float symbol '#' but not inside double quotes
	#$pattern = '(?<!")#(?![^"]*")'
	$pattern = '(?<!")#(?!")'
	$line = $line -replace $pattern
	# Remove string symbol '$' but not inside double quotes
	$pattern = '(?<!")\$(?!")' 
	$line = $line -replace $pattern	
	# Remove string symbol '%' but not inside double quotes
	$pattern = '(?<!")%(?!")' 
	$line = $line -replace $pattern		

	foreach ($keyword in $keywords) {

		if ($keyword -eq "Text") {
			# Use a different pattern for the "Text" keyword to avoid conflicts with commands like "LoadTexture"
			$pattern = "\b$keyword\b(?!ure\s*\()"
		} else {
			$pattern = "\b$keyword\b"
		}

		if ($line -match "$pattern\s*\((.*?)\)") {
			# If keyword already has parentheses, ignore it usually nested Commands already have braces.
			continue
		} elseif ($line -match $pattern) {
			# Replace matching keyword with modified string
			$line = $line -replace "(?<!""[^""]*)$pattern\s*(.*?)(?=;.*|$)", "$keyword(`$1)"
		}
	}

	# Replace ; with ;//  but not inside double quotes
	$pattern = '(?<!"[^"]*);(?![^"]*")'
	$line = $line -replace $pattern,";//"

	# Replace : chain statements but after the comments above are executed
	$pattern = '(?<!"[^"]*):(?![^"]*")'
	$line = $line -replace $pattern,";"  

	# Keywords that need to stick together
	$line = $line -replace "(?i)Else\s+If", "ElseIf"
	$line = $line -replace "(?i)End\s+Type", "EndType"
	$line = $line -replace "(?i)End\s+Function", "Function"
	$line = $line -replace "^(\s*)Else\s*$", '$1ElseDo'	

	# Add Start if line starts with Graphics3D
	$pattern = '^(?i)Graphics3D'
	if ($line -match $pattern) {
		$line = "Start $line"
		$has3D = $true
	}		

	# Replace the Main Loop terminator with Esc either KeyHit or KeyDown
	$pattern = "While Not KeyDown\s*\(\s*1\s*\)"
	$line = $line -replace $pattern, 'While Not KeyEnd(KEY_ESC)'
	$pattern = "While Not KeyHit\s*\(\s*1\s*\)"
	$line = $line -replace $pattern, 'While Not KeyEnd(KEY_ESC)'


	# Should only remove End if the code has Graphics3D
	if($has3D){
		$line = $line -replace '^End\s*$', ''
	}

	# If Then Do FIXER
	if($line -match "^\s*If\b"){

		if ($line -notmatch "^\s*If\s+\S+\s*(\(\s*\S*\s*\)\s*|)$") {

			# Only if it has no Then
			if ($line -notmatch "\bthen\b") {
				$splitStatement = $line.Trim().Split(" ")
				$lastMatchIndex = $line.LastIndexOf($splitStatement[-1])
				$line = $line.Insert($lastMatchIndex, "Then ")
			}
		
		} else {
			$line = "${line} Then Do"
		}

		# Fix C Style Equal Sign '=='
		# Split the string with the word "Then"
		$parts = $line -split 'Then', 2
		# Apply the replacement only to the first part of the string
		$parts[0] = $parts[0] -replace '(?<![>=<])=(?!=)', '=='
		# Rejoin the parts and print the modified string
		$line = $parts -join 'Then'

	}

	# ElseIf Then Do FIXER
	if($line -match "^\s*ElseIf\b"){
		if ($line -match "^\s*ElseIf\s+\S+\s*(\(\s*\S*\s*\)\s*|)$") {
			$line = "${line} Then Do"
		}

		# Fix C Style Equal Sign '=='
		# Split the string with the word "Then"
		$parts = $line -split 'Then', 2
		# Apply the replacement only to the first part of the string
		$parts[0] = $parts[0] -replace '(?<![>=<])=(?!=)', '=='
		# Rejoin the parts and print the modified string
		$line = $parts -join 'Then'
	}

	# Adding 'set' in function calls
	# Must not start with any syntax that follows equal sign ex. If, For
	if ($line -notmatch "^\s*($($syntax -join '|'))\b") {
		if (!$line.StartsWith(";") -and ![string]::IsNullOrEmpty($line) -and $prevline -match "^\s*let\s+") {
			if($defer -and $line -notmatch "^\s*let\s+") {
				$line = $line -replace '(^\s*)(\S)', '$1set $2'
				$defer = $false
			}	
		} else {
			$defer = $true	
		}
	} else {
		# if it encounters an assignment $defer becomes false
		$defer = $false
	}

	# Load the previous line for the 'set' checker above if it is not empty or starts with a comment
	if (!$line.StartsWith(";") -and ![string]::IsNullOrEmpty($line)){
		$prevline = $line
	}

	Write-Output $line

} 
