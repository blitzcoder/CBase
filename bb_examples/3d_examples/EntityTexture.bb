;// EntityTexture Example
;// ---------------------

camera,light,cube,tex
let float pitch,yaw,roll

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load texture
let tex=LoadTexture( "media/b3dlogo.jpg" )

;// Texture entity
set EntityTexture(cube,tex)

While Not KeyEnd(KEY_ESC)

let pitch=0
let yaw=0
let roll=0

If KeyDown(KEY_DOWN)==True Then pitch=-1
If KeyDown(KEY_UP)==True Then pitch=1   
If KeyDown(KEY_LEFT)==True Then yaw=-1
If KeyDown(KEY_RIGHT)==True Then yaw=1
If KeyDown(KEY_X)==True Then roll=-1
If KeyDown(KEY_Z)==True Then roll=1

set TurnEntity(cube,pitch,yaw,roll)

RenderWorld
Flip

Wend
