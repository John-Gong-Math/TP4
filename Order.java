import java.util.*;

// Rewrite the comparator to sort the point (x, y) in order to left to right, above to below

public class Order implements Comparator<Byte> {  // attention for reference type here !!

    int[] toXY(byte input) {
	int[] coordi =  new int[]{(int)(input >>> 3) - 3, (int)input % 8 - 3};
	return coordi;
    }
	    
    public int compare(Byte first, Byte second) {
	int x1 = toXY(first)[0];
	int y1 = toXY(first)[1];
	int x2 = toXY(second)[0];
	int y2 = toXY(second)[1];
	if(x1 != x2) return x1 - x2;
	else return y2 - y1;
    }
}
