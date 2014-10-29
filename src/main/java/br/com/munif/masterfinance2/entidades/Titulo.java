/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.entidades;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author GuilhermeAlmeida
 */
@Entity
public class Titulo {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;
    private Double valor;
    private Double acrescimo;
    private Double desconto;
    private Boolean pago;
    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private PlanoContas planoContas;

    @OneToMany
    private List<Movimento> movimentos;

    public Titulo() {
    }

    public Titulo(Date dataVencimento, Double valor, Double acrescimo, Double desconto, Boolean pago, Pessoa pessoa, PlanoContas planoContas, List<Movimento> movimentos) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
        this.pago = pago;
        this.pessoa = pessoa;
        this.planoContas = planoContas;
        this.movimentos = movimentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Boolean isPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PlanoContas getPlanoContas() {
        return planoContas;
    }

    public void setPlanoContas(PlanoContas planoContas) {
        this.planoContas = planoContas;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Titulo other = (Titulo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Titulo{" + "id=" + id + ", dataVencimento=" + dataVencimento + ", valor=" + valor + ", acrescimo=" + acrescimo + ", desconto=" + desconto + ", pago=" + pago + ", pessoa=" + pessoa + ", planoContas=" + planoContas + ", movimentos=" + movimentos + '}';
    }

}
