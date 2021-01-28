package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import dto.AccountDto;

// DAO = Data Access Object
public class AccountDao {
	Scanner sc = new Scanner(System.in);
	
	// 서류철
	private AccountDto accountBook[] = new AccountDto[100]; // 캡슐화 
	private int indexCount;
	
	// 생성자
	public AccountDao() {
		indexCount = 0;
	}
	
	// 추가
	public void insert() {
		System.out.print("지출(1)/수입(2) = ");
		int c = sc.nextInt();
		String classify = (c == 1)? "지출" : "수입"; // 삼항연산자 사용
		
		System.out.print("금액 = ");
		int money = sc.nextInt();
		
		System.out.print("사용처 = ");
		String use = sc.next();
		
		System.out.print("memo = ");
		String memo = sc.next();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초"); // 2021년 45월 28일 10시 45분 47초
		
		Calendar cal = Calendar.getInstance();
		String dateTime = f.format(cal.getTime());
		
		// 배열에 추가
		 accountBook[indexCount] = new AccountDto(dateTime, use, classify, money, memo);
		 indexCount++;
	}
	
	// 삭제
	public void delete() {
		System.out.print("삭제할 데이터 = ");
		String use = sc.next();
		
		int index = search(use);
		if(index == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		accountBook[index].setClassify("");
		accountBook[index].setDateTime("");
		accountBook[index].setMoney(0);
		accountBook[index].setUse("");
		accountBook[index].setMemo("");
		
		System.out.println("데이터를 삭제 하였습니다");
		
	}
	
	// 검색
	public void select() {
		System.out.println("검색할 날짜 >> ");
		
		System.out.print("월 = ");
		int month = sc.nextInt();
		System.out.print("일 = ");
		int day = sc.nextInt(); // yyyy년 mm월 dd일 HH시 mm분 ss초
		
		String smonth = (month < 10)? "0" + month:"" + month; // 10보다 작은 수는 앞에 0을 붙여서 return 
		String sday = (day < 10) ? "0" + day: "" + day; 
		
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null && !accountBook[i].getUse().equals("")) {
				AccountDto dto = accountBook[i];
				String dateTime = dto.getDateTime();
				
				String monthDay = dateTime.substring(6, 13); // 데이터를 잘라서 가져온다
				
				String searchDay = smonth + "월 " + sday + "일";
				
				if(searchDay.equals(monthDay)) {
					System.out.println(dto.toString());
				}
			}
		}
	}
	
	// 수정
	public void update() {
		System.out.print("수정할 데이터 = ");
		String use = sc.next();
		
		int index = search(use);
		if(index == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.print("수정할 금액");
		int money = sc.nextInt();
		
		accountBook[index].setMoney(money);
		
		
		System.out.println("수정되었습니다");
	}
	
	// 모두 출력
	public void allprint() {
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null 
					&& !accountBook[i].getClassify().equals("")) {
				System.out.println(accountBook[i].toString());
			}
		}
	}
	
	// 조회
	public int search(String use) {
		int index = -1;
		
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null && !accountBook[i].getUse().equals("")) {
				if(accountBook[i].getUse().contains(use)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
}
























