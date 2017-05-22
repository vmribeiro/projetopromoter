package apd3.negocios.mgtAfiliado.entities;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Entidade implements Serializable {

    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
    }

    
    
//    public PessoaJuridica(Papel papel) {
//        super(papel);
//    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
