import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class CheckTest {
    public static void main(String[] args)throws IOException {
	
	InputStream file = new FileInputStream("d:/Program Files/emacs/files/java/TP4/dico.txt");
	InputStreamReader in = new InputStreamReader(file, "ISO-8859-1");
	Set<String> dict = new HashSet<>();
	Scanner scan = new Scanner(in);
	Set<Integer> kSet = new HashSet<>();
	
	while (scan.hasNextLine()) {
	    dict.add(scan.nextLine());
	}
	scan.close();

	
	String plaintext = "compactificationdigitaliseraisqu'endêvantD'Ouzbékistan";
	Check check = new Check(plaintext, dict);
	
	System.out.println(check.isSentence(0));
	System.out.println(check.mapCtoI);
	System.out.println(check.mapItoL);

	kSet = check.mapItoL.keySet();
	Iterator it = kSet.iterator();
	while(it.hasNext()) {
	    int index =(Integer)it.next();
	    int length = (Integer)check.mapItoL.get(index);
	    System.out.print(plaintext.substring(index, index + length) + " ");
	}
	System.out.print("\n");
    }
}
    
    
