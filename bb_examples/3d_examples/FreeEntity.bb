;// FreeEntity Example
;// This example creates an entity and
;// allows you to move it, but shows
;// that a handle is no longer valid after
;// FreeEntity(is used on it.)
;// Run in Debug Mode

Cam,Lit,AnEntity

Start Graphics3D(640,480,0,2)
AppTitle "FreeEntity Example"

let Cam = CreateCamera()
let Lit = CreateLight()

set PositionEntity(Lit,-5,-5,0  )
PositionEntity(Cam,0,0,-5   )

let AnEntity = CreateCube()    ;// This is our Test Entity
set RotateMesh(AnEntity,45,45,45)

While Not KeyEnd(KEY_ESC) ;// Until we press ESC

;// Use the Left(or Right(Arrows to Move the Entity))
If KeyDown(KEY_LEFT) Then MoveEntity(AnEntity,-0.1,0,0 )
If KeyDown(KEY_RIGHT) Then MoveEntity(AnEntity,0.1,0,0)

;// Use the Space Key to Free the Entity. It will disappear
;// The next time you try to move it, you will get an error
;// Notice that the Handle Variable doesn't change after the
;// Entity is free. It simply becomes invalid.

If KeyHit(KEY_SPACEBAR) Then FreeEntity(AnEntity );// Hit Space to Free!

set RenderWorld ;// Draw the Scene

;// What is in the AnEntity handle?
Text(10,10,"Entity Handle: ",AnEntity)
Flip ;// Flip it into View
Wend
