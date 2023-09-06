package model;



public class Main {
	static Edital e;
	static Questao q;
	static QuestaoMultiplaEscolha qm;
	static QuestaoDissertativa qd;
	
	

	
	
	public static void main(String[] args) {
		e = new Edital("Banco do Brasil", "chegar no horario e levar caneta preta", "100.00" , 
				"20/07/2023", "20/06/2023");
		
		
		qm = new QuestaoMultiplaEscolha("Questao 1", "Qual a primeira letra do albafeto?", "A" , "B");
		qd = new QuestaoDissertativa("Questao 2", "Escreva sobre um dos Romantisas do seculo XIX", "Minha Redacao");
		
		
		System.out.println(e.toString());
		System.out.println(qm.toString());
		System.out.println(qd.toString());
		
	
	}

}
