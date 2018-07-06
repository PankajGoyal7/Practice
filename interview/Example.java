/*
* @Author: pankajgoyal7
* @Date:   2018-06-03 00:53:47
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-03 00:58:25
*/
public class Example
{
	public void reverseWordInMyString(String str)
	{
	/* The split() method of String class splits
	 * a string in several strings based on the
	 * delimiter passed as an argument to it
	 */
	String[] words = str.split(" ");
	String reversedString = "";
	for (int i = words.length-1; i >= 0 ; i--)
	{
		String word = words[i]; 
		String reverseWord = "";
		reversedString = (reversedString.equals("")) ? word : reversedString+" "+word;
	}
	System.out.println(str);
	System.out.println(reversedString);
	}
public static void main(String[] args) 
{
	Example obj = new Example();
	obj.reverseWordInMyString("Welcome to BeginnersBook");
	obj.reverseWordInMyString("This is an easy Java Program");
}
}