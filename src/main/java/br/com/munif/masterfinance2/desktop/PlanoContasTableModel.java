/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.Pessoa;
import br.com.munif.masterfinance2.entidades.PlanoContas;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author GuilhermeAlmeida
 */
public class PlanoContasTableModel implements TableModel{
    
    private List<PlanoContas> lista;

    public List<PlanoContas> getLista() {
        return lista;
    }

    public PlanoContasTableModel() {
        lista = Programa.getEntityManager().createQuery("from PlanoContas").getResultList();        
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Descricao";
            case 1:
                return "Total";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PlanoContas planoContas=lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return planoContas.getDescricao();
            case 1:
                return planoContas.isTotalizador();            
        }
        return String.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }
    
    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
