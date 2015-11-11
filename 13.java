public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        if(len <= 0)
            return 0;
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('M', 1000);
        roman.put('D', 500);
        roman.put('C', 100);
        roman.put('L', 50);
        roman.put('X', 10);
        roman.put('V', 5);
        roman.put('I', 1);
        char c1 = s.charAt(len-1), c2;
        int res = roman.get(c1);
        for(int i=len-2; i>=0; i--)
        {
            c1 = s.charAt(i);
            c2 = s.charAt(i+1);
            if(roman.get(c1) >= roman.get(c2))
                res += roman.get(c1);
            else
                res -= roman.get(c1);
        }
        return res;
    }
}