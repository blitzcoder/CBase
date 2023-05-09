;// PointEntity Example
;// -------------------

camera,light,cube

Start Graphics3D(640,480,0,2)
	
let camera=CreateCamera(0)
set RotateEntity(camera,-45,0,0)

let light=CreateLight()
set RotateEntity(light,45,45,0)

let cube=CreateCube(0)
set PositionEntity(cube,0,0,5)
	
While Not KeyEnd(KEY_ESC)

If KeyHit(KEY_SPACEBAR) Then PointEntity(camera,cube)
If KeyHit(KEY_ENTER) Then PointEntity(camera,cube,30)

RenderWorld

Text(0,0,"Press spacebar for PointEntity")
Text(0,20,"Press enter for PointEntity with 30 Degree Roll")

Flip
Wend
