package informantdb;

import informantdb.Ads;
import informantdb.Choosen;
import informantdb.Payment;
import informantdb.Statistics;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Ads> adsCollection;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> details;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile CollectionAttribute<User, Choosen> choosenCollection;
    public static volatile CollectionAttribute<User, Payment> paymentCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile CollectionAttribute<User, Statistics> statisticsCollection;
    public static volatile SingularAttribute<User, String> cridetCard;
    public static volatile SingularAttribute<User, String> token;

}