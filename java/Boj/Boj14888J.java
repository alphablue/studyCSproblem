package Boj;

import util.FastReaderJava;

public class Boj14888J {
    FastReaderJava scan = new FastReaderJava();
    StringBuilder sb = new StringBuilder();

    int N, max, min;
    int[] nums, operators;

    void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    int calculator(int operand1, int operator, int operand2) {
        if (operator == 1)
            return operand1 + operand2;

        if (operator == 2)
            return operand1 - operand2;

        if (operator == 3)
            return operand1 * operand2;

        else
            return operand1 / operand2;
    }

    void rec_fun(int n, int value) {
        if (n == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int oper=1; oper<=4; oper++) {
                if(operators[oper]>=1) {
                    operators[oper]--;
                    rec_fun(n + 1, calculator(value, oper, nums[n+1]));
                    operators[oper]++;
                }
            }
        }
    }

    public void run() {
        input();
        rec_fun(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
