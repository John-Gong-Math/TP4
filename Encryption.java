import java.util.Arrays;


public class Encryption {

    int l;  // the length of the plaintext
    int n;
    char[] tableText;
    Byte[][] key = new Byte[4][9];
    
    public Encryption(Byte[][] key, String plaintext){
	
	l = plaintext.length();
	tableText = new char[l];
	n = (int)(l/36);
	
	for(int s = 0; s < n; s++) {
	    for(int i = 0; i < 4; i++) {
		Arrays.sort(key[i], new Order()); //re-write the comparator !!
		// rearrange the 9 points at each step to write in from plaintext
		for(int j = 0; j < 9; j++) {
		    int x = (int)(key[i][j] >>> 3);
		    int y = (int)(key[i][j]) % 8;
		    // in the set {0,1,2,4,5,6}
		    if(x > 3) x = x -1;
		    if(y > 3) y = y -1;
		    tableText[s * 36 + x * 6 + y] = plaintext.charAt(s * 36 + j + i * 9);
		    // the 6 * 6 grill is writen into
		}
	    }
	}
    }

    public String getEncryption() {

	char[] ciphertext = new char[l];

	for(int s = 0; s < n; s++) {
	    for(int i = 0; i < 6; i++) {
		for(int j = 0; j < 6; j++){
		    ciphertext[s * 36 + i * 6 + j] = tableText[s * 36 + 5 - i + 6 * j];
		    // read in the order left to right, above to below, x==j, y==5-i
		}
	    }
	}
	return String.valueOf(ciphertext);
    }
    
}
