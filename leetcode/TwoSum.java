package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jbu
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<numbers.length;i++) {
            if (map.containsKey(target-numbers[i])) return new int[]{map.get(target-numbers[i])+1,i+1};
            else map.put(numbers[i], i);
        }
        return new int[]{0,0};
    }
}
