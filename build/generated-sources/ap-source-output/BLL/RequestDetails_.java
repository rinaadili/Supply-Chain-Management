package BLL;

import BLL.Products;
import BLL.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(RequestDetails.class)
public class RequestDetails_ { 

    public static volatile SingularAttribute<RequestDetails, Integer> requestDetailsID;
    public static volatile SingularAttribute<RequestDetails, Integer> quantity;
    public static volatile SingularAttribute<RequestDetails, Products> productID;
    public static volatile SingularAttribute<RequestDetails, Request> requestID;

}