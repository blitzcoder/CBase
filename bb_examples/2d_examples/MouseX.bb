Start Graphics3D(640,480,0,2)

SetBuffer BackBuffer()

let int camera = CreateCamera()

While Not KeyEnd(KEY_ESC)

If MouseDown(1) Or MouseDown(2) Then MoveMouse(320,240)

RenderWorld

Text(0,0,"Mouse X:",MouseX)
Text(0,20,"Mouse Y:",MouseY)
Text(320,0,"Click to reset mouse")

Text(MouseX,MouseY,"X")

Flip

Wend
