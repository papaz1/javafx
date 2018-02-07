package model;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyAccountCommonData {
    private String CustomerID;
    private List<LoyaltyAccountType> LoyaltyProgram;
    private boolean CustomerIsEmployeeFlag;

    public LoyaltyAccountCommonData() {
        LoyaltyProgram = new ArrayList<LoyaltyAccountType>();
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public List<LoyaltyAccountType> getLoyaltyProgram() {
        return LoyaltyProgram;
    }

    public void setLoyaltyProgram(List<LoyaltyAccountType> loyaltyProgram) {
        LoyaltyProgram = loyaltyProgram;
    }

    public boolean isCustomerIsEmployeeFlag() {
        return CustomerIsEmployeeFlag;
    }

    public void setCustomerIsEmployeeFlag(boolean customerIsEmployeeFlag) {
        CustomerIsEmployeeFlag = customerIsEmployeeFlag;
    }

    public void addLoyaltyProgram(LoyaltyAccountType newLoyaltyProgram) {
        LoyaltyProgram.add(newLoyaltyProgram);
    }
}

