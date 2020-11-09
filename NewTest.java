import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;



import java.io.IOException;
import java.util.*;

public class NewTest {
    public static void main(String[] args)throws IOException {
	/*
	InputStream file = new FileInputStream("d:/Program Files/emacs/files/java/TP4/dico.txt");
	InputStreamReader in = new InputStreamReader(file, "UTF-8");
	Set<String> dict = new HashSet<>();
	Scanner scan = new Scanner(in);

	while (scan.hasNextLine()) {
	    dict.add(scan.nextLine());
	}
	scan.close();
*/


	Path path = Paths.get("d:/Program Files/emacs/files/java/TP4/dico.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.split("\n");
        Set<String> dict = new HashSet<>();
        Collections.addAll(dict, words);

	
	String plaintext = "compactification";
	Check check = new Check(plaintext, dict);
	
	System.out.println(check.isSentence(0));
	System.out.println(check.mapCtoI);
	System.out.println(check.mapItoL);

    }
}


class Check {

    String plaintext;
    int l;
    String answer = "";
    Set<String> dict;
    Map<Integer, Integer> mapCtoI = new HashMap<>();
    Map<Integer, Integer> mapItoL = new HashMap<>();
    
    public Check(String plaintext, Set<String> dict)throws IOException {
	this.plaintext = plaintext;
	this.l = plaintext.length();
	this.dict = dict;
	mapCtoI.put(0, 0);
	mapItoL.put(0, 1);
    }

    boolean isWord(String word) {
	Iterator it = dict.iterator();
	while(it.hasNext()) {
	    if(it.next().equals(word)) return true;
	}
	return false;
    }

    void mkHmaps(int count, int i, int j) {
	mapCtoI.put(count, i);
	mapItoL.put(i, j);
    }
    
    boolean isSentence(int c) {

	if(c < 0) return false;
	
	int count = c;
	int i = mapCtoI.get(count);
	int j = mapItoL.get(i) + 1;
	mapCtoI.remove(count);
	mapItoL.remove(i);  // remove the old maps
	
	String w = null;

	while(i < l) {

	    int flag = 0;
	    while((i + j) < (l + 1)) {
		w = plaintext.substring(i, i + j);
		if(isWord(w)) {
		    mkHmaps(count, i, j);
		    count++;
		    i = i + j;
		    j = 2;
		    flag = 1;
		    break;
		} else {
		    j++;
		}
	    }
	    
	    if(flag == 0) {
		count--;
	
		return isSentence(count);
		    
	    }
	
	}

	return true;
    }

}
