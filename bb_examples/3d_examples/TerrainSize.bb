;// TerrainSize Example
;// -------------------

camera,light,terrain,grass_tex
let float x,y,z,terra_y

Start Graphics3D(640,480,0,2)
SetBuffer BackBuffer()

let camera=CreateCamera()
set PositionEntity(camera,1,1,1)
RotateEntity(camera,0,0,0)

let light=CreateLight()
set RotateEntity(light,90,0,0)

;// Load terrain
let terrain=LoadTerrain( "media/height_map.bmp" )
set RotateEntity(terrain,0,90,0)

;// Set terrain detail, enable vertex morphing
;//set TerrainDetail(terrain,4000,True)

;// Scale terrain
//ScaleEntity(terrain,1,50,1)

;// Texture terrain
let grass_tex=LoadTexture( "media/mossyground.bmp" )
set EntityTexture(terrain,grass_tex,0,1)
ScaleTexture(grass_tex,10,10)

While Not KeyEnd(KEY_ESC)

If KeyDown( KEY_LEFT )==True Then x=x-0.1
If KeyDown( KEY_RIGHT )==True Then x=x+0.1
If KeyDown( KEY_DOWN )==True Then y=y-0.1
If KeyDown( KEY_UP )==True Then y=y+0.1
If KeyDown( KEY_Z )==True Then z=z-0.1
If KeyDown( KEY_X )==True Then z=z+0.1

If KeyDown( KEY_RIGHT )==True Then TurnEntity(camera,0,-1,0)
If KeyDown( KEY_LEFT )==True Then TurnEntity(camera,0,1,0)
If KeyDown( KEY_DOWN )==True Then MoveEntity(camera,0,0,-1)
If KeyDown( KEY_UP )==True Then MoveEntity(camera,0,0,1)

let x=EntityX(camera)
let y=EntityY(camera)
let z=EntityZ(camera)

let terra_y=TerrainY(terrain,x,y,z)

set PositionEntity(camera,x,terra_y+5,z)

RenderWorld

Text(0,0,"Use cursor keys to move about the terrain")

;// Output terrain size to screen
Text(0,20,"Terrain Size: ",TerrainSize(terrain))

Flip

Wend
