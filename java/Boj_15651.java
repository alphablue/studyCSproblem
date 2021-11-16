import util.FastReader;

public class Boj_15651 {

    StringBuilder sb = new StringBuilder();
    int N, M;
    int[] selected;

    void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;

                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public void run() {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }
}
