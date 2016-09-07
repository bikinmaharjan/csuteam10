/**
 * @author : Bikin Maharjan (Neptron)
 */

//importing package from datamanagement folder
package datamanagement;

//importing required util and jdom
import org.jdom.*;
import java.util.List;

//Public class StudentManager was created
public class StudentManager {
    //private data entities were created
	private static StudentManager self = null;
    
    private StudentMap sm;
    
    //HashMap was created that stored string as Key and Object StudentMap as value
    private java.util.HashMap<String, StudentMap> um;
    
    //get method for Student Manager
    public static StudentManager get() {
        if (self == null) 
            self = new StudentManager(); 
        	return self; 
        }
    
    //no-arg constructor
    private StudentManager() {    
        sm = new StudentMap();
        um = new java.util.HashMap<>();
    }
    
    //a get method to get Student id from Interface IStudent    
    public IStudent getStudent(Integer id) {
    	IStudent is = sm.get(id);
    	return is != null ? is : createStudent(id);
    }
    
	//a private get method to get id from XML database 
    private Element getStudentElement(Integer id) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
            if (id.toString().equals(el.getAttributeValue("sid"))){ //If the student id is present in the database return el 
            	return el;
        }
        	return null; //else return null
    }
    
    //private methodto create new Student id            
    private IStudent createStudent(Integer id) {
        IStudent is;
        Element el = getStudentElement(id);
        if (el != null) { //If user enters a new student Id then add it to the XML
            StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
            is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);    
            sm.put(is.getID(), is);
            return is; 
        }
        
        throw new RuntimeException("DBMD: createStudent : student not in file"); //throws Exception run time error if the student file is not present
    }
    
    //private method to create Student Proxy from Data entered from interface
    private IStudent createStudentProxy(Integer id) {
        Element el = getStudentElement(id);        
        if (el != null) return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

	//public getter method that gets Students by unit from studentMap class
    public StudentMap getStudentsByUnit(String uc) {
        StudentMap s = um.get(uc);
        if (s != null) {    //if the data from the Object is not null then return s
        	return s;
        }

        s = new StudentMap();
        IStudent is;
        StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        
        for (IStudentUnitRecord S : ur) {            //loop to loop if the user keeps on entering user data
            is = createStudentProxy(new Integer(S.getStudentID()));
            s.put(is.getID(), is);}
        	um.put( uc, s);
        	return s;
    }
}
