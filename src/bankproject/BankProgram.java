package bankproject;

import bankproject.exception.InvalidUserInputException;

import java.util.Scanner;

public class BankProgram {
    private static Bank bank = new Bank(); // 은행 객체
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        while (true) {
            try {
                printMenu();
                int choice = sc.nextInt();
                handleMenuChoice(choice);
            } catch (Exception e) {
                System.out.println("오류 발생: " + e.getMessage());
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n======*[Premium Bank]*======");
        System.out.println("1. 고객 등록");
        System.out.println("2. 계좌 생성");
        System.out.println("3. 입금 하기");
        System.out.println("4. 출금 하기");
        System.out.println("5. 잔액 조회");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    // 메뉴 처리
    private static void handleMenuChoice(int choice) throws Exception {
        switch (choice) {
            case 1 -> registerCustomer();
            case 2 -> createAccount();
            case 3 -> depositToAccount();
            case 4 -> withdrawFromAccount();
            case 5 -> checkBalance();
            case 6 -> {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            default -> throw new InvalidUserInputException("[예외] 올바르지 않은 메뉴 선택입니다.");
        }
    }

    // 1. 고객 등록
    private static void registerCustomer() {
        System.out.print("고객 ID 입력: ");
        String userID = sc.next();
        System.out.print("고객 이름 입력: ");
        String userName = sc.next();
        bank.registerCustomer(userID, userName);
    }

    // 2. 계좌 생성
    private static void createAccount() throws Exception {
        System.out.print("고객 ID 입력: ");
        String userID = sc.next();
        Customer customer = bank.existsUserId(userID);

        System.out.print("새 계좌 번호 입력: ");
        String accountNumber = sc.next();

        customer.addAccount(accountNumber);
    }

    // 3. 입금
    private static void depositToAccount() throws Exception {
        System.out.print("고객 ID 입력: ");
        String userID = sc.next();
        Customer customer = bank.existsUserId(userID);

        System.out.print("계좌 번호 입력: ");
        String accountNumber = sc.next();

        System.out.print("입금 금액 입력: ");
        double amount = sc.nextDouble();

        for (Account account : customer.getAccounts()) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                System.out.println("입금 성공! 현재 잔액: " + account.getBalance()); // 입금 현황 출력
                return;
            }
        }

        throw new InvalidUserInputException("[예외] 계좌를 찾을 수 없습니다.");
    }

    // 4. 출금
    private static void withdrawFromAccount() throws Exception {
        System.out.print("고객 ID 입력: ");
        String userID = sc.next();
        Customer customer = bank.existsUserId(userID);

        System.out.print("계좌 번호 입력: ");
        String accountNumber = sc.next();

        System.out.print("출금 금액 입력: ");
        double amount = sc.nextDouble();

        for (Account account : customer.getAccounts()) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                System.out.println("출금 성공! 현재 잔액: " + account.getBalance()); // 출금 현황 출력
                return;
            }
        }

        throw new InvalidUserInputException("계좌를 찾을 수 없습니다.");
    }

    // 5. 잔액 조회
    private static void checkBalance() throws Exception {
        System.out.print("고객 ID 입력: ");
        String userID = sc.next();
        Customer customer = bank.existsUserId(userID);

        System.out.print("계좌 번호 입력: ");
        String accountNumber = sc.next();

        // 고객의 계좌들 중 입력한 계좌번호에 해당하는 계좌의 잔액을 호출 후 출력
        for (Account account : customer.getAccounts()) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                System.out.println("현재 잔액: " + account.getBalance());
                return;
            }
        }

        throw new InvalidUserInputException("계좌를 찾을 수 없습니다.");
    }
}
