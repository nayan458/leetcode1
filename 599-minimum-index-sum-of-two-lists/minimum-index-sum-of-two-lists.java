import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                int sum = j + map.get(str);
                if (sum < minSum) {
                    result.clear();
                    result.add(str);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(str);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
