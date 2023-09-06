package model;

public class QuestaoMultiplaEscolha extends Questao {
	private String escolhaVerdadeira;
	private String escolhaFalsa;
	
	
	
	public QuestaoMultiplaEscolha(String questaoMateria, String perguntaQuestão, String escolhaVerdadeira, String escolhaFalsa) {
		super(questaoMateria, perguntaQuestão);
		this.escolhaVerdadeira = escolhaVerdadeira;
		this.escolhaFalsa = escolhaFalsa;
	}


	

	public String getEscolhaVerdadeira() {
		return escolhaVerdadeira;
	}

	public void setEscolha(String escolhaVerdadeira) {
		this.escolhaVerdadeira = escolhaVerdadeira;
	}


	public String getEscolhaFalsa() {
		return escolhaFalsa;
	}




	public void setEscolhaFalsa(String escolhaFalsa) {
		this.escolhaFalsa = escolhaFalsa;
	}




	@Override
	public String toString() {
		return  perguntaQuestão + "\n"
	            + "Matéria: " + questaoMateria + "\n"
	            + "Opcao verdadeira: " + escolhaVerdadeira + "\n"
	            + "Opcao falsa: " + escolhaFalsa + "\n";
	}




	

	

}
