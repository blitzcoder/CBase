;// EntityRadius Example
;// --------------------

camera,light,sphere,cone,type_cone,type_sphere
let float sphere_radius

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

let sphere=CreateSphere( 32 )
set PositionEntity(sphere,-2,0,5)

let cone=CreateCone( 32 )
set EntityType(cone,type_cone)
PositionEntity(cone,2,0,5)

;// Set collision type values
let int type_sphere=1
let int type_cone=2

;// Set sphere radius value
let sphere_radius=1

;// Set sphere and cone entity types
set EntityType(sphere,type_sphere)
EntityType(cone,type_cone)

;// Enable Collisions(between type_sphere and type_cone, with ellipsoid->polygon method and slide response)
Collisions(type_sphere,type_cone,2,2)

While Not KeyEnd(KEY_ESC)

let float x=0
let float y=0
let float z=0

If KeyDown(KEY_LEFT)==True Then x=-0.1
If KeyDown(KEY_RIGHT)==True Then x=0.1
If KeyDown(KEY_DOWN)==True Then y=-0.1
If KeyDown(KEY_UP)==True Then y=0.1   
If KeyDown(KEY_X)==True Then z=-0.1
If KeyDown(KEY_Z)==True Then z=0.1

set MoveEntity(sphere,x,y,z)

;// If square brackets keys pressed then change sphere radius value
If KeyDown( KEY_LSQUAREBRACKET )==True Then sphere_radius=sphere_radius-0.1
If KeyDown( KEY_RSQUAREBRACKET )==True Then sphere_radius=sphere_radius+0.1

;// Set entity radius of sphere
EntityRadius(sphere,sphere_radius)

;// Perform collision checking
UpdateWorld()

RenderWorld

Text(0,0,"Use cursor/A/Z keys to move sphere")
Text(0,20,"Press [ or ] to change EntityRadius radius_x value")
Text(0,40,"EntityRadius sphere,",sphere_radius)

Flip

Wend
