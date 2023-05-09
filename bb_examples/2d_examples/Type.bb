;// Define the CHAIR Type

Type CHAIR as
Field int x
Field int y
Field int height
EndType chair

;// Create a linked list room of chair type
set list(room,chair)

Start

;// Create 100 new chairs using FOR ... NEXT using the collection name of ROOM 

int tempx,tempy
For (tempx In 1 To 6) ;// We offset to 6 since list index starts at 0
For (tempy In 1 To 6) ;// We offset to 6 since list index starts at 0
new(room)
let obj(room).x = tempx
let obj(room).y = tempy
let obj(room).height = Rnd(0,10) ;// set a random height 0 to 10
Next
Next 

;// Move them all over 1 (like the description example) 

For(key(room) in 0 to each(room))
let obj(room).x = obj(room).x + 1
let Print(obj(room).x)	
Next

End
