package session_11.exercise.optional.optional_demerging_queue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<DemergingQueue> demerge = new ArrayList<>();

        demerge.add(new DemergingQueue(1,"Hoang",new Date(95, Calendar.OCTOBER,17), true));
        demerge.add(new DemergingQueue(2,"Quang",new Date(93,Calendar.AUGUST,20), false));
        demerge.add(new DemergingQueue(3,"Thuan",new Date(98,Calendar.SEPTEMBER,16), false));
        demerge.add(new DemergingQueue(4,"Ngoc",new Date(97,Calendar.MARCH,3), true));
        demerge.add(new DemergingQueue(5,"Sang",new Date(96,Calendar.MAY,6), true));
        demerge.add(new DemergingQueue(6,"Vi",new Date(92,Calendar.JUNE,3), false));
        demerge.add(new DemergingQueue(7,"Tung",new Date(88,Calendar.JANUARY,20), true));
        demerge.add(new DemergingQueue(8,"Khoa",new Date(99,Calendar.FEBRUARY,25), false));
        demerge.add(new DemergingQueue(9,"Van",new Date(98,Calendar.MARCH,8), false));
        demerge.add(new DemergingQueue(10,"Nghia",new Date(97,Calendar.JUNE,9), true));
        demerge.add(new DemergingQueue(11,"Huu Duc",new Date(96,Calendar.DECEMBER,16), true));
        demerge.add(new DemergingQueue(12,"Le Van Quang",new Date(93,Calendar.AUGUST,17), true));
        demerge.add(new DemergingQueue(13,"Dong",new Date(85,Calendar.MARCH,7), true));

        System.out.println("Pre-sort");
        for(DemergingQueue demergingQueue : demerge) {
            System.out.print(demergingQueue);
        }

        Queue<DemergingQueue> queueNu = new ArrayDeque<>();
        Queue<DemergingQueue> queueNam = new ArrayDeque<>();

        ComparatorByDate copa = new ComparatorByDate();

        //  demerge.sort(copa); sort truoc khi dua vao trong Queue
        Collections.sort(demerge,copa);

        for(DemergingQueue queue : demerge) {
            if (!queue.isGender()) {
                queueNu.offer(queue);
            } else {
                queueNam.offer(queue);
            }
        }
        ArrayList<DemergingQueue> list = new ArrayList<>();

        while (!queueNu.isEmpty()) {
            list.add(queueNu.poll());
        }
        while (!queueNam.isEmpty()) {
            list.add(queueNam.poll());
        }
        System.out.println("LIST\n"+list);

    }
}
