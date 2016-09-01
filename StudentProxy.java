/**
 * @author : Bikin Maharjan (Neptron)
 */
//importing package from datamanagement folder
package datamanagement;

//Public class that implemented IStudent was created
public class StudentProxy implements IStudent {
	//Required private data entities were created
	private Integer I;
	private String l;
    private String Il;
    private StudentManager lI;
    
    //Constructor that took three data id, fn and Il was created
    public StudentProxy( Integer id, String fn, String Il) {
        this.I = id;
        this.l = fn;
        this.Il = Il;
        this.lI = StudentManager.get();}

    //get Method to getID
    public Integer getID() { 
    	return I; 
    }
    
    //get Method to getFirstName
    public String getFirstName() { 
        return l; 
    }
    
    //get Method to getLastName
    public String getLastName() { 
    	return Il; 
    }
    
    //set Method to setFirstName
    public void setFirstName(String firstName) {    
    	lI.getStudent(I).setFirstName(firstName);
    }
    
    //set Method to setLastName
    public void setLastName(String lastName) {
    	lI.getStudent(I).setLastName(lastName);
    }
    
    //public void method that adds student record to lI
    public void addUnitRecord(IStudentUnitRecord record) {
        lI.getStudent(I).addUnitRecord(record);
    }
    
    //get Mehtod to get unitCode of a student
    public IStudentUnitRecord getUnitRecord(String unitCode) {
    	return lI.getStudent(I).getUnitRecord(unitCode);
    }
    
    //get Method to get Records 
	public StudentUnitRecordList getUnitRecords() {
		return lI.getStudent(I).getUnitRecords();
	}
}
