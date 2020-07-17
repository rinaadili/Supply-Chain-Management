package BLL;

import BLL.Inputs;
import BLL.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(InputDetails.class)
public class InputDetails_ { 

    public static volatile SingularAttribute<InputDetails, Double> unitPrice;
    public static volatile SingularAttribute<InputDetails, Inputs> inputID;
    public static volatile SingularAttribute<InputDetails, Integer> inputDetailsID;
    public static volatile SingularAttribute<InputDetails, Integer> quantity;
    public static volatile SingularAttribute<InputDetails, Products> productID;

}