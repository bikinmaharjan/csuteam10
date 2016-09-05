/**
 * @author Bishal Sapkota (sapkotabishal10)
 * IStudentUnitRecord
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

//contains public signatures and fields for polymorphism
public interface IStudentUnitRecord {
	
	//getters and setters for ID
	public Integer getStudentID();
    public String getUnitCode();

    //getters and setters for asg1 mark
    public void setAsg1(float mark);
    public float getAsg1();

    //getters and setters for asg2 mark
    public void setAsg2(float mark);
    public float getAsg2();

    //getters and setters for asg3 mark
    public void setExam(float mark);
    public float getExam();
    
    //getter for getting total mark
    public float getTotal();
}
