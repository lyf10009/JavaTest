package BasicApp;

public class EightQueen {
    // 同栏是否有皇后，1表示有
    private int[] column;
    // 右上至左下是否有皇后
    private int[] rup;
    // 左上至右下是否有皇后
    private int[] lup;
    // 解答
    private int[] queen;
    // 解答编号
    private int num;
    private int n = 4;//N-Queens
    public EightQueen() {
        column = new int[n + 1];
        rup = new int[2 * n + 1];
        lup = new int[2 * n + 1];

        for (int i = 1; i <= n; i++)
            column[i] = 1;

        for (int i = 1; i <= 2 * n; i++){
            rup[i] = lup[i] = 1;
        }

        queen = new int[8 + 1];
    }

    public void backtrack(int i) {
        if (i > n) {
            showAnswer();
        } else {
            for (int j = 1; j <= n; j++) {
                if (column[j] == 1 && rup[i + j] == 1 && lup[i - j + n] == 1) {
                    queen[i] = j;
                    // 设定为占用
                    column[j] = rup[i + j] = lup[i - j + n] = 0;
                    backtrack(i + 1);
                    column[j] = rup[i + j] = lup[i - j + n] = 1;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("\n解答 " + num);
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (queen[y] == x) {
                    System.out.print(" Q");
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.backtrack(1);
    }
}
