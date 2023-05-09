;// PositionTexture Example
;// -----------------------

camera,light,cube,tex
let float u_position,v_position

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let cube=CreateCube()
set PositionEntity(cube,0,0,5)

;// Load texture
let tex=LoadTexture( "media/b3dlogo.jpg" )

;// Texture cube
set EntityTexture(cube,tex)

;// Set initial uv position values
let u_position=1
let v_position=1

While Not KeyEnd(KEY_ESC)

;// Change uv position values depending on key pressed
If KeyDown( KEY_DOWN )==True Then u_position=u_position-0.01 
If KeyDown( KEY_UP )==True Then u_position=u_position+0.01 
If KeyDown( KEY_LEFT )==True Then v_position=v_position-0.01 
If KeyDown( KEY_RIGHT )==True Then v_position=v_position+0.01 

;// Position texture
set PositionTexture(tex,u_position,v_position )

TurnEntity(cube,0.1,0.1,0.1)

RenderWorld

Text(0,0,"Use cursor keys to change uv position values")
Text(0,20,"u_position=",u_position)
Text(0,40,"v_position=",v_position)

set Flip

Wend
