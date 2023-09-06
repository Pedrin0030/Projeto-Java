package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Dados;
import model.QuestaoDissertativa;


/**
 * Essa classe cria a interface completa para que o CRUD de 
 * questões dissertativas e sua listagem sejam visualizadas.
 * 
 * @author Pedro
 * @author Camila
 * @since 2023
 * @version 1.1
 */
public class TelaDissertativa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> redacoesList;
    private DefaultListModel<String> redacoesListModel;
    private JButton excluirButton;
    private JButton atualizarButton;
    private JButton buscarMateriaButton;
    private JButton lerQuestaoButton; 
    private JComboBox<String> materiaDFiltroComboBox;
    private JTextField redacaoTextField = new JTextField();
    
    @SuppressWarnings("unused")//PESQUISAR SOBRE
	private Dados d;
    
    /**
     * Constrói um objeto TelaDissertativa
     * @param d
     */
    public TelaDissertativa(Dados d) {
    	this.d = d;
    	
    	//Configurações básicas
        setTitle("Planejando Meu Futuro | Dissertativa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2));
        
        
        /*
         * PAINEL 1
         */
        //Configurações do painel e do título
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        JLabel tituloPanel1 = new JLabel("Lista de Questões");
        tituloPanel1.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanel1.setForeground(Color.WHITE); 
        panel1.setLayout(new BorderLayout());
        panel1.add(tituloPanel1, BorderLayout.NORTH);
        
        //Forma para aparecer a listagem
        redacoesListModel = new DefaultListModel<>();
        for (QuestaoDissertativa questaoDissertativa : d.getQuestoesDissertativa()) {
        	redacoesListModel.addElement( "Questão:" + "  " + questaoDissertativa.getPerguntaQuestão());
        }
        redacoesList = new JList<>(redacoesListModel);
        JScrollPane questoesScrollPane = new JScrollPane(redacoesList);
        panel1.add(questoesScrollPane, BorderLayout.CENTER);

        //Botões de "Excluir", "Atualizar", "Buscar" e "Ler".
        JPanel buttonPanel = new JPanel(new FlowLayout());
        excluirButton = new JButton("Excluir");
        atualizarButton = new JButton("Atualizar Questão");
        buscarMateriaButton = new JButton("Buscar por Matéria");
        lerQuestaoButton = new JButton("Ler Questão"); 

        //Filtro dos temas das redações
        materiaDFiltroComboBox = new JComboBox<>();
        materiaDFiltroComboBox.addItem("Todas as Matérias");
        materiaDFiltroComboBox.addItem("PORTUGUÊS");
        materiaDFiltroComboBox.addItem("MATEMÁTICA");
        materiaDFiltroComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaDFiltroComboBox.addItem("ATUALIDADES");
        
        //Adiciona os notões no painel.
        buttonPanel.add(excluirButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(buscarMateriaButton);
        buttonPanel.add(lerQuestaoButton); 
        buttonPanel.add(materiaDFiltroComboBox);
        panel1.add(buttonPanel, BorderLayout.SOUTH);
        add(panel1);

        /*
         * PAINEL 3
         */
        //Configurações básicas no painel e do título
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN); 
        JLabel tituloPanel3 = new JLabel("Cadastro de Questões");
        tituloPanel3.setHorizontalAlignment(SwingConstants.CENTER); 
        tituloPanel3.setForeground(Color.WHITE); 
        panel3.setLayout(new BorderLayout());
        panel3.add(tituloPanel3, BorderLayout.NORTH);
        JPanel questaoInputPanel = new JPanel();
        questaoInputPanel.setLayout(new GridLayout(0, 2));
        
        //Campos para escrever a redação
        JLabel questaoLabel = new JLabel("Questão:");
        JTextArea questaoTextArea = new JTextArea();
        JLabel dissertacaoLabel = new JLabel("Disserte sobre:");
        JLabel materiaLabel = new JLabel("Matéria:");
        JComboBox<String> materiaDComboBox = new JComboBox<>();
        materiaDComboBox.addItem("PORTUGUÊS");
        materiaDComboBox.addItem("MATEMÁTICA");
        materiaDComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaDComboBox.addItem("ATUALIDADES");
        
        //Botão de cadastrar
        JLabel cadastrarLabel = new JLabel();
        JButton cadastrarButton = new JButton("Cadastrar");

        questaoInputPanel.add(questaoLabel);
        questaoInputPanel.add(questaoTextArea);
        questaoInputPanel.add(dissertacaoLabel);
        questaoInputPanel.add(new JLabel()); 
        questaoInputPanel.add(new JLabel("Resposta "));
        questaoInputPanel.add(redacaoTextField);
        questaoInputPanel.add(materiaLabel);
        questaoInputPanel.add(materiaDComboBox);
        questaoInputPanel.add(cadastrarLabel);
        questaoInputPanel.add(cadastrarButton);
        panel3.add(questaoInputPanel, BorderLayout.CENTER);
        add(panel3);
        
        //Listeners do botão "Excluir"
        excluirButton.addActionListener(new ActionListener() {
        	/**
             *Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para exluir uma questão.
        	 * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            	int selectedIndex = redacoesList.getSelectedIndex();
   	         if (selectedIndex != -1) {
   	             boolean res = d.excluirQuestaoD(selectedIndex);
   	             if (res) {
   	                 JOptionPane.showMessageDialog(null, "Questão removida com sucesso!");
   	              redacoesList.updateUI();
   	                 // Atualiza a lista de questoes após a remoção
                       DefaultListModel<String> questoesModel = (DefaultListModel<String>) redacoesList.getModel();
   	                 questoesModel.remove(selectedIndex);
   	              redacoesList.setModel(questoesModel); // Atualiza o modelo da lista
   	             } else {
   	                 JOptionPane.showMessageDialog(null, "Erro ao remover a questão!");
   	             }
   	         } else {
   	             JOptionPane.showMessageDialog(null, "Selecione uma questão para remover!");
   	         }
   	         
            }
        });
            
        //Listeners do botão "Arualizar"
        atualizarButton.addActionListener(new ActionListener() {
        	/**
             * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para atualizar a lista.
        	 * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            	redacoesList.addListSelectionListener(new ListSelectionListener() {
            	    public void valueChanged(ListSelectionEvent e) {
            	        if (!e.getValueIsAdjusting()) {
            	            // Obtém o índice da questao selecionada
            	            int selectedIndex = redacoesList.getSelectedIndex();

            	            // Verifica se uma questao foi selecionado
            	            if (selectedIndex != -1) {
            	                // Obtém a questao selecionada a partir do objeto Dados
            	                QuestaoDissertativa questaoDSelecionado = d.getQuestoesDissertativa().get(selectedIndex);
            	                
            	                // Preenche os campos de texto com os dados da questao
            	                questaoTextArea.setText(questaoDSelecionado.getPerguntaQuestão());
            	                redacaoTextField.setText(questaoDSelecionado.getRedacao());
            	                materiaDComboBox.setSelectedItem(questaoDSelecionado.getQuestaoMateria());
            	               
            	                
            	            }
            	        }
            	    }
            	});	 
        
           }
        });

        //Listeners do botão buscar por matéria
        buscarMateriaButton.addActionListener(new ActionListener() {
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para que o botão buscar 
        	 * matéria, busque corretamente.
        	 * @param e
        	 */
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<String> materias = d.listarMateriasD();

                // Preenche o JComboBox com as matérias
                for (String materia : materias) {
               	 materiaDFiltroComboBox.addItem(materia);
                }

                // Percorre todas as questões cadastradas
                for (int i = 0; i < redacoesListModel.size(); i++) {
                    String questao = redacoesListModel.getElementAt(i);
                    String materia = getMateriaFromQuestao(questao);
                    if (!materias.contains(materia)) {
                        materias.add(materia);
                    }
                }
                
                if (materias.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma matéria encontrada.");
                } else {
                    // Exibe a lista de matérias em um JOptionPane
                    Object[] materiasArray = materias.toArray();
                    String selectedMateria = (String) JOptionPane.showInputDialog(null, "Selecione uma matéria:",
                            "Buscar por Matéria", JOptionPane.PLAIN_MESSAGE, null, materiasArray, materiasArray[0]);

                    redacoesList.updateUI();
                    if (selectedMateria != null) {
                        DefaultListModel<String> filteredModel = new DefaultListModel<>();
                        ArrayList<QuestaoDissertativa> questoesFiltradas = d.buscarMateriaD(selectedMateria);
                        for (QuestaoDissertativa questaoD : questoesFiltradas) {
                        	filteredModel.addElement(questaoD.toString());
                        
                        }
                        
                        // Filtra as questões com base na matéria selecionada
                        for (int i = 0; i < redacoesListModel.size(); i++) {
                            String questao = redacoesListModel.getElementAt(i);
                            String materia = getMateriaFromQuestao(questao);
                            if (selectedMateria.equals(materia)) {
                                filteredModel.addElement(questao);
                            }
                        }

                        // Atualiza o modelo da lista de questões com as questões filtradas
                        redacoesList.setModel(filteredModel);
                    }
                }
            }

            /**
             * Método de auxílio para extrair a matéria de uma questão
             * @param questao
             * @return
             */
            private String getMateriaFromQuestao(String questao) {
                String[] lines = questao.split("\n");
                for (String line : lines) {
                    if (line.startsWith("Matéria:")) {
                        return line.substring(line.indexOf(":") + 1).trim();
                    }
                }
                return "";
            }
        });

        //Listeners do botão "Ler"
        lerQuestaoButton.addActionListener(new ActionListener() {
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para ler questões.
        	 * @param e
        	 */
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int selectedIndex = redacoesList.getSelectedIndex();
                 if (selectedIndex != -1) {
                     String selectedQuestion = (String) redacoesList.getModel().getElementAt(selectedIndex);

                     String questaoString = d.lerQuestaoD(selectedQuestion).toString();
                     redacoesList.updateUI();

                     if (questaoString != null) {
                         JOptionPane.showMessageDialog(null, questaoString, "Questão", JOptionPane.PLAIN_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Questão não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         });
        





        //certo/ conectado com a dados 
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String questao = questaoTextArea.getText();
                String redacao = redacaoTextField.getText();
                
                
                String materia = (String) materiaDComboBox.getSelectedItem(); 
                
                
                d.cadastrarQuestaoD(materia, questao, redacao);

                String novaQuestao = "Questão: " + questao + "    ";
                        
                        
                       
                       
                        

                redacoesListModel.addElement(novaQuestao);
                JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Limpar os campos de entrada após cadastrar a questão
                questaoTextArea.setText("");
                redacaoTextField.setText("");
                
                
            }
        });

    }
    
    public  ArrayList<String[]> getQuestaoDissertativa() {
        ArrayList<String[]> QuestoesDissertativa = new ArrayList<>();
        ArrayList<QuestaoDissertativa> D = Dados.getTodasQuestoesDissertativas();
        
        for (int i=0; i<D.size();i++) {
        
        }
       
        return QuestoesDissertativa;
    }
    
    
   
}