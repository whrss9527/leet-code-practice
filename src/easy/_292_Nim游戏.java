package easy;

public class _292_Nim游戏 {

    /***
     * 简单描述如下：当出现4的倍数时，对手总是可以让你回到4的倍数的情况，而4刚好是赢不了的情况，所以只要你拿到的数量是4的倍数，对手总是可以让你回到4的情况。 想赢也是同样的道理，每次给对手留下4的倍数的数量即可。
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
