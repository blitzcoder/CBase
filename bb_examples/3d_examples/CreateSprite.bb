Start Graphics3D(640,480,0,2)

let int cam = CreateCamera()
set MoveEntity(cam,0,0,-5)

let int sp = CreateSprite()
set RotateSprite(sp,20)

RenderWorld;Flip
While Not KeyEnd(KEY_ESC)
Wend
