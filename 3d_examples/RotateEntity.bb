;// RotateEntity Example
;// --------------------
camera,light,cone
let float pitch,yaw,roll
Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

camera=CreateCamera()
let light=CreateLight()

let cone=CreateCone( 32 )
set PositionEntity(cone,0,0,5)

set EntityTexture(cone,LoadTexture("arrow.png"))

While Not KeyEnd(KEY_ESC)

;// Change rotation values depending on the key pressed
If KeyDown(KEY_DOWN)==True Then pitch=pitch-1
If KeyDown(KEY_UP)==True Then pitch=pitch+1
If KeyDown(KEY_LEFT)==True Then yaw=yaw-1
If KeyDown(KEY_RIGHT)==True Then yaw=yaw+1
If KeyDown(KEY_X)==True Then roll=roll-1
If KeyDown(KEY_Z)==True Then roll=roll+1

;// Rotate cone using rotation values
RotateEntity(cone,pitch,yaw,roll)

RenderWorld

Text(0,0,"Use cursor/Z/X keys to change cone rotation") 
Text(0,20,"Pitch: ", pitch , " " , EntityPitch(cone))
Text(0,40,"Yaw : ",yaw , " " , EntityYaw(cone))
Text(0,60,"Roll : ",roll , " " , EntityRoll(cone))

Flip

Wend
