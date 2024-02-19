package brainteaser.L0292_Nim游戏;

public class Solution {
    public boolean canWinNim(int n) {
        //脑筋急转弯:如果 n 为 4 的倍数时，则你必然会输掉游戏；
        return n % 4 != 0;
    }
}
