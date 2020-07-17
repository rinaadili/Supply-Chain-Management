package BLL;

import BLL.City;
import BLL.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> customerSurname;
    public static volatile SingularAttribute<Customer, Date> customerBirthdate;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, Boolean> sex;
    public static volatile SingularAttribute<Customer, Integer> customerID;
    public static volatile CollectionAttribute<Customer, Orders> ordersCollection;
    public static volatile SingularAttribute<Customer, City> cityID;
    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile SingularAttribute<Customer, String> email;

}