package entity;

import entity.Category;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-23T21:10:44", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> pname;
    public static volatile SingularAttribute<Product, Integer> pid;
    public static volatile SingularAttribute<Product, String> brandname;
    public static volatile SingularAttribute<Product, Category> cid;

}