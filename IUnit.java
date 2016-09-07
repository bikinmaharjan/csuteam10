/**
 * @author Bishal Sapkota (sapkotabishal10)
 * IUnit
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

//contains public signatures and fields for polymorphism
public interface IUnit {
	
	//getters and setters for UnitCode
	public String getUnitCode();
    public String getUnitName();
    
    //getters and setters for Pass cut off marks
    public float getPsCutoff();
    public void  setPsCutoff1(float cutoff);
    
    //getters and setters for Credit cut off marks
    public float getCrCutoff();
    public void  setCrCutoff(float cutoff);
    
    //getters and setters for Distinction cut off marks
    public float getDiCuttoff();    
    public void  setDiCutoff(float cutoff);
    
    //getters and setters for High DIstinction cut off marks
    public float getHdCutoff();
    public void  setHdCutoff(float cutoff);    
    
    //getters and setters for AeCutoff
    public float getAeCutoff();    
    public void  setAeCutoff(float cutoff);
    
    //getters for Asg1,Asg2 and Asg3 weight.
    public int getAsg1Weight();
    public int getAsg2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);//setters for the asg weight
    
    //getters for Grade of asg 1,2 and 3
    public String getGrade(float asg1, float asg2, float exam);
    
    //adds records to IStudentUnitRedord
    public void addStudentRecord(IStudentUnitRecord record );
    public IStudentUnitRecord getStudentRecord(int studentID );
    
    public StudentUnitRecordList listStudentRecords();
}
