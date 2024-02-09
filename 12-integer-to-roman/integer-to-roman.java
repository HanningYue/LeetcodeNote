class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        int[] sorted = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sorted.length; i++) {
            int currentMax = sorted[i];
            int result = num / currentMax;
            if (result != 0) {
                String s = map.get(currentMax);
                for (int j = 0; j < result; j++) {
                    sb.append(s);
                }
                num = num - currentMax * result;
            }
        }
        return sb.toString();
    }
}