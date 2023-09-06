package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Dados;
import model.QuestaoMultiplaEscolha;

/**
 * Essa classe cria a interface completa para que o CRUD de 
 * questões e sua listagem sejam visualizadas.
 * 
 * @author Camila
 * @author Pedro
 * @since 2023
 * @version 1.1
 *
 */
public class TelaMultiplaEscolha extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> listaQuestoes;
    private DefaultListModel<String> questoesModel;
    private JButton excluirButton;
    private JButton atualizarButton;
    private JButton buscarMateriaButton;
    private JButton lerQuestaoButton; // Botão para ler a questão
    private JComboBox<String> materiaFiltroComboBox;
    private JTextField alternativaATextField = new JTextField();
    private JTextField alternativaBTextField = new JTextField();;
    @SuppressWarnings("unused")
	private Dados d;
    
    /**
     * Contrói objeto TelaMultiplaEscolha
     * @param d
     */
    public TelaMultiplaEscolha(Dados d) {
    	this.d = d;
    	
    	//Configurações básicas
        setTitle("Planejando Meu Futuro | MULTIPLA ESCOLHA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2));

        /*
         * PAINEL 1
         */
        //Estilização
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.MAGENTA);
        JLabel tituloPanel1 = new JLabel("Lista de Questões");
        tituloPanel1.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanel1.setForeground(Color.WHITE); 
        panel1.setLayout(new BorderLayout());
        panel1.add(tituloPanel1, BorderLayout.NORTH);
        
        //Puxa a questão da classe Dados
        questoesModel = new DefaultListModel<>();
        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : d.getQuestoesMultiplaEscolha()) {
        	 questoesModel.addElement( "Questão:" + "  " + questaoMultiplaEscolha.getPerguntaQuestão());
        }

        listaQuestoes = new JList<>(questoesModel);
        JScrollPane questoesScrollPane = new JScrollPane(listaQuestoes);
        panel1.add(questoesScrollPane, BorderLayout.CENTER);

        //Botões
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
        excluirButton = new JButton("Excluir");
        atualizarButton = new JButton("Atualizar Questão");
        buscarMateriaButton = new JButton("Buscar por Matéria");
        lerQuestaoButton = new JButton("Ler Questão"); 
        
        //Filtro de matérias 
        materiaFiltroComboBox = new JComboBox<>();
        materiaFiltroComboBox.addItem("Todas as Matérias");
        materiaFiltroComboBox.addItem("PORTUGUÊS");
        materiaFiltroComboBox.addItem("MATEMÁTICA");
        materiaFiltroComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaFiltroComboBox.addItem("ATUALIDADES");
        
        //Adiciona os botões no painel 1.
        buttonPanel.add(excluirButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(buscarMateriaButton);
        buttonPanel.add(lerQuestaoButton); // Adiciona o botão "Ler Questão"
        buttonPanel.add(materiaFiltroComboBox);
        panel1.add(buttonPanel, BorderLayout.SOUTH);
        add(panel1);

        /*
         * PAINEL 3
         */
        //Estilização
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.PINK);
        JLabel tituloPanel3 = new JLabel("Cadastro de Questões");
        tituloPanel3.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanel3.setForeground(Color.WHITE);
        panel3.setLayout(new BorderLayout());
        panel3.add(tituloPanel3, BorderLayout.NORTH);
        JPanel questaoInputPanel = new JPanel();
        questaoInputPanel.setLayout(new GridLayout(0, 2));
        
        //Cadastro de questões
        JLabel questaoLabel = new JLabel("Questão:");
        JTextArea questaoTextArea = new JTextArea();
        JLabel alternativasLabel = new JLabel("Alternativas:");
        JLabel materiaLabel = new JLabel("Matéria:");
        JComboBox<String> materiaComboBox = new JComboBox<>();
        materiaComboBox.addItem("PORTUGUÊS");
        materiaComboBox.addItem("MATEMÁTICA");
        materiaComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaComboBox.addItem("ATUALIDADES");
        
        JLabel cadastrarLabel = new JLabel();
        JButton cadastrarButton = new JButton("Cadastrar");

        //Adiciona as informações no painel 3
        questaoInputPanel.add(questaoLabel);
        questaoInputPanel.add(questaoTextArea);
        questaoInputPanel.add(alternativasLabel);
        questaoInputPanel.add(new JLabel()); 
        questaoInputPanel.add(new JLabel("Escolha verdadeira: "));
        questaoInputPanel.add(alternativaATextField);
        questaoInputPanel.add(new JLabel("Escolha falsa"));
        questaoInputPanel.add(alternativaBTextField);    
        questaoInputPanel.add(materiaLabel);
        questaoInputPanel.add(materiaComboBox);
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
            	int selectedIndex = listaQuestoes.getSelectedIndex();
   	         if (selectedIndex != -1) {
   	             boolean res = d.excluirQuestaoME(selectedIndex);
   	             if (res) {
   	                 JOptionPane.showMessageDialog(null, "Edital removido com sucesso!");
                       listaQuestoes.updateUI();
   	                 	//Atualiza a lista de editais após a remoção
                       DefaultListModel<String> questoesModel = (DefaultListModel<String>) listaQuestoes.getModel();
   	                 questoesModel.remove(selectedIndex);
   	                 listaQuestoes.setModel(questoesModel); //Atualiza o modelo da lista
   	             } else {
   	                 JOptionPane.showMessageDialog(null, "Erro ao remover o edital!");
   	             }
   	         } else {
   	             JOptionPane.showMessageDialog(null, "Selecione um edital para remover!");
   	         }
   	         
            }
        });
            
        //Listeners do botão "Atualizar"
        atualizarButton.addActionListener(new ActionListener() {
            /**
             * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para atualizar a lista.
        	 * @param e
             */
        	@Override
            public void actionPerformed(ActionEvent e) {
            	listaQuestoes.addListSelectionListener(new ListSelectionListener() {
            	    public void valueChanged(ListSelectionEvent e) {
            	        if (!e.getValueIsAdjusting()) {
            	            // Obtém o índice do edital selecionado
            	            int selectedIndex = listaQuestoes.getSelectedIndex();

            	            // Verifica se um edital foi selecionado
            	            if (selectedIndex != -1) {
            	                // Obtém o edital selecionado a partir do objeto Dados
            	                QuestaoMultiplaEscolha questaoMESelecionado = d.getQuestoesMultiplaEscolha().get(selectedIndex);
            	                
            	                // Preenche os campos de texto com os dados do edital
            	                questaoTextArea.setText(questaoMESelecionado.getPerguntaQuestão());
            	                alternativaATextField.setText(questaoMESelecionado.getEscolhaVerdadeira());
            	                alternativaBTextField.setText(questaoMESelecionado.getEscolhaFalsa());
            	                materiaComboBox.setSelectedItem(questaoMESelecionado.getQuestaoMateria());

            	            }
            	        }
            	    }
            	});	 
            
           }
        });

        //Listeners do botão de buscar matéria
        buscarMateriaButton.addActionListener(new ActionListener() {
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para que o botão buscar 
        	 * matéria, busque corretamente.
        	 * @param e
        	 */
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<String> materias = d.listarMaterias();
                //Preenche o filtro com as matérias
                for (String materia : materias) {
               	 materiaFiltroComboBox.addItem(materia);
                }
                //Percorre todas as questões cadastradas
                for (int i = 0; i < questoesModel.size(); i++) {
                    String questao = questoesModel.getElementAt(i);
                    String materia = getMateriaFromQuestao(questao);
                    if (!materias.contains(materia)) {
                        materias.add(materia);
                    }
                }
                if (materias.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma matéria encontrada.");
                } else {
                	
                    // Exibe a lista de matérias no painel
                    Object[] materiasArray = materias.toArray();
                    String selectedMateria = (String) JOptionPane.showInputDialog(null, "Selecione uma matéria:",
                            "Buscar por Matéria", JOptionPane.PLAIN_MESSAGE, null, materiasArray, materiasArray[0]);
                    listaQuestoes.updateUI();
                    if (selectedMateria != null) {
                        DefaultListModel<String> filteredModel = new DefaultListModel<>();
                        ArrayList<QuestaoMultiplaEscolha> questoesFiltradas = d.buscarMateriaME(selectedMateria);
                        for (QuestaoMultiplaEscolha questaoME : questoesFiltradas) {
                        	filteredModel.addElement(questaoME.toString());

                        }
                        
                        //Filtra as questões com base na matéria selecionada
                        for (int i = 0; i < questoesModel.size(); i++) {
                            String questao = questoesModel.getElementAt(i);
                            String materia = getMateriaFromQuestao(questao);
                            if (selectedMateria.equals(materia)) {
                                filteredModel.addElement(questao);
                            }
                        }

                        // Atualiza a lista de questões com as questões filtradas
                        listaQuestoes.setModel(filteredModel);
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
            	 int selectedIndex = listaQuestoes.getSelectedIndex();
                 if (selectedIndex != -1) {
                     String selectedQuestion = (String) listaQuestoes.getModel().getElementAt(selectedIndex);
                     String questaoString = d.lerQuestaoME(selectedQuestion);
                     listaQuestoes.updateUI();
                     if (questaoString != null) {
                         JOptionPane.showMessageDialog(null, questaoString, "Questão", JOptionPane.PLAIN_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Questão não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         });
        
        //Listeners do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
        	/**
        	 * Aqui tem um sobreescrita, ou seja, implementa um 
        	 * método da interface para cadastrar uma questão.
        	 * @param e
        	 */
            @Override
            public void actionPerformed(ActionEvent e) {
                String questao = questaoTextArea.getText();
                String alternativaA = alternativaATextField.getText();
                String alternativaB = alternativaBTextField.getText();
                String materia = (String) materiaComboBox.getSelectedItem(); 
                d.cadastrarQuestaoME(materia, questao, alternativaA, alternativaB);
                String novaQuestao = "Questão: " + questao + "    ";
                questoesModel.addElement(novaQuestao);
                JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                //Limpa os campos de entrada após cadastrar a questão
                questaoTextArea.setText("");
                alternativaATextField.setText("");
                alternativaBTextField.setText("");
                
            }
        });

    }
    
    /**
     * Aqui é retornado as questões que estão no ArrayList.
     * @return
     */
    public  ArrayList<String[]> getQuestaoMultiplaEscolha() {
        ArrayList<String[]> QuestoesMultiplaEscolha = new ArrayList<>();
        ArrayList<QuestaoMultiplaEscolha> D = Dados.getTodasQuestoesMultiplaEscolha();
       
        return QuestoesMultiplaEscolha;
    }
    
    /**
     * Configuração para exibir as informações e permitir as
	 * interações com os dados com a instância da classe Dados.
     * @param args
     */
   
}
