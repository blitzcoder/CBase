;// ProjectedX Example
;// ------------------

camera,light,plane,ground_tex,cube,cube_tex

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,2,-10)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let plane=CreatePlane()
let ground_tex=LoadTexture("media/Chorme-2.bmp")
set EntityTexture(plane,ground_tex)
ScaleTexture(ground_tex,.00001,-.00001)

let cube=CreateCube()
let cube_tex=LoadTexture("media/b3dlogo.jpg")
set EntityTexture(cube,cube_tex)
PositionEntity(cube,0,1,0)

While Not KeyEnd(KEY_ESC)

If KeyDown( KEY_RIGHT )==True Then TurnEntity(camera,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(camera,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(camera,0,0,-0.05)
If KeyDown( KEY_UP )==True Then MoveEntity(camera,0,0,0.05)

;// Use camera project to get 2D coordinates from 3D coordinates of cube
CameraProject(camera,EntityX(cube),EntityY(cube),EntityZ(cube))

RenderWorld

;// If cube is in view then draw text, if not then draw nothing otherwise text  will be drawn at 0,0
If EntityInView(cube,camera) Then Do

;// Use ProjectedX() and ProjectedY() to get 2D coordinates from when CameraProject  was used.
;// Use these coordinates to draw text at a 2D position, on top of a 3D scene.
Text(ProjectedX,ProjectedY,"Cube" )

EndIf

Text(0,0,"Use cursor keys to move about")
Text(0,20,"ProjectedX: ",ProjectedX)
Text(0,40,"ProjectedY: ",ProjectedY)
Text(0,60,"ProjectedZ: ",ProjectedZ)
Text(0,80,"EntityInView: ",EntityInView(cube,camera))

Flip

Wend
