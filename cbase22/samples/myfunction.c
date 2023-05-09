// This is part of the
// C Functions Example 
// ------------------- 

#include <math.h>

void PositionWheels() {
	for (double z = 1.5; z >= -1.5; z -= 3) {
		z = round(z);
		for (int x = -1; x <= 1; x += 2) {
			printf("z=%1.0f\n", z);
			printf("x=%d\n", x);
		}
	}	
}

