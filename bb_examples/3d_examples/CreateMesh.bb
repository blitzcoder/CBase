;// CreateMesh Example
;// ------------------

;// In this example, we will create a custom mesh. This custom mesh will be in the shape of a ramp.

camera,light,ramp,surf,v0,v1,v2,v3,v4,v5,t0,t1,t2,t3,t4,t5,t6,t7

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,45,0,0)

;// Create blank mesh
let ramp=CreateMesh()

;// Create blank surface which is attached to mesh (surfaces must always be attached to a mesh)
let surf=CreateSurface(ramp)

;// Now we have our blank mesh and surface, we can start adding vertices to it, to form the shape of our
;// ramp.
;// Vertices are invisible 'points' in a 3D object that we can attach triangles too later.
;// To create a single triangle, you need three vertices, one for each corner.
;// However, you can share vertices between triangles, so you do not always need 3 new vertices per
;// triangle.
;// In the case of our ramp mesh, we will require 6 vertices, one for each corner

let v0=AddVertex(surf,0,0,0) ;// bottom corner 1
let v1=AddVertex(surf,0,0,1) ;// bottom corner 2
let v2=AddVertex(surf,4,0,1) ;// bottom corner 3
let v3=AddVertex(surf,4,0,0) ;// bottom corner 4
let v4=AddVertex(surf,0,2,0) ;// top corner 1
let v5=AddVertex(surf,0,2,1) ;// top corner 2 

;// Having created our blank mesh and surface, and added our vertices to form the shape of the mesh, we
;// now need to add triangles to it in order to make it solid and visible to the user. We create
;// triangles simply by connecting vertices up, very much like a 3D dot-to-dot.

;// When adding triangles, we need to remember that they are only one sided, and the side they are
;// visible from is determined by the order in which we specify the vertices when using AddTriangle(.)
;// If the vertices, in the order that they are specified, are aligned in a clockwise fashion relative 
;// to the camera then they will appear visible, otherwise they won't. 
;// So, to make our ramp visible from the outside, we will be connecting all vertices in a clockwise
;// fashion, relative to the camera.

let t0=AddTriangle(surf,v0,v3,v2) ;// bottom triangle 1
let t1=AddTriangle(surf,v0,v2,v1) ;// bottom triangle 2
let t2=AddTriangle(surf,v0,v4,v3) ;// front triangle
let t3=AddTriangle(surf,v1,v2,v5) ;// back triangle
let t4=AddTriangle(surf,v0,v1,v5) ;// side triangle 1
let t5=AddTriangle(surf,v0,v5,v4) ;// side triangle 2
let t6=AddTriangle(surf,v2,v4,v5) ;// top triangle 1
let t7=AddTriangle(surf,v2,v3,v4) ;// top triangle 2

;// Now we will position our ramp in front of the camera so we can see it!
set PositionEntity(ramp,0,-4,10)

;// Enable Wireframe(mode so we can see structure of model more clearly)
Wireframe(True)

;// And a quick loop that renders the scene and displays the contents on the screen until we press esc
While Not KeyEnd(KEY_ESC)

;// Constantly turn our ramp entity to show it off a bit
TurnEntity(ramp,0,1,0)

RenderWorld
Flip

Wend

;// The end!
