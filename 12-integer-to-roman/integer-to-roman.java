class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int[] highToLow 
        = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < highToLow.length; i++) {
            if (num / highToLow[i] != 0) {
                int frequency = num / highToLow[i];
                String current = map.get(highToLow[i]);
                sb.append(current.repeat(frequency));
                num = num % highToLow[i];
            }
        }
        return sb.toString();
    }
}