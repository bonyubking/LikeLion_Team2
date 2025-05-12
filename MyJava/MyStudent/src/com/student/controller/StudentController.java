package com.student.controller;

import java.util.List;
import java.util.Scanner;


import com.student.service.StudentServiceImple;
import com.student.view.StudentConsolView;
import com.student.java.Student;

public class StudentController {
	
	private final StudentServiceImple service = new StudentServiceImple();
	private final StudentConsolView view = new StudentConsolView();
	private final Scanner sc = new Scanner(System.in);
	
	public void run() {
		
		while(true) {
			System.out.println("1. 전체 출력 |  2. 추가  |  3. 삭제  | 4. 수정 | 0. 종료 ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : 
				
				view.showAllList(service.selectAllstudent());
				break;
				
			case "2" :
				
				
				System.out.print("아이디 입력");
				String id = sc.nextLine();
				System.out.print("이름 입력");
				String sname = sc.nextLine();
				System.out.print("전공 입력");
				String major = sc.nextLine(); 
				System.out.print("성적 입력");
				String grade = sc.nextLine();
				
				// 2.  
				
				Student dta = new Student(id, sname, major, grade);
				
				// 3.
				int res = service.insertStudent(dta);
				view.showMessage(res > 0 ? "입력 완료" : " 입력 실패");
				
				break;
			
				
			case "3" : 
				
				System.out.print("삭제 할 이름 :");
				String delete_name = sc.nextLine();
				
				Student p0 = new Student();
				p0.setSname(delete_name);
				
				view.showMessage(service.deleteStudent(p0) > 0 ? "입력 완료" : " 입력 실패");
				break;
				
			case "4" : 
				
				
				System.out.print("정보를 수정할 이름 입력");
				String usname = sc.nextLine();
				System.out.print("새 아이디 입력");
				String uid = sc.nextLine();

				System.out.print("새 전공 입력");
				String umajor = sc.nextLine(); 
				System.out.print("새 성적 입력");
				String ugrade = sc.nextLine();
				
				Student p02 = new Student(uid, usname, umajor, ugrade);
				
				int res02 = service.updateStudent(p02);
				
				view.showMessage(res02 > 0 ? "수정 완료" : "존재하지 않는 학생");
				
				break;
		
		
			case "0" : 
					view.showMessage("종료");
					return;
			default :
					view.showMessage("입력 잘못했어 ");
			}
			
		}
	}
}
	


