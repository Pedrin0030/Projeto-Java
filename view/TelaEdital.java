package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Dados;
import model.Edital;

/**
 * Essa classe cria a interface completa para que o CRUD de 
 * editais sejam visualizadas.
 * 
 * @author Camila
 * @author Pedro
 * @since 2023
 * @version 1.1
 *
 */
public class TelaEdital extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel1;
    private JPanel painel2;
    private JPanel painel3;
    private JPanel painel4;
    private JList<String> listaEditais;
    private DefaultListModel<String> modelEditais;
    private JTextField txtNomeConcurso;
    private JTextField txtRegrasProva;
    private JTextField txtTaxaInscricao;
    private JTextField txtDataConcurso;
    private JTextField txtDataFechamento;
    private JTextField txtDataAtual;
    private JButton btnExcluirEdital;
    private JButton btnAdicionarLeitura;
    private JButton btnUpdate;
    private JButton btnAdicionarEdital;
    private JButton btnBuscarEditais;
    private String localLeitura;
    private JTextArea leitura;
	private Dados d;

	/**
	 * Contrói objeto TelaEdital
	 * @param d
	 */
    public TelaEdital(Dados d) {
    	this.d = d;
    	
        //Configurações básicas dos painéis 1, 2, 3 e 4.
        setTitle("Planejando Meu Futuro | EDITAIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Aplicação fecha após clicar no X.
        setLayout(new GridLayout(2, 2));
        painel1 = new JPanel(new BorderLayout());
        painel2 = new JPanel(new BorderLayout());
        painel3 = new JPanel(new BorderLayout());
        painel4 = new JPanel(new BorderLayout());
        
        // Títulos dos painéis
        JLabel tituloPainel1 = new JLabel("Editais Disponíveis");
        JLabel tituloPainel2 = new JLabel("Campo leitura");
        JLabel tituloPainel3 = new JLabel("Adicionar Edital");
        JLabel tituloPainel4 = new JLabel("Buscar Editais");

        // Adicionando os títulos aos painéis
        painel1.add(tituloPainel1, BorderLayout.NORTH);
        painel2.add(tituloPainel2, BorderLayout.NORTH);
        painel3.add(tituloPainel3, BorderLayout.NORTH);
        painel4.add(tituloPainel4, BorderLayout.NORTH);
        
        //Cores para os fundos dos títulos
        Color corTituloPainel1 = Color.BLUE;
        Color corTituloPainel2 = Color.GREEN;
        Color corTituloPainel3 = Color.RED;
        Color corTituloPainel4 = Color.ORANGE;
        tituloPainel1.setOpaque(true);
        tituloPainel1.setBackground(corTituloPainel1);
        tituloPainel2.setOpaque(true);
        tituloPainel2.setBackground(corTituloPainel2);
        tituloPainel3.setOpaque(true);
        tituloPainel3.setBackground(corTituloPainel3);
        tituloPainel4.setOpaque(true);
        tituloPainel4.setBackground(corTituloPainel4);
        
        //Alinhamento central dos títulos
        tituloPainel1.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel2.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel3.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel4.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Espaçamento dos títulos
        int padding = 7;
        tituloPainel1.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel2.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel3.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel4.setBorder(new EmptyBorder(padding, padding, padding, padding));
        
        // Definindo as cores de fundo e de letra dos títulos
        tituloPainel1.setOpaque(true);
        tituloPainel1.setBackground(corTituloPainel1);
        tituloPainel1.setForeground(Color.WHITE);
        tituloPainel2.setOpaque(true);
        tituloPainel2.setBackground(corTituloPainel2);
        tituloPainel2.setForeground(Color.WHITE);
        tituloPainel3.setOpaque(true);
        tituloPainel3.setBackground(corTituloPainel3);
        tituloPainel3.setForeground(Color.WHITE);
        tituloPainel4.setOpaque(true);
        tituloPainel4.setBackground(corTituloPainel4);
        tituloPainel4.setForeground(Color.WHITE);
        
        /*
         * PAINEL 1
         */
        //Formato desejado para aparecer no painel pegando os dados da classe Dados.
        modelEditais = new DefaultListModel<>();
        for (Edital edital : d.getEditais()) {
        	 modelEditais.addElement(edital.getNomeConcurso() + " - " + edital.getDataFechamento());
        }
        listaEditais = new JList<>(modelEditais);
        JScrollPane scrollPane1 = new JScrollPane(listaEditais);
        painel1.add(scrollPane1, BorderLayout.CENTER);
        
        //Cria, adiciona e centraliza os botões "Excluir" e "Ler".
        btnExcluirEdital = new JButton("Excluir Edital");
        btnAdicionarLeitura = new JButton("Ler Edital");
        JPanel panelBotoes1 = new JPanel();
        panelBotoes1.add(btnExcluirEdital);
        panelBotoes1.add(btnAdicionarLeitura);
        painel1.add(panelBotoes1, BorderLayout.SOUTH);

        /*
         * PAINEL 2
         */
        //Cria o painel 2, coloca no lugar desejado e adiciona na tela.
        leitura =  new JTextArea(localLeitura);
        leitura.setBounds(0, 3000, 250, 300);
        painel2.add(leitura);      
        
        btnUpdate = new JButton("Atualizar Edital");
        JPanel panelBotoes2 = new JPanel();
        panelBotoes2.add(btnUpdate);
        painel2.add(panelBotoes2, BorderLayout.SOUTH);

        /*
         * PAINEL 3
         */
        //Campos para criar edital
        JPanel panelCampos = new JPanel(new GridLayout(5, 2));
        panelCampos.add(new JLabel("Nome do Concurso:"));
        txtNomeConcurso = new JTextField();
        panelCampos.add(txtNomeConcurso);
        panelCampos.add(new JLabel("Regras da Prova:"));
        txtRegrasProva = new JTextField();
        panelCampos.add(txtRegrasProva);
        panelCampos.add(new JLabel("Taxa de Inscrição:"));
        txtTaxaInscricao = new JTextField();
        panelCampos.add(txtTaxaInscricao);
        panelCampos.add(new JLabel("Data Concurso:"));
        txtDataConcurso = new JTextField(); 
        panelCampos.add(txtDataConcurso);
        panelCampos.add(new JLabel("Data de Fechamento:"));
        txtDataFechamento = new JTextField();
        panelCampos.add(txtDataFechamento);
        btnAdicionarEdital = new JButton("Adicionar Edital");
       
        painel3.add(panelCampos, BorderLayout.CENTER);
        painel3.add(btnAdicionarEdital, BorderLayout.SOUTH);

        /*
         * PAINEL 4
         */
        JPanel panelDataAtual = new JPanel(new FlowLayout(FlowLayout.LEFT));//Quebra linha quando necessário
        panelDataAtual.add(new JLabel("Data Atual:"));
        txtDataAtual = new JTextField(15);//Tamanho do texto
        panelDataAtual.add(txtDataAtual);

        btnBuscarEditais = new JButton("Buscar Editais");
        painel4.add(panelDataAtual, BorderLayout.CENTER); //Painel no centro
        painel4.add(btnBuscarEditais, BorderLayout.SOUTH);
        btnBuscarEditais.addActionListener(new ActionListener() {
			
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface.
        	 * @param e
        	 */
        	@Override
            public void actionPerformed(ActionEvent e) {
                String dataDigitadaStr = txtDataAtual.getText();
                DefaultListModel<String> modelPainel4 = new DefaultListModel<>();
                listaEditais.setModel(modelPainel4);
        
                if (d.pesquisarPorData(dataDigitadaStr) == null) {
                	JOptionPane.showMessageDialog(TelaEdital.this, "Data atual inválida! A data atual é anterior à data digitada.", "Aviso"
                			, JOptionPane.INFORMATION_MESSAGE);
                
                } else {
                modelPainel4.addElement(d.pesquisarPorData(dataDigitadaStr).getNomeConcurso());
                }  
                
                
            }
        });

        //Adiciona os painéis ao JFrame
        add(painel1);
        add(painel2);
        add(painel3);
        add(painel4);

        //Listeners dos botões "Ler" e "Update".
        btnAdicionarLeitura.addActionListener(new ActionListener() {
            /**
             * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para ler editais específicos.
             */
        	@Override
            public void actionPerformed(ActionEvent e) {
                String selectedEdital = listaEditais.getSelectedValue();
                if (selectedEdital != null) {
                	leitura.setText(d.leituraEdital(selectedEdital).toString());
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para atualizar a lista do painel 1.
        	 * @param e
        	 */
        	@Override
            public void actionPerformed(ActionEvent e) {
            	listaEditais.addListSelectionListener(new ListSelectionListener() {
            	    public void valueChanged(ListSelectionEvent e) {
            	        if (!e.getValueIsAdjusting()) {
            	            //Obtém o índice do edital selecionado
            	            int selectedIndex = listaEditais.getSelectedIndex();

            	            //Verifica se um edital foi selecionado
            	            if (selectedIndex != -1) {
            	                //Edital selecionado a partir do objeto Dados
            	                Edital editalSelecionado = d.getEditais().get(selectedIndex);
            	                //Preenche os campos de texto com os dados do edital
            	                txtNomeConcurso.setText(editalSelecionado.getNomeConcurso());
            	                txtRegrasProva.setText(editalSelecionado.getRegrasProva());
            	                txtTaxaInscricao.setText(editalSelecionado.getTaxaInscricao());
            	                txtDataConcurso.setText(editalSelecionado.getDataConcurso());
            	                txtDataFechamento.setText(editalSelecionado.getDataFechamento());
            	            }
            	        }
            	    }
            	});	 
           }
        });
        
        //Listeners do botão "Adiconar"
        btnAdicionarEdital.addActionListener(new ActionListener() {
            /**
             * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para o cadastro de editais.
        	 * @param e
             */
        	@Override
            public void actionPerformed(ActionEvent e) {
                //Adiciona um novo edital no painel 1.
                String nomeConcurso = txtNomeConcurso.getText();
                String regrasProva = txtRegrasProva.getText();
                String taxaInscricao = txtTaxaInscricao.getText();
                String dataConcurso = txtDataConcurso.getText();
                String dataFechamento = txtDataFechamento.getText();
                
                //Adiciona na classe Dados.
                d.criarEdital(nomeConcurso, regrasProva, taxaInscricao, dataConcurso, dataFechamento);
                d.getEditais().add(null);
                
                if (d.getEditais().contains(null)) {
                    JOptionPane.showMessageDialog(null, "Edital Salvo!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar!");                
                }
                
                
                DefaultListModel<String> model = (DefaultListModel<String>) listaEditais.getModel();
                model.addElement(nomeConcurso + " - " + dataConcurso);             
                listaEditais.setModel(model);
                
                // Limpa os campos de entrada após adicionar o edital
                txtNomeConcurso.setText("");
                txtRegrasProva.setText("");
                txtTaxaInscricao.setText("");
                txtDataConcurso.setText("");
                txtDataFechamento.setText("");
                ;
            }
        });
        
      //Listeners do botão "Excluir".
         btnExcluirEdital.addActionListener(new ActionListener() {
        	   
        	 	/**
        	 	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 	 * método da interface para excluir algum edital da lista.
        	 	 * @param e
        	 	 */
        	 	@Override
        	    public void actionPerformed(ActionEvent e) {
        	    	 int selectedIndex = listaEditais.getSelectedIndex();
        	         if (selectedIndex != -1) {
        	             boolean res = d.excluirEdital(selectedIndex);
        	             if (res) {
        	                 JOptionPane.showMessageDialog(null, "Edital removido com sucesso!");
                            listaEditais.updateUI();
        	                 // Atualizar a lista de editais após a remoção
        	                 DefaultListModel<String> model = (DefaultListModel<String>) listaEditais.getModel();
        	                 model.remove(selectedIndex);
        	                 listaEditais.setModel(model); // Atualizar o modelo da lista
        	             } else {
        	                 JOptionPane.showMessageDialog(null, "Erro ao remover o edital!");
        	             }
        	         } else {
        	             JOptionPane.showMessageDialog(null, "Selecione um edital para remover!");
        	         }
        	         
        	    }
        	 });
        
        // Configurações finais do JFrame
        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
        
    }
    
    /**
     * Aqui é retornado os editais que estão no ArrayList da classe Dados.
     * @return
     */
	public  ArrayList<String[]> getEdital() {
        ArrayList<String[]> Editais = new ArrayList<>();
        ArrayList<Edital> E = Dados.getTodosEditais();
        
        return Editais;
    }
    
	/**
	 * Configuração para exibir as informações e permitir as
	 * interações com os dados com a instância da classe Dados.
	 * @param args
	 */
	
      

}