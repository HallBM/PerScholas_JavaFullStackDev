package testing;

@FunctionalInterface
public interface Example {
	public void display(String a);
	static void doMoreWork() {System.out.println("a");}
}
