package BLL;

import BLL.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Title.class)
public class Title_ { 

    public static volatile CollectionAttribute<Title, Employees> employeesCollection;
    public static volatile SingularAttribute<Title, String> titleName;
    public static volatile SingularAttribute<Title, Integer> titleID;
    public static volatile SingularAttribute<Title, String> description;

}