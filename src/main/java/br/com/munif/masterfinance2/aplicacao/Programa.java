/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.aplicacao;

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

    }

    public static void createEntityManagerFactory() {
        emf=Persistence.createEntityManagerFactory("UnidadeDePersistencia");
    }
}
