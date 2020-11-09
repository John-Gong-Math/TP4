import java.util.Arrays;


public class KeyGeneration {
 
      /*
	x-y coordinate of each hole is represented by a byte:
	the 3 least significent bits of values from 1 to 6 stand for height y + 3 (y possible negative)
	while further 3 more significent bits of values from 1 to 6 stand for width x + 3
	
      */
    Byte[][] key = new Byte[4][9]; // key divided into 4 parts, each is a byte[9] with 9 holes
    int[] x = new int[9];
    int[] y = new int[9];  // the real positions of initial holes
    
    public KeyGeneration(Byte[] initia) {
	
	for(int i = 0; i < 9; i++) {
	    y[i] = (int)(initia[i] % 8) - 3;
	    x[i] = (int)(initia[i] >>> 3) - 3; 
	    // note the byte value always positive while x-y may be negative
	    
	    key[0] = initia; // 1st part of the key
	}	
	
    }
    
    public void rotation1() {
	for(int i = 0; i < 9; i ++) {
	    key[1][i] = Byte.valueOf((byte)((-1) * x[i] + 3 + (y[i] + 3) * 8));
	    /*
	      the new point with (y, -x), but to make represented by one byte 
	      it should make all positive
	    */
	    }
    }

    public void rotation2() {
	for(int i = 0; i < 9; i ++) {
	    key[2][i] = Byte.valueOf((byte)((-1) * y[i] + 3 + ((-1) * x[i] + 3) * 8));
	    
	}
    }
    
    public void rotation3() {
	for(int i = 0; i < 9; i ++) {
	    key[3][i] = Byte.valueOf((byte)(x[i] + 3 + ((-1) * y[i] + 3) * 8));
	}
    }

    public Byte[][] getKey() {
	
	rotation1();
	rotation2();
	rotation3();
	return key;
    }
   
}
