/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.dataAcess;

import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public interface IEntidadeDAO extends IGenericDAO<Entidade> {
    public Entidade findByEmail(String email);
    public Entidade findByCPF(String cpf);
    public Entidade findByCNPJ(String CNPJ);
}
