package jdbc;

public class Student {
    private String sno;
    private String sname;
    private int sage;
    private String ssex;
    private String spe_id;
    public Student() {
	}
    
	public Student(String sno, String sname, int sage, String ssex,
			String spe_id) {
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.spe_id = spe_id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSpe_id() {
		return spe_id;
	}
	public void setSpe_id(String spe_id) {
		this.spe_id = spe_id;
	}
    public String toString(){
    	return sno+","+sname+","+sage+","+ssex+","+spe_id;
    }
}
