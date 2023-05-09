;// LoadAnimTexture Example
;// -----------------------

camera,light,cube,anim_tex,frame

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load anim texture
let anim_tex=LoadAnimTexture( "media/boomstrip.bmp",49,64,64,0,39 )

While Not KeyEnd(KEY_ESC)

;// Cycle through anim frame values. 100 represents Delay(, 39 represents no. of  anim frames)
let frame=Millisecs/100 Mod 39

;// Texture cube with anim texture frame
set EntityTexture(cube,anim_tex,frame)

let float pitch=0
let float yaw=0
let float roll=0

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
