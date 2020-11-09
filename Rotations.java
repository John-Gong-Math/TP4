public class Rotations {

    
     // rotation matrices only work for coordinates of center (0, 0)
    public Byte rotation0(int x, int y) {
	return Byte.valueOf((byte) (y + 3 + (x + 3) * 8));  //(x, y)
    }
    
    public Byte rotation1(int x, int y) {
	return Byte.valueOf((byte)((-1) * x + 3 + (y + 3) * 8)); // (y, -x)
    }
    
    public Byte rotation2(int x, int y) {
	return Byte.valueOf((byte)((-1) * y + 3 + ((-1) * x + 3) * 8));  //(-x, -y)
    }
    
    public Byte rotation3(int x, int y) {
	return Byte.valueOf((byte)(x + 3 + ((-1) * y + 3) * 8));  // (-y, x)
    }
    
}
