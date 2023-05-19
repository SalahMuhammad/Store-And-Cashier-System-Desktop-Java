package classes;

import java.sql.Blob;
import java.sql.Date;

public class SuppliersInvO extends SuppliersInfoO {
    
    public int id;
    public Blob inv;
    public int invPrice;
    public Date date;
    public int suppid;
    public String note;

    public SuppliersInvO(int id, int invPrice, Date date, String note, String name) {
        this.id = id;
        this.invPrice = invPrice;
        this.date = date;
        this.note = note;
        this.name = name;
    }

    public SuppliersInvO(int id, int invPrice, Date date, String note) {
        this.id = id;
        this.invPrice = invPrice;
        this.date = date;
        this.note = note;
    }

    public SuppliersInvO(int id, Blob inv, int invPrice, Date date) {
        this.id = id;
        this.inv = inv;
        this.invPrice = invPrice;
        this.date = date;
    }

    public SuppliersInvO(int id, Blob inv, int invPrice, Date date, int suppid) {
        this.id = id;
        this.inv = inv;
        this.invPrice = invPrice;
        this.date = date;
        this.suppid = suppid;
    }    
}
