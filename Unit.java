package datamanagement;

public class Unit implements IUnit {
	private String uc;
	private String UN;
	private float co2;
	private float co1;
	private float co4;
	private float co3;
	private float co5;
	private int a1, a2, ex;
	
	private StudentUnitRecordList rs;

	public Unit(String UC, String un, float f1, float f2, float f3, float f4,
			float f5, int i1, int i2, int i3, StudentUnitRecordList rl) {

		uc = UC;
		UN = un;
		co2 = f1;
		co1 = f2;
		this.co4 = f3;
		co3 = f4;
		this.co5 = f5;
		this.setAssessmentWeights(i1, i2, i3);
		rs = rl == null ? new StudentUnitRecordList() : rl;
	}

	public String getUnitCode() {
		return this.uc;
	}

	public String getUnitName() {

		return this.UN;
	}

	public void setPsCutoff1(float cutoff) {
		this.co2 = cutoff;
	}

	public float getPsCutoff() {
		return this.co2;
	}

	public void setCrCutoff(float cutoff) {
		this.co1 = cutoff;
	}

	public float getCrCutoff() {
		return this.co1;
	}

	public void setDiCutoff(float cutoff) {
		this.co4 = cutoff;
	}

	public float getDiCuttoff() {
		return this.co4;
	}

	public void HDCutoff(float cutoff) {
		this.co3 = cutoff;
	}

	public void setHdCutoff(float cutoff) {
		this.co3 = cutoff;
	}

	public float getHdCutoff() {
		return this.co3;

	}

	public void setAeCutoff(float cutoff) {
		this.co5 = cutoff;
	}

	public float getAeCutoff() {
		return this.co5;
	}

	public void addStudentRecord(IStudentUnitRecord record) {
		rs.add(record);
	}

	public IStudentUnitRecord getStudentRecord(int studentID) {
		for (IStudentUnitRecord r : rs) {
			if (r.getStudentID() == studentID)
				return r;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() {
		return rs;
	}

	@Override
	public int getAsg1Weight() {
		return a1;
	}

	@Override
	public int getAsg2Weight() {
		return a2;
	}

	@Override
	public int getExamWeight() {
		return ex;
	}

	@Override
	public void setAssessmentWeights(int a1, int a2, int ex) {
		if (a1 < 0 || a1 > 100 ||
			a2 < 0 || a2 > 100 ||
			ex < 0 || ex > 100 ) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}			
		if (a1 + a2 + ex != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.a1 = a1;
		this.a2 = a2;
		this.ex = ex;			
	}
	
	private void setCutoffs( float ps, float cr, float di, float hd, float ae) {
		if (ps < 0 || ps > 100 ||
			cr < 0 || cr > 100 ||
			di < 0 || di > 100 ||
			hd < 0 || hd > 100 ||
			ae < 0 || ae > 100 ) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (ae >= ps) {
			throw new RuntimeException("AE cutoff must be less than PS cutoff");
		}
		if (ps >= cr) {
			throw new RuntimeException("PS cutoff must be less than CR cutoff");
		}
		if (cr >= di) {
			throw new RuntimeException("CR cutoff must be less than DI cutoff");
		}
		if (di >= hd) {
			throw new RuntimeException("DI cutoff must be less than HD cutoff");
		}

	}
	
	public String getGrade(float f1, float f2, float f3) {
		float t = f1 + f2 + f3;
		
		if (f1 < 0 || f1 > a1 ||
			f2 < 0 || f2 > a2 ||
			f3 < 0 || f3 > ex ) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		}

		if (t < co5) {
			return "FL";
		} else if (t < co2)
			return "AE";
		else if (t < co1)
			return "PS";
		else if (t < co4)
			return "CR";
		else if (t < co3)
			return "DI";
		else
			return "HD";
	}

	
}