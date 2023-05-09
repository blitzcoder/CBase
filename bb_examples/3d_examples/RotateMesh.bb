;// RotateMesh Example
;// ------------------
 
;// In this example we will demonstrate the use of the RotateMesh command.

;// Unlike RotateEntity, RotateMesh actually modifies the actual mesh structure.

;// So whereas using RotateEntity 0,45,0 would only rotate an entity by 45 degrees the first time it was 
;// used, RotateMesh 0,45,0 will rotate the mesh every time it is used.

;// This is because RotateEntity rotates an entity based on a fixed mesh structure, whereas RotateMesh
;// actually modifies the mesh structure itself.

camera,light,cube
let string syntax = ""

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()
 
let camera=CreateCamera()
 
let light=CreateLight()

;// Rotate light to give better lighting of cube
set RotateEntity(light,60,30,0)

;// Create cube mesh
let cube=CreateCube()

;// Position cube in front of camera so we can see it 
set PositionEntity(cube,0,0,5)
 
While Not KeyEnd(KEY_ESC)

	;// If space bar pressed then rotate mesh by 45 degrees on the y axis. Also set syntax Text(.)
	If KeyHit(KEY_SPACEBAR)==True Then Do RotateMesh(cube,0,45,0) ; let syntax="RotateMesh 0,45,0" EndIf

	RenderWorld
	
	Text(0,0,"Press space to rotate mesh by 45 degrees on the y axis")
	Text(0,20,syntax)
	
	Flip

Wend
