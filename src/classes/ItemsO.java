package classes;

import java.math.BigDecimal;

public class ItemsO {
    
    protected String itemId;
    protected String desc;
    private BigDecimal purchasePrice;
    private BigDecimal price;
    private BigDecimal ws_price;
    private BigDecimal ws_ws_price;
    public int warehouseStock;
    public int centerStock;

    public ItemsO() {}
    
    public ItemsO(String item_id, String description, BigDecimal price, BigDecimal ws_price) {
        this.itemId = item_id;
        this.desc = description;
        this.price = price;
        this.ws_price = ws_price;
    }

    public ItemsO( BigDecimal price, BigDecimal wsPrice ) {
        this.price      = price;
        this.ws_price   = wsPrice; 
    }
    
    public ItemsO(String item_id, String description, BigDecimal price, BigDecimal ws_price, int warehouseStock, int centerStock ) {
        this.itemId = item_id;
        this.desc = description;
        this.price = price;
        this.ws_price = ws_price;
        this.warehouseStock = warehouseStock;
        this.centerStock = centerStock;
    }
    
    public ItemsO(String item_id, String description) {
        this.itemId = item_id;
        this.desc = description;
    }

    public ItemsO(String item_id, String description, BigDecimal purchasePrice, BigDecimal price, BigDecimal ws_price, BigDecimal ws_ws_price, int warehouseStock, int centerStock ) {
        this.itemId = item_id;
        this.desc = description;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.ws_price = ws_price;
        this.ws_ws_price = ws_ws_price;
        this.warehouseStock = warehouseStock;
        this.centerStock = centerStock;
    }

    public ItemsO(String item_id, String description, BigDecimal purchasePrice, BigDecimal price, BigDecimal ws_price, BigDecimal ws_ws_price) {
        this.itemId = item_id;
        this.desc = description;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.ws_price = ws_price;
        this.ws_ws_price = ws_ws_price;
    }

    public String getItem_id() {
        return itemId;
    }

    public String getDescription() {
        return desc;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getWs_price() {
        return ws_price;
    }

    public BigDecimal getWs_ws_price() {
        return ws_ws_price;
    }
}
