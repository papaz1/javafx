package client;

public class TableViewModel {
    private String saleItemId;
    private String regularSalesUnitPrice;
    private String extendedAmount;
    private String extendedDiscountAmount;
    private String currency;

    public String getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(String saleItemId) {
        this.saleItemId = saleItemId;
    }

    public String getRegularSalesUnitPrice() {
        return regularSalesUnitPrice;
    }

    public void setRegularSalesUnitPrice(String regularSalesUnitPrice) {
        this.regularSalesUnitPrice = regularSalesUnitPrice;
    }

    public String getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(String extendedAmount) {
        this.extendedAmount = extendedAmount;
    }

    public String getExtendedDiscountAmount() {
        return extendedDiscountAmount;
    }

    public void setExtendedDiscountAmount(String extendedDiscountAmount) {
        this.extendedDiscountAmount = extendedDiscountAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
