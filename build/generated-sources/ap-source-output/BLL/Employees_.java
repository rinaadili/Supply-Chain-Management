package BLL;

import BLL.City;
import BLL.Employees;
import BLL.Inputs;
import BLL.Objects;
import BLL.Orders;
import BLL.Request;
import BLL.Title;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> employeeName;
    public static volatile CollectionAttribute<Employees, Request> requestCollection;
    public static volatile SingularAttribute<Employees, Date> birthdate;
    public static volatile SingularAttribute<Employees, String> employeeLastname;
    public static volatile SingularAttribute<Employees, Boolean> sex;
    public static volatile SingularAttribute<Employees, Title> titleID;
    public static volatile SingularAttribute<Employees, Integer> employeeID;
    public static volatile SingularAttribute<Employees, Employees> reportsTo;
    public static volatile CollectionAttribute<Employees, Orders> ordersCollection;
    public static volatile SingularAttribute<Employees, City> cityID;
    public static volatile SingularAttribute<Employees, Date> hiredate;
    public static volatile CollectionAttribute<Employees, Inputs> inputsCollection;
    public static volatile CollectionAttribute<Employees, Employees> employeesCollection;
    public static volatile SingularAttribute<Employees, String> phone;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, Objects> objectID;

}