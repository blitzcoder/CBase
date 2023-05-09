;// BrushColor Example
;// ------------------

camera,light,cube,brush

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Create brush
let brush=CreateBrush()

;// Set brush Color()
set BrushColor(brush,0,0,255)

;// Paint mesh with brush
PaintMesh(cube,brush)

While Not KeyEnd(KEY_ESC)

let float pitch=0
let float yaw=0
let float roll=0

If KeyDown(KEY_DOWN)==True Then pitch=-1
If KeyDown(KEY_UP)==True Then pitch=1   
If KeyDown(KEY_LEFT)==True Then yaw=-1
If KeyDown(KEY_RIGHT)==True Then yaw=1
If KeyDown(KEY_X)==True Then roll=-1
If KeyDown(KEY_Z)==True Then roll=1

set TurnEntity(cube,pitch,yaw,roll)

RenderWorld
Flip

Wend
