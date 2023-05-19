package classes;

import java.sql.Timestamp;

public class SalesInvoicesO {
    public int id;
    public Timestamp date;

    public SalesInvoicesO(int id, Timestamp date) {
        this.id = id;
        this.date = date;
    }
}
