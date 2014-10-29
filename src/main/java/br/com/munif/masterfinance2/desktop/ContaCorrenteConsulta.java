/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.masterfinance2.desktop;

import br.com.munif.masterfinance2.aplicacao.Programa;
import br.com.munif.masterfinance2.entidades.ContaCorrente;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author munifgebarajunior
 */
public class ContaCorrenteConsulta extends JFrame implements ActionListener {

    private JButton btExcluir;
    private JButton btAlterar;
    private JButton btIncluir;
    private JButton btPesquisar;

    private JTextField tfFiltro;
    private JLabel lFiltro;
    private JTable tabela;

    private JPanel pBotoes;

    //Pesquisar bordas no swing
    public ContaCorrenteConsulta() {
        setTitle("Cadastro de Conta Corrente");
        setLayout(new BorderLayout());
        pBotoes = new JPanel(new FlowLayout());
        tabela = new JTable(new ContaCorrenteTableModel());
        btExcluir = new JButton("Excluir");
        btAlterar = new JButton("Alterar");
        btIncluir = new JButton("Incluir");
        btPesquisar = new JButton("Pesquisar");
        lFiltro = new JLabel("Filtar");
        tfFiltro = new JTextField(30);

        add(pBotoes, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        pBotoes.add(lFiltro);
        pBotoes.add(tfFiltro);
        pBotoes.add(btPesquisar);
        pBotoes.add(btIncluir);
        pBotoes.add(btAlterar);
        pBotoes.add(btExcluir);

        btPesquisar.addActionListener(this);
        btIncluir.addActionListener(this);
        btAlterar.addActionListener(this);
        btExcluir.addActionListener(this);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btPesquisar)) {
            pesquisar();
        }
        if (e.getSource().equals(btAlterar)) {
            alterar();
        }
        if (e.getSource().equals(btIncluir)) {
            incluir();
        }
        if (e.getSource().equals(btExcluir)) {
            excluir();
        }

    }

    private void pesquisar() {
        tabela.setModel(new ContaCorrenteTableModel(tfFiltro.getText()));

    }

    private void alterar() {
        System.out.println("alterar");
    }

    private void incluir() {
        System.out.println("incluir");
    }

    private void excluir() {
        int selecionado = tabela.getSelectedRow();
        if (selecionado != -1) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Confirma exclusão?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)) {
                ContaCorrenteTableModel tableModel = (ContaCorrenteTableModel) tabela.getModel();
                ContaCorrente objeto = tableModel.getLista().get(selecionado);
                EntityManager em = Programa.getEntityManager();
                em.getTransaction().begin();
                objeto = em.find(ContaCorrente.class, objeto.getId());
                if (objeto == null) {
                    JOptionPane.showMessageDialog(this, "Este registro já foi excluído.", "Problemas", JOptionPane.ERROR_MESSAGE);
                } else {
                    em.remove(objeto);
                    em.getTransaction().commit();
                }
                tabela.setModel(new ContaCorrenteTableModel());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um registro.", "Problemas", JOptionPane.ERROR_MESSAGE);
        }
    }
}
