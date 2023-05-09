;// RotateTexture Example
;// ---------------------

camera,light,cube,tex
let float angle

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load texture
let tex=LoadTexture( "media/b3dlogo.jpg" )

;// Texture cube
set EntityTexture(cube,tex)

;// Set initial texture angle value
let angle=1

While Not KeyEnd(KEY_ESC)

;// Change texture angle value depending on key pressed
If KeyDown( KEY_RIGHT )==True Then angle=angle-1
If KeyDown( KEY_LEFT )==True Then angle=angle+1 

;// Rotate texture
RotateTexture(tex,angle)

TurnEntity(cube,0.1,0.1,0.1)

RenderWorld

Text(0,0,"Use left and right cursor keys to change texture angle value")
Text(0,20,"angle=",angle)

Flip

Wend
