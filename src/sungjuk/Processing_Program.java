package sungjuk;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processing_Program {
static List<Student> studentList = new ArrayList<Student>();
	

	static int index = -1;
	
	
	static Scanner scan = new Scanner(System.in);
	
	static String fileName = "student.data";
	
	public static void main(String[] args) {
		
		while(true) {
			printMenu();
			switch(scan.next().charAt(0)) {
			case 'i':
			case 'I':
				getData(); 
				break;
			case 'l':
			case 'L':
				printList();
				break;
			case 's':
			case 'S':
				searchData();
				break;
			case 'u':
			case 'U':
				updateData();
				break;
			case 'd':
			case 'D':
				deleteData();
				break;
			case 'r':
			case 'R':
				readData();
				break;
			case 'w':
			case 'W':
			case 'ㅈ':
				writeData();
				break;
			case 'q':
			case 'Q':
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				return;

			}
		}

	}


}
