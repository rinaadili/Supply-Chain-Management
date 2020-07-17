package BLL;

import BLL.Orders;
import BLL.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Double> totalAmount;
    public static volatile SingularAttribute<OrderDetails, Products> productID;
    public static volatile SingularAttribute<OrderDetails, Orders> orderID;
    public static volatile SingularAttribute<OrderDetails, Double> discount;
    public static volatile SingularAttribute<OrderDetails, Integer> quantityOrdered;
    public static volatile SingularAttribute<OrderDetails, Integer> id;

}