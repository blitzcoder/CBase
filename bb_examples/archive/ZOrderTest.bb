;// code by Beaker 2002 - please credit prominently (or arrange otherwise)
;// beaks@playerfactory.co.uk

;// Alpha Z-Ordering Test Code

c,p,y,b,m,s

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let b = CreateBrush()
set BrushFX(b,1+2+16+32)

let m = CreateMesh()
let s = CreateSurface(m,b)

let float size = 5.0
let float hsize = size/2.0

let int i
For (i in 0 To 1000)
	let int x = Rnd(-50,50)
	let int z = Rnd(-50,50)
	
	let int a = Rand(0,3)*90
	let int xx = Sin(a)*hsize
	let int zz = Cos(a)*hsize
	
	let int v0 = AddVertex(s,x-xx,0,z-zz)
		set VertexColor(s,v0,Rand(128,255),Rand(128,255),Rand(128,255),Rnd(0,1))
	let int v1 = AddVertex(s,x-xx,size,z-zz)
		set VertexColor(s,v1,Rand(128,255),Rand(128,255),Rand(128,255),Rnd(0,1))
	let int v2 = AddVertex(s,x+xx,size,z+zz)
		set VertexColor(s,v2,Rand(128,255),Rand(128,255),Rand(128,255),Rnd(0,1))
	let int v3 = AddVertex(s,x+xx,0,z+zz)
		set VertexColor(s,v3,Rand(128,255),Rand(128,255),Rand(128,255),Rnd(0,1))
		
	let AddTriangle(s,v0,v1,v2)
	let AddTriangle(s,v2,v3,v0)
Next

let c = CreateCamera()
let p = 0
let y = 0

set MoveMouse(320,240)

While Not KeyEnd(KEY_ESC)
	
	let p = p+MouseYSpeed
	let y = y-MouseXSpeed
	set RotateEntity(c,p,y,0)
	MoveEntity(c,KeyDown(KEY_RIGHT)-KeyDown(KEY_LEFT),0,KeyDown(KEY_UP)-KeyDown(KEY_DOWN))
	
	MoveMouse(320,240)

	RenderWorld
	Flip
	
Wend
