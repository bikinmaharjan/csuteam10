package datamanagement;

public interface IStudentUnitRecord {

    public Integer getStudentID();
    public String getUnitCode();

    public void setAsg1(float mark);
    public float getAsg1();

    public void setAsg2(float mark);
    public float getAsg2();

    public void setExam(float mark);
    public float getExam();

    public float getTotal();
}
