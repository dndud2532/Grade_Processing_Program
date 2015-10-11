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
	
	private static void readData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			studentList = (ArrayList<Student>)ois.readObject();
			System.out.println("데이터를 로드했습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if(ois != null) 
				try {ois.close();}catch(Exception e) {}
		}		
	}

	private static void deleteData() {

		System.out.print(studentList.get(index).name + "학생의 정보를 삭제하겠습니까?(Y/N) : ");
		if(scan.next().charAt(0) =='Y') {
			studentList.remove(index);
			index = -1;
		}else {
			System.out.println("삭제를 취소합니다.");
		}
	}


}
