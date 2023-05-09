;// INSERT example

;// Define a CHAIR type with a created field to track what order it was created  in.
Type CHAIR as
Field int created
EndType chair

;// Create a linked list room of chair type
set list(room,chair)

Start

;// Create 10 chairs, setting created field to the order of creation
;// We offset to 11 since list index starts at 0
float t
For (t in 1 To 11) 
new(room)
obj(room).created = t
Next

;// Make a NEW chair (the 11th) 
chair newroom

;// Set its created value to 11
let newroom.created = 11

;// Now, let's insert this chair BEFORE the first one in the collection
set first(room) ; insert(room,newroom)

;//set delete(room)

For(key(room) in 0 to each(room))
Print(obj(room).created)	
Next

End
