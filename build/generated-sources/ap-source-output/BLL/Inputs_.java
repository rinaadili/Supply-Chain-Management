package BLL;

import BLL.Employees;
import BLL.InputDetails;
import BLL.Objects;
import BLL.Shippers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Inputs.class)
public class Inputs_ { 

    public static volatile SingularAttribute<Inputs, Integer> inputID;
    public static volatile SingularAttribute<Inputs, Shippers> shipperID;
    public static volatile CollectionAttribute<Inputs, InputDetails> inputDetailsCollection;
    public static volatile SingularAttribute<Inputs, Employees> employeeID;
    public static volatile SingularAttribute<Inputs, Date> inputDate;
    public static volatile SingularAttribute<Inputs, Objects> objectID;

}