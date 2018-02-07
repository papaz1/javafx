package model;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculateBase {
    private TransactionID TransactionID;
    private DateTime DateTime;
    private String TransactionType;
    private boolean NetPriceFlag;
    private ShoppingBasketBase ShoppingBasket;
    private String CalculationMode;
    //private List<LoyaltyAccountCommonData> Loyalty;
    private RegularSalesUnitPriceRoundingRule RegularSalesUnitPriceRoundingRule;


    public PriceCalculateBase() {
        //Loyalty = new ArrayList<LoyaltyAccountCommonData>();
    }

    public void setTransactionID(model.TransactionID transactionID) {
        TransactionID = transactionID;
    }

    public void setDateTime(model.DateTime dateTime) {
        DateTime = dateTime;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public void setNetPriceFlag(boolean netPriceFlag) {
        NetPriceFlag = netPriceFlag;
    }

    public void setShoppingBasket(ShoppingBasketBase shoppingBasket) {
        ShoppingBasket = shoppingBasket;
    }

    public TransactionID getTransactionID() {
        return TransactionID;
    }

    public DateTime getDateTime() {
        return DateTime;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public boolean isNetPriceFlag() {
        return NetPriceFlag;
    }

    public ShoppingBasketBase getShoppingBasket() {
        return ShoppingBasket;
    }

    public String getCalculationMode() {
        return CalculationMode;
    }

    public void setCalculationMode(String calculationMode) {
        CalculationMode = calculationMode;
    }

    public RegularSalesUnitPriceRoundingRule getRegularSalesUnitPriceRoundingRule() {
        return RegularSalesUnitPriceRoundingRule;
    }

    public void setRegularSalesUnitPriceRoundingRule(RegularSalesUnitPriceRoundingRule regularSalesUnitPriceRoundingRule) {
        RegularSalesUnitPriceRoundingRule = regularSalesUnitPriceRoundingRule;
    }
}
