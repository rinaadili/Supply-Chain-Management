package BLL;

import BLL.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, Boolean> approved;
    public static volatile SingularAttribute<Request, Integer> requestID;
    public static volatile SingularAttribute<Request, Employees> employeeID;

}