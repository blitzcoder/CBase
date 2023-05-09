;// TurnEntity Example
;// ------------------

camera,light,cone
let float pitch,yaw,roll

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

let cone=CreateCube()
set PositionEntity(cone,0,0,5)

While Not KeyEnd(KEY_ESC)

;// Reset turn values - otherwise, the cone will not stop turning!
let pitch=0
let yaw=0
let roll=0

;// Change movement values depending on the key pressed
If KeyDown(KEY_DOWN)==True Then pitch=-1
If KeyDown(KEY_UP)==True Then pitch=1   
If KeyDown(KEY_LEFT)==True Then yaw=-1
If KeyDown(KEY_RIGHT)==True Then yaw=1
If KeyDown(KEY_X)==True Then roll=-1
If KeyDown(KEY_Z)==True Then roll=1

;// Move sphere using movement values
TurnEntity(cone,pitch,yaw,roll)

RenderWorld

Text(0,0,"Use cursor/Z/X keys to turn cone")
Text(0,20,"Pitch: ",pitch)
Text(0,40,"Yaw: ",yaw )
Text(0,60,"Roll: ",roll)

Flip

Wend
