/*
* @Author: pankajgoyal7
* @Date:   2018-06-13 14:09:51
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-13 15:10:16
*/
class LookAndSaySequence{

	static String findSequence(int n){

		if(n==1)
			return "1";
		if(n==2)
			return "11";
		String str = "11";

		for(int i=3;i<=n;i++){

			str += "$";
			int len = str.length();
			int cnt =1;
			String tmp = "";
			for(int j=1;j< len;j++){
				if(str.charAt(j) != str.charAt(j-1)){
					tmp += cnt;
					tmp += str.charAt(j-1);
					cnt = 1;
				}else{
					cnt++;
				}

			}
			str = tmp;
		}
		return str;
	}
	public static void main(String[] args) {
		int  n =5;
		System.out.println(findSequence(n));
	}
}