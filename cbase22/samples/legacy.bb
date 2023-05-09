
#include "helper.bb"

InitB3D // Start BASIC

	//Place Globals here
	x = 10;
	
	Start Game // Main 
	//Local variables starts here

	Graphics3D(640,480,0,2);
	
	camera = CreateCamera(0);

	light = CreateLight(1,0);
	RotateEntity(light,90,0,0,0);

	// Create cube 
	cube = CreateCube(0);

	PositionEntity(cube,0,0,5,0);
	SetUpdateRate(60);
	
EndB3D // End Main

While Not Exit	// Render event

	if KeyHit(KEY_ESC) Then
		End
	endif
	RenderWorld
	Flip 		

Wend // End Render


	

