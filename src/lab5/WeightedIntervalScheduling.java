package lab5;

import java.util.Arrays;

public class WeightedIntervalScheduling {
    static class Job implements Comparable<Job>{
        int start;
        int stop;
        int value;
        Job(int s, int f, int v) {
            start = s;
            stop = f;
            value = v;
        }
        @Override
        public int compareTo(Job j){
            return this.stop-j.stop;
        }
    }
    public static int maxValueJobs(int s[], int f[], int[] v, int n) {
        Job[] act = new Job[n];
        for (int i = 0; i < n; i++)
            act[i] = new Job(s[i], f[i], v[i]);
        Arrays.sort(act);
        int[] dp = new int[n];
        dp[0]=act[0].value;
        for (int i=1;i<n;i++){
            int incl = act[i].value;
            for (int j = i-1; j >=0; j--) {
                if(act[j].stop<=act[i].start){
                    incl += dp[j];
                    break;
                }
            }
            dp[i]=Math.max(incl,dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int start[] = { 1, 5, 0, 3, 5, 6, 8 };
        int finish[] = { 2, 6, 5, 4, 9, 7, 9 };
        int value[] = { 2, 2, 4, 3, 10, 2, 8 };
        int n = start.length;
        System.out.println(maxValueJobs(start, finish, value, n));
    }
}
