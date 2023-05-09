Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let int mesh = CreateMesh()
let int surf = CreateSurface(mesh)

let int v0 = AddVertex (surf, -5,-5,0,  0  ,0)
let int v1 = AddVertex (surf,  5,-5,0,  1  ,0)
let int v2 = AddVertex (surf,  0, 5,0,  0.5,1)

let int tri = AddTriangle (surf,v0,v2,v1)

let int cam = CreateCamera()
set MoveEntity(cam, 0,0,-7)

RenderWorld
Flip

While Not KeyEnd(KEY_ESC)
Wend
