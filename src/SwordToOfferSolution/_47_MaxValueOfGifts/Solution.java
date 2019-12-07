package SwordToOfferSolution._47_MaxValueOfGifts;

/*
 * 礼物的最大价值
 * 思路：经典 DP 问题
 * 当前节点的最大总价值 = max(上面节点的最大总价值 +　左边节点的最大总价值) + 当前节点最大总价值
 * 第一行和第一列都要进行初始化
 */
public class Solution {
    public int getMost1(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int n = values.length;
        int[][] dp = new int[n][n];
        // 初始化（0, 0）点
        dp[0][0] = values[0][0];
        // 初始化第一行和第一列
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + values[0][i];
            dp[i][0] = dp[i - 1][0] + values[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }

    // 优化后
    public int getMost2(int[][] values) {
        int rows = values.length;
        int columns = values[0].length;
        if (values == null || rows == 0 || columns == 0) {
            return 0;
        }
        int[] dp = new int[columns];
        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < columns; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }
        return dp[columns - 1];
    }
}
