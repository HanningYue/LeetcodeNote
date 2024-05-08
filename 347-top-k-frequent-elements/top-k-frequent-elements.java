class Solution {
     Map<Integer,Integer> map; 
    public int[] topKFrequent(int[] nums, int k) {
        // quick select
        map = new HashMap<>(); 
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        }
        
        int[] unique = new int[map.keySet().size()]; 
        int i = 0; 
        for (int num : map.keySet()) {
            unique[i++] = num; 
        }

        quickSelect(unique, 0, unique.length - 1, unique.length - k); 
        return Arrays.copyOfRange(unique, unique.length - k, unique.length); 
    }

    public void quickSelect(int[] unique, int l, int r, int kLessFrquent) {
        if (l == r) return; 

        int pivotIndex = partition(unique, l, r); 
        if (pivotIndex == kLessFrquent) return; 
        else if (pivotIndex > kLessFrquent) {
            quickSelect(unique, l, pivotIndex - 1, kLessFrquent);

        }
        else {
            quickSelect(unique, pivotIndex + 1, r, kLessFrquent); 
        }
        
    }

    public int partition(int[] unique, int l, int r) {
        int randomIndex = (int)((Math.random() * (r - l + 1)) + l); 
        // 1: swap random index and r 
        swap(unique, r, randomIndex); 
        // 2 : now the unqiue[r] is pivot 
        int pivot = unique[r]; 
        int wall = l - 1; 
        for (int i = l; i <= r; i++) {
            if (map.get(unique[i]) < map.get(pivot)) {
                swap(unique, ++wall, i); 
            }
        }
        swap(unique, ++wall, r); 
        return wall; 
    }

    public void swap(int[] unique, int l, int r) {
        int temp = unique[l]; 
        unique[l] = unique[r]; 
        unique[r] = temp; 
    }
}