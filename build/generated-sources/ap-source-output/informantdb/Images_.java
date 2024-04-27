package informantdb;

import informantdb.Ads;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Images.class)
public class Images_ { 

    public static volatile SingularAttribute<Images, byte[]> image;
    public static volatile CollectionAttribute<Images, Ads> adsCollection;
    public static volatile SingularAttribute<Images, Ads> adId;
    public static volatile SingularAttribute<Images, Long> id;

}