// ScaleEntity Example 
// ------------------- 

#define True 1

BASIC(

int camera,light,cone;
float x_scale,y_scale,z_scale;

function MAIN app
	Graphics3D(640,480,0,2);
	
	camera = CreateCamera(0);
	light = CreateLight(1,0);

	cone=CreateCone(32,1,0);
	PositionEntity(cone,0,0,5,0);	

	// Set scale values so that cone is default size to begin with
	x_scale=1;
	y_scale=1;
	z_scale=1;

	SetUpdateRate(60);
end

function Render event
	if KeyHit(KEY_ESC) do
		End();
	end;

	// Change scale values depending on the key pressed
	if KeyDown(KEY_LEFT)==True then x_scale=x_scale-0.1;
	if KeyDown(KEY_RIGHT)==True then x_scale=x_scale+0.1;
	if KeyDown(KEY_DOWN)==True then y_scale=y_scale-0.1;
	if KeyDown(KEY_UP)==True then y_scale=y_scale+0.1;
	if KeyDown(KEY_Z)==True then z_scale=z_scale-0.1;
	if KeyDown(KEY_A)==True then z_scale=z_scale+0.1;
	
	// Scale cone using scale values
	ScaleEntity(cone,x_scale,y_scale,z_scale,0);

	RenderWorld();

	Text(10,20,"Use cursor/A/Z keys to scale cone");
	FormatString(TextBuffer,"X Scale: %3.2f",x_scale);
	Text(10,40,TextBuffer);
	FormatString(TextBuffer,"Y Scale: %3.2f",y_scale);
	Text(10,60,TextBuffer);	
	FormatString(TextBuffer,"Z Scale: %3.2f",z_scale);
	Text(10,80,TextBuffer);	
	
	Flip(); 	
end 

)
