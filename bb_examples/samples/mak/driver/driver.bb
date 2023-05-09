let int wheels[5]
let int car,target,camera
let int BODY=1,WHEEL=2,SCENE=3

let float speed
let float GRAVITY=-.01
let float x_vel,y_vel,z_vel
let float prev_x,prev_y,prev_z
let float dx=0,dy=0,dz=0

Start Graphics3D(640,480,0,2)

Collisions(BODY,SCENE,2,3)
Collisions(WHEEL,SCENE,2,3)

let int terr=LoadTerrain( "heightmap_256.png" )
;// set ScaleEntity(terr,1000/TerrainSize(terr),70,1000/TerrainSize(terr))
set ScaleEntity(terr, (1000/256), (256/70), (1000/256));
;// TerrainDetail(terr,1000,True)
;// TerrainShading(terr,True)
;// PositionEntity(terr,-500,0,-500)
PositionEntity(terr, -150, 0, 500)

let int tex=LoadTexture( "terrain-1.jpg" )
set ScaleTexture(tex,50,50)
EntityTexture(terr,tex)
EntityType(terr,SCENE)

let car=LoadMesh( "car.b3d" )
set ScaleMesh(car,1,1,-1)
FlipMesh(car)
FitMesh(car,-1.5,-1,-3,3,2,6)
PositionEntity(car,0,70,0)
EntityShininess(car,1)
EntityType(car,BODY)

let int cnt=1
let float z,x
For(z in 1.5 To -1.5 Step -3)
For(x in -1 To 1 Step 2)
    let wheels[cnt]=CreateSphere( 8,car )
    set EntityAlpha(wheels[cnt],.5)
    ScaleEntity(wheels[cnt],.5,.5,.5)
    EntityRadius(wheels[cnt],.5)
    PositionEntity(wheels[cnt],x,0,z)
    EntityType(wheels[cnt],WHEEL)
    let cnt=cnt+1
Next
Next

let int light=CreateLight()
set TurnEntity(light,45,45,0)

let target=CreatePivot( car )
set PositionEntity(target,0,5,-12)

let camera=CreateCamera()
set CameraClsColor(camera,0,128,255)

let speed=0.001
let x_vel=0,prev_x=EntityX( car )
let y_vel=0,prev_y=EntityY( car )
let z_vel=0,prev_z=EntityZ( car )

While Not KeyEnd(KEY_ESC)

    ;// align car to wheels
    let float zx = 0,zy = 0,zz = 0   
    If speed > 0.002 or !EntityCollided( car,SCENE ) Then Do
    let zx=(EntityX( wheels[2],True )+EntityX( wheels[4],True ))/2
    let zx=zx-(EntityX( wheels[1],True )+EntityX( wheels[3],True ))/2
    let zy=(EntityY( wheels[2],True )+EntityY( wheels[4],True ))/2
    let zy=zy-(EntityY( wheels[1],True )+EntityY( wheels[3],True ))/2
    let zz=(EntityZ( wheels[2],True )+EntityZ( wheels[4],True ))/2
    let zz=zz-(EntityZ( wheels[1],True )+EntityZ( wheels[3],True ))/2
    set AlignToVector(car,zx,zy,zz,1)

    let zx=(EntityX( wheels[1],True )+EntityX( wheels[2],True ))/2
    let zx=zx-(EntityX( wheels[3],True )+EntityX( wheels[4],True ))/2
    let zy=(EntityY( wheels[1],True )+EntityY( wheels[2],True ))/2
    let zy=zy-(EntityY( wheels[3],True )+EntityY( wheels[4],True ))/2
    let zz=(EntityZ( wheels[1],True )+EntityZ( wheels[2],True ))/2
    let zz=zz-(EntityZ( wheels[3],True )+EntityZ( wheels[4],True ))/2
    set AlignToVector(car,zx,zy,zz,3)
    EndIf

    ;// calculate car velocities 
	let float cx = 0,cy = 0,cz = 0
    let cx=EntityX( car,0 ),x_vel=cx-prev_x,prev_x=cx
    let cy=EntityY( car,0 ),y_vel=cy-prev_y,prev_y=cy
    let cz=EntityZ( car,0 ),z_vel=cz-prev_z,prev_z=cz

    ;// resposition wheels
    let int cnt=1
    let float x,z
    For (z in 1.5 To -1.5 Step -3)
    For (x in -1 To 1 Step 2)
;//      PositionEntity(wheels[cnt],0,0,0)
;//      ResetEntity(wheels[cnt])
        PositionEntity(wheels[cnt],x,-1,z)
        let cnt=cnt+1
    Next
    Next    

    ;// move car
    If KeyDown(KEY_LEFT) Then TurnEntity(car,0,3,0)
    If KeyDown(KEY_RIGHT) Then TurnEntity(car,0,-3,0)
    If EntityCollided( car,SCENE ) Then Do
        If KeyDown(KEY_UP) Then Do
            let speed=speed+.02
            If speed>.7 Then speed=.7
        ElseIf KeyDown(KEY_DOWN) Then Do
            let speed=speed-.02
            If speed<-.5 Then speed=-.5
        ElseDo
            If !KeyDown(KEY_UP) Then Do
                If speed > 0.002 Then Do let speed=speed*.9 ElseDo speed = 0.001 EndIf            
            EndIf
        EndIf
        MoveEntity(car,0,0,speed)
        TranslateEntity(car,0,GRAVITY,0)
    ElseDo
        TranslateEntity(car,x_vel,y_vel+GRAVITY,z_vel)
    EndIf


    ;// update camera
    If speed>=0  Then Do
        let dx=EntityX( target,True )-EntityX( camera )
        let dy=EntityY( target,True )-EntityY( camera )
        let dz=EntityZ( target,True )-EntityZ( camera )
        set TranslateEntity(camera,dx*.1,dy*.1,dz*.1)
    EndIf   

    PointEntity(camera,car)

    UpdateWorld(0)
    RenderWorld
    Flip
Wend
