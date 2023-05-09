#define FontHeight() 16

sphere,camera,light1,light2,light3,on1,on2,on3
set Start Graphics3D(800,600,0,2)

AmbientLight(0,0,0)

let sphere=CreateSphere(32)

let camera=CreateCamera()
set PositionEntity(camera,0,0,-3)

;//directional light
let light1=CreateLight( 1 )
set TurnEntity(light1,0,-30,0)
LightColor(light1,255,0,0)
HideEntity(light1)

;//point light
let light2=CreateLight( 2 )
set PositionEntity(light2,5,0,-10)
LightColor(light2,0,255,0)
LightRange(light2,15)
HideEntity(light2)

;//spot light
let light3=CreateLight( 3 )
set PositionEntity(light3,0,0,-10)
LightColor(light3,0,0,255)
LightConeAngles(light3,0,10)
LightRange(light3,15)
HideEntity(light3)

let on1=True
let on2=True
let on3=True

If on1 Then ShowEntity(light1)
If on2 Then ShowEntity(light2)
If on3 Then ShowEntity(light3)

While Not KeyEnd(KEY_ESC)

	If KeyHit(KEY_F1) Then Do
		let on1=NOT on1
		If on1 Then Do ShowEntity(light1) ElseDo HideEntity(light1) EndIf
	EndIf
	If KeyHit(KEY_F2) Then Do
		let on2=NOT on2
		If on2 Then Do ShowEntity(light2) ElseDo HideEntity(light2) EndIf
	EndIf
	If KeyHit(KEY_F3) Then Do
		let on3=NOT on3
		If on3 Then Do ShowEntity(light3) ElseDo HideEntity(light3) EndIf
	EndIf	

	If on3 Then Do
		RotateEntity(light3,Sin(Millisecs*.07)*5,Sin(Millisecs*.05)*5,0)
;//		TurnEntity(light3,0,1,0)
	EndIf

	UpdateWorld()
	RenderWorld
	
	Text(0,FontHeight()*0,"(F1) Light1=",on1)
	Text(0,FontHeight()*1,"(F2) Light2=",on2)
	Text(0,FontHeight()*2,"(F3) Light3=",on3)
	Flip
Wend
