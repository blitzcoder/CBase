;// CopyMesh Example
;// ----------------

camera,light,crate1,crate2

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let crate1=LoadMesh("media/wood-crate/wcrate1.b3d")
set PositionEntity(crate1,-40,0,100)

let crate2=CopyMesh(crate1)
set PositionEntity(crate2,40,0,100)

While Not KeyEnd(KEY_ESC)

TurnEntity(crate1,1,1,1)
TurnEntity(crate2,1,1,-1)

RenderWorld
Flip

Wend
