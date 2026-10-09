class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right],map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int fruit = fruits[left];
                map.put(fruit, map.get(fruit) - 1);
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
