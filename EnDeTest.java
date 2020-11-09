import java.util.Arrays;
import java.util.*;

public class EnDeTest {
    
    public static void main(String[] args) {
	
	String text = "cestletexteclaircestletexteclairokoktelretccacteeeislxstxiettelrkelcaooé";
	Byte[] initia = new Byte[]{18, 9, 10, 12, 0, 1, 2, 4, 5};
	KeyGeneration k = new KeyGeneration(initia);
	Byte[][] key = k.getKey();
	Encryption e = new Encryption(key, text); // Byte
	Decryption d = new Decryption(key, e.getEncryption());
	
	for(int i = 0; i < 4; i++) {
	    for(int j = 0; j < 9; j++) {
		System.out.println(" " +((key[i][j] >>> 3) -3) + " " + ((key[i][j] % 8) - 3));
	    }
	    System.out.println("\n");
	    
	}

	System.out.println(text.length());	
	System.out.println("" + e.getEncryption());
	System.out.println("" + d.getDecryption());
	System.out.println(d.getDecryption().equals(text));

    }
}
