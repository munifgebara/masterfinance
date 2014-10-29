/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.munif.masterfinance2.desktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class JuridicaConsulta extends JFrame implements ActionListener {

    private JButton btExcluir;
    private JButton btAlterar;
    private JButton btIncluir;
    private JButton btPesquisar;
    
    private JTextField tfFiltro;
    private JLabel lFiltro;
    private JTable tabela;

    private JPanel pBotoes;
    
    public JuridicaConsulta(){
        setTitle("Cadastro de Pessoa Juridica");
        setLayout(new BorderLayout());
        pBotoes = new JPanel(new FlowLayout());
        tabela = new JTable(new JuridicaTableModel());
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
       
    }
    
    
    
}
