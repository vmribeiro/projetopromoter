package apd3.negocios.mgtAfiliado.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Entidade.class)
public abstract class Entidade_ {

	public static volatile SingularAttribute<Entidade, String> senha;
	public static volatile SingularAttribute<Entidade, String> tipo;
	public static volatile SingularAttribute<Entidade, String> nome;
	public static volatile SingularAttribute<Entidade, Integer> id;
	public static volatile SingularAttribute<Entidade, State> state;
	public static volatile SingularAttribute<Entidade, String> email;
	public static volatile SingularAttribute<Entidade, Papel> papel;
	public static volatile SingularAttribute<Entidade, String> habilidades;

}

