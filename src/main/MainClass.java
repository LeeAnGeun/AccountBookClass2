package main;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// menu
		String Menu[] = {"1. 추가 ", "2. 삭제", "3. 검색", "4. 수정", "5. 모두 출력", "6. 종료"};
		
		
		// 형식
		AccountDao dao = new AccountDao();
		boolean b = true;
		while(b) {
			System.out.println(Arrays.toString(Menu));
			int workNumber;
			System.out.print("원하는 메뉴의 번호를 누르십시오 : ");
			workNumber = sc.nextInt();
			switch (workNumber) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allprint();
					break;
				case 6:
					System.out.println("시스템을 종료합니다.");
					b=false;
					break;
			}
		}
	}

}
/* 참고
SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 mm월 dd일 HH시 mm분 ss초");

Calendar cal = Calendar.getInstance();


String ftime1 = format1.format(cal.getTime());
String ftime2 = format2.format(cal.getTime());

System.out.println(ftime1);
System.out.println(ftime2);
*/
