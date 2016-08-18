package datamanagement;
public class UnitProxy implements IUnit {
private String UC;
        private String un;

        
        UnitManager   um;

    public UnitProxy( String unitCode, String unitName ) {
        this.UC = unitCode;
            this.un = unitName;
                um = UnitManager.UM(); }
    public String getUnitCode() { 
        return this.UC;}
        public String getUnitName() { 
            return this.un; 
        }
    public void setPsCutoff1(float cutoff) {
        um.getUnit(UC).setPsCutoff1(cutoff);
}
public float getPsCutoff() {
        return um.getUnit(UC).getPsCutoff();}
    public void setCrCutoff(float cutoff) {um.getUnit(UC).setCrCutoff(cutoff);
    }
    public float getCrCutoff() {
return um.getUnit(UC).getCrCutoff();
    }

public void setDiCutoff(float cutoff) {um.getUnit(UC).setDiCutoff(cutoff);}
    public float getDiCuttoff() {return um.getUnit(UC).getDiCuttoff();}
public void setHdCutoff(float cutoff) {
    um.getUnit(UC).setHdCutoff(cutoff);}
    public float getHdCutoff() {

        return um.getUnit(UC).getHdCutoff();}
public void setAeCutoff(float cutoff) {um.getUnit(UC).setAeCutoff(cutoff);
    }
    public float getAeCutoff() {return um.getUnit(UC).getAeCutoff();}
public String getGrade(float f1, float f2, float f3) {
return um.getUnit(UC).getGrade(f1, f2, f3);
    }
    public void addStudentRecord(IStudentUnitRecord record) 
{ 
um.getUnit(UC).addStudentRecord(record);
    }
    public IStudentUnitRecord getStudentRecord(int s) {return um.getUnit(UC).getStudentRecord(s);}
public StudentUnitRecordList listStudentRecords() {
    return um.getUnit(UC).listStudentRecords();
}
public int getAsg1Weight() {
	return um.getUnit(UC).getAsg1Weight();
}
public int getAsg2Weight() {
	return um.getUnit(UC).getAsg2Weight();
}
public int getExamWeight() {
	return um.getUnit(UC).getExamWeight();
}
public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
	um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	
}}
