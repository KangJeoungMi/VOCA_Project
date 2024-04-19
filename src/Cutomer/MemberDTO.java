package Cutomer;

public class MemberDTO {
	private String Name;
	private String Id;
	private String Pw;
	private String Tel;
	private String Email;
	
	public MemberDTO() {}
	public MemberDTO(String name, String id, String pw, String tel, String email){
		super();
		this.Name = name;
		this.Id = id;
		this.Pw = pw;
		this.Tel = tel;
		this.Email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	

}
