// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not matter.
//
//


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        	List<List<String>> result=new ArrayList<List<String>>();
	HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
	for(String str:strs){
		char[] arr=new char[26];
		for(int i=0;i<str.length();i++){
			arr[str.charAt(i)-'a']++;
		}
		String tmp=new String(arr);
		if(map.containsKey(tmp)){
			map.get(tmp).add(str);
		}else{
			ArrayList<String> list=new ArrayList<String>();
			list.add(str);
			map.put(tmp, list);
		}
	}
	result.addAll(map.values());
	return result;
    }
}
