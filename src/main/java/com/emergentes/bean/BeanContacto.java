package com.emergentes.bean;

import com.emergentes.entidades.Contacto;
import com.emergentes.jpa.ContactoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diman
 */
public class BeanContacto {

    private EntityManagerFactory emf;
    private ContactoJpaController jpaContacto;

    public BeanContacto() {
        emf = Persistence.createEntityManagerFactory("UPagenda");
        jpaContacto = new ContactoJpaController(emf);
    }

    public List<Contacto> listarTodos() {
        return jpaContacto.findContactoEntities();
    }

    public void insertar(Contacto c) {
        jpaContacto.create(c);
    }

    public void editar(Contacto c) {
        try {
            jpaContacto.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) {
        try {
            jpaContacto.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Contacto buscar(Integer id) {
        Contacto conta = new Contacto();
        conta = jpaContacto.findContacto(id);
        return conta;
    }
}
