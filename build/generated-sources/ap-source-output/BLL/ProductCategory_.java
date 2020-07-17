package BLL;

import BLL.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile CollectionAttribute<ProductCategory, Products> productsCollection;
    public static volatile SingularAttribute<ProductCategory, String> description;
    public static volatile SingularAttribute<ProductCategory, String> categoryName;
    public static volatile SingularAttribute<ProductCategory, Integer> categoryID;

}