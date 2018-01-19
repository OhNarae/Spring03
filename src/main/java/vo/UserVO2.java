package vo;

public class UserVO2 {

	@Override
	public String toString() {
		return "사용자정보 [name=" + name + ", age=" + age + ", mphone=" + mphone + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	String name;
	String age;
	String mphone;
	
	
}
