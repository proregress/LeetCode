class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else{
            while(temp != 0){
                int pop = temp % 10;
                rev = rev * 10 + pop;
                temp /= 10;
            }
            System.out.println(rev);
            if(rev == x)
                return true;
            else{
                return false;
            }
        }
    }
}