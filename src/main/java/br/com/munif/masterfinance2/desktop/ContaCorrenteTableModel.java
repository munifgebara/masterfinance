/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.ContaCorrente;
import java.util.List;
import javax.persistence.Query;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Estrada
 */
public class ContaCorrenteTableModel implements TableModel{
    
    private List<ContaCorrente> lista;

    
    public List<ContaCorrente> getLista(){
        return lista;
    }
    
    public ContaCorrenteTableModel(){
        lista = Programa.getEntityManager().createQuery("from ContaCorrente").getResultList();
    }
    public ContaCorrenteTableModel(String text) {
        Query q=Programa.getEntityManager().createQuery("from ContaCorrente obj where upper(obj.descricao) like :filtro");
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
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Agencia";
            case 1:
                return "Banco";
            case 2:
                return "Conta";
            case 3:
                return "Descricao";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
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
        ContaCorrente contaCorrente=lista.get(rowIndex);
        switch (columnIndex){
            case 0:
                return contaCorrente.getAgencia();
            case 1:
                return contaCorrente.getBanco();
            case 2:
                return contaCorrente.getConta();
            case 3:
                return contaCorrente.getDescricao();
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
