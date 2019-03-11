// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Example 1:
//
//
// Input: pattern = "abba", str = "dog cat cat dog"
// Output: true
//
// Example 2:
//
//
// Input:pattern = "abba", str = "dog cat cat fish"
// Output: false
//
// Example 3:
//
//
// Input: pattern = "aaaa", str = "dog cat cat dog"
// Output: false
//
// Example 4:
//
//
// Input: pattern = "abba", str = "dog dog dog dog"
// Output: false
//
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.


public class Solution {
   public static boolean wordPattern(String pattern, String str) {
		if(pattern.isEmpty()||str.isEmpty())
		return false;
		String[] patterncopy = pattern.split("");
		//String[] patterncopy=new String[patterncop.length-1];
		//for(int i=0;i<patterncop.length-1;i++)
		//{
		//	patterncopy[i]=patterncop[i+1];
		//}
		String[] strcopy = str.split(" ");
		int[] patternint=new int[patterncopy.length];
		int[] strint=new int[strcopy.length];
		patternint[0]=strint[0]=0;
		if(patterncopy.length>=1&&strcopy.length>=1)
		{
	    for(int i=1;i<patterncopy.length;i++)
	    {for(int y=i-1;y>=0;y--)
	    	{if(patterncopy[i].equals(patterncopy[y]))
	    		{patternint[i]=patternint[y];
	    		break;}
	    	else 
	    		patternint[i]=i;}
	    }
	    
	    for(int i=1;i<strcopy.length;i++)
	    {for(int y=i-1;y>=0;y--)
	    	{if(strcopy[i].equals(strcopy[y]))
	    	{	strint[i]=strint[y];
	    		break;}
	    	else 
	    		strint[i]=i;}
	    }
	    
	    for(int i=0;i<patterncopy.length;i++)
	    {
	    	System.out.println(patterncopy[i]);
	    }
	    for(int i=0;i<strint.length;i++)
	    {
	    	System.out.println(strint[i]);
	    }
	    if(patternint.length!=strint.length)
	    return false;
	    int k;
	    for(k=0;k<strint.length;k++)
	    {
		    if(patternint[k]!=strint[k])
		       break;
	    }
	    if(k==strint.length)
	    return true;
	    else
		return false;
	 }
	 else 
	 return true;        
	    }
}
