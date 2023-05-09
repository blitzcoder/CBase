;// TFormPoint example

Start Graphics3D(640, 480,0,2)

let int s = CreateSphere()       ;// center at (0,0,0)  north pole at (0,1,0)

set MoveEntity(s, 1,2,3     );// center at (1,2,3)  north pole at (1,2+1,3)  
ScaleEntity(s, 10,10,10  );// center at (1,2,3)  north pole at (1,2+10,3)

;// Now verify that the north pole is at (1,12,3) in the 3d world

TFormPoint(0,1,0, s,0    );// north pole transformed from sphere to world

let string message = "North pole is at ( "
let message = str(message , TFormedX , ",  " , TFormedY , ",  " , TFormedZ , " )")

;// display message
RenderWorld
Text(180, 200, message)
Flip

;// same as WaitKey
While Not KeyEnd(KEY_ESC)
Wend
