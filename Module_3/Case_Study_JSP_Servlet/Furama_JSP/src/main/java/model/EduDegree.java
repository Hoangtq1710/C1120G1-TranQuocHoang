package model;

public class EduDegree {
    private int eduDegreeId;
    private String eduDegreeName;

    public EduDegree() {
    }

    public EduDegree(int eduDegreeId, String eduDegreeName) {
        this.eduDegreeId = eduDegreeId;
        this.eduDegreeName = eduDegreeName;
    }

    public int getEduDegreeId() {
        return eduDegreeId;
    }

    public void setEduDegreeId(int eduDegreeId) {
        this.eduDegreeId = eduDegreeId;
    }

    public String getEduDegreeName() {
        return eduDegreeName;
    }

    public void setEduDegreeName(String eduDegreeName) {
        this.eduDegreeName = eduDegreeName;
    }
}
