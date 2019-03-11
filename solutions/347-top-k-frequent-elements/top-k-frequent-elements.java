// Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
//
//
// Example 2:
//
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Note: 
//
//
// 	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// 	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
//


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Element> elementList = new ArrayList<>();
        //Map保存的是元素和elementList对应元素下标的键值对.空间换时间.
        HashMap<Integer, Integer> number2IndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (number2IndexMap.containsKey(num)) {
                //如果Map中已保存该num的键值对,则获取出来并且count自增.
                int index = number2IndexMap.get(num);
                elementList.get(index).count++;
            } else {
                //否则,新建一组键值对,保存到Map中.
                Element element = new Element(num);
                elementList.add(element);
                number2IndexMap.put(num, elementList.size() - 1);
            }
        }
        //降序排序elementList.
        Collections.sort(elementList);
        //把前面k个输出到resultList中.
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resultList.add(elementList.get(i).number);
        }
        return resultList;
    }

    /**
     * 用来记录元素出现的次数
     */
    private static class Element implements Comparable<Element> {
        public final int number;
        public int count = 0;
        public Element(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Element element) {
            return element.count - this.count;
        }
    }
}
