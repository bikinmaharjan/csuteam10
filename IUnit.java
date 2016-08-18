package datamanagement;

public interface IUnit {

    public String getUnitCode();
    public String getUnitName();

    public float getPsCutoff();
    public void  setPsCutoff1(float cutoff);

    public float getCrCutoff();
    public void  setCrCutoff(float cutoff);

    public float getDiCuttoff();    
    public void  setDiCutoff(float cutoff);

    public float getHdCutoff();
    public void  setHdCutoff(float cutoff);    

    public float getAeCutoff();    
    public void  setAeCutoff(float cutoff);
    
    public int getAsg1Weight();
    public int getAsg2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

    public String getGrade(float asg1, float asg2, float exam);

    public void addStudentRecord(IStudentUnitRecord record );
    public IStudentUnitRecord getStudentRecord(int studentID );
    
    public StudentUnitRecordList listStudentRecords();
}
