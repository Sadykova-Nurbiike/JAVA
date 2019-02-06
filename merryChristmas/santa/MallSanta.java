package santa;

public class MallSanta extends SantaSaying{
	
	//Attributes
	private Kid kid;
	private String mallName;
	
	//Constructor
	public MallSanta(Kid kid, String mallName){
		
		this.kid = kid;
		this.mallName = mallName;
	}
	
	//Getters and setters
	public Kid getKid(){
		return kid;
	}
	
	public void setKid(Kid kid){
		this.kid = kid;
	}
	
	public String getMallName(){
		return mallName;
	}
	
	public void setMallName(String mallName){
		this.mallName = mallName;
	}
	
	//Methods
	
	@Override
	public String merryChristmas(String name){
		return super.merryChristmas(name) + ", enjoy shopping with  " + this.mallName;
	}
	
	public String merryChristmas(){
		return merryChristmas(this.kid.getName());
	}
} 