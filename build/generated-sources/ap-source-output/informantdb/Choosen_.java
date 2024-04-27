package informantdb;

import informantdb.Ads;
import informantdb.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Choosen.class)
public class Choosen_ { 

    public static volatile SingularAttribute<Choosen, Ads> adId;
    public static volatile SingularAttribute<Choosen, Long> id;
    public static volatile SingularAttribute<Choosen, Float> profit;
    public static volatile SingularAttribute<Choosen, User> userId;

}