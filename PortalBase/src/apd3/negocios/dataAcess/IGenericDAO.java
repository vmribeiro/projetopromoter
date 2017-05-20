/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.dataAcess;

import java.util.List;

/**
 *
 * @author vmrib
 */
interface IGenericDAO<E> {

    public E findById(int id);

    public List<E> findAll();

    public boolean update(E e);

    public boolean remove(E e);
    
    public boolean insert(E e);
}
