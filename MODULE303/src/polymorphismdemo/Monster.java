package polymorphismdemo;

public class Monster {

	public String name;

	public Monster(String name) {
		this.name = name;
	}

	public String attack() {
		return "!@#$% I don't know how to attack!";
	}

}

class FireMonster extends Monster {

//	public String name;

	public FireMonster(String name) {
		super(name);
	}

	public String attack() {
		return "Attack with fire!";
	}

}

class WaterMonster extends Monster {

//	public String name;

	public WaterMonster(String name) {
		super(name);
	}

	public String attack() {
		return "Attack with water!";
	}

}

class StoneMonster extends Monster {

//	public String name;

	public StoneMonster(String name) {
		super(name);
	}

	public String attack() {
		return "Attack with stones!";
	}

}