package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Dados;

/**
 * Classe principal a fim de que as outras telas estejam 
 * juntas para serem selecionadas para qualquer tela, 
 * seja TelaDissertativa, TelaMultiplaEscolha e TelaEdital.
 * 
 * @author Camila
 * @author Pedro
 * @since 2023
 * @version 1.1
 */
public class TelaMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> filtroComboBox;
    private JButton filtrarButton;
    private Dados d;

    /**
     * Contrói um objeto TelaMenu 
     * @param d Banco de dados
     */
    public TelaMenu(Dados d) {
        this.d = d;

        /**
         * Configurações básicas da tela como 
         * tamanho dos Painéis e estilização dos títulos.
         */
        setTitle("Planejando Meu Futuro | PRINCIPAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());

        /*
         *PAINEL 1
         */
        //Título com fundo preto e texto branco
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(Color.BLACK);
        JLabel tituloLabel = new JLabel("ESTUDO PARA CONCURSO");
        tituloLabel.setForeground(Color.WHITE);
        tituloPanel.add(tituloLabel);
        panel.add(tituloPanel, BorderLayout.NORTH);
        JPanel filtroPanel = new JPanel();
        filtroPanel.setLayout(new FlowLayout());//FlowLayout:quebra linha quando necessário

        filtroComboBox = new JComboBox<>();
        filtroComboBox.addItem("ESCOLHA O QUE DESEJA ESTUDAR:");
        filtroComboBox.addItem("EDITAIS");
        filtroComboBox.addItem("QUESTÕES DE MULTIPLA ESCOLHA");
        filtroComboBox.addItem("QUESTÕES DISSERTATIVAS");
        filtroPanel.add(filtroComboBox);

        //Cria o botão para ir a tela escolhida 
        filtrarButton = new JButton("Vamos estudar!");
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarQuestoes();
            }
        });
        filtroPanel.add(filtrarButton);
        panel.add(filtroPanel, BorderLayout.CENTER);//Centraliza o filtro
        add(panel);//Adiciona o painel 1 à tela
        setVisible(true);// Exibe a tela
    }


    public JComboBox<String> getFiltroComboBox() {
		return filtroComboBox;
	}

	public void setFiltroComboBox(JComboBox<String> filtroComboBox) {
		this.filtroComboBox = filtroComboBox;
	}

	public JButton getFiltrarButton() {
		return filtrarButton;
	}

	public void setFiltrarButton(JButton filtrarButton) {
		this.filtrarButton = filtrarButton;
	}
	
	/**
	 * Cria e exibe a tela correspondente ao filtro selecionado
	 * @see Dados
	 */
	private void filtrarQuestoes() {
        String filtro = (String) filtroComboBox.getSelectedItem();
        if (filtro.equals("EDITAIS")) {
        	Dados dados = new Dados();
            TelaEdital telaEdital = new TelaEdital(dados);
            telaEdital.setVisible(true);
        } else if (filtro.equals("QUESTÕES DE MULTIPLA ESCOLHA")) {
        	Dados dados = new Dados();
            TelaMultiplaEscolha telaMultiplaEscolha = new TelaMultiplaEscolha(dados);
            telaMultiplaEscolha.setVisible(true);
        } else if (filtro.equals("QUESTÕES DISSERTATIVAS")) {
        	Dados dados = new Dados();
            TelaDissertativa telaDissertativa = new TelaDissertativa(dados);
            telaDissertativa.setVisible(true);
        }
    }
	
	/**
	 * Configuração para exibir as informações e permitir as
	 * interações com os dados com a instância da classe Dados.
	 * @param args
	 */
    public static void main(String[] args) {
        // Cria a tela principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Dados dados = new Dados();
                new TelaMenu(dados).setVisible(true);
            }
        });
    }
}