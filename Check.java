import java.io.IOException;
import java.util.*;


public class Check {
  
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
	    while((j < 19) && ((i + j) < (l + 1))) { // the maximal word length is the dict is 18
		w = plaintext.substring(i, i + j);
		if(isWord(w)) {
		    mkHmaps(count, i, j);
		    count++;
		    System.out.print(count + " ");
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
