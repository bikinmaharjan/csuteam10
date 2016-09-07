/**
 * @author : Bikin Maharjan (Neptron)
 */
//importing package from datamanagement folder
package datamanagement;
//A public class StudentUnitRecord was created that implemented IStudentUnitRecord
public class StudentUnitRecord implements IStudentUnitRecord {
	//required private data entities were created
	private Integer sid;
	private String uc;
	private float a1, a2, ex;
	
	//constructor was created that took id, code, assignment 1, assignment 2 and exam marks. 
	public StudentUnitRecord(Integer id, String code, float asg1, float asg2,
			float exam) {
		this.sid = id;
		this.uc = code;
		this.setAsg1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}
	
	//getter method to get studentID
	public Integer getStudentID() {
		return sid;
	}
	
	//getter method to get a UnitCode
	public String getUnitCode() {
		return uc;
	}
	
	//setter method to set marks for assignment 1
	public void setAsg1(float a1) {
		if (a1 < 0 ||
			a1 > UnitManager.UM().getUnit(uc).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a1 = a1;
	}
	
	//getter method to get marks for assignment 1
	public float getAsg1() {

		return a1;
	}

	//setter method to set marks for assignment 2
	public void setAsg2(float a2) {
		if (a2 < 0 ||
			a2 > UnitManager.UM().getUnit(uc).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a2 = a2;

	}

	//getter method to get marks for assignment 2
	public float getAsg2() {
		return a2;
	}

	//setter method to set the marks for exam
	public void setExam(float ex) {
		if (ex < 0 ||
				ex > UnitManager.UM().getUnit(uc).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.ex = ex;
	}

	//getter method to get the marks for exam
	public float getExam() {
		return ex;
	}

	//getter method to get Total
	public float getTotal() {
		return a1 + a2 + ex;

	}
}
