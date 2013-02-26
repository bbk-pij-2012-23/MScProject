package example;

public class PAP extends Person implements AnotherPerson {
/*
 * (non-Javadoc)
 * @see example.AnotherPerson#youWho()
 */
	@Override
	public String youWho() {
		
		return whoAreYou();
	}

}
