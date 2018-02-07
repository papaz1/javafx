package model;

import java.util.ArrayList;
import java.util.List;

public class SaleBase {
    private boolean TaxIncludedInPriceFlag;
    private boolean NonPieceGoodFlag;
    private boolean FrequentShopperPointsEligibilityFlag;
    private boolean NotConsideredByPriceEngineFlag;
    private List<ItemID> ItemID;
    private String ItemType;
    private boolean NonDiscountableFlag;
    private boolean FixedPriceFlag;
    private List<QuantityCommonData> Quantity;
    private ExtendedAmount ExtendedAmount;
    private ExtendedDiscountAmount ExtendedDiscountAmount;
    private String PriceTypeCode;
    private RegularSalesUnitPrice RegularSalesUnitPrice;

    public SaleBase() {
        ItemID = new ArrayList<model.ItemID>();
        Quantity = new ArrayList<QuantityCommonData>();
    }

    public model.RegularSalesUnitPrice getRegularSalesUnitPrice() {
        return RegularSalesUnitPrice;
    }

    public void setRegularSalesUnitPrice(model.RegularSalesUnitPrice regularSalesUnitPrice) {
        RegularSalesUnitPrice = regularSalesUnitPrice;
    }

    public void setTaxIncludedInPriceFlag(boolean taxIncludedInPriceFlag) {
        TaxIncludedInPriceFlag = taxIncludedInPriceFlag;
    }

    public void setNonPieceGoodFlag(boolean nonPieceGoodFlag) {
        NonPieceGoodFlag = nonPieceGoodFlag;
    }

    public void setFrequentShopperPointsEligibilityFlag(boolean frequentShopperPointsEligibilityFlag) {
        FrequentShopperPointsEligibilityFlag = frequentShopperPointsEligibilityFlag;
    }

    public void setNotConsideredByPriceEngineFlag(boolean notConsideredByPriceEngineFlag) {
        NotConsideredByPriceEngineFlag = notConsideredByPriceEngineFlag;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public void setNonDiscountableFlag(boolean nonDiscountableFlag) {
        NonDiscountableFlag = nonDiscountableFlag;
    }

    public void setFixedPriceFlag(boolean fixedPriceFlag) {
        FixedPriceFlag = fixedPriceFlag;
    }

    public boolean isTaxIncludedInPriceFlag() {
        return TaxIncludedInPriceFlag;
    }

    public boolean isNonPieceGoodFlag() {
        return NonPieceGoodFlag;
    }

    public boolean isFrequentShopperPointsEligibilityFlag() {
        return FrequentShopperPointsEligibilityFlag;
    }

    public boolean isNotConsideredByPriceEngineFlag() {
        return NotConsideredByPriceEngineFlag;
    }

    public List<model.ItemID> getItemID() {
        return ItemID;
    }

    public void setItemID(List<model.ItemID> itemID) {
        ItemID = itemID;
    }

    public String getItemType() {
        return ItemType;
    }

    public boolean isNonDiscountableFlag() {
        return NonDiscountableFlag;
    }

    public boolean isFixedPriceFlag() {
        return FixedPriceFlag;
    }

    public List<QuantityCommonData> getQuantity() {
        return Quantity;
    }

    public void setQuantity(List<QuantityCommonData> quantity) {
        Quantity = quantity;
    }

    public model.ExtendedAmount getExtendedAmount() {
        return ExtendedAmount;
    }

    public void setExtendedAmount(model.ExtendedAmount extendedAmount) {
        ExtendedAmount = extendedAmount;
    }

    public model.ExtendedDiscountAmount getExtendedDiscountAmount() {
        return ExtendedDiscountAmount;
    }

    public void setExtendedDiscountAmount(model.ExtendedDiscountAmount extendedDiscountAmount) {
        ExtendedDiscountAmount = extendedDiscountAmount;
    }

    public String getPriceTypeCode() {
        return PriceTypeCode;
    }

    public void setPriceTypeCode(String priceTypeCode) {
        PriceTypeCode = priceTypeCode;
    }

    public void addItemID(ItemID newItemID) {
        ItemID.add(newItemID);
    }

    public void addQuantity(QuantityCommonData newQuantity) {
        Quantity.add(newQuantity);
    }
}
