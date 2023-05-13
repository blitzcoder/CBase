;// NameEntity Example
;// ------------------

midh,midw,camera,light,box,box2,ball

Start Graphics3D(640,480,0,2)

let midh=GraphicsHeight/2
let midw=GraphicsWidth/2

set SetBuffer BackBuffer()

let camera=CreateCamera()
set CameraClsColor(camera,50,40,50)
MoveEntity(camera,3,0,-10)
let light=CreateLight(2)

let box=CreateCube() ; EntityColor(box,155,0,0 );// red
let box2=CreateCube() ; EntityColor(box2,0,144,0 );// green
let ball=CreateSphere() ;EntityColor(ball,255,255,0 );// yellow

NameEntity(box," a RED box ")
NameEntity(box2," a GREEN box ")
NameEntity(ball," a small YELLOW ball ")

EntityRadius(ball,1)

EntityPickMode(box,3)
EntityPickMode(box2,3)
EntityPickMode(ball,1)

MoveEntity(box,0,3,0)
MoveEntity(box2,3,0,0)
MoveEntity(ball,6,2,0)

While Not KeyEnd(KEY_ESC)
let int mx=MouseX
let int my=MouseY	
let int picked=CameraPick(camera,mx,my)

set TurnEntity(box,0,3,0)
TurnEntity(box2,1,0,1)

TurnEntity(ball,0,1,0)
MoveEntity(ball,0,0,.1)

RenderWorld
If picked>0 Then Do
Color(0,0,255)
Text(mx,my-25,"you are picking")
Text(mx,my-12,EntityName(picked))
EndIf

Flip

Wend
