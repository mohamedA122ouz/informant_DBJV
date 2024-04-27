package informantdb;

import informantdb.Ads;
import informantdb.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile CollectionAttribute<Payment, Ads> adsCollection;
    public static volatile SingularAttribute<Payment, Long> id;
    public static volatile SingularAttribute<Payment, Float> value;
    public static volatile SingularAttribute<Payment, User> userId;

}