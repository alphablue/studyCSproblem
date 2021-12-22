package Boj;

import util.FastReaderJava;

/**
*
 * 대표적인 백 트레킹 문제라고 함
 *
* */

public class Boj9663J {

    FastReaderJava scan = new FastReaderJava();
    StringBuilder sb = new StringBuilder();

    int N, ans;
    int[] col;

    void input(){
        N = scan.nextInt();
        col = new int[N+1];
    }

    boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;

                for (int i=1; i<=row-1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    void run() {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}
