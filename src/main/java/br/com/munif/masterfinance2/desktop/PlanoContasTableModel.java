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
import javax.persistence.Query;
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
    
    public PlanoContasTableModel(String text) {
        Query q=Programa.getEntityManager().createQuery("from PlanoContas obj where upper(obj.codigo) like :filtro or upper(obj.descricao) like :filtro");
        text="%"+text.toUpperCase()+"%";
        q.setParameter("filtro", text);
        lista=q.getResultList();
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
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Descrição";
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
                return planoContas.getCodigo();
            case 1:
                return planoContas.getDescricao();            
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
