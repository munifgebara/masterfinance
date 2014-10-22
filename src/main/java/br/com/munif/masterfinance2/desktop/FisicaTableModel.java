/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.Fisica;
import java.util.List;
import javax.persistence.Query;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author munifgebarajunior
 */
public class FisicaTableModel implements TableModel {

    private List<Fisica> lista;

    public List<Fisica> getLista() {
        return lista;
    }

    public FisicaTableModel() {
        lista = Programa.getEntityManager().createQuery("from Fisica").getResultList();
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
                return "nome";
            case 1:
                return "telefone";
            case 2:
                return "cpf";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fisica fisica=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fisica.getNome();
            case 1:
                return fisica.getTelefone();
            case 2:
                return fisica.getCpf();
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
