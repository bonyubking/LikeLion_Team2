package com.Person.controller;

import java.util.List;
import java.util.Scanner;

import com.Person.Service.PersonServiceImple;
import com.Person.java.Person;
import com.Person.view.PersonColsolView;

public class PersonController {
	
	private final PersonServiceImple service = new PersonServiceImple();
	private final PersonColsolView view = new PersonColsolView();
	private final Scanner sc = new Scanner(System.in);
	
	public void run() {
		
		while(true) {
			System.out.println("1. 전체 출력 |  2. 추가  |  3. 삭제  | 4. 수정  | 5. 찾기 | 6. 파일저장 | 7. 페이징 | 0. 종료 ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : 
				
				view.showAllList(service.selectAllPerson());
				break;
				
			case "2" :
				
				System.out.print("이름 입력");
				String name = sc.nextLine();
				System.out.print("주소 입력");
				String address = sc.nextLine(); 
				System.out.print("번호 입력");
				String phone = sc.nextLine();
				
				// 2.  
				
				Person dta = new Person(name, address, phone);
				
				// 3.
				int res = service.insertPerson(dta);
				view.showMessage(res > 0 ? "입력 완료" : " 입력 실패");
				
				break;
			
				
			case "3" : 
				
				System.out.print("삭제 할 이름 :");
				String delete_name = sc.nextLine();
				
				Person p0 = new Person();
				p0.setName(delete_name);
				
				view.showMessage(service.deletePerson(p0) > 0 ? "입력 완료" : " 입력 실패");
				break;
				
			case "4" : 
				
				System.out.print("이름 입력");
				String uname = sc.nextLine();
				System.out.print("주소 입력");
				String uaddress = sc.nextLine(); 
				System.out.print("번호 입력");
				String uphone = sc.nextLine();
				
				Person p02 = new Person(uname, uaddress, uphone);
				
				int res02 = service.updatePerson(p02);
				view.showMessage(res02 > 0 ? "입력성공" : "실패");
				break;
			
			case "5" : 
				
				System.out.print("검색 이름 입력");
				String find_name = sc.nextLine();
				Person p03 = new Person();
				p03.setName(find_name);
				
				Person found = service.searchByName(p03);
				if (found != null) 
					view.showAllList(List.of(found));
				
				else
					view.showMessage("이름 없엉");
				break;
			
			case "6" :
				
				System.out.print("저장할 파일 입력! ");
				String file_name = sc.nextLine();
				view.saveToFile(service.selectAllPerson(), file_name);
				
				
				break;
				
			case "7" : // 페이징 -> 페이지번호와 크기 입력해서 해당범위 목록 리턴
					// select * from person LIMIT OFFSET ; 구현하는거임
				System.out.print("페이지 번호 " );
				int page = Integer.parseInt(sc.nextLine());
				System.out.print("페이지 크기 " );
				int size = Integer.parseInt(sc.nextLine());
				
				List<Person> pageList = service.getPersonByPage(page, size);
				view.showAllList(pageList);
				
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
	


