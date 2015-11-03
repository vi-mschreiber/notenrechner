/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hof.se2.web;

import de.hof.se2.ejb.Noten;
import de.hof.se2.ejb.Studiengang;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author markus
 */
@Named(value = "notenManaged")
@SessionScoped
public class NotenManaged implements Serializable{

    @PersistenceContext
    EntityManager em;
    
    
    List<Studiengang> a; 
    /**
     * Creates a new instance of NotenManaged
     */
    public NotenManaged() {
        
    }
    
    @Named
    public List<Noten> getAllNoten(){
        List<Noten> rc = new ArrayList<>();
        rc = (List<Noten>) em.createNativeQuery("select * from noten").getResultList();
//        rc.add(new Noten(120, 2));
        return rc;
    }
    
    
}
