import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Attack {

    public static void main(String[] args) throws IOException {

	InputStream file = new FileInputStream("d:/Program Files/emacs/files/java/TP4/dico.txt");
	InputStreamReader in = new InputStreamReader(file, "ISO-8859-1");
	Set<String> dict = new HashSet<>();
	Scanner scan = new Scanner(in);
	Set<Integer> kSet = new HashSet<>();
	
	while(scan.hasNextLine()) {
	    dict.add(scan.nextLine());
	}
	scan.close();

       
	InputStream file1 = new FileInputStream("d:/Program Files/emacs/files/java/TP4/texte5.txt");
	InputStreamReader in1 = new InputStreamReader(file1, "ISO-8859-1");
	String ciphertext = "";  // ciphertext
	Scanner scan1 = new Scanner(in1);

	while(scan1.hasNext()) {
	    ciphertext = ciphertext + scan1.next();
	}
	scan1.close();
	
    
	KeyGeneration k;
	Byte[][] key;
	Decryption d;
	String plaintext;
	Check check;

	Byte[] initia;
	Rotations r = new Rotations();
	// take one representative, then get its orbit
	Byte[] orb1 = new Byte[]{r.rotation0(-1, -1), r.rotation1(-1, -1), r.rotation2(-1, -1), r.rotation3(-1, -1)}; 
	Byte[] orb2 = new Byte[]{r.rotation0(-2, -2), r.rotation1(-2, -2), r.rotation2(-2, -2), r.rotation3(-2, -2)};
	Byte[] orb3 = new Byte[]{r.rotation0(-2, -1), r.rotation1(-2, -1), r.rotation2(-2, -1), r.rotation3(-2, -1)};
	Byte[] orb4 = new Byte[]{r.rotation0(-2, 1), r.rotation1(-2, 1), r.rotation2(-2, 1), r.rotation3(-2, 1)};
	Byte[] orb5 = new Byte[]{r.rotation0(-3, -3), r.rotation1(-3, -3), r.rotation2(-3, -3), r.rotation3(-3, -3)};
	Byte[] orb6 = new Byte[]{r.rotation0(-3, -2), r.rotation1(-3, -2), r.rotation2(-3, -2), r.rotation3(-3, -2)};
	Byte[] orb7 = new Byte[]{r.rotation0(-3, -1), r.rotation1(-3, -1), r.rotation2(-3, -1), r.rotation3(-3, -1)};
	Byte[] orb8 = new Byte[]{r.rotation0(-3, 1), r.rotation1(-3, 1), r.rotation2(-3, 1), r.rotation3(-3, 1)};
	Byte[] orb9 = new Byte[]{r.rotation0(-3, 2), r.rotation1(-3, 2), r.rotation2(-3, 2), r.rotation3(-3, 2)};
	

	
	for(int i1 : orb1) {
	    for(int i2 : orb2){
		for(int i3 : orb3){
		    for(int i4 :orb4){
			for(int i5 : orb5){
			    for(int i6 : orb6){
				for(int i7 : orb7){
				    for(int i8 : orb8){
					for(int i9 : orb9){
					    initia = new Byte[]{(byte)i1, (byte)i2, (byte)i3, (byte)i4, (byte)i5, (byte)i6, (byte)i7, (byte)i8, (byte)i9};
					    k = new KeyGeneration(initia);
					    key = k.getKey();
					    d = new Decryption(key, ciphertext);
					    plaintext = d.getDecryption();
					    check = new Check(plaintext, dict);
					    if(check.isSentence(0)) {

						System.out.println("The initial key is " + Arrays.toString(initia));
				
						kSet = check.mapItoL.keySet();
						Iterator it = kSet.iterator();
						while(it.hasNext()) {
						    int index =(Integer)it.next();
						    int length = (Integer)check.mapItoL.get(index);
						    System.out.print(plaintext.substring(index, index + length) + " ");
						}
						System.out.print("\n");
						return;
					    }
					   
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
    }
}




