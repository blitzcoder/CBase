;// Wireframe Example
;// -----------------

camera,light,sphere,enable

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()

let light=CreateLight()
set RotateEntity(light,90,0,0)

let sphere=CreateSphere( 32 )
set PositionEntity(sphere,0,0,2)

While Not KeyEnd(KEY_ESC)

;// Toggle Wireframe(enable value between true and false when spacebar is pressed)
If KeyHit( KEY_SPACEBAR )==True Then enable=1-enable

;// Enable/disable Wireframe(rendering)
Wireframe(enable)

RenderWorld

Text(0,0,"Press spacebar to toggle between Wireframe True/False")
If enable==True Then Do Text(0,20,"Wireframe True") ElseDo Text(0,20,"Wireframe False") EndIf

Flip

Wend
