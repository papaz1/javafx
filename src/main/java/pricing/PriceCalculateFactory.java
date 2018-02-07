package pricing;

import model.*;

import java.util.List;

public class PriceCalculateFactory {
    private final static int InternalMajorVersion = 1;
    private final static int InternalMinorVersion = 0;
    private final static String UOM_PCE = "PCE";
    private static List<String> saleItemIds;
    private static String businessUnitValue;

    public static PriceCalculate createPriceCalculate(List<String> saleItemIds,
                                                      String businessUnitValue) {
        PriceCalculateFactory.saleItemIds = saleItemIds;
        PriceCalculateFactory.businessUnitValue = businessUnitValue;

        PriceCalculate priceCalculate = new PriceCalculate();
        ARTSCommonHeaderType ARTSHeader = creeateARTSHeader();
        PriceCalculateBase priceCalculateBody = createPriceCalculateBody();

        priceCalculate.setARTSHeader(ARTSHeader);
        priceCalculate.addPriceCalculate(priceCalculateBody);
        priceCalculate.setInternalMajorVersion(InternalMajorVersion);
        priceCalculate.setInternalMinorVersion(InternalMinorVersion);

        return priceCalculate;
    }

    private static PriceCalculateBase createPriceCalculateBody() {
        PriceCalculateBase priceCalculateBody = new PriceCalculateBase();
        DateTime dateTime = new DateTime();
        dateTime.setValue("2018-01-21T16:53:25.278+02:00");
        priceCalculateBody.setDateTime(dateTime);
        TransactionID transactionId = new TransactionID();
        priceCalculateBody.setTransactionID(transactionId);
        transactionId.setValue("9a89f2edfd1e413ea147e334b9c2ed4b");
        priceCalculateBody.setTransactionType("SaleTransaction");
        priceCalculateBody.setNetPriceFlag(false);
        ShoppingBasketBase shoppingBasket = createShoppingBasket();
        priceCalculateBody.setShoppingBasket(shoppingBasket);
        return priceCalculateBody;
    }

    private static ShoppingBasketBase createShoppingBasket() {
        ShoppingBasketBase shoppingBasket = new ShoppingBasketBase();

        int sequenceNumber = 0;
        for (String saleItemId : saleItemIds) {
            LineItemDomainSpecific lineItem = createLineItem(saleItemId, sequenceNumber);
            shoppingBasket.addLineItem(lineItem);
            sequenceNumber++;
        }
        return shoppingBasket;
    }

    private static LineItemDomainSpecific createLineItem(String saleItemId, int sequenceNumber) {
        LineItemDomainSpecific lineItem = new LineItemDomainSpecific();
        lineItem.addSequenceNumber(sequenceNumber);
        MerchandiseHierarchyCommonData merchandiseHierarchy = new MerchandiseHierarchyCommonData();
        merchandiseHierarchy.setID("1");
        merchandiseHierarchy.setValue("1130");
        lineItem.addMerchandiseHierarchy(merchandiseHierarchy);
        SaleBase sale = new SaleBase();
        sale.setNonPieceGoodFlag(false);
        sale.setFrequentShopperPointsEligibilityFlag(true);
        sale.setNotConsideredByPriceEngineFlag(false);
        sale.setTaxIncludedInPriceFlag(false);
        sale.setItemType("Stock");
        sale.setNonDiscountableFlag(false);
        sale.setFixedPriceFlag(false);

        ItemID itemID = new ItemID();
        itemID.setValue(saleItemId);
        sale.addItemID(itemID);

        QuantityCommonData quantity = new QuantityCommonData();
        quantity.setValue(9);
        quantity.setUnits(1);
        quantity.setUnitOfMeasureCode(UOM_PCE);
        sale.addQuantity(quantity);
        lineItem.setSale(sale);
        return lineItem;
    }

    private static ARTSCommonHeaderType creeateARTSHeader() {
        ARTSCommonHeaderType ARTSHeader = new ARTSCommonHeaderType();
        MessageID MessageID = new MessageID();
        MessageID.setValue("24006277100103003034034700701395");
        BusinessUnitCommonData BusinessUnit = new BusinessUnitCommonData();
        BusinessUnit.setTypeCode("RetailStore");
        BusinessUnit.setValue(businessUnitValue);

        ARTSHeader.setActionCode("Calculate");
        ARTSHeader.setMessageType("Request");
        ARTSHeader.setMessageID(MessageID);
        ARTSHeader.addBusinessUnit(BusinessUnit);
        return ARTSHeader;
    }
}
