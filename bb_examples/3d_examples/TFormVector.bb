;// TFormVector example

Start Graphics3D(640, 480,0,2)

let int p = CreatePivot()

set PositionEntity(p, 10, 20, 30   );// easy to visualize
TurnEntity(p, -5, -15, 25      );// hard to visualize

;// Question; what would happen if we took one step 'forward'?
;// The local vector corresponding to one step forward is (0,0,1)
;// in the pivot's local space. We need the global version.

TFormVector(0,0,1, p,0    );//  transform from pivot to world

let string message = "'One step forward' vector is  ( "
let message = str(message , TFormedX , ",  " , TFormedY , ",  " , TFormedZ , " )")

;// Now actually take the step. The new location should be
;// (10,20,30) plus the vector we just computed.

set MoveEntity(p, 0,0,1)

RenderWorld
set Text(70, 180, message)

let message = "New location of pivot is  ( "
let message = str(message , EntityX(p) , ",  ")
let message = str(message , EntityY(p) , ",  " , EntityZ(p) , " )")
set Text(100, 210, message)
Flip

;// same as WaitKey
While Not KeyEnd(KEY_ESC)
Wend
