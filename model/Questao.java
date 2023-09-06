package model;

public abstract class Questao {
	protected String questaoMateria;
	protected String perguntaQuestão;
	
	
	
	
    public Questao(String questaoMateria, String perguntaQuestão) {
		super();
		this.questaoMateria = questaoMateria;
		this.perguntaQuestão = perguntaQuestão;
		
	}


	//metodos
	

	
	


	public String getQuestaoMateria() {
		return questaoMateria;
	}


	public void setQuestaoMateria(String questaoMateria) {
		this.questaoMateria = questaoMateria;
	}


	public String getPerguntaQuestão() {
		return perguntaQuestão;
	}


	public void setPerguntaQuestão(String perguntaQuestão) {
		this.perguntaQuestão = perguntaQuestão;
	}


	


	@Override
	public String toString() {
		return "Questao [questaoMateria=" + questaoMateria + ", perguntaQuestão=" + perguntaQuestão
				+ "]";
	}

	
	
	
}
