package porter.json;

public class Avatar {
	
	private String name;
	private int age;
	private String hairColor;
	private String height;
	private String bodyType;
	
	public Avatar(String name, int age, String hairColor, String height, String bodyType) {
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
		this.height = height;
		this.bodyType = bodyType;
	}

	// Getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	// To string method
	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nHair Color: " + 
				hairColor + "\nHeight: " + height + "\nBody Type: " + bodyType;
	}
}
