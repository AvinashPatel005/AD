package lab3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class IntervalScheduling {
    static class Job implements Comparable<Job> {
        int start;
        int finish;
        String name;
        Job(int s,int f,String n){
            start=s;
            finish=f;
            name=n;
        }

        @Override
        public int compareTo(Job o) {
            return this.finish-o.finish;
        }
        public void print(){
            System.out.println("[" + name + ": (" + start + ", " + finish + ")]");
        }
    }
    public static void main(String[] args) {
        Job[] jobs = {
                new Job(0, 6, "a"),
                new Job(1, 4, "b"),
                new Job(3, 5, "c")
        };
        Arrays.sort(jobs);
        LinkedList<Job> jobsSelected = new LinkedList<Job>();
        jobsSelected.add(jobs[0]);
        int last = jobs[0].finish;
        for(Job j:jobs){
            if(j.start>=last){
                jobsSelected.add(j);
                last= j.finish;
            }
        }
        for(Job j:jobsSelected){
            j.print();
        }
    }
}
