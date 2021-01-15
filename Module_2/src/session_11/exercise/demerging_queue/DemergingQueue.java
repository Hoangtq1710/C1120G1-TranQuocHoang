package session_11.exercise.demerging_queue;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemergingQueue {
    private int id;
    private String name;
    private Date dob;
    private boolean gender = true;

    public DemergingQueue() {
    }

    public DemergingQueue(int id, String name, Date dob, boolean gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String formatDob(Date dob) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatDate.format(dob);
        return date;
    }
    public String displayGender(boolean gender) {
        String display = "";
        if (gender) {
            display = "NAM";
        } else {
            display = "NU";
        }
        return display;
    }

    @Override
    public String toString() {
        return  "Employee "+this.id+
                ", Name "+this.name+
                ", Day Of Birth "+this.formatDob(this.dob)+
                ", Gender "+this.displayGender(this.gender)+"\n";
    }
}
