package session_11.exercise.demerging_queue;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<DemergingQueue> {
    @Override
    public int compare(DemergingQueue e1, DemergingQueue e2) {
        int year = e1.getDob().getYear() - e2.getDob().getYear();
        int month = e1.getDob().getMonth() - e2.getDob().getMonth();
        int day = e1.getDob().getDay() - e2.getDob().getDay();
        if (year < 0) {
            return 1;
        } else if (year > 0) {
            return -1;
        } else {
            if (month < 0) {
                return 1;
            } else if (month > 0) {
                return -1;
            } else {
                if (day < 0) {
                    return 1;
                } else if (day > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

}
