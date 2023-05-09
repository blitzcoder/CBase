;// TrisRendered Example
;// --------------------

camera,light,segs,sphere

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,0,-2)

let light=CreateLight()
set RotateEntity(light,90,0,0)

let segs=Rand( 2,16 )
let sphere=CreateSphere(segs)

set MoveEntity(sphere,2,0,0)


While Not KeyEnd(KEY_ESC)

If KeyHit( KEY_SPACEBAR )==True Then Do

FreeEntity(sphere)
let segs=Rand( 2,16 )
let sphere=CreateSphere( segs )
set MoveEntity(sphere,2,0,0)
EndIf

RenderWorld

Text(0,0,"Press space to create a sphere with a random segments value")

;// Display triangles rendered
Text(0,20,"Triangles Rendered: ",TrisRendered)

Flip

Wend
