cam,sp
let float handlepos

Start Graphics3D(640,480,0,2)

let cam = CreateCamera()
set MoveEntity(cam,0,0,-5)

let sp = CreateSprite()

let handlepos = 0.0
While Not KeyEnd(KEY_ESC)
RenderWorld
Color(100,100,100)
;//Plot 320,240
Text(320,250,"Handle")
Flip
HandleSprite(sp,handlepos,handlepos)
let handlepos = handlepos + 0.01
Wend
