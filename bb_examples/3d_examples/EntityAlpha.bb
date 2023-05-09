;// EntityAlpha Example
;// -------------------

camera,light,cube,back
let float alpha

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
let back=CreateCube()

set PositionEntity(cube,0,0,5)
PositionEntity(back,0,0,15)
ScaleEntity(back,10,2,1)
EntityColor(back,255,0,0)
;// Set initial entity Color(values)
let alpha=1

While Not KeyEnd(KEY_ESC)

;// Change alpha value depending on key pressed
If alpha<0.01 Then alpha = 0.01
If alpha>1 Then alpha = 1
If KeyDown( KEY_2 )==True And alpha>0 Then alpha=alpha-0.01
If KeyDown( KEY_3 )==True And alpha<1 Then alpha=alpha+0.01
;// Set entity alpha value
EntityAlpha(cube,alpha)


TurnEntity(cube,0.1,0.1,0.1)
TurnEntity(back,1,0,0)

RenderWorld

Text(0,0,"Press keys 1-2 to change EntityAlpha")
Text(0,20,"Entity Alpha: ",alpha)

Flip

Wend
