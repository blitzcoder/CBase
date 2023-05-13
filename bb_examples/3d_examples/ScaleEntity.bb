;// ScaleEntity Example
;// -------------------

camera,light,cone
let float x_scale,y_scale,z_scale

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

let cone=CreateCone( 32 )
set PositionEntity(cone,0,0,5)

;// Set scale values so that cone is default size to begin with
let x_scale=1
let y_scale=1
let z_scale=1

While Not KeyEnd(KEY_ESC)

;// Change scale values depending on the key pressed
If KeyDown( KEY_LEFT )==True Then x_scale=x_scale-0.1
If KeyDown( KEY_RIGHT )==True Then x_scale=x_scale+0.1
If KeyDown( KEY_DOWN )==True Then y_scale=y_scale-0.1
If KeyDown( KEY_UP )==True Then y_scale=y_scale+0.1
If KeyDown( KEY_Z )==True Then z_scale=z_scale-0.1
If KeyDown( KEY_X )==True Then z_scale=z_scale+0.1

;// Scale cone using scale values
ScaleEntity(cone,x_scale,y_scale,z_scale)

RenderWorld

Text(0,0,"Use cursor/A/Z keys to scale cone")
Text(0,20,"X Scale: ",x_scale)
Text(0,40,"Y Scale: ",y_scale)
Text(0,60,"Z Scale: ",z_scale)

Flip

Wend
