;// CameraFogColor Example
;// ----------------------

camera,light,plane,grass_tex,red,green,blue

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,1,0)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let plane=CreatePlane(1,0)
let grass_tex=LoadTexture( "media/mossyground.bmp" )
set EntityTexture(plane,grass_tex)
ScaleTexture(grass_tex, .00001, -.00001)
 
;// Set camera fog to 1 (linear fog)
CameraFogMode(camera,1)

;// Set camera fog range
CameraFogRange(camera,1,10)

;// Set initial fog colour values
let red=0
let green=0
let blue=0

While Not KeyEnd(KEY_ESC)

;// Change red, green, blue values depending on key pressed
If KeyDown( KEY_1 )==True And red>0 Then red=red-1
If KeyDown( KEY_2 )==True And red<255 Then red=red+1
If KeyDown( KEY_3 )==True And green>0 Then green=green-1
If KeyDown( KEY_4 )==True And green<255 Then green=green+1
If KeyDown( KEY_5 )==True And blue>0 Then blue=blue-1
If KeyDown( KEY_6 )==True And blue<255 Then blue=blue+1

;// Set camera fog Color(using red, green, blue values)
CameraFogColor(camera,red,green,blue)

If KeyDown( KEY_RIGHT )==True Then TurnEntity(camera,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(camera,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(camera,0,0,-0.05)
If KeyDown( KEY_UP )==True Then MoveEntity(camera,0,0,0.05)

RenderWorld

Text(0,0,"Use cursor keys to move about the infinite plane")
Text(0,20,"Press keys 1-6 to change CameraFogColor red,green,blue values")
Text(0,40,"Fog Red: ",red)
Text(0,60,"Fog Green: ",green)
Text(0,80,"Fog Blue: ",blue)

Flip

Wend
