;// FlipMesh Example
;// ----------------

camera,light,sphere,sky_tex

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
let light=CreateLight()

;// Create sphere
let sphere=CreateSphere()

;// Scale sphere
set ScaleEntity(sphere,100,100,100)

;// Texture sphere with sky texture
let sky_tex=LoadTexture("media/sky.bmp")
set EntityTexture(sphere,sky_tex)

;// Flip mesh so we can see the inside of it
FlipMesh(sphere)

Color(0,0,0)

While Not KeyEnd(KEY_ESC)
RenderWorld
Text(0,0,"You are viewing a flipped sphere mesh - makes a great sky!")
Flip
Wend
