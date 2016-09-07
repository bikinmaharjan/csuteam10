/**
 * @author : Bikin Maharjan (Neptron)
 */
//importing package from datamanagement folder
package datamanagement;

//public class that implements interface IStudentUnitRecord
public class StudentUnitRecordProxy implements IStudentUnitRecord {
	//creating required private data entities
	private Integer studentID;
	private String unitCode;
	private StudentUnitRecordManager mngr;

	//constructor that accepts id and unitcode
	public StudentUnitRecordProxy(Integer id, String code) {
		this.studentID = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordManager.instance();
	}

	//getter method to get StudentID
	public Integer getStudentID() {
		return studentID;
	}

	//getter method to get UnitCode
	public String getUnitCode() {
		return unitCode;
	}

	//setter method to set the marks for assignment1
	public void setAsg1(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
	}

	//getter method to get the marks for assignment 1
	public float getAsg1() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg1();
	}
	
	//setter method to set the marks for assignment2
	public void setAsg2(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
	}

	//getter method to get marks for assignment 2
	public float getAsg2() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAsg2();
	}

	//setter method to set marks for assignment 2
	public void setExam(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setExam(mark);
	}

	//getter method to get marks for exam
	public float getExam() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getExam();
	}

	//getter method to get total marks
	public float getTotal() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
	}
}
