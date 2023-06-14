package classes;

import java.sql.Timestamp;
import javaapplication2.MyMethods;

public class ItemOrderInvoicesO {
    
    public int id;
    public String date;
    
    public ItemOrderInvoicesO( int id, Timestamp date ) {
        this.id = id;
        this.date = MyMethods.sdf.format( date );
    }
}
