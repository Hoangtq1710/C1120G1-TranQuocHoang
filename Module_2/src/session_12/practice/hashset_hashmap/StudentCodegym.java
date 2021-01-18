package session_12.practice.hashset_hashmap;

public class StudentCodegym {
    private String name;
    private int id;
    private boolean gender;

    public StudentCodegym() {
    }

    public StudentCodegym(String name, int id, boolean gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public String displayGender(){
        if (this.isGender()) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    @Override
    public String toString() {
        return "Student of Codegym : Id "+this.id+
                ", Name "+this.name+
                ", Gender "+this.displayGender();
    }
}
