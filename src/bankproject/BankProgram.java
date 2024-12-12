package bankproject;

import java.util.Scanner;

public class BankProgram {
    // 객체 생성 Part-----
    static Bank bank = new Bank();
    static Customer customer = new Customer();
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);;

    // =====Methods=====
    public static void main(String[] args){
        /*
        입금/출금: 계좌 번호로 계좌를 조회하여 입금하거나 출금합니다.
        잔액 조회: 계좌 번호로 현재 잔액을 조회합니다.
        고객 등록: 새로운 고객을 은행에 등록합니다.
        계좌 생성: 고객이 새로운 통장을 생성합니다.
        예외 처리: 잘못된 입력이나 오류 상황에 대해 사용자에게 적절한 메시지를 출력합니다.
         */
        runProgram();
    }

    public static void runProgram(){
        printSystemMenu();
        System.out.print("이용하실 서비스를 입력해주세요 : ");
        moveToSystem(sc.nextInt());
    }

    private static void moveToSystem(int i) {
        switch(i){
            case 0: // Testcase : 현재 고객의 이름 및 아이디 정보 전체 출력
                bank.printUser(); // Testcase : 현재 고객의 이름 정보 출력
                bank.printId(); // Testcase : 현재 고객의 아이디 정보 출력
                runProgram();

            case 1: // 고객 등록 (Bank 클래스)
                bank.registerCustomer(); // 고객 등록 메소드 호출


            case 2: // 계좌 생성 (Customer 클래스)
                customer.addAccount(); // 계좌 생성 메소드 호출
                runProgram();

            case 3: // 입금 하기 (Account 클래스)
                account.deposit(); // 입금하기 메소드 호출
                runProgram();

            case 4: // 출금 하기 (Account 클래스)
                account.withdraw(); // 출금하기 메소드 호출
                runProgram();

            case 5: // 잔액 조회 (Account 클래스)
                account.searchMyBalance(); // 잔액조회 메소드 호출
                runProgram();

            case 6: // 종료하기 (System.exit(0))
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
        }
    }
    private static void printSystemMenu() {
        System.out.println("\n=== 프리미엄 은행 ===");
        System.out.println("._._.[서비스 목록]._._.");
        System.out.println("0. 고객 전체정보출력 - TESTCASE");
        System.out.println("1. 고객 등록");
        System.out.println("2. 계좌 생성");
        System.out.println("3. 입금 하기");
        System.out.println("4. 출금 하기");
        System.out.println("5. 잔액 조회");
        System.out.println("6. 종    료\n");
    }
}
