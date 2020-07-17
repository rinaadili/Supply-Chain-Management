package BLL;

import BLL.Objects;
import BLL.ProductCategory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Offers.class)
public class Offers_ { 

    public static volatile SingularAttribute<Offers, Boolean> valid;
    public static volatile SingularAttribute<Offers, ProductCategory> productCategoryID;
    public static volatile SingularAttribute<Offers, Date> endDate;
    public static volatile SingularAttribute<Offers, Integer> discountPrs;
    public static volatile SingularAttribute<Offers, Integer> offerID;
    public static volatile SingularAttribute<Offers, Date> startDate;
    public static volatile SingularAttribute<Offers, Objects> objectID;

}