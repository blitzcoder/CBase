;// TextureWidth and TextureHeight Example
;// --------------------------------------

Start Graphics3D(640,480,0,2)

;// This bit of code creates 4 textures 
;// of different sizes and shapes.

let int texture1=CreateTexture(256,256,59) 
let int texture2=CreateTexture(256,128,59) 
let int texture3=CreateTexture(128,256,59) 
let int texture4=CreateTexture(200,200,59)

;// The following lines print the selected value
;// of the texture, and reports the actual texture
;// resolution.


Print("Texture 1 was created at 256x256")
Print("On your system the dimensions are ",TextureWidth(texture1),"x",TextureHeight(texture1))
Print()
Print("Texture 2 was created at 256x128")
Print("On your system the dimensions are ",TextureWidth(texture2),"x",TextureHeight(texture2))
Print()
Print("Texture 3 was created at 128x256")
Print("On your system the dimensions are ",TextureWidth(texture3),"x",TextureHeight(texture3))
Print()
Print("Texture 4 was created at 200x200")
Print("On your system the dimensions are ",TextureWidth(texture4),"x",TextureHeight(texture4))

RenderWorld;Flip
While Not KeyEnd(KEY_ESC)
Wend
