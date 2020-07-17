package BLL;

import BLL.ProductCategory;
import BLL.Suppliers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T21:52:22")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Double> buyPrice;
    public static volatile SingularAttribute<Products, Suppliers> supplierID;
    public static volatile SingularAttribute<Products, Integer> productID;
    public static volatile SingularAttribute<Products, Double> sellPrice;
    public static volatile SingularAttribute<Products, Integer> barcode;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, ProductCategory> categoryID;

}