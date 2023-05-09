camera,ball,lite
let float range

Start Graphics3D(640,480,0,2)

let camera = CreateCamera()
set MoveEntity(camera,0,0,-3)

let ball = CreateSphere()

let lite = CreateLight(2) ;// try different lights 1 to 3
set MoveEntity(lite,5,0,-5)
PointEntity(lite,ball)

let range = 0.5
set LightRange(lite,range)

While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
If KeyHit(KEY_SPACEBAR) Then Do ;// hit SPACEBAR to increase light range
let range = range + 0.5
set LightRange(lite,range)
EndIf
Wend
