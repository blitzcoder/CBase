;// EntityClass Example
;// -------------------

ent

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

SeedRnd(Millisecs)

;// Select a random number between 0 and 7 then create a certain class of entity depending on the number selected
let int i=Rand(0,7)
Select i On
	Case 0 is ent=CreatePivot();
	Case 1 is ent=CreateLight();
	Case 2 is ent=CreateCamera();
	Case 3 is ent=CreateCube();
	Case 4 is ent=CreateSprite();
	Case 5 is ent=CreateTerrain(32);
	Case 6 is ent=CreatePlane();
	Case 7 is ent=CreateMesh();
	;//Case 8 ent=CreateListener(parent)
	;//Case 9 ent=LoadMD2(md2_file)
	;//Case 10 ent=LoadBSP(bsp_file)
EndSelect

;// Get the class of the entity
let string class = strdup(EntityClass(ent))

set RenderWorld
;// Output the class to the screen
Text(0,0,"A ",class," was created.")
Text(0,20,"Press a key.")
Flip
While Not KeyEnd(KEY_ESC)
Wend
