package leetcode;

public class Solution88 {
	
    public  void merge(int[] nums1, int m, int[] nums2, int n) {
        //先将nums1[0 - m-1]移动到nums1[n - n+m-1],这样空间大小正好等于nums1+nums2两个数组的总和
        for (int i = m - 1; i >= 0; i--)
        	nums1[n + i] = nums1[i];
        // 整合
        int cnt1 = n, cnt2 = 0, cnt = 0;//初始化数组1的标志指向n，数组2从0开始，cnt代表最终结果下标
        while (cnt1 < n + m && cnt2 < n) {
            if (nums1[cnt1] > nums2[cnt2])
            	nums1[cnt++] = nums2[cnt2++];
            else
            	nums1[cnt++] = nums1[cnt1++];
        }
        while (cnt2 < n)
        	nums1[cnt++] = nums2[cnt2++];
        
    }

	public static void main(String[] args) {
		Solution88 sol = new Solution88();
		int a[] = new int[10];
		a[0]=1;
		a[1]=3;
		a[2]=5;
		a[3]=7;
		a[4]=9;
		int[] b = {2,4,6};
		sol.merge(a, 5, b, 3);
		System.out.println(a[7]);
		
		// TODO Auto-generated method stub

	}

}
