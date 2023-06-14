package classes;

import java.math.BigDecimal;

public class SuppliersInfoO {
    
    public int id;
    public String name;
    public String phone;
    public BigDecimal debt;

    public SuppliersInfoO() {}
    
    public SuppliersInfoO(int id, String name, String phone, BigDecimal debt ) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.debt = debt;
    }
}
