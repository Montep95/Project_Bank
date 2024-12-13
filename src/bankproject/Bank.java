package bankproject;

import java.util.Scanner;

/*
고객을 배열로 관리합니다.
고객을 추가하고 찾는 메서드를 제공합니다.
 */
public class Bank {
    // 객체 생성 Part-----
    static Customer[] customers = new Customer[10];
    Customer customer = new Customer();
    static int customerIndex = 0;
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // =====Methods=====

    // 고객 등록 메소드
    public void registerCustomer(){
        // 추가된 기능
        if(customerIndex >= customers.length){
            System.out.println("더 이상 고객을 등록할 수 없습니다.");
            return;

            // Todo : BankOperationException 예외처리 필요
        }

        System.out.print("고객의 ID를 입력해주세요 : ");
        String userInputID = sc.nextLine();

        System.out.print("고객의 이름을 입력해주세요 : ");
        String userInputName = sc.nextLine();

        Customer customer = new Customer(userInputID, userInputName);
        customers[customerIndex++] = customer;

        System.out.println("고객이 성공적으로 등록되었습니다.");
    }

    // 고객ID가 은행에 등록되어있는지 확인하는 메소드
    public boolean existsUserId(String id) {
        for(int i = 0; i < customerIndex; i++){
            if (customers[i] != null && customers[i].getUserID().equals(id)) {
                return true;
            }
        }
        // 은행에 등록되지 않은 id이면, false리턴
        return false;
    }
}