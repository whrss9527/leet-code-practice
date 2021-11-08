package medium;

public class _299_猜数字游戏 {
    public String getHint(String secret, String guess) {
        // 定义一个长度为10的数组，0-9 10个数
        int[] nums = new int[10];
        int countA = 0, countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) countA++;
            else{
                // 猜对了但是位置不对
                // 猜的数减掉 1 3   3 8
                if (nums[guess.charAt(i) - '0']-- > 0) countB++;
                // 真实的数先加
                if(nums[secret.charAt(i) - '0']++ < 0) countB++;
                //当进行比较的时候，由于+ -- 是延迟的，所以当时如果该位置有数，则该位置即num[i]会由-1或1变为0
            }
        }
        return countA + "A" + countB + "B";
    }
}

