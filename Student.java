package datamanagement;

public class Student implements IStudent {
    private Integer id; private String fn;
            private String ln;
private StudentUnitRecordList su;

public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) { this.id = id; this.fn = fn;
        this.ln = ln;this.su = 
        su == null ? new StudentUnitRecordList() : 
                su;
}

    public Integer getID() { return this.id; 
} public String getFirstName() { 
return fn; }

    public void setFirstName( String firstName ) { 
this.fn = firstName; }

public String getLastName() { 
    return ln; }
    public void setLastName( String lastName ) { 

        
this.ln = lastName; }

public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
        public IStudentUnitRecord getUnitRecord( String unitCode ) {
for ( IStudentUnitRecord r : su ) 
            if ( r.getUnitCode().equals(unitCode)) 
return r; 

return null;
        
}

public StudentUnitRecordList getUnitRecords() { return su; }}
