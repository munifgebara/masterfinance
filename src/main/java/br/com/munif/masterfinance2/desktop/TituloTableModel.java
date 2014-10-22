/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.Titulo;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author GuilhermeAlmeida
 */
public class TituloTableModel implements TableModel {
    
    private List<Titulo> lista;
    
    public List<Titulo> getLista() {
        return lista;
    }
    
    public TituloTableModel() {
        lista = Programa.getEntityManager().createQuery("from Titulo").getResultList();
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
                return "Nome";
            case 1:
                return "DataVencimento";
            case 2:
                return "Valor";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Date.class;
            case 2:
                return Double.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        
        return false;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        
        Titulo titulo=lista.get(i);
        
        switch (i1) {
            case 0:
                return titulo.getPessoa().getNome();
            case 1:
                return titulo.getData_vencimento();
            case 2:
                return titulo.getValor();
        }
        return String.class;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
