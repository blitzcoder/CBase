;// PositionMesh Example
;// --------------------
 
;// In this example we will demonstrate the use of the PositionMesh command.

;// Unlike PositionEntity, PositionMesh actually modifies the actual mesh structure.

;// So whereas using PositionEntity 0,0,1 would only move an entity by one unit the first time it was 
;// used, PositionMesh 0,0,1 will move the mesh by one unit every time it is used.

;// This is because PositionEntity positions an entity based on a fixed mesh structure, whereas 
;// PositionMesh actually modifies the mesh structure itself.

camera,light,cube
let string syntax = ""

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
 
;// Create cube mesh
let cube=CreateCube()

;// Position cube in front of camera so we can see it 
set PositionEntity(cube,0,0,5)
 
While Not KeyEnd(KEY_ESC)

	;// If space bar pressed then position mesh 1 unit along the z axis. Also set syntax Text.
	If KeyHit(KEY_SPACEBAR)==True Then Do PositionMesh(cube,0,0,1) ; syntax="PositionMesh 0,0,1" EndIf

	RenderWorld
	
	Text(0,0,"Press space to position the mesh 1 unit along the z axis")
	Text(0,20,syntax)
	
	Flip

Wend
