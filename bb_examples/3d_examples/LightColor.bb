camera,ball,lite

Start Graphics3D(640,480,0,2)

let camera = CreateCamera()
set MoveEntity(camera,0,0,-3)

let ball = CreateSphere()

let lite = CreateLight() ;// try different lights 1 to 3
set MoveEntity(lite,5,0,-15)
PointEntity(lite,ball)


While Not KeyEnd(KEY_ESC)
RenderWorld;Flip
If KeyHit(KEY_SPACEBAR) Then LightColor(lite,Rnd(255),Rnd(255),Rnd(255) );// press SPACEBAR to try different light colors
Wend
