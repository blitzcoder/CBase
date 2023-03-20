;// BrushTexture Example
;// --------------------
camera,light,cube

Start Graphics3D(640,480,0,2)

camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load texture
let int tex=LoadTexture("b3dlogo.jpg")

;// Create brush
let int brush=CreateBrush()

;// Apply texture to brush
set BrushTexture(brush,tex)

;// Paint mesh with brush
set PaintMesh(cube,brush)

While Not KeyEnd(KEY_ESC)

let float pitch=0
let float yaw=0
let float roll=0

;// Change movement values depending on the key pressed
If KeyDown(KEY_DOWN)==True Then pitch=-1
If KeyDown(KEY_UP)==True Then pitch=1	
If KeyDown(KEY_LEFT)==True Then yaw=-1
If KeyDown(KEY_RIGHT)==True Then yaw=1
If KeyDown(KEY_Z)==True Then roll=-1
If KeyDown(KEY_X)==True Then roll=1
	
set TurnEntity(cube,pitch,yaw,roll)

RenderWorld
Flip

Wend
