package com.BasicApp;

public class EightQueen {
    // ͬ���Ƿ��лʺ�1��ʾ��
    private int[] column;
    // �����������Ƿ��лʺ�
    private int[] rup;
    // �����������Ƿ��лʺ�
    private int[] lup;
    // ���
    private int[] queen;
    // �����
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
                    // �趨Ϊռ��
                    column[j] = rup[i + j] = lup[i - j + n] = 0;
                    backtrack(i + 1);
                    column[j] = rup[i + j] = lup[i - j + n] = 1;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("\n��� " + num);
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
