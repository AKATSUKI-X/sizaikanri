package co.jp.mamol.myapp.dto;
/*
 * ユーザ情報DTO
 */
public class UserDto {
//ユーザID
	private String id;
	//パスワード
	private String password;
	//ユーザ名
	private String name;
	//部署ID
	private String depid;
	//部署名
	private String depname;
	//連絡先
	private String tel;
	//権限区分
	private String role_class;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole_class() {
		return role_class;
	}
	public void setRole_class(String role_class) {
		this.role_class = role_class;
	}


}

