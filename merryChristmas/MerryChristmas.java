import santa.*;

import java.util.*;

public class MerryChristmas{
	
	public static void main(String[] args){
		
		//Grade 2
		Kid kid1 = new Kid(2016,"Josh","male",true);
		Kid kid2 = new Kid(2012,"Amanda","female",true);
		Kid kid3 = new Kid(2010,"Robert","male",false);
		
		MallSanta mallSanta1 = new MallSanta(kid1,"TescoMall");
		MallSanta mallSanta2 = new MallSanta(kid3,"Allee");
		
		System.out.println(mallSanta1.hoHoHo());
		System.out.println(mallSanta1.merryChristmas());
		System.out.println(mallSanta1.merryChristmas(kid2.getName()));
		System.out.println(mallSanta2.merryChristmas());
		
		
		//Grade 3
		
		SantaDelivery santaDelivery1 = null, santaDelivery2 = null, santaDelivery3 = null;
		
		Boolean isParsed = true;
		
		try{
		santaDelivery1 = new SantaDelivery(kid1,"12:45","Pazmany Peter setany");
		santaDelivery2 = new SantaDelivery(kid2,"15:00","Deak ter");
		santaDelivery3 = new SantaDelivery(kid3,"12:23","London 22");
		}catch (Exception e){
			System.out.println("Parse error!");
            isParsed = false;
        }
		
		if(isParsed){
		System.out.println(santaDelivery1);
		System.out.println(santaDelivery2);
		System.out.println(santaDelivery3);
		}
		
		//Grade 4 
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1st kid's name:");
		String newName = sc.next();
		System.out.print("1st kid's birthYear:");
		int newYear = sc.nextInt();
		System.out.println("1st kid's gender:");
		String newGender = sc.next();
		Kid newKid1 = new Kid(newYear,newName,newGender,true);
		
		System.out.println("2nd kid's name:");
		newName = sc.next();
		System.out.println("2nd kid's birthYear:");
		newYear = sc.nextInt();
		System.out.println("2nd kid's gender:");
		newGender = sc.next();
		Kid newKid2 = new Kid(newYear,newName,newGender,true);
		
		if(newKid1.equals(newKid2)){
			System.out.println("2 kids are equal.");
		}
		else{
			System.out.println("2 kids are not equal.");
		}
		
		//Grade 5
		ArrayList<Kid> kids = new ArrayList<Kid>();
		
		System.out.println("N:");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++){
		System.out.println((i+1)+" kid's name:");
		newName = sc.next();
		System.out.println((i+1)+" kid's birthYear:");
		newYear = sc.nextInt();
		System.out.println((i+1)+" kid's gender:");
		newGender = sc.next();
		kids.add(new Kid(newYear,newName,newGender,true));
		}
		
		ArrayList<Kid> kids1 = new ArrayList<Kid>();
		ArrayList<Kid> kids2 = new ArrayList<Kid>();
		
		kids1.add(kids.get(0));
		for(int i=1;i<n;i++){
			if((kids1.get(0).getName().compareTo(kids.get(i).getName()))>0){
				kids1.add(kids.get(i));
			}
			else{
				kids2.add(kids.get(i));
			}
		}
		
		System.out.print("1st list: ");
		for(Kid kid: kids1){
			System.out.print(kid.getName() + " ");
		}

		System.out.println();
		System.out.println("2nd list: ");
		for(Kid kid: kids2){
			System.out.print(kid.getName() + " ");
		}
	
}}
	
