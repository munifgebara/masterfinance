/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.entidades;

import javax.persistence.Entity;

/**
 *
 * @author GuilhermeAlmeida
 */
@Entity
public class Fisica extends Pessoa {

    private String cpf;

    public Fisica() {
    }

    public Fisica(String nome, String email, String telefone, String endereco, String cidade, String uf, String cep, String cpf) {
        super(nome, email, telefone, endereco, cidade, uf, cep);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
