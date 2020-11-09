import java.util.Arrays;
import java.util.*;

public class ExTest {

    public static void main(String[] args) {

	String text = "cestletexteclair";
	Byte[] initia = new Byte[]{3, 25, 24, 36};
	KeyGeneration2 k = new KeyGeneration2(initia);
	Byte[][] key = k.getKey();
	Encryption2 e = new Encryption2(key, text); // Byte
	Decryption2 d = new Decryption2(key, e.getEncryption());
	
	for(int i = 0; i < 4; i++) {
	    for(int j = 0; j < 4; j++) {
		System.out.println(" " +((key[i][j] >>> 3) -2) + " " + ((key[i][j] % 8) - 2));
	    }
	    System.out.println("\n");
	    
	}
	
	System.out.println("" + e.getEncryption());

	System.out.println("" + d.getDecryption());

    }
}


class KeyGeneration2 {
 
    
    Byte[][] key = new Byte[4][4]; // key divided into 4 parts, each is a byte[4] with 4 holes
    int[] x = new int[4];
    int[] y = new int[4];  // the real positions of initial holes
    
    public KeyGeneration2(Byte[] initia) {
	
	for(int i = 0; i < 4; i++) {
	    y[i] = (int)initia[i] % 8 - 2;
	    x[i] = (int)(initia[i] >>> 3) - 2; 
	   	    
	    key[0] = initia; // 1st part of the key
	}	
	
    }
    
    public void rotation1() {
	for(int i = 0; i < 4; i ++) {
	    key[1][i] = Byte.valueOf((byte)((-1) * x[i] + 2 + (y[i] + 2) * 8));
	    
	    }
    }

    public void rotation2() {
	for(int i = 0; i < 4; i ++) {
	    key[2][i] = Byte.valueOf((byte)((-1) * y[i] + 2 + ((-1) * x[i] + 2) * 8));
	    
	}
    }
    
    public void rotation3() {
	for(int i = 0; i < 4; i ++) {
	    key[3][i] = Byte.valueOf((byte)(x[i] + 2 + ((-1) * y[i] + 2) * 8));
	}
    }

    public Byte[][] getKey() {
	rotation1();
	rotation2();
	rotation3();
	return key;
    }
   
}


class Order2 implements Comparator<Byte> {  // attention for reference type here !!

    int[] toXY(byte input) {
	int[] coordi =  new int[]{(int)(input >>> 3) - 2, (int)input % 8 - 2};
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



class Encryption2 {

    char[] tableText =  new char[16];
    
    public Encryption2(Byte[][] key, String plaintext){
	for(int i = 0; i < 4; i++) {
	    Arrays.sort(key[i], new Order2()); //re-write the comparator !!
	    // rearrange the 9 points at each step to write in from plaintext
	    for(int j = 0; j < 4; j++) {
		int x = (int)(key[i][j] >>> 3);
		int y = (int)(key[i][j]) % 8;
		// in the set {0,1,3,4}
		if(x > 2) x = x -1;
		if(y > 2) y = y -1;
		tableText[x * 4 + y] = plaintext.charAt(j + i * 4);
		//the 4 * 4 grill is writen into

	    }
	}
    }

    public String getEncryption() {
	String s = String.valueOf(tableText);
	char[] ciphertext = new char[16];
	
	for(int i = 0; i < 4; i++) {
	    for(int j = 0; j < 4; j++){
		ciphertext[i * 4 + j] = tableText[3 - i + 4 * j];
		// read in the order left to right, above to below from the grill
	    }
	}
	
	System.out.println(s);
	return String.valueOf(ciphertext);
    }
}
    
class Decryption2 {
    
    char[] tableText = new char[16];
    Byte[][] key = new Byte[4][4];
    
    public Decryption2(Byte[][] key, String ciphertext) {
	this.key = key;
	for(int i = 0; i < 16; i++) {
	    tableText[(i % 4) * 4 + (3 - (int)(i/4))] = ciphertext.charAt(i);
	    // write the ciphertext into the table, with index x * 4 + y
	}
    }
	   
    public String getDecryption() {
	
	char[] plaintext = new char[16];
	
	for(int i = 0; i < 4; i++) {
	    Arrays.sort(key[i], new Order2());
	    for(int j = 0; j < 4; j++) {
		int x = (int)(key[i][j] >>> 3);
		int y = (int)(key[i][j]) % 8;
		// in the set {0,1,3,4}
		if(x > 2) x = x -1;
		if(y > 2) y = y -1;
		plaintext[j + i * 4] = tableText[x * 4 + y];
	    }
	}
	
	return String.valueOf(plaintext);
	
    }
    
}
