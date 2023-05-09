;// EntityShininess Example
;// -----------------------

camera,light,sphere
let float shine

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()
let camera=CreateCamera()
;// Set ambient light to a low level, to increase effect of shininess

set AmbientLight(32,32,32)
let light=CreateLight()
set RotateEntity(light,45,45,0)

let sphere=CreateSphere(100)
set EntityColor(sphere,255,0,0)
PositionEntity(sphere,0,0,4)

;// Set initial shine value

let shine=0

While Not KeyEnd(KEY_ESC)
;// Change shine value depending on key pressed

If KeyDown(KEY_1)==True And shine>0 Then shine=shine-0.01
If KeyDown(KEY_2)==True And shine<1 Then shine=shine+0.01

;// Set entity shininess using shine value
EntityShininess(sphere,shine)

RenderWorld

Text(0,0,"Press keys 1-2 to change EntityShininess Setting")
Text(0,20,"Entity Shininess: ",shine)

Flip
Wend
