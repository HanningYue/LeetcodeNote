class Solution {
  public int mySqrt(int x) {
    if (x < 2)
      return x; // return x if it is 0 or 1

    int left = 2, right = x / 2; // initialize left and right pointers
    int pivot;
    long num; // use long to store result of pivot * pivot to prevent overflow
    while (left <= right) { // binary search for the square root
      pivot = left + (right - left) / 2; // find the middle element
      num = (long) pivot * pivot;
      if (num > x)
        right = pivot - 1; // if pivot * pivot is greater than x, set right to pivot - 1
      else if (num < x)
        left = pivot + 1; // if pivot * pivot is less than x, set left to pivot + 1
      else
        return pivot; // if pivot * pivot is equal to x, return pivot
    }

    return right; // return right after the loop
  }
}