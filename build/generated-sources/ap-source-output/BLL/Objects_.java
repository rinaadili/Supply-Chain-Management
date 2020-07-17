package BLL;

import BLL.City;
import BLL.Employees;
import BLL.Inputs;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Objects.class)
public class Objects_ { 

    public static volatile CollectionAttribute<Objects, Employees> employeesCollection;
    public static volatile SingularAttribute<Objects, String> address;
    public static volatile SingularAttribute<Objects, String> phone;
    public static volatile SingularAttribute<Objects, String> companyName;
    public static volatile SingularAttribute<Objects, City> cityID;
    public static volatile SingularAttribute<Objects, Integer> objectID;
    public static volatile SingularAttribute<Objects, String> email;
    public static volatile CollectionAttribute<Objects, Inputs> inputsCollection;

}