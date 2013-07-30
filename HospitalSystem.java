
	public class HospitalSystem {
		 Patient patientListStart = null;
		Patient lastPatient = null;
		
		public void addPatient(Patient newPatient) {
			if(patientListStart == null){
				patientListStart = newPatient;
				lastPatient = newPatient;
			}
			else{
				Patient pos = lastPatient; 
				pos.nextPatient = newPatient; //this is where the link to next patient is
				newPatient.prevPatient = pos; //this is the link to the previous patient
				newPatient.nextPatient = patientListStart;
				patientListStart.prevPatient = newPatient;
				lastPatient = newPatient;
			}
			
		}	
		
		
		public void deletePatient(Patient oldPatient) { 
			Patient current = patientListStart;
			while (current != null) {
				if (current.name.equals(oldPatient.name)){
					if (current.nextPatient != null) {
						current.nextPatient.prevPatient = current.prevPatient;
					}
					else {
						current.prevPatient.nextPatient = null;
						
					}
					if (current.prevPatient != null) {
						current.prevPatient.nextPatient = current.nextPatient;
					}
					else {
						current.nextPatient.prevPatient = null;
						patientListStart = current.nextPatient; //else the head is still pointing to firstperson
					}
					
					break;
				}
				else {
					current = current.nextPatient;
					
				}	
			}
		}	
		
		
		public void peep(){
			
			Patient counter = patientListStart;
			while (counter != null) { //&& (!counter.name.equals("-1"))) {
				System.out.println("Patient name: " + counter.name);
					
				if (counter.nextPatient != null) {
					counter = counter.nextPatient;
				}
				else {
					break;
				}
			}	
			
			while (counter != null) {
				System.out.println("Patient name: " + counter.name);
				
				if (counter.prevPatient != null) {
					counter = counter.prevPatient;
				}
				else {
					break;
				}	
			}
		}	

				
		public static void main(String[] args) {
			boolean stop = false;
			HospitalSystem hospitalSystem = new HospitalSystem();
			hospitalSystem.launch();
			hospitalSystem.peep();
			hospitalSystem.deleterlaunch();
			hospitalSystem.peep();
			
			//hospitalSystem.addMore();
			//
			//hospitalSystem.peep();
			System.out.println("what would you like to do next? Choose from the following options:");
			System.out.println("0 - Exit");
			System.out.println("1 - Add patients");
			System.out.println("2 - Delete a patient");
			System.out.println("3 - Display patient list");
			String str = System.console().readLine();
			if (str.equals("0")) {
					
			}
			if (str.equals("1")) {
				hospitalSystem.launch();
			}
			if(str.equals("2")) {
				hospitalSystem.deleterlaunch();
			}
			if(str.equals("3")) {
				hospitalSystem.peep();
			}		
			
			
		}
	
			
			
			
		public void launch() {
			// add someting to take in new patients from user
			
				System.out.println("key in patient names, hitting enter after each. enter -1 when you have finished entering names");
			while(true) {	
				System.out.println("Patient: ");
				String str = System.console().readLine();
				if (str.equals("-1")){
					break;
				}
				
				Patient firstPatient = new Patient(str);
				addPatient(firstPatient);
			 
				}	
			} 
			
		
		public void deleterlaunch() {
 				
			System.out.println("What is the name of the patient so I can remove them from the records?");
			String str = System.console().readLine();
			Patient removePatient = new Patient(str);
			deletePatient(removePatient);	
		
		}	
		
	
		
		
	}