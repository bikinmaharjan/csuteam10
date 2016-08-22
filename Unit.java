package datamanagement;

/**class Unit*/

public class Unit implements IUnit {
	
	private String uc; // set the varaiable as private
	private String UN;   // set the varaiable as private
	private float co2;  // set the varaiable as private
	private float co1;  // set the varaiable as private
	private float co4;  // set the varaiable as private
	private float co3;  // set the varaiable as private
	private float co5;  // set the varaiable as private
	private int a1, a2, ex;  // set the varaiable as private
	
	private StudentUnitRecordList rs;  // set the varaiable as private
	/**Construct a Unit with specified values from the main method*/
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
	/** Returns Unit Code*/
	public String getUnitCode() {
		return this.uc;
	}
	/** Returns Unit Name*/
	public String getUnitName() {

		return this.UN;
	}
	/** Set Pass Cut off marks*/
	public void setPsCutoff1(float cutoff) {
		this.co2 = cutoff;
	}
	/** Returns Pass Cut off marks*/
	public float getPsCutoff() {
		return this.co2;
	}
	/** Set Credit Cut off Marks*/
	public void setCrCutoff(float cutoff) {
		this.co1 = cutoff;
	}
	/** Return Credit cutoff marks*/
	public float getCrCutoff() {
		return this.co1;
	}
	/** Set Distinction Cut off Marks*/
	public void setDiCutoff(float cutoff) {
		this.co4 = cutoff;
	}
	/** Return Distinctiont cutoff marks*/
	public float getDiCuttoff() {
		return this.co4;
	}
	
	/**
	public void HDCutoff(float cutoff) {
		this.co3 = cutoff;
	}
	*/
	/** Set High Distinction Cut off Marks*/
	public void setHdCutoff(float cutoff) {
		this.co3 = cutoff;
	}
	/** Return Distinctiont cutoff marks*/
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