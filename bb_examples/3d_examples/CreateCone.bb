;// CreateCone Example
;// ------------------

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let int camera=CreateCamera()

let int light=CreateLight()
set RotateEntity(light,90,0,0)

;// Create cone
let int cone=CreateCone()

set PositionEntity(cone,0,0,5)

While Not KeyEnd( KEY_F2 )
RenderWorld
Flip
Wend
