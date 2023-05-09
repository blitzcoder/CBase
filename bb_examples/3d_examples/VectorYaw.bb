;// VectorYaw Example
;// -----------------

camera,light,cone,pivot
let float vx,vy,vz

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

;// Set vector x,y,z values
let vx=2
let vy=2
let vz=0

let camera=CreateCamera()
set PositionEntity(camera,0,0,-5)

let light=CreateLight()

let cone=CreateCone()

 set ;// Rotate cone so that it points in the direction it is facing
RotateMesh(cone,90,0,0)

let pivot=CreatePivot()

;// Position pivot to represent a vector
set PositionEntity(pivot,vx,vy,vz)

;// Point cone in direction of pivot. It should now have same yaw value.
PointEntity(cone,pivot)

While Not KeyEnd(KEY_ESC)

	RenderWorld
	
	;// Print entity yaw value and vector yaw value. Both should be identical.
	Text(0,0,"Entity yaw: ",EntityYaw(cone))
	Text(0,20,"Vector yaw: ",VectorYaw(vx,vy,vz))
	
	Flip

Wend
