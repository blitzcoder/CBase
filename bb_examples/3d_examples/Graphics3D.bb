;// Graphics3D Example
;// ------------------

;// Set 3D graphics mode
Start Graphics3D(640,480,0,2)

SetBuffer BackBuffer()

let int camera=CreateCamera()
let int light=CreateLight()

let int cone=CreateCone( 32 )
set PositionEntity(cone,0,0,5)

While Not KeyEnd(KEY_ESC)
RenderWorld
Flip
Wend
