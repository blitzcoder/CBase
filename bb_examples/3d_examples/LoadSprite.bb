campivot

Start Graphics3D(640,480,0,2)

let campivot = CreatePivot()
let int cam = CreateCamera(campivot)
set MoveEntity(cam,0,0,-5)

let int sp = LoadSprite("media/grass.bmp")
set SpriteViewMode(sp,4)

While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
TurnEntity(campivot,1,1,3)
Wend
