package introclassdemo;

// Module 303.4, Lab 3

public class Lamp {
    // "isOn" stores the value for light: true if light is on, false if light is off
	private boolean isOn;
	
	public Lamp () {
		this.isOn = false; // default light status is off.
	}
	
	public Lamp (boolean light_status) {
		this.isOn = light_status;
	}
	
    // Please implement method to turn on the light
    public void turnOn() {
    	this.isOn = true;
    }
    
    // Please implement  method to turn off the light
    public void turnOff() {
    	this.isOn = false;
    }

    public boolean getLightStatus() {
    	return this.isOn;
    }
    
    public String printStatus() {
    	return (this.getLightStatus() ? "Light is on." : "Light is off.");
    }
    
    public static void main(String[] args) {

        // create objects led and halogen
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();

        // turn on the light by calling method turnOn()
        System.out.println("Turn on LED");
        System.out.println("Beginning state of LED: " + led.printStatus());   
        led.turnOn();
        System.out.println("Ending state of LED: " + led.printStatus());
        System.out.println();

        // turn off the light by calling method turnOff()
        System.out.println("Turn off Halogen");
        System.out.println("Beginning state of Halogen: " + halogen.printStatus());
        halogen.turnOff();
        System.out.println("Ending state of Halogen: " + halogen.printStatus());
        System.out.println();
        
        // create new lights with constructor overload
        Lamp incandescent  = new Lamp(true);
        System.out.println("Turn off Incandescent");
        System.out.println("Beginning state of Incandescent: " + incandescent.printStatus());
        incandescent.turnOff();
        System.out.println("Ending state of Incandescent: " + incandescent.printStatus());
        System.out.println();
        
        // create new lights with constructor overload
        Lamp neon = new Lamp(false);
        System.out.println("Turn on Neon");
        System.out.println("Beginning state of Neon: " + neon.printStatus());
        neon.turnOn();
        System.out.println("Ending state of Neon: " + neon.printStatus());
        System.out.println();
        
	}

}
