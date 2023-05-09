camera,flat,lite

Start Graphics3D(640,480,0,2)

let camera = CreateCamera()
set MoveEntity(camera,0,0,-40)

;//let flat = CreatePlane(10)
let flat = CreateSphere(16)
set TurnEntity(flat,-90,0,0)
ScaleMesh(flat,10,10,10)

let lite = CreateLight(3) ;// try different lights 1 to 3
set MoveEntity(lite,0,0,-15)

While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
If KeyHit(KEY_SPACEBAR) Then Do ;// press SPACEBAR to randomly change the 'cone' of light
LightConeAngles(lite, Rand(120),Rand(120))
EndIf
Wend
