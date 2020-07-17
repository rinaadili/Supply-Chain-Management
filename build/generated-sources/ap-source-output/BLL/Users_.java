package BLL;

import BLL.Employees;
import BLL.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Permission> permissionID;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> employeeID;
    public static volatile SingularAttribute<Users, Employees> employees;
    public static volatile SingularAttribute<Users, String> username;

}