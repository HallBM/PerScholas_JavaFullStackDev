package genericdemo;

public class GenericMultipleDataType<Datatypeone, DatatypeTwo> {
	Datatypeone valueOne;
	DatatypeTwo valueTwo;

	public GenericMultipleDataType(Datatypeone v1, DatatypeTwo v2) {
		this.valueOne = v1;
		this.valueTwo = v2;
	}
	
	public Datatypeone getValueOne() {
		return valueOne;
	}

	public void setValueOne(Datatypeone valueOne) {
		this.valueOne = valueOne;
	}

	public DatatypeTwo getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(DatatypeTwo valueTwo) {
		this.valueTwo = valueTwo;
		valueTwo.toString();
	}
}
