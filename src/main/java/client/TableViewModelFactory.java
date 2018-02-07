package client;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class TableViewModelFactory {
    public static List<TableViewModel> createTableViewModel(PriceCalculate priceCalculate) {
        List<TableViewModel> tableViewRecords = new ArrayList<>();
        ARTSCommonHeaderType artsHeader = priceCalculate.getARTSHeader();

        List<PriceCalculateBase> priceCalculateBases = priceCalculate.getPriceCalculateBody();
        for (PriceCalculateBase priceCalculateBase : priceCalculateBases) {
            ShoppingBasketBase shoppingBasket = priceCalculateBase.getShoppingBasket();
            List<LineItemDomainSpecific> lineItems = shoppingBasket.getLineItem();
            for (LineItemDomainSpecific lineItem : lineItems) {
                TableViewModel tableViewRecord = new TableViewModel();
                SaleBase sale = lineItem.getSale();

                    /*
                     This should only contain one value, becuase the prices are outside of the jsonarray
                     so there is no way of knowing which article belongs to which set of prices
                     */
                tableViewRecord.setSaleItemId(sale.getItemID().get(0).getValue());
                tableViewRecord.setRegularSalesUnitPrice(sale.getRegularSalesUnitPrice().getValue());
                tableViewRecord.setExtendedAmount(sale.getExtendedAmount().getValue());
                tableViewRecord.setExtendedDiscountAmount(sale.getExtendedDiscountAmount().getValue());
                tableViewRecord.setCurrency(sale.getExtendedAmount().getCurrency());
                tableViewRecords.add(tableViewRecord);
            }
        }
        return tableViewRecords;
    }
}
