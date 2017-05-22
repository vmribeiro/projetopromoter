package apd3.negocios.mgtAfiliado.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(State.class)
public abstract class State_ {

	public static volatile SingularAttribute<State, Long> id;
	public static volatile SingularAttribute<State, String> state;
	public static volatile SingularAttribute<State, String> token;
	public static volatile SingularAttribute<State, Date> expirationDate;

}

