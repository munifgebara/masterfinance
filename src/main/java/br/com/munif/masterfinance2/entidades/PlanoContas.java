/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author USER
 */
@Entity
public class PlanoContas {

    @Id
    @GeneratedValue
    private Long id;

    private String codigo;
    private String descricao;
    private Boolean totalizador;

    public PlanoContas() {
    }

    public PlanoContas(String codigo, String descricao, Boolean totalizador) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.totalizador = totalizador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlanoContas other = (PlanoContas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanoContas{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", totalizador=" + totalizador + '}';
    }

    public Object getcodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getdescricao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
