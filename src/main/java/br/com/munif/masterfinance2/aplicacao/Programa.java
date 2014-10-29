/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.aplicacao;

import br.com.munif.masterfinance2.desktop.ContaCorrenteConsulta;
import br.com.munif.masterfinance2.desktop.PlanoContasConsulta;
import br.com.munif.masterfinance2.entidades.Fisica;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author munifgebarajunior
 */
public class Programa {

    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        createEntityManagerFactory();
        
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Fisica f=new Fisica();
        f.setNome("Munif");
        f.setCpf("0123");
        em.persist(f);
        em.getTransaction().commit();
        
        new ContaCorrenteConsulta();
        
        new PlanoContasConsulta();

    }

    public static void createEntityManagerFactory() {
        emf=Persistence.createEntityManagerFactory("UnidadeDePersistencia");
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
