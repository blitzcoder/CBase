;// CameraPick Example
;// ------------------

camera,light,plane,ground_tex,cube,cube_tex

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,2,-10)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let plane=CreatePlane()
set EntityPickMode(plane,2 );// Make the plane entity 'pickable'. Use pick_geometry  mode no.2 for polygon collision.
let ground_tex=LoadTexture("media/Chorme-2.bmp")
set ScaleTexture(ground_tex,-.00001,.00001)
EntityTexture(plane,ground_tex)

let cube=CreateCube()
set EntityPickMode(cube,2 );// Make the cube entity 'pickable'. Use pick_geometry mode  no.2 for polygon collision.
let cube_tex=LoadTexture("media/b3dlogo.jpg")
set EntityTexture(cube,cube_tex)
PositionEntity(cube,0,1,0)

While Not KeyEnd(KEY_ESC)

If KeyDown( KEY_RIGHT )==True Then TurnEntity(camera,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(camera,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(camera,0,0,-0.05)
If KeyDown( KEY_UP )==True Then MoveEntity(camera,0,0,0.05)

;// If Left(mouse button hit then use CameraPick(with mouse coordinates))
;// In this example, only three things can be picked; the plane, the cube, or  nothing
If MouseHit(1)==True Then CameraPick(camera,MouseX,MouseY)

set RenderWorld

Text(0,0,"Use cursor keys to move about")
Text(0,20,"Press left mouse button to use CameraPick with mouse coordinates")
Text(0,40,"PickedX: ",PickedX)
Text(0,60,"PickedY: ",PickedY)
Text(0,80,"PickedZ: ",PickedZ)
Text(0,100,"PickedNX: ",PickedNX)
Text(0,120,"PickedNY: ",PickedNY)
Text(0,140,"PickedNZ: ",PickedNZ)
Text(0,160,"PickedTime: ",PickedTime)
Text(0,180,"PickedEntity: ",PickedEntity)
Text(0,200,"PickedSurface: ",PickedSurface)
Text(0,220,"PickedTriangle: ",PickedTriangle)

Flip

Wend
