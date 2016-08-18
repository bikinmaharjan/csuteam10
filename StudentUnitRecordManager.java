package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager {

private static StudentUnitRecordManager s = null;
            private StudentUnitRecordMap rm;
    private java.util.HashMap<String,StudentUnitRecordList> ur;
private java.util.HashMap<Integer,StudentUnitRecordList> sr;
    public static StudentUnitRecordManager instance() {
        if (s == null ) s = new StudentUnitRecordManager(); return s;}
            private StudentUnitRecordManager() {
        rm = new StudentUnitRecordMap();
    ur = new java.util.HashMap<>();
    sr = new java.util.HashMap<>();}
    public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode ) {
IStudentUnitRecord ir = rm.get(studentID.toString()+unitCode);
return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);}

    private IStudentUnitRecord createStudentUnitRecord( Integer uid, String sid ) {
        IStudentUnitRecord ir;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
        if (uid.toString().equals(el.getAttributeValue("sid")) && sid.equals(el.getAttributeValue("uid"))) {
                ir = new StudentUnitRecord( new Integer(el.getAttributeValue("sid")),el.getAttributeValue("uid"),new Float(el.getAttributeValue("asg1")).floatValue(),new Float(el.getAttributeValue("asg2")).floatValue(),new Float(el.getAttributeValue("exam")).floatValue() );
               rm.put(ir.getStudentID().toString()+ir.getUnitCode(), ir);return ir;
}
}
throw new RuntimeException("DBMD: createStudent : student unit record not in file");}
        public StudentUnitRecordList getRecordsByUnit( String unitCode ) {
    StudentUnitRecordList recs = ur.get(unitCode);
    if ( recs != null ) return recs; 
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
    if (unitCode.equals(el.getAttributeValue("uid"))) recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
        }
        if ( recs.size() > 0 ) 
            ur.put(unitCode, recs); // be careful - this could be empty
            return recs;
        }

public StudentUnitRecordList getRecordsByStudent( Integer studentID ) {
    StudentUnitRecordList recs = sr.get(studentID);
    if ( recs != null ) return recs; recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
            if (studentID.toString().equals(el.getAttributeValue("sid"))) 
                recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
                if ( recs.size() > 0 ) 
                    sr.put(studentID, recs); // be careful - this could be empty
                        return recs;
    }

    public void saveRecord( IStudentUnitRecord irec ) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (irec.getStudentID().toString().equals(el.getAttributeValue("sid")) && irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
                el.setAttribute("asg1", new Float(irec.getAsg1()).toString());
                
                
                
        el.setAttribute("asg2", new Float(irec.getAsg2()).toString());
        el.setAttribute("exam", new Float(irec.getExam()).toString());
        XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
        return;
}}
        
        
        
        
    
        
        
        
        
        
        
        
        
        
        
        
        
                        throw new RuntimeException("DBMD: saveRecord : no such student record in data");}}
