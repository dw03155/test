package co.yedam;

public class College {
	int number;
	String name;
	int engSco;
	int mathSco;

	public College(int number, String name, int engSco, int mathSco) {
		this.number = number;
		this.name = name;
		this.engSco = engSco;
		this.mathSco = mathSco;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEngSco() {
		return engSco;
	}

	public void setEngSco(int engSco) {
		this.engSco = engSco;
	}

	public int getMathSco() {
		return mathSco;
	}

	public void setMathSco(int mathSco) {
		this.mathSco = mathSco;
	}
	
	public void info() {
		String info = "학번 : " + number//
				+ "\n이름 : " + name //
				+ "\n영어점수 : " + engSco //
				+ "\n수학점수 : " + mathSco;
		System.out.println(info);
	}

}//end of class