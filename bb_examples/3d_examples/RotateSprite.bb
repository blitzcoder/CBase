cam,sp,ang

Start Graphics3D(640,480,0,2)

let cam = CreateCamera()
set MoveEntity(cam,0,0,-5)

let sp = CreateSprite()

let ang = 0
While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
RotateSprite(sp,ang)
let ang = ang +3
Wend
