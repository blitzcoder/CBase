;// MeshHeight Example
;// -----------------

cone

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

;// Create camera
let int camera=CreateCamera()

let int light=CreateLight()

let cone=CreateCone()
set PositionEntity(cone,0,0,5)

;// Double the height
ScaleMesh(cone,1,2,1)

While Not KeyEnd(KEY_ESC)
RenderWorld
Text(0,0,"Mesh Width : ",MeshWidth(cone))
Text(0,20,"Mesh Height: ",MeshHeight(cone))
Text(0,40,"Mesh Depth : ",MeshDepth(cone))
Flip
Wend
