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

        // 리팩토링 이전 코드 [24-12-13 12:38]
//        // 은행에 등록된 id이면, true 리턴
//        if (customers[customerIndex].getUserID().equals(id)) {
//            return true;
//        }
//        // 은행에 등록되지 않은 id이면, false리턴
//        return false;


//        System.out.println("NAME : " + customers[customerIndex].getUserName());
//        if(customers[0].getUserAccount() == null){
//            System.out.println("ACCOUNT : 비어있습니다.");
//        }
//
//        return true;

        //        System.out.println("ID : " + customer.getUserID()); // null값

        // 리팩토링 중... [12-12 21:14]
//        // 고객 정보를 순회하면서 null값이 아닌 값이 있으면 그 해당 배열의 인덱스를 저장
//        int targetUserIndex = 0;
//        for(int i = 0; i < customers.length; i++){
//            if(customers[i].getUserID() != null) {
//                targetUserIndex = i;
//            }
//        }
//
//        if(customers[targetUserIndex].getUserID().equals(id)){
//            return true;
//        }
//        return false; // 존재하지 않는 ID면 false리턴

//    // 고객 조회 메소드
//    public void findCustomer(String id) {
//        int targetUserIndex = 0;
//
//        outter: while(true){
//            for(int i = 0; i < Account.accounts.length; i++){
//                if(Account.accounts[i].getUserId().equals(id)) {
//                    System.out.println("-----입력하신 ID:[" + id + "]의 고객정보를 가져옵니다-----");
//                    targetUserIndex = i;
//                    break outter;
//                }
//            }
//            System.out.println("은행에 고객정보가 없습니다.");
//        }
//
//        System.out.println("이름 : " + Account.accounts[targetUserIndex].getUserName());
//        System.out.println("계좌 : " + Account.accounts[targetUserIndex].getUserAccount());
//        System.out.println("잔액 : " + Account.accounts[targetUserIndex].getBalance());
//    }

// registerCustomer 메소드
// <더미코드>
// 두번째 고객부터의 조건문
//        if(customers[customerIndex].getUserID() != null){
//            System.out.println(customers[customerIndex].getUserID() + "의 유저가 존재하므로 인덱싱 값을 늘립니다.");
//            customerIndex++;
//        }
// BankProgram.runProgram(); // static 메소드 바로 접근

