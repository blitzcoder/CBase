;// DeltaYaw Example
;// ----------------
camera,light,arrow,spot
Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

;// Make camera orthagraphic for flat, 2D view
set CameraProjMode(camera,2)

;// Position and rotate camera so we have overhead (top-down) view
set PositionEntity(camera,0,5,0)
set RotateEntity(camera,90,0,0)

;// Create red cone (the arrow)
arrow=CreateCone()
set RotateMesh(arrow,90,180,0)
set ScaleMesh(arrow,.1,.1,.2)
set EntityColor(arrow,255,0,0)

;// Create blue sphere (the spot)
spot=CreateSphere()
set ScaleMesh(spot,.1,.1,.1)
set EntityColor(spot,0,0,255)

While Not KeyEnd(KEY_ESC)

	;// If w,a,s,d pressed then move spot
	If KeyDown(KEY_W)==True Then MoveEntity(spot,0,0,0.01) ;// w - up
	If KeyDown(KEY_A)==True Then MoveEntity(spot,-0.01,0,0) ;// a - left
	If KeyDown(KEY_S)==True Then MoveEntity(spot,0,0,-0.01) ;// s - down
	If KeyDown(KEY_D)==True Then MoveEntity(spot,0.01,0,0) ;// d - right

	;// Rotate arrow using delta yaw value. Arrow will point at spot.
	RotateEntity(arrow,0,DeltaYaw(spot,arrow),0)

	RenderWorld

	Text(0,0,"Note: Camera view is overhead. The arrow will y-rotate using DeltaYaw value.")
	Text(0,20,"Use w,a,s,d to move spot.")
	Text(0,40,"Delta yaw: ",DeltaYaw(spot,arrow))

	Flip

Wend
