;// PositionEntity Example
;// ----------------------

camera,light,cone
let float x,y,z

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

let cone=CreateCone( 32 )

;// Set position values so that cone is positioned in front of camera, so we  can see it to begin with
let x=0
let y=0
let z=10

While Not KeyEnd(KEY_ESC)

;// Change position values depending on key pressed
If KeyDown(KEY_LEFT)==True Then x=x-0.1;
If KeyDown(KEY_RIGHT)==True Then x=x+0.1;
If KeyDown(KEY_DOWN)==True Then y=y-0.1;
If KeyDown(KEY_UP)==True Then y=y+0.1;
If KeyDown(KEY_Z)==True Then z=z-0.1;
If KeyDown(KEY_A)==True Then z=z+0.1;

;// Position cone using position values
PositionEntity(cone,x,y,z)

RenderWorld

Text(0,0,"Use cursor/A/Z keys to change cone position")
Text(0,20,"X Position: ",x)
Text(0,40,"Y Position: ",y)
Text(0,60,"Z Position: ",z)

Flip

Wend
