/**
 * @author Bishal Sapkota (sapkotabishal10)
 * IStudent.java
 * Edits: All the required comments are added and made the code presentable
 */

package datamanagement;

//contains public signatures and fields for polymorphism
public interface IStudent {

    public Integer getID(); //variable for student ID
    
    //getters and setters for the first name
    public String getFirstName(); 
    public void setFirstName(String firstName);
    
    //getters and setters for the last name
    public String getLastName();
    public void setLastName(String lastName);
    
    //adds records to IStudentUnitRedord
    public void addUnitRecord( IStudentUnitRecord record );
    public IStudentUnitRecord getUnitRecord( String unitCode );
    
    //gets records from StudentUnitRecordLost
    public StudentUnitRecordList getUnitRecords();
}
