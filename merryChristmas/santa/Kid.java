package santa;

public class Kid{
	
	//Attributes
	private int birthYear;
	private String name;
	private String gender;
	private Boolean goodKid;
	
	//Constructor
	public Kid(int birthYear, String name, String gender, Boolean goodKid){
		this.birthYear = birthYear;
		this.name = name;
		this.gender = gender;
		this.goodKid = goodKid;
	}
	
	//Getters and setters
	public int getBirthYear(){
		return birthYear;
	}
	
	public void setBirthYear(int birthYear){
		this.birthYear = birthYear;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public Boolean isGoodKid(){
		return goodKid;
	}
	
	public void setGoodKid(Boolean goodKid){
		this.goodKid = goodKid;
	}
	
	//Methods
	public int getAge(){
		return 2017 - this.birthYear;
	}
	
	@Override
	public String  toString(){
		return this.name + " (" + this.getAge() + "," + this.gender + ")";
	}
	 
	public Boolean equals(Kid other){
		if(this == other){
			return true;
		}
		if(other == null){
			return false;
		}
		if (getClass() != other.getClass()){
  		return false;
		}
		Kid k = (Kid)other;
		return (this.name.equals(k.getName()) && this.birthYear==k.getBirthYear()) && this.gender.equals(k.getGender());
	}

}