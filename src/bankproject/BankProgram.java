package bankproject;

import java.util.Scanner;

public class BankProgram {
    // 객체 생성 Part-----
    static Bank bank = new Bank();
    static Customer customer = new Customer();
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);;

    // =====Methods=====
    public static void main(String[] args) throws Exception{
        runProgram();
    }

    public static void runProgram() throws Exception{
        printSystemMenu();
        System.out.print("이용하실 서비스를 입력해주세요 : ");
        moveToSystem(sc.nextInt());
    }

    private static void moveToSystem(int i) throws Exception{
        switch(i){
            case 1: // 고객 등록 (Bank 클래스)
                bank.registerCustomer(); // 고객 등록 메소드 호출
                runProgram();


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
        System.out.println("\n======*[Premium Bank]*======");
        System.out.println("       < Choose a menu >");
        System.out.println("1. 고객 등록");
        System.out.println("2. 계좌 생성");
        System.out.println("3. 입금 하기");
        System.out.println("4. 출금 하기");
        System.out.println("5. 잔액 조회");
        System.out.println("6. 종    료\n");
    }
}
