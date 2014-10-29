/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.munif.masterfinance2.entidades;

import javax.persistence.Entity;

/**
 *
 * @author USER
 */
@Entity
public class Juridica extends Pessoa {
    
    private String cnpj;

    public Juridica() {
    }

    public Juridica(String cnpj, String nome, String email, String telefone, String endereco, String cidade, String uf, String cep) {
        super(nome, email, telefone, endereco, cidade, uf, cep);
        this.cnpj = cnpj;
    }
    
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    
    
}
