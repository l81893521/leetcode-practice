package will.zhang.UsingArray.ContainerWithMostWater11;

/**
 * Created by Will.Zhang on 2018/4/9 0009 14:58.
 */
public class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        /*
        使用对撞指针的思想
        在数组的两侧分别定义i 和 j
        两个指针不断往中间移动, 遇到高的柱子则保留高的柱子
         */
        int max=0;
        while(i!=j){
            if(height[i]<=height[j]){
                max=height[i]*(j-i)>max?height[i]*(j-i):max;
                i++;
            }
            if(height[i]>height[j]){
                max=height[j]*(j-i)>max?height[j]*(j-i):max;
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
