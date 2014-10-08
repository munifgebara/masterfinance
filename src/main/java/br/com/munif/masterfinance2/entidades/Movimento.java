/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.munif.masterfinance2.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author USER
 */
@Entity
public class Movimento {
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date quando;
    private Double valor;
    
    @ManyToOne
    private Titulo titulo;
    
    @ManyToOne
    private ContaCorrente contaCorrente;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getQuando() {
        return quando;
    }

    public void setQuando(Date quando) {
        this.quando = quando;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
    
    
    
}
