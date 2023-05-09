;// MoveEntity Example
;// ------------------

camera,light,cone
let float x,y,z

Start Graphics3D(800,600,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

let cone=CreateCone( 32 )

;// Move cone in front of camera, so we can see it to begin with
set MoveEntity(cone,0,0,10 )

While Not KeyEnd(KEY_ESC)

;// Reset movement values - otherwise, the cone will not stop!
let x=0
let y=0
let z=0

;// Change rotation values depending on the key pressed
If KeyDown( KEY_LEFT )==True Then x=-0.1
If KeyDown( KEY_RIGHT )==True Then x=0.1
If KeyDown( KEY_DOWN )==True Then y=-0.1
If KeyDown( KEY_UP )==True Then y=0.1
If KeyDown( KEY_Z )==True Then z=-0.1
If KeyDown( KEY_A )==True Then z=0.1

;// Move cone using movement values
MoveEntity(cone,x,y,z)

;// If spacebar pressed then rotate cone by random amount
If KeyHit( KEY_SPACEBAR )==True Then RotateEntity(cone,Rnd( 0,360 ),Rnd( 0,360 ),Rnd(  0,360 ))

RenderWorld

Text(0,0,"Use cursor/A/Z keys to move cone, spacebar to rotate cone by random  amount")
Text(0,20,"X Movement: ",x)
Text(0,40,"Y Movement: ",y)
Text(0,60,"Z Movement: ",z)

Flip

Wend
