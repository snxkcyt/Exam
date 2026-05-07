package bean;

public class Teacher implements java.io.Serializable {

	private String id;
	private String password;
	private String name;
	private String school_cd;

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSchool() {
		return school_cd;
	}
	
	
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setSchool(String school) {
		this.school_cd=school;
	}
	
}
