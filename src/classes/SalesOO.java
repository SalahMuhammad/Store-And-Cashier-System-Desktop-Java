package classes;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SalesOO {
    public ArrayList<SalesO> listData;
    public Timestamp date;

    public SalesOO( ArrayList<SalesO> listData, Timestamp date ) {
        this.listData = listData;
        this.date = date;
    }    
}
