;// EntityColor Example
;// -------------------

cube,light,camera,red,green,blue

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Set initial entity Color(values)
let red=255
let green=255
let blue=255

While Not KeyEnd(KEY_ESC)

;// Change red, green, blue values depending on key pressed
If KeyDown( KEY_1 )==True And red>0 Then red=red-1
If KeyDown( KEY_2 )==True And red<255 Then red=red+1
If KeyDown( KEY_3 )==True And green>0 Then green=green-1
If KeyDown( KEY_4 )==True And green<255 Then green=green+1
If KeyDown( KEY_5 )==True And blue>0 Then blue=blue-1
If KeyDown( KEY_6 )==True And blue<255 Then blue=blue+1

;// Set entity Color(using red, green, blue values)
EntityColor(cube,red,green,blue)

TurnEntity(cube,0.1,0.1,0.1)

RenderWorld

Text(0,0,"Press keys 1-6 to change EntityColor red,green,blue values")
Text(0,20,"Entity Red: ",red)
Text(0,40,"Entity Green: ",green)
Text(0,60,"Entity Blue: ",blue)

Flip

Wend
