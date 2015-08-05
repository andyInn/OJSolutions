package jiuDuOj_Answers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;
//题意是每分钟只降落一架飞机，不会同时降3架
//OJ 前三个case Accepted，第四个tle
public class Main_1556_TLE {
    private static final int MAX_TIME = 24*60;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Plane planes[] = new Plane[n];
            for (int i = 0; i < n; i++) {
                String time = scanner.next();
                String name = scanner.next();
                String level = scanner.next();
                String timeMsg[] = time.split(Pattern.quote(":"));
                int minute = Integer.parseInt(timeMsg[0]) * 60 + Integer.parseInt(timeMsg[1]); 
                planes[i] = new Plane(minute, name, level);
            }
            Queue<Plane> queueArr[] = new Queue[3];
            for (int i = 0; i < 3; i++) {
                queueArr[i] = new LinkedList<Plane>();
            }
            int curTime = planes[0].time;
            int runArr[] = new int[3];
            int i = 0;
            for (; curTime < MAX_TIME; curTime++) {
                int hour = curTime / 60;
                int minute = curTime % 60;
                int rank1 = -1;
                for (int j = 0; j < 3; j++) {
                    if (!queueArr[j].isEmpty()) {
                        rank1 = j;
                        break;
                    }
                }
                int rank2 = -1;
                for (int j = 0; j < 3; j++) {
                    if (runArr[j] <= curTime) {
                        rank2 = j;
                        break;
                    }
                }
//              说明目前管制区有飞机并且有空闲跑道可以降落
                if (rank1 != -1 && rank2 != -1) {
                    Plane plane = queueArr[rank1].poll();
                    runArr[rank2] = curTime + 20;
                    System.out.printf("%s,landing on runway %d.@%02d:%02d\n", plane.name, rank2+1, hour, minute);
                }
//              升级
                if (curTime % 20 == 0) {
                    if (!queueArr[1].isEmpty()) {
                        Plane plane = queueArr[1].poll();
                        plane.level = "A";
                        plane.time = curTime;
                        queueArr[0].offer(plane);
                        System.out.printf("%s,level up from B to A.@%02d:%02d\n", plane.name, hour, minute);
                    }
                    if (!queueArr[2].isEmpty()) {
                        Plane plane = queueArr[2].poll();
                        plane.level = "B";
                        plane.time = curTime;
                        queueArr[1].offer(plane);
                        System.out.printf("%s,level up from C to B.@%02d:%02d\n", plane.name, hour, minute);
                    }
                }
                if (i < n && planes[i].time == curTime) {
                    if (planes[i].level.equals("A")) {
                        queueArr[0].offer(planes[i]);
                    }
                    if (planes[i].level.equals("B")) {
                        queueArr[1].offer(planes[i]);
                    }
                    if (planes[i].level.equals("C")) {
                        queueArr[2].offer(planes[i]);
                    }
                    System.out.printf("hello %s.@%02d:%02d\n", planes[i].name, hour, minute);
                    i++;
                }
            }
        }
    }
 
    private static class Plane {
        int time;
        String name;
        String level;
 
        public Plane(int time, String name, String level) {
            super();
            this.time = time;
            this.name = name;
            this.level = level;
        }
    }
}
/**************************************************************
    Problem: 1556
    User: wangzhenqing
    Language: Java
    Result: Time Limit Exceed
****************************************************************/