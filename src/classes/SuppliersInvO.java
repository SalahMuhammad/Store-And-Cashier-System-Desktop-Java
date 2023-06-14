package classes;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import javaapplication2.MyMethods;

public class SuppliersInvO extends SuppliersInfoO {
    
    public int id;
    public Blob inv;
    public BigDecimal invPrice;
    public String date;
    public int suppid;
    public String note;

    public SuppliersInvO(int id, BigDecimal invPrice, Timestamp date, String note, String name) {
        this.id = id;
        this.invPrice = invPrice;
        this.date = MyMethods.sdf.format( date );
        this.note = note;
        this.name = name;
    }

    public SuppliersInvO(int id, BigDecimal invPrice, Timestamp date, String note) {
        this.id = id;
        this.invPrice = invPrice;
        this.date = MyMethods.sdf.format( date );
        this.note = note;
    }

    public SuppliersInvO(int id, Blob inv, BigDecimal invPrice, Timestamp date) {
        this.id = id;
        this.inv = inv;
        this.invPrice = invPrice;
        this.date = MyMethods.sdf.format( date );
    }

    public SuppliersInvO(int id, Blob inv, BigDecimal invPrice, Timestamp date, int suppid) {
        this.id = id;
        this.inv = inv;
        this.invPrice = invPrice;
        this.date = MyMethods.sdf.format( date );
        this.suppid = suppid;
    }    
}
