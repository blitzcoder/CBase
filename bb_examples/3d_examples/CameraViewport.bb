;// CameraViewport Example
;// ----------------------

cam1,cam2,light,plane,grass_tex

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

;// Create second camera
let cam2=CreateCamera()

;// Set the second camera's viewport so that it fills the bottom half of the  camera
set CameraViewport(cam2,0,GraphicsHeight/2,GraphicsWidth,GraphicsHeight/2)

;// Create first camera
let cam1=CreateCamera()

;// Set the first camera's viewport so that it fills the top half of the  camera
set CameraViewport(cam1,0,0,GraphicsWidth,GraphicsHeight/2)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let plane=CreatePlane()
let grass_tex=LoadTexture( "media/mossyground.bmp" )
set ScaleTexture(grass_tex,-.00001,.00001)
set EntityTexture(plane,grass_tex)
PositionEntity(plane,0,-1,0)

While Not KeyEnd(KEY_ESC)

If KeyDown( KEY_RIGHT )==True Then TurnEntity(cam1,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(cam1,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(cam1,0,0,-0.05)
If KeyDown( KEY_UP )==True Then MoveEntity(cam1,0,0,0.05)

set RenderWorld

Text(0,0,"Use cursor keys to move the first camera about the infinite plane")

Flip

Wend
