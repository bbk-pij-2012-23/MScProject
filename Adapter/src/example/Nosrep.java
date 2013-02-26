package example;

public class Nosrep implements AnotherPerson {
	private Person person;
	
	public Nosrep(){
		person= new Person();
	}
	
	@Override
	public String youWho() {
		
		return person.whoAreYou();
	}
	
	
}
