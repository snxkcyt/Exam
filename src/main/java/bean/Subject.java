package bean;

public class Subject implements java.io.Serializable {

	private String cd;
	private String name;
	private String school;
	
	public String getCd() {
		return cd;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSchool() {
		return school;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
}