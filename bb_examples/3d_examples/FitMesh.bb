;// FitMesh Example
;// ---------------

;// In this example we will demonstrate the use of the FitMesh(command.)

;// First we will use FitMesh(on a semi-transparent blue box. This will represent the dimensions we will)
;// be using with FitMesh(.)

;// Then we will use these dimensions on a red cone, so that it appears to fit inside the box when the 
;// space bar is pressed.

;// The first time the space bar is pressed a uniform FitMesh(will be performed, which means the cone )
;// will be scaled equally along all axis so that at least one axis fits the dimensions specified.

;// The second time the space bar is pressed a non-unifrom FitMesh(will be performed, meaning the cone )
;// will be scaled non-equally along all axes so that all axes fit the dimensions specified.

camera,light,cube,cone,uniform
let string syntax = ""

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

;// Create cube
let cube=CreateCube()

;// Set cube colour to blue
set EntityColor(cube,0,0,255)

;// Make cube semi-transparent so we will be able to see cone inside it later
EntityAlpha(cube,0.5)

;// Use FitMesh(on cube to make it a cuboid)
FitMesh(cube,-1,-.5,-1,2,1,2)

;// Position cube in front of camera so we can see it
PositionEntity(cube,0,-1,5)

;// Create cone
let cone=CreateCone()

;// Set cone Color(to red)
set EntityColor(cone,255,0,0)

;// Position cone in front of camera so we can see it 
PositionEntity(cone,0,-1,5)

;// Set uniform value to 1 so when space is first pressed, FitMesh(will be uniform)
let uniform=1

While Not KeyEnd(KEY_ESC)

	;// If space bar pressed....
	If KeyHit(KEY_SPACEBAR)==True Then Do
	
		;// Set syntax string to show syntax useage
		let syntax=str("FitMesh cone,-1,-.5,-1,2,1,2,",uniform)
		
		;// Use FitMesh(with cone, using same values as used with cube earlier. Cone should now fit in cube.)
		FitMesh(cone,-1,-.5,-1,2,1,2,uniform)
		
		;// Change uniform value from 1 to 0 so when space bar is pressed again FitMesh(will be non-uniform )
		let uniform=0

	EndIf

	RenderWorld

	Text(0,0,"Press space to use uniform FitMesh with cone")
	Text(0,20,"Press space again to use non-uniform FitMesh with cone")
	Text(0,40,syntax)
	
	Flip

Wend
