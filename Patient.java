public class Patient {
	 String name;
	 Patient nextPatient;
	 Patient prevPatient;
	
	public Patient(String name) {
		this.name = name;
		this.nextPatient = null;
		this.prevPatient = null;
	}
    
    public String getName() {
        return name;
    }
    
    public Patient getNext () {
        return nextPatient;
    }
    
    public Patient getPrev(){
        return prevPatient;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setNext(Patient nextPatient){
        this.nextPatient = nextPatient;
    }
    
    public void setPrev (Patient prevPatient){
        this.prevPatient = prevPatient;
    }
}

	
	
/*
	public static void main(String[] args) {
		Patient patient = new Patient();
		patient.launch();
	}
*/

	
	