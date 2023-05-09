;// AddMesh Example
;// ---------------

camera,light,tree,trunk,green_br,brown_br

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,0,0,-10)

let light=CreateLight()
set RotateEntity(light,90,0,0)

;// Create tree mesh (Upper(half))
let tree=CreateCone()
let green_br=CreateBrush(0,255,0)
set PaintMesh(tree,green_br)
ScaleMesh(tree,2,2,2)
PositionMesh(tree,0,1.5,0)

;// Create trunk mesh
let trunk=CreateCylinder()
let brown_br=CreateBrush(128,64,0)
set PaintMesh(trunk,brown_br)
PositionMesh(trunk,0,-1.5,0)

;// Add trunk mesh to tree mesh, to form one whole tree
AddMesh(trunk,tree)

;// Free trunk mesh - we don't need it anymore
FreeEntity(trunk)

While Not KeyEnd(KEY_ESC)

TurnEntity(tree,1,1,1)

RenderWorld
Flip

Wend
