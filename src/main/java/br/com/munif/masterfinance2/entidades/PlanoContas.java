/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.munif.masterfinance2.entidades;

/**
 *
 * @author USER
 */
public class PlanoContas {
    private String codigo;
    private String descricao;
    private Boolean totalizador;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean isTotalizador() {
        return totalizador;
    }

    public void setTotalizador(Boolean totalizador) {
        this.totalizador = totalizador;
    }
    
}
