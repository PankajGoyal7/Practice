/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 12:44:38
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 13:25:24
*/
import java.util.*;

class BoyerMooreBad{

	private Map<Character,Integer> findBadChar(String pattern,int size){
		Map<Character,Integer> maps = new HashMap<Character,Integer>();
		for(int i=0;i<size;i++){
			Character c = pattern.charAt(i);
			maps.put(c,i);
		}
		return maps;
	}

	public void search(String str,String pattern){
		int n = str.length();
		int m = pattern.length();

		Map<Character,Integer> maps = this.findBadChar(pattern,m);
		int s = 0;
		while(s <= n-m){
			int j =  m-1;

			while(j >=0 && pattern.charAt(j) == str.charAt(s+j) )
				j -= 1;

			// System.out.println("j "+j+" s "+s);
			if(j < 0){

				System.out.println(s);

				int v = -1;
				if(maps.containsKey(str.charAt(s+m)))
					v = maps.get(str.charAt(s+m));

				if(s+m < n){
					s += m- v; 
				}else{
					s+= 1;
				}

			}else{

				int v = -1;
				if(maps.containsKey(str.charAt(s+j)))
					v = maps.get(str.charAt(s+j));

				s += Math.max(1,j - v);
			}
		}
	}

	public static void main(String[] args) {
			
		BoyerMooreBad al = new BoyerMooreBad();
		String txt = "GCAATGCCTATGTGACCGCAATGCCTATGTGACC";
    	String pat = "TATGTG";
		al.search(txt,pat);
	}
}