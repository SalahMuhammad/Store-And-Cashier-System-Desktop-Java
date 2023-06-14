package classes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javaapplication2.MyMethods;

public class ExpensesO {
    public int id;
    public BigDecimal pay;
    public String note;
    public String supplierName;
    public String date;
    
    public ExpensesO( int id, String supplierName, BigDecimal pay, String note, Timestamp date ) {
        this.id = id;
        this.pay = pay;
        this.note = note;
        this.supplierName = supplierName;
        this.date = MyMethods.sdf.format( date );
    }

    public ExpensesO(BigDecimal pay, String note) {
        this.pay = pay;
        this.note = note;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public String getNote() {
        return note;
    }
    
}
