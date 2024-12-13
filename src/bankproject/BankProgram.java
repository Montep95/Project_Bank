package bankproject;

import bankproject.exception.AccountNotFoundException;
import bankproject.exception.BankOperationException;
import bankproject.exception.InvalidTransactionException;
import bankproject.exception.InvalidUserInputException;

import java.util.Scanner;

public class BankProgram {
    // 객체 생성 Part-----
    static Bank bank = new Bank();
    static Customer customer = new Customer();
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // =====Methods=====
    public static void main(String[] args) throws Exception{
        runProgram();
    }

    public static void runProgram() throws Exception{
        printSystemMenu();
        System.out.print("이용하실 서비스를 입력해주세요 : ");
        try{
            moveToSystem(sc.nextInt());
        }catch(InvalidUserInputException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("[예외처리] 숫자만 입력해주세요.");
        }
    }

    private static void moveToSystem(int i) throws Exception{
        switch(i){
            case 1: // 고객 등록 (Bank 클래스)
                bank.registerCustomer(); // 고객 등록 메소드 호출
                runProgram();


            case 2: // 계좌 생성 (Customer 클래스)
                try{
                    customer.addAccount(); // 계좌 생성 메소드 호출
                }catch(BankOperationException e){
                    System.out.println(e.getMessage()); // 계좌 등록 최대 개수 초과 예외처리
                }
                runProgram();

            case 3: // 입금 하기 (Account 클래스)
                try{
                    account.deposit(); // 입금하기 메소드 호출
                }catch(InvalidTransactionException e){
                    e.printStackTrace(); // 잘못된 입출금 요청 에외처리
                }catch(AccountNotFoundException e){
                    e.printStackTrace(); // 존재하지 않는 계좌 요청 예외처리
                }
                runProgram();

            case 4: // 출금 하기 (Account 클래스)
                try{
                    account.withdraw(); // 출금하기 메소드 호출
                }catch(InvalidTransactionException e){
                    e.printStackTrace(); // 잘못된 입출금 요청 에외처리
                }catch(AccountNotFoundException e){
                    e.printStackTrace(); // 존재하지 않는 계좌 요청 예외처리
                }
                runProgram();

            case 5: // 잔액 조회 (Account 클래스)
                try{
                    account.searchMyBalance(); // 잔액조회 메소드 호출
                }catch(AccountNotFoundException e){
                    e.printStackTrace(); // 존재하지 않는 계좌 요청 예외처리
                }
                runProgram();

            case 6: // 종료하기 (System.exit(0))
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);

            default: // [고객입력오류] 예외처리
                throw new InvalidUserInputException("[고객입력오류] 해당하는 메뉴가 없습니다.");
        }
    }
    private static void printSystemMenu() {
        System.out.println("\n======*[Premium Bank]*======");
        System.out.println("       <Choose a menu>");
        System.out.println("1. 고객 등록");
        System.out.println("2. 계좌 생성");
        System.out.println("3. 입금 하기");
        System.out.println("4. 출금 하기");
        System.out.println("5. 잔액 조회");
        System.out.println("6. 종    료\n");
    }
}
