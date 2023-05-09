;// CameraFogRange Example
;// ----------------------

camera,light,plane,grass_tex,fog_range

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,1,0)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let plane=CreatePlane()
let grass_tex=LoadTexture( "media/mossyground.bmp" )
set EntityTexture(plane,grass_tex)
ScaleTexture(grass_tex,.00001,-.00001)

;// Set camera fog to 1 (linear fog)
CameraFogMode(camera,1)

;// Set intial fog range value
let fog_range=10

While Not KeyEnd(KEY_ESC)

;// If square brackets keys pressed then change fog range value
If KeyDown( KEY_LSQUAREBRACKET )==True Then fog_range=fog_range-1
If KeyDown( KEY_RSQUAREBRACKET )==True Then fog_range=fog_range+1

;// Set camera fog range
CameraFogRange(camera,1,fog_range)

If KeyDown( KEY_RIGHT )==True Then TurnEntity(camera,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(camera,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(camera,0,0,-0.05)
If KeyDown( KEY_UP )==True Then MoveEntity(camera,0,0,0.05)

RenderWorld

Text(0,0,"Use cursor keys to move about the infinite plane")
Text(0,20,"Press [ or ] to change CameraFogRange value")
Text(0,40,"CameraFogRange camera,1,",fog_range)

Flip

Wend
