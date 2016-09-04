/**
 * @author : Pujan Shrestha (Dreameeer)
 * Student IF: 11587794
 * Team 10
 * Professional programming practices
 */
package datamanagement;


// class UnitProxy
public class UnitProxy implements IUnit {
	private String UC;  // declare variable Unit Code as string and private
    private String un;	// declare variable Unit Name as string and private
    UnitManager   um;

    //construct a Subject object with specified unitcode and unit name 
    public UnitProxy( String unitCode, String unitName ) {
        this.UC = unitCode;
        this.un = unitName;
        um = UnitManager.UM(); 
    }
    
    // return Unit code
    public String getUnitCode() { 
        return this.UC;
    }
    
    // retuenr unit name 
    public String getUnitName() { 
            return this.un;       
    }
    
    // set the pass cut off marks according to the unit code
    public void setPsCutoff1(float cutoff) {
        um.getUnit(UC).setPsCutoff1(cutoff);
    }
    
	// return the pass cut off marks according to the unit code
    public float getPsCutoff() {
	        
		return um.getUnit(UC).getPsCutoff();
	}
	
    // set the credit cut off marks according to the unit code 
	public void setCrCutoff(float cutoff) {
		um.getUnit(UC).setCrCutoff(cutoff);
	    
	}
	// return the credit cut off marks according to the unit code    
	public float getCrCutoff() {
		return um.getUnit(UC).getCrCutoff();    
	}
	
	// set the distinction cut off marks according to the unit code
	public void setDiCutoff(float cutoff) {
		um.getUnit(UC).setDiCutoff(cutoff);
	}
	    
	// return the distinction cut off marks according to the unit code
	public float getDiCuttoff() {
		return um.getUnit(UC).getDiCuttoff();
	}
	// set high distinction cutt off marks according to the unit code
	public void setHdCutoff(float cutoff) {
	    um.getUnit(UC).setHdCutoff(cutoff);
	    
	}
	 
	//return the high distinction cut off marks according to the unit code
	public float getHdCutoff() {
		return um.getUnit(UC).getHdCutoff();
		
	}
	
	// Set ae cut off marks
	public void setAeCutoff(float cutoff) {
		um.getUnit(UC).setAeCutoff(cutoff);
	    
	}
	
	// return ae cut off marks   
	public float getAeCutoff() {
		return um.getUnit(UC).getAeCutoff();
	}
	
	// retuen the marks obtained in all the assesment in the soecific subject
	public String getGrade(float f1, float f2, float f3) {
		return um.getUnit(UC).getGrade(f1, f2, f3);  
	}
	
	// add student record for the specific subject 
	public void addStudentRecord(IStudentUnitRecord record) { 
		um.getUnit(UC).addStudentRecord(record);  
	}
	 
	// return the records of a student  in the specified unit
	public IStudentUnitRecord getStudentRecord(int s) {
		return um.getUnit(UC).getStudentRecord(s);
	}
	
	//returns the records of all the  student  in the specified unit
	public StudentUnitRecordList listStudentRecords() {
	    return um.getUnit(UC).listStudentRecords();
	}
	
	// returns the assignment 1 total weight 
	public int getAsg1Weight() {
		return um.getUnit(UC).getAsg1Weight();
	}
	
	// returns the assignement 2 total weight
	public int getAsg2Weight() {
		return um.getUnit(UC).getAsg2Weight();
	}
	
	//returns the total weight for the exam
	public int getExamWeight() {
		return um.getUnit(UC).getExamWeight();
	}
	
	//set the assessment weight for assignement 1, assignment 2 and exam
	public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
		um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
		
	}
}
