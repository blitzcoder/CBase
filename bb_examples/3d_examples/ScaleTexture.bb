;// ScaleTexture Example
;// --------------------

camera,light,cube,tex
let float u_scale,v_scale

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

;// Set initial uv scale values
let u_scale=1
let v_scale=1

While Not KeyEnd(KEY_ESC)

;// Change uv scale values depending on key pressed
If KeyDown( KEY_DOWN )==True Then u_scale=u_scale-0.01 
If KeyDown( KEY_UP )==True Then u_scale=u_scale+0.01 
If KeyDown( KEY_LEFT )==True Then v_scale=v_scale-0.01 
If KeyDown( KEY_RIGHT )==True Then v_scale=v_scale+0.01 

;// Scale texture
ScaleTexture(tex,u_scale,v_scale )

TurnEntity(cube,0.1,0.1,0.1)

RenderWorld

Text(0,0,"Use cursor keys to change uv scale values")
Text(0,20,"u_scale=",u_scale)
Text(0,40,"v_scale=",v_scale)

Flip

Wend
