package bankproject;

import java.util.Scanner;

public class Bank {
    // 객체 생성 Part-----
    static Customer[] customers = new Customer[100];
    static int customerIndex = 0;
    static Account account = new Account();
    static Scanner sc = new Scanner(System.in);

    // 필드 생성 Part-----
//    private List<String> allUserId = new ArrayList<>(); // 모든 고객 아이디 저장 리스트
//    private List<String> allUserName = new ArrayList<>(); // 모든 고객 이름 저장 리스트
    private String[] allUserId; // 모든 고객 아이디 저장 배열
    private String[] allUserName; // 모든 고객 이름 저장 배열

    // [추가된 기능] Part-----

    // =====Methods=====

    // 고객 등록 메소드
    public void registerCustomer(){
        System.out.print("고객의 ID를 입력해주세요 : ");
        String userInputID = sc.nextLine();

        while(true){

            break;
            // 리스트 추가 코드
//            if(allUserId.contains(userInputID)){
//                System.out.println("중복된 [아이디]입니다. 다시 입력해주세요.");
//            }else{
//                allUserId.add(userInputID);
//                break;
//            }
        }

        while(true){
            System.out.print("고객의 이름의 입력해주세요 : ");
            String userInputName = sc.nextLine();

            break;
            // 리스트 추가 코드
//            if(allUserName.contains(userInputName)){
//                System.out.println("중복된 [이름]입니다. 다시 입력해주세요.");
//            }else{
//                allUserName.add(userInputName);
//                break;
//            }
        }

        System.out.println("고객이 성공적으로 등록되었습니다.");
        BankProgram.runProgram(); // static 메소드 바로 접근
    }

    // 고객 찾기 메소드 (=고객 정보 조회)
    public void findCustomer(){

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
