package inheritancedemo;

public class Hospital {
	
	public static void main(String args[]) {

		//s.Doctor_Details();
		//s.Surgeon_Details();
		
		Surgeon s = new Surgeon();
		Doctor d = new Doctor();
		
		d.DoctorName = "Mark";
		s.DoctorName = "Jim";
				
		System.out.println(d.DoctorName);
		System.out.println(s.DoctorName);
	}
}
