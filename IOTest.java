import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class IOTest {
    public static void main(String[] args) throws IOException {
	
	InputStream file1 = new FileInputStream("d:/Program Files/emacs/files/java/TP4/texte5.txt");
	InputStreamReader in1 = new InputStreamReader(file1, "ISO-8859-1");
	String ciphertext = "";  // ciphertext
	Scanner scan1 = new Scanner(in1);

	while(scan1.hasNext()) {
	    ciphertext = ciphertext + scan1.next();
	}
	scan1.close();
	
	System.out.println(ciphertext);

	InputStream file = new FileInputStream("d:/Program Files/emacs/files/java/TP4/dico.txt");
	InputStreamReader in = new InputStreamReader(file, "ISO-8859-1");
	Scanner scan = new Scanner(in);
	int maxLen = 1;
	
	while(scan.hasNextLine()) {
	    if(maxLen < scan.nextLine().length()) {
		maxLen = scan.nextLine().length();
	    }
	}
	scan.close();

	System.out.println("The maximal word length is: " + maxLen);

    }
}
