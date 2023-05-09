;// FreeTexture Example
;// -------------------

camera,light,cube,tex

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load texture
let tex=LoadTexture( "media/b3dlogo.jpg" )

;// Texture cube with texture
set EntityTexture(cube,tex)

While Not KeyEnd(KEY_ESC)

;// If spacebar pressed then free texture
If KeyHit( KEY_SPACEBAR )==True Then FreeTexture(tex)

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

Text(0,0,"Press spacebar to free texture")
Text(0,20,"As you can see this will not affect already textured entities")

Flip

Wend
