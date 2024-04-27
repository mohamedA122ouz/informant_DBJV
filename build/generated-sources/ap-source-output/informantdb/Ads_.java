package informantdb;

import informantdb.Choosen;
import informantdb.Images;
import informantdb.Payment;
import informantdb.Statistics;
import informantdb.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, Images> imageId;
    public static volatile SingularAttribute<Ads, Float> price;
    public static volatile SingularAttribute<Ads, Payment> paymentId;
    public static volatile SingularAttribute<Ads, User> creatorID;
    public static volatile SingularAttribute<Ads, String> details;
    public static volatile SingularAttribute<Ads, Short> stars;
    public static volatile SingularAttribute<Ads, Long> id;
    public static volatile CollectionAttribute<Ads, Choosen> choosenCollection;
    public static volatile CollectionAttribute<Ads, Images> imagesCollection;
    public static volatile SingularAttribute<Ads, Statistics> statistics;

}