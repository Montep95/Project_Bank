package bankproject;

import bankproject.exception.InvalidUserInputException;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers; // 고객 리스트

    public Bank() {
        this.customers = new ArrayList<>();
    }

    // 고객 등록 메소드
    public void registerCustomer(String userID, String userName) {
        customers.add(new Customer(userID, userName));
        System.out.println("고객 등록 완료: ID = " + userID + ", 이름 = " + userName);
    }

    // 고객 ID 존재 확인
    public boolean existsUserId(String userID) {
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                return true;
            }
        }
        return false;
    }

    // 고객 검색 메소드
    public Customer findCustomerById(String userID) throws InvalidUserInputException {
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                return customer;
            }
        }
        throw new InvalidUserInputException("입력한 ID가 존재하지 않습니다.");
    }
}