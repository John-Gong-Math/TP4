import java.util.Arrays;

public class Decryption {

    int l; // the length of the ciphertext
    int n;
    char[] tableText;
    Byte[][] key = new Byte[4][9];
    
    public Decryption(Byte[][] key, String ciphertext) {

	l = ciphertext.length();
	tableText = new char[l];
	n = (int)(l/36);
	this.key = key;

	for(int s = 0; s < n; s++) {
	    for(int i = 0; i < 36; i++) {
		tableText[s * 36 + (i % 6) * 6 + (5 - (int)(i/6))] = ciphertext.charAt(s * 36 + i);
		// write the ciphertext into the table, with index x * 6 + y
	    }
	}
    }
	   
    public String getDecryption() {
	
	char[] plaintext = new char[l];

	for(int s = 0; s < n; s++) {
	    for(int i = 0; i < 4; i++) {
		Arrays.sort(key[i], new Order());
		for(int j = 0; j < 9; j++) {
		    int x = (int)(key[i][j] >>> 3);
		    int y = (int)(key[i][j]) % 8;
		    // in the set {0,1,2,4,5,6}
		    if(x > 3) x = x -1;
		    if(y > 3) y = y -1;
		    plaintext[s * 36 + j + i * 9] = tableText[s * 36 + x * 6 + y];
		}
	    }
	}
	
	return String.valueOf(plaintext);
	
    }
   
}
