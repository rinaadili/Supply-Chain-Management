package BLL;

import BLL.Country;
import BLL.Customer;
import BLL.Employees;
import BLL.Objects;
import BLL.Suppliers;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, Employees> employeesCollection;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile CollectionAttribute<City, Customer> customerCollection;
    public static volatile CollectionAttribute<City, Objects> objectsCollection;
    public static volatile CollectionAttribute<City, Suppliers> suppliersCollection;
    public static volatile SingularAttribute<City, Integer> cityID;
    public static volatile SingularAttribute<City, Country> countryID;

}