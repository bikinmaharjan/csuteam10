/**
 * @author : Bikin Maharjan (Neptron)
 */
package datamanagement; //Imported package from datamanagement

//A public class named Student was created that implements the interface IStudent
public class Student implements IStudent {
    //Private data types were created to store specific data.
	private Integer id; //Integer to store student it
    private String fn; //String to store first name
    private String ln; //String to store second name
    private StudentUnitRecordList su; //StudentUnitRecordList Object
    
    //Public Student Constructor was created that took all the data in the private class above
    public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) {
    	//Set the id to data retrieved from get methods.
    	this.id = id;
    	this.fn = fn;
        this.ln = ln;
        this.su = su == null ? new StudentUnitRecordList() : su;
    }
    
    //get method to get student id
    public Integer getID() {
    	return this.id; 
    }
    
    //get method for first name
    public String getFirstName() { 
    	return fn; 
    }
    
    //set method for first name
    public void setFirstName( String firstName ) { 
    	this.fn = firstName;
    }
    
    //get method for last name
    public String getLastName() { 
    	return ln; 
    }
    
    //set method for last name
    public void setLastName( String lastName ) { 
    	this.ln = lastName; 
    }
    
    //void method to add record to StudentUnitRecordList that is retrieved from the interface
    public void addUnitRecord( IStudentUnitRecord record ) {
    	su.add(record); 
    }
    
    // Object method for Interface that accepts a code and returns it if it matches the record
    public IStudentUnitRecord getUnitRecord( String unitCode ) {
    	for ( IStudentUnitRecord r : su ) 
            if ( r.getUnitCode().equals(unitCode)) 
            	return r; 

    		return null; //else return null
    		
    }
    
    //StudentUnitRecordList Object method that returns the record selected
    public StudentUnitRecordList getUnitRecords() {
    	return su; 
    }
}
