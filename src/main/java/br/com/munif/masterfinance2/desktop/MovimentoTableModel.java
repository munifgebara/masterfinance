/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.Movimento;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author GuilhermeAlmeida
 */
public class MovimentoTableModel implements TableModel {
    
    private List<Movimento> lista;
    
    public List<Movimento> getLista() {
        return lista;
    }
    
    public MovimentoTableModel() {
        lista = Programa.getEntityManager().createQuery("from Movimento").getResultList();
    }

    @Override
    public int getRowCount() {
        
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        
        return 2;
    }

    @Override
    public String getColumnName(int i) {
        
        switch ( i ) {
            case 0:
                return "Data";
            case 1:
                return "Valor";
                
        }
        return "";
      
    }

    @Override
    public Class<?> getColumnClass(int i) {
        
        switch ( i ) {
            case 0:
                return Date.class;
            case 1:
                return Double.class;
           
        }
        
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1){
            
        return false;
         
    }

    @Override
    public Object getValueAt(int i, int i1) {

        Movimento movimento=lista.get(i);
        
        switch (i1) {
            case 0:
                return movimento.getQuando();
            case 1:
                return movimento.getValor();
        }
        return String.class;
        
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        
    }
    
    
    
}
