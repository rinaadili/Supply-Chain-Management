package BLL;

import BLL.Inputs;
import BLL.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Shippers.class)
public class Shippers_ { 

    public static volatile SingularAttribute<Shippers, Integer> shipperID;
    public static volatile SingularAttribute<Shippers, String> phone;
    public static volatile SingularAttribute<Shippers, String> companyName;
    public static volatile CollectionAttribute<Shippers, Orders> ordersCollection;
    public static volatile SingularAttribute<Shippers, String> email;
    public static volatile CollectionAttribute<Shippers, Inputs> inputsCollection;

}