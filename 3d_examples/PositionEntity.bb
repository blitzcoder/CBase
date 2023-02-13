// PositionEntity Example 
// ------------------- 

#define True 1

BASIC(

int camera,light,cone;
float x,y,z;

function MAIN app
	Graphics3D(640,480,0,2);
	
	camera = CreateCamera(0);
	light = CreateLight(1,0);

	cone=CreateCone(32,1,0);
	PositionEntity(cone,0,0,5,0);	

	// Set position values so that cone is positioned in front of camera, so we  can see it to begin with
	x=0;
	y=0;
	z=10;

	SetUpdateRate(60);
end

function Render event
	if KeyHit(KEY_ESC) do
		End();
	end;

	// Change position values depending on key pressed
	if KeyDown(KEY_LEFT)==True then x=x-0.1;
	if KeyDown(KEY_RIGHT)==True then x=x+0.1;
	if KeyDown(KEY_DOWN)==True then y=y-0.1;
	if KeyDown(KEY_UP)==True then y=y+0.1;
	if KeyDown(KEY_Z)==True then z=z-0.1;
	if KeyDown(KEY_A)==True then z=z+0.1;
	
	// Position cone using position values
	PositionEntity(cone,x,y,z,0);

	RenderWorld();

	Text(10,20,"Use cursor/A/Z keys to change cone position");
	FormatString(TextBuffer,"X Position: %3.2f",x);
	Text(10,40,TextBuffer);
	FormatString(TextBuffer,"Y Position: %3.2f",y);
	Text(10,60,TextBuffer);	
	FormatString(TextBuffer,"Z Position: %3.2f",z);
	Text(10,80,TextBuffer);	
	
	Flip(); 	
end 

)  
