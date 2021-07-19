package co.yedam;

import java.util.Scanner;

public class CollegeApp {
	static College[] student = new College[10];
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			menu();
			int menu = scn.nextInt();
			if (menu == 1) { // 학생입력
				add();
			} else if (menu == 2) { // 학생수정
				modify();
			} else if (menu == 3) { // 학생삭제
				delete();
			} else if (menu == 4) { // 학생목록
				list();
			} else if (menu == 5) { // 학생조회(한건)
				search();
			} else if (menu == 6) { // 성적분석
				analysis();
			} else if (menu == 7) { // 종료
				break;
			}
		}
		System.out.println("프로그램 종료");

	}// end of main

	public static void menu() {
		System.out.println("◼◻◼◻◼◻◼◻◼◻");
		System.out.println("◻ 1.학생입력 ◼");
		System.out.println("◼ 2.학생수정 ◻");
		System.out.println("◻ 3.학생삭제 ◼");
		System.out.println("◼ 4.학생목록 ◻");
		System.out.println("◻ 5.학생조회 ◼");
		System.out.println("◼ 6.성적분석 ◻");
		System.out.println("◻  7.종료   ◼");
		System.out.println("◼◻◼◻◼◻◼◻◼◻");
		System.out.println("번호를 선택해주세요.");
	}// end of menu

	public static String scanString(String arg) {
		System.out.print(arg);
		String val = scn.nextLine();
		return val;
	}// end of SS

	public static int scanInt(String arg) {
		int val = 0;
		while (true) {
			try {
				System.out.print(arg);
				val = scn.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력할 수 있습니다.");
				scn.nextLine();
			}
		}
		scn.nextLine();
		return val;
	}// end of SI

	public static void add() {
		int number = scanInt("학번 ▶");
		String name = scanString("이름 ▶");
		int engSco = scanInt("영어점수 ▶");
		int mathSco = scanInt("수학점수 ▶");

		College students = new College(number, name, engSco, mathSco);

		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {// 입력시 비워져 있는 곳에 입력
				student[i] = students;
				break; // 비어있는 위치에 한번 입력 후 종류
			}
		}
	}// end of add

	public static void modify() {
		int number = scanInt("수정하실 학생의 학번을 입력해주세요");
		boolean run = false;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				if (student[i].getNumber() == number) {
					student[i].info();
					int modifyEng = scanInt("수정하실 영어점수를 입력하세요.");
					student[i].setEngSco(modifyEng);
					int modifyMath = scanInt("수정하실 수학점수를 입력하세요.");
					student[i].setMathSco(modifyMath);
					run = true;
				}
		}
		if (!run)
			System.out.println("같은 학번을 찾을 수 없습니다.");
	}// end of modify

	public static void delete() {
		int number = scanInt("삭제하실 학생의 학번을 입력해주세요.");
		boolean run = false;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null) {
				if (student[i].getNumber() == number) {
					student[i].info();
					student[i] = null;
					System.out.println("1건 삭제했습니다.");
					run = true;
				}
			}
		}
		if (!run)
			System.out.println("같은 학번을 찾을 수 없습니다.");
	}// end of delete

	public static void list() {
		boolean run = false;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				System.out.println(student[i].getNumber() + //
						" " + student[i].getName());
			run = true;
		}
		if (!run)
			System.out.println("저장된 정보가 없습니다.");
	}// end of list

	public static void search() {
		int number = scanInt("찾으실 학생의 학번을 입력해주세요.");
		boolean run = false;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null) {
				if (student[i].getNumber() == number) {
					student[i].info();
					run = true;
				}
			}
		}
		if (!run)
			if (student != null)
				System.out.println("같은 학번을 찾을 수 없습니다.");
			else if (student == null)
				System.out.println("저장된 정보가 없습니다.");
	}// end of search

	public static void analysis() {
		int maxEng = 0;
		College maxEngStu = null;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				if (maxEng < student[i].getEngSco()) {
					maxEng = student[i].getEngSco();
					maxEngStu = student[i];
				}
		}
		System.out.println("--------------");
		System.out.println("영어1등");
		maxEngStu.info();
		System.out.println("--------------");

		int maxMath = 0;
		College maxMathStu = null;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				if (maxMath < student[i].getMathSco()) {
					maxMath = student[i].getMathSco();
					maxMathStu = student[i];
				}
		}
		System.out.println("수학1등");
		maxMathStu.info();
		System.out.println("--------------");

		int maxScore = 0;
		College maxStudent = null;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				if (maxScore < (student[i].getEngSco() + student[i].getMathSco())) {
					maxScore = (student[i].getMathSco() + student[i].getMathSco());
					maxStudent = student[i];
				}
		}
		System.out.println("총합1등");
		maxStudent.info();
		System.out.println("--------------");
	}// end of analysis
}// end of class
