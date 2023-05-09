;// CreateCamera Example
;// --------------------

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

;// Create camera
let int camera=CreateCamera()

let int light=CreateLight()

let int cone=CreateCone()
set PositionEntity(cone,0,0,5)

While Not KeyEnd(KEY_ESC)
RenderWorld
Flip
Wend
