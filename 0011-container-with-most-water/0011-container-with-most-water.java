/*
本质上，这道题是在求最大长方形面积
Use 2-pointer technique, update the area each iteration
    QUESTION IS, HOW TO DETERMINE WHEN TO MOVE THE POINTER?
        看题目，我们要尽量optimize高度差，that is两个柱状体的高度差尽量最小
        For example, 当a方高度高于当前b方时，a方左边所有柱体都小于a方，这时move b方向a方的方向. And vice versa
*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int rectangular_length = right - left;
            int rectangular_height = Math.min(height[right], height[left]);
            
            maxArea = Math.max(maxArea, rectangular_height * rectangular_length);    
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}