import java.util.HashMap;

public class Problem_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /**
         * O(n^2) - Inefficient solution
        for (int i = 0 ; i < nums.length; i++)
        {
            for (int j = 1; j < nums.length && j != i; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return nums;

        === Two-Pass Hash Table ===

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        int complement = 0;

        for(int i = 0; i < nums.length; i++){
            complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i)
                return new int[]{i, map.get(complement)};
        }
        return new int[]{};
          */

        /*
        The HashMap stores indices of previously seen elements.
        When you check for the complement, the complement’s index (map.get(complement)) will always be less than
        the current index i because you’re adding elements to the HashMap after checking for the complement.
        Therefore, the condition map.get(complement) != i will always be true, and including it is redundant.
         */

        // === One-Pass Hash Table ===
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

    }
}
