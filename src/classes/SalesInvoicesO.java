package classes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javaapplication2.MyMethods;

public class SalesInvoicesO {
    public int id;
    public String date;
    public String customerName;
    public String note;
    public BigDecimal payed;
    public BigDecimal total;
    
    
    
    public SalesInvoicesO(int id, Timestamp date, String customerName, BigDecimal payed, BigDecimal total, String note ) {
        this.id = id;
//        this.date = date;
        this.date = MyMethods.sdf.format( date );
        this.customerName = customerName;
        this.payed = payed;
        this.total = total;
        this.note = note;
    }
}
