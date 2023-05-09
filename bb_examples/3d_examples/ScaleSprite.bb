cam,sp
let float size

Start Graphics3D(640,480,0,2)

let cam = CreateCamera()
set MoveEntity(cam,0,0,-5)

let sp = CreateSprite()

let size = 1.0
While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
ScaleSprite(sp,size,size)
let size = size + 0.01
Wend
