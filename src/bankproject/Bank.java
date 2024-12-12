package bankproject;

import java.util.Scanner;

/*
고객을 배열로 관리합니다.
고객을 추가하고 찾는 메서드를 제공합니다.
 */
public class Bank {
    // 객체 생성 Part-----
    static Customer[] customers = new Customer[100];
    Customer bankCustomers = new Customer();
    static int customerIndex = 0;
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
    private String[] allUserId; // 모든 고객 아이디 저장 배열
    private String[] allUserName; // 모든 고객 이름 저장 배열

    // =====Methods=====

    // 고객 등록 메소드
    public void registerCustomer(){
        System.out.print("고객의 ID를 입력해주세요 : ");
        String userInputID = sc.nextLine();

        System.out.print("고객의 이름을 입력해주세요 : ");
        String userInputName = sc.nextLine();

        Customer customer = new Customer(userInputID, userInputName);
        customers[customerIndex] = customer;

        System.out.println("고객이 성공적으로 등록되었습니다.");

        BankProgram.runProgram(); // static 메소드 바로 접근
    }

    // 고객ID가 은행에 등록되어있는지 확인하는 메소드
    public boolean existsUserId(String id){
        for(int i = 0; i < customers.length; i++){
            if(customers[i] == null) return true;
            if(customers[i].getUserID().equals(id)){
                return true;
            }
        }
        return false; // 존재하지 않는 ID면 false리턴
    }

    // 고객 찾기 메소드 (=고객 정보 조회)
    public void findCustomer(String id){
        for(int i = 0; i < customers.length; i++){
            if(customers[i].getUserID().equals(id)){

            }
        }
    }

    // TESTCASE : 고객 이름 전체 출력 메소드
    public void printUser(){
        System.out.println(allUserName);
    }

    // TESTCASE : 고객 Id 전체 출력 메소드
    public void printId(){
        System.out.println(allUserId);
    }
}
