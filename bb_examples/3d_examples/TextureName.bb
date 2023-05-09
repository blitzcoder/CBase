;// TextureName Example
;// -------------------

camera,light,crate,surf,crate_brush,crate_tex
let string texname

;// StripPath function declaration, see function body below
Function string StripPath(string file)

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

;// Load mesh
let crate=LoadMesh("media/wood-crate/wcrate1.b3d")
set PositionEntity(crate,0,0,100)

;// Get mesh surface
let surf=GetSurface(crate,1)

;// Get surface brush
let crate_brush=GetSurfaceBrush(surf)

;// Get brush texture
let crate_tex=GetBrushTexture(crate_brush,0)

While Not KeyEnd(KEY_ESC)

	RenderWorld

	;// Display full texture name
	Text(0,0,"Texture name, as returned by TextureName():")
	Text(0,20,TextureName(crate_tex))

	let texname = StripPath((string)TextureName(crate_tex))

	;// Display trimmed texture name
	Text(0,40,"Texture name with path stripped:")
	Text(0,60,texname)

	Flip

Wend

Function string StripPath(string file) Do

	let string name = ""
	
	If Len(file) > 0  Then Do

		For (i in Len(file) To 1 Step -1) 

			let string mi=Mid(file,i,1)			 			
			If equal(mi,"\\") Or equal(mi,"/") Then Do Return(name) ElseDo name = str(mi,name) EndIf
		
		Next 
	
	EndIf 
	
	Return(name)

EndFunction
