package sungjuk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	private static void writeData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(studentList);
			System.out.println("데이터가 저장되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일 명이 잘 못 되었습니다.");
		} catch (IOException e) {
			System.out.println(e.getMessage());			
		} finally {
			if(oos != null) 
				try {oos.close();}catch(Exception e) {}
		}
		
	}


}
