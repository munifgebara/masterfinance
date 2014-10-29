/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Alterar 4 lugares

Programa

Table Model

Consulta
-Pesquisar
-excluir



*/






package br.com.munif.masterfinance2.aplicacao;

import br.com.munif.masterfinance2.desktop.ContaCorrenteConsulta;
import br.com.munif.masterfinance2.desktop.FisicaConsulta;
import br.com.munif.masterfinance2.desktop.JuridicaConsulta;
import br.com.munif.masterfinance2.desktop.MovimentoConsulta;
import br.com.munif.masterfinance2.desktop.PlanoContasConsulta;
import br.com.munif.masterfinance2.desktop.TituloConsulta;
import br.com.munif.masterfinance2.entidades.ContaCorrente;
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

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fisica f = new Fisica();
        f.setNome("Munif");
        f.setCpf("0123");
        em.persist(f);

        insereContasCorrente(em);
        insereFisica(em);
        insereJuridica(em);
        insereTitulo(em);
        insereMovimento(em);
        inserePlanoContas(em);

        em.getTransaction().commit();

        new FisicaConsulta();

        new JuridicaConsulta();

        new MovimentoConsulta();

        new PlanoContasConsulta();

        new TituloConsulta();

        new ContaCorrenteConsulta();
    }

    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void insereContasCorrente(EntityManager em) {
        em.persist(new ContaCorrente("Dinheiro", "", "", "", 0.0));
        em.persist(new ContaCorrente("Itaú Conta Corrente", "Itaú", "6667", "22472-6", 3500.0));
        em.persist(new ContaCorrente("Poupança", "Itaú", "6667", "22477-1", 0.0));
        em.persist(new ContaCorrente("Visa", "", "", "", 2000.0));
        em.persist(new ContaCorrente("Empresa", "Banco do Brasil", "012", "1234", 300.0));
    }

    private static void insereFisica(EntityManager em) {

    }

    private static void insereJuridica(EntityManager em) {

    }

    private static void insereTitulo(EntityManager em) {

    }

    private static void insereMovimento(EntityManager em) {

    }

    private static void inserePlanoContas(EntityManager em) {

    }
}
