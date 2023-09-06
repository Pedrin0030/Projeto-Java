package model;

import java.util.ArrayList;

/**
 * Classe que simula um banco de dados e faz o gerenciamento deles.
 * 
 * @author Pedro
 * @author Camila
 * @since 2023
 * @version 1.1
 *
 */
public class Dados {
	private ArrayList<Edital> editais = new ArrayList<>();
	private ArrayList<QuestaoDissertativa> questoesDissertativa = new ArrayList<>();
	private ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();

	/**
	 * Contém um objeto Dados
	 */
	public Dados() {
		editais.add(new Edital("Bambco do Brasil" , "chegar no horario e levar caneta preta", "100","30/09/2023" ,
				"30/10/2023"));
		editais.add(new Edital("Departamento Estadual de Trânsito","chegar no horario e levar caneta preta", "100.00", "05/05/2023",
				"05/09/2023" ));
		editais.add(new Edital("Caixa Econômica Federal", "chegar no horario e levar caneta preta", "100.0" , "05/08/2023" ,
				"09/10/2023"));
		editais.add(new Edital("Polícia Rodoviária Federal", "nao levar lapiz. borracha, celular", "120.00" , 
				"30/09/2023" , "30/10/2023" ));
		editais.add(new Edital("Departamento de Trânsito", "o candidato devara fazer pelo menos 50% da prova", 
				"150.00" , "05/08/2023", "07/012/2023"));
		editais.add(new Edital("Receita Federal", "levar caneta preta e lanche em algo transparente",
				"90.00" , "18/11/2023", "05/01/2024"));
		
		editais.add(new Edital("Polícia Federal", "chegar no horario e levar caneta preta", "160.00" , 
				"07/12/2023", "05/02/2024"));
		editais.add(new Edital("Câmaras dos Deputados", "chegar 30 minutos antes do horario final", "120.00" ,
				"22/08/2023", "25/09/2023"));
		editais.add(new Edital("Tribunal de Contas da União" , "chegar no horario e levar caneta preta", "160.00" , 
				"22/08/2023", "05/02/2024"));
		
	
		
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("PORTUGUÊS", "Qual a primeira letra do alfabeto?",  
	    		"A primeira letra do Alfabeto é A", "A primeira letra do alfabeto é B"));
		
	   
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("MATEMÁTICA", "Quanto é 2+2x4?", "O valor é 10", "O valor é 16"));
	    
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("ATUALIDADES", "Qual cantor(a) brasileiro(a) que chegou no top 1 com a musica envolve?", 
	    		"Anita", "Neymar"));
	    
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("DIREITO CONSTITUCIONAL", "(CONSULPLAN - 2017 - Prefeitura de Sabará/MG - Advogado) - Constitui um dos objetivos da"
	    		+ " República Federativa do Brasil:" , "Garantia do desenvolvimento nacional" , "Independência nacional"));
	    
	    
	    questoesDissertativa.add(new QuestaoDissertativa("PORTUGUÊS", "A língua pode assumir modalidades variadas em sua forma de apresentação. De acordo com conhecimentos\r\n"
	    		+ "adquiridos acerca da língua ao longo do ensino médio, estabeleça uma relação entre a língua portuguesa em sua\r\n"
	    		+ "modalidade escrita formal e as características da variação linguística presente nas mais variadas situações de\r\n"
	    		+ "comunicação. ", 
	    		" As diferenças ocorrem entre a modalidade escrita formal e a fala. A escrita não é a simples transcrição da\r\n"
	  	    			+ "fala. Podemos sintetizar as diferenças que se estabelecem. Como características da fala podemos citar: espontânea,\r\n"
	    				+ "passageira, grande apoio contextual, face a face, repetições, redundâncias, truncamentos e desvios. Já na escrita,\r\n"
	    				+ "podemos citar como características: monitorada, duradoura, ausência de apoio contextual, interlocutor distante,\r\n"
	    				+ "controle de sintaxe, das repetições, da redundância. As variações linguísticas envolvem diversos aspectos históricos,\r\n"
	    				+ "sociais, culturais, geográficos, dentre outros."));
	    
		questoesDissertativa.add(new QuestaoDissertativa("DIREITO CONSTITUCIONAL", "Defina direito fundamental.", 
				        " O conjunto institucionalizado de direitos e garantias do ser humano que tem por finalidade básica o respeito,\n "
				        + "a sua dignidade, por meio de sua proteção contra o arbítrio do poder estatal e o estabelecimento de condições mínimas,\n "
				        + "de vida e desenvolvimento da personalidade humana."));
		
		questoesDissertativa.add(new QuestaoDissertativa("MATÉMATICA", "Quatro médicos –– Amélia, Joaquim, Marcela e Paulo –– estão escalados para os próximos quatro plantões em um\r\n"
				+ "hospital, não necessariamente nessa ordem. O diretor do hospital fez três afirmações; analise-as.\r\n"
				+ "I. Joaquim e Marcela farão plantões consecutivos.\r\n"
				+ "II. Joaquim não será o terceiro a realizar o plantão.\r\n"
				+ "III. O plantão de Amélia será entre os plantões de Joaquim e Marcela.\r\n"
				+ "Entretanto, constatou-se que todas as afirmações do diretor são falsas. Diante do exposto, qual médico irá fazer o\r\n"
				+ "segundo e o quarto plantão? Justifique sua resposta." ,
				"Paulo irá fazer o segundo plantão. Amélia irá fazer o quarto plantão.\r\n"
				+ "Como as afirmações do diretor são falsas conclui-se que Joaquim e Marcela não farão plantões consecutivos, Joaquim\r\n"
				+ "será o terceiro plantonista e que o plantão de Amélia não será entre os plantões de Joaquim e Marcela. Se Joaquim é\r\n"
				+ "o terceiro plantonista e não fará plantão consecutivo com Marcela, então, Marcela será a primeira médica de\r\n"
				+ "plantão. O plantão de Amélia não será entre os plantões de Joaquim e Marcela; portanto, ela será a quarta médica de\r\n"
				+ "plantão. Dessa forma, Paulo será o médico que realizará o segundo plantão."));
		
		 questoesDissertativa.add(new QuestaoDissertativa("ATUALIDADES", 
				   "Com base na seguinte afirmação: \"As mudanças climáticas são uma preocupação global\", desenvolva uma redação de até 10 linhas discutindo a importância da ação coletiva \n"
				   + " na redução das emissões de gases de efeito estufa e na promoção de práticas sustentáveis para enfrentar o desafio das mudanças climáticas. \n",
				   "As mudanças climáticas são um tema de extrema relevância na sociedade atual. Essas transformações no clima do nosso planeta têm impactos \n"
				   + "significativos em diversos aspectos da vida humana e do meio ambiente. "
				   + "É fundamental compreendermos a gravidade dessas mudanças e agirmos de forma proativa para mitigar seus efeitos.\r\n"
				   + "\n"
				   + "O aumento das temperaturas, o derretimento das calotas polares, a intensificação de eventos climáticos extremos e a elevação do nível do mar são apenas alguns exemplos dos \n"
				   + "fenômenos decorrentes das mudanças climáticas. Essas alterações afetam diretamente a biodiversidade, a disponibilidade de recursos naturais, a segurança alimentar e o \n"
				   + "equilíbrio dos ecossistemas. \n"
				   +"\n"
				   + "Em suma, as mudanças climáticas representam um dos maiores desafios da atualidade. Precisamos agir com urgência e determinação para proteger nosso planeta e assegurar um \n"
				   + "futuro sustentável para as próximas gerações. A conscientização, a educação ambiental e a implementação de políticas e práticas sustentáveis são caminhos fundamentais \n "
				   + "para enfrentarmos essa crise climática de forma efetiva."));
	    
	  
	}		
		
		
	
	
	
	
	
	
	public ArrayList<Edital> getEditais() {
		return editais;
	}


	public void setEditais(ArrayList<Edital> editais) {
		this.editais = editais;
	}


	public ArrayList<QuestaoDissertativa> getQuestoesDissertativa() {
		return questoesDissertativa;
	}

	public void setQuestoesDissertativa(ArrayList<QuestaoDissertativa> questoesDissertativa) {
		this.questoesDissertativa = questoesDissertativa;
	}

	public ArrayList<QuestaoMultiplaEscolha> getQuestoesMultiplaEscolha() {
		return questoesMultiplaEscolha;
	}


	public void setQuestoesMultiplaEscolha(ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha) {
		this.questoesMultiplaEscolha = questoesMultiplaEscolha;
	}


	




	/**
	 * Aqui é retornado uma lista de editais.
	 * @return
	 */
	public static ArrayList<Edital> getTodosEditais() {
		ArrayList<Edital> todosEditais = new ArrayList<> ();
		return todosEditais;
	}
	
	/**
	 * Aqui é retornado uma lista de questões dissertativas.
	 * @return
	 */
	public static ArrayList<QuestaoDissertativa> getTodasQuestoesDissertativas(){
		ArrayList<QuestaoDissertativa> todasQuestoesDissertativas = new ArrayList<QuestaoDissertativa>();
		return todasQuestoesDissertativas;
	}
	
	/**
	 * Aqui retorna uma lista de questões de multipla escolha.
	 * @return
	 */
	public static ArrayList<QuestaoMultiplaEscolha> getTodasQuestoesMultiplaEscolha(){
		ArrayList<QuestaoMultiplaEscolha> todasQuestoesMultiplaEscolha = new ArrayList<QuestaoMultiplaEscolha>();
		return todasQuestoesMultiplaEscolha;
	}

	
	
	
	/**
	 * Aqui pesquisa por data para saber se está atual ou não.
	 * 
	 * @param dataDigitada
	 * @return
	 */
	public Edital pesquisarPorData(String dataDigitada) {
		for (Edital edital : editais) {
			
			if(dataDigitada.equals(edital.getDataFechamento())) {
				return edital;
			}				
		}
		return null;
	}	
	
	/**
	 * Cria um edital com seus atributos específicos.
	 * 
	 * @param nomeConcurso
	 * @param regras
	 * @param taxaInscricao
	 * @param dataConcurso
	 * @param dataFechamento
	 */
	public  void criarEdital(String nomeConcurso, String regras, String taxaInscricao, String dataConcurso,
			String dataFechamento){
			editais.add(new Edital(nomeConcurso, regras, taxaInscricao ,dataConcurso, dataFechamento));	
	 }
	
	/**
	 * Aqui é a lógica para exluir um edital.
	 * 
	 * @param indice
	 * @return
	 */
	public boolean excluirEdital(int indice) {
	    ArrayList<Edital> editais = getEditais();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < editais.size()) {
	        editais.remove(indice);
	        
	        return true; // Exclusão bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível excluir o edital
	    }
	}

	/**
	 * Aqui é lógica para ler um edital
	 * 
	 * @param selectedEdital
	 * @return
	 */
	public Edital leituraEdital(String selectedEdital) {
		for (Edital edital: editais) {
			if(selectedEdital.contains(edital.getNomeConcurso())) {
				return edital;
			}
		}
		return null;
	}
	
	/**
	 * Aqui é a lógica para atualizar um edital
	 * 
	 * @param indice
	 * @param editalAtualizado
	 * @return
	 */
	public boolean atualizarEdital(int indice, Edital editalAtualizado) {
	    ArrayList<Edital> editais = getEditais();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < editais.size()) {
	        // Atualiza o edital no índice especificado
	        editais.set(indice, editalAtualizado);

	        return true; // Atualização bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível atualizar o edital
	    }
	}


    /**
     * Aqui é a lógica para excluir uma questão multipla escolha.
     * 
     * @param indice
     * @return
     */
	public boolean excluirQuestaoME(int indice) {
	    ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = getQuestoesMultiplaEscolha();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < questoesMultiplaEscolha.size()) {
	        questoesMultiplaEscolha.remove(indice);
	        return true; // Exclusão bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível excluir o edital
	    }
	}
	
	/**
	 * Lógica para atualizar uma questão multipla escolha.
	 * 
	 * @param indice
	 * @param questaoMEAtualizado
	 * @return
	 */
	public boolean atualizarQuestaoME(int indice, QuestaoMultiplaEscolha questaoMEAtualizado) {
		 ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = getQuestoesMultiplaEscolha();

		    // Verifica se o índice está dentro dos limites do ArrayList
		    if (indice >= 0 && indice < questoesMultiplaEscolha.size()) {
		        // Atualiza a questão no índice especificado
		        questoesMultiplaEscolha.set(indice, questaoMEAtualizado);

		        return true; // Atualização bem-sucedida
		    } else {
		        return false; // Índice inválido, não é possível atualizar a questão
		    }
		}
	
	
	/**
	 * Lógica para ler uma questão multipla escolha.
	 * 
	 * @param selectedQuestaoMultiplaEscolha
	 * @return
	 */
	public String lerQuestaoME(String selectedQuestaoMultiplaEscolha) {
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        if (selectedQuestaoMultiplaEscolha.contains(questaoME.getPerguntaQuestão())) {
	            return questaoME.toString();
	        }
	    }
	    return null;
	}
	
	/**
	 * Lógica para cadastrar uma questão multipla escolha.
	 * 
	 * @param questaoMateria
	 * @param perguntaQuestao
	 * @param escolhaVerdadeira
	 * @param escolhaFalsa
	 */
	public  void cadastrarQuestaoME(String questaoMateria, String perguntaQuestao, String escolhaVerdadeira, String escolhaFalsa){
			questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha(questaoMateria, perguntaQuestao, escolhaVerdadeira , escolhaFalsa));	
	  
	 }

	/**
	 * Lógica para listagem de uma questão multipla escolha por uma determinada materia.
	 * 
	 * @return
	 */
	public ArrayList<String> listarMaterias() {
	    ArrayList<String> materias = new ArrayList<>();
	    
	    // Percorre todas as questões cadastradas
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        String materia = questaoME.getQuestaoMateria();
	        if (!materias.contains(materia)) {
	            materias.add(materia);
	        }
	    }
	    
	    return materias;
	}
	
	/**
	 * Lógica para buscar uma questão multipla escolha de uma determinada matéria.
	 * 
	 * @param selectedMateria
	 * @return
	 */
	public ArrayList<QuestaoMultiplaEscolha> buscarMateriaME(String selectedMateria) {
	    ArrayList<QuestaoMultiplaEscolha> questoesFiltradas = new ArrayList<>();
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        if (selectedMateria.equals(questaoME.getQuestaoMateria())) {
	            questoesFiltradas.add(questaoME);
	        }
	    }
	    return questoesFiltradas;
	}
	
	
	

	public boolean excluirQuestaoD(int indice) {
	    ArrayList<QuestaoDissertativa> questoesDissertativa = getQuestoesDissertativa();
	
	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < questoesDissertativa.size()) {
	        questoesDissertativa.remove(indice);
	        return true; // Exclusão bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível excluir o edital
	    }
	}
	
	public boolean atualizarQuestaoD(int indice, QuestaoDissertativa questaoDAtualizado) {
		 ArrayList<QuestaoDissertativa> questoesDissertativa = getQuestoesDissertativa();
	
		    // Verifica se o índice está dentro dos limites do ArrayList
		    if (indice >= 0 && indice < questoesDissertativa.size()) {
		        // Atualiza a questão no índice especificado
		        questoesDissertativa.set(indice, questaoDAtualizado);
	
		        return true; // Atualização bem-sucedida
		    } else {
		        return false; // Índice inválido, não é possível atualizar a questão
		    }
		}
	
	
	public ArrayList<String> listarMateriasD() {
	    ArrayList<String> materias = new ArrayList<>();
	    
	    // Percorre todas as questões cadastradas
	    for (QuestaoDissertativa questaoD : questoesDissertativa) {
	        String materia = questaoD.getQuestaoMateria();
	        if (!materias.contains(materia)) {
	            materias.add(materia);
	        }
	    }
	    
	    return materias;
	}
	
	
	public ArrayList<QuestaoDissertativa> buscarMateriaD(String selectedMateria) {
	    ArrayList<QuestaoDissertativa> questoesFiltradas = new ArrayList<>();
	    for (QuestaoDissertativa questaoD : questoesDissertativa) {
	        if (selectedMateria.equals(questaoD.getQuestaoMateria())) {
	            questoesFiltradas.add(questaoD);
	        }
	    }
	    return questoesFiltradas;
	}
	
	
	
	public String lerQuestaoD(String selectedQuestaoDissertativa) {
	    for (QuestaoDissertativa questaoD : questoesDissertativa) {
	        if (selectedQuestaoDissertativa.contains(questaoD.getPerguntaQuestão())) {
	            return questaoD.toString();
	        }
	    }
	    return null;
	}
	
	public  void cadastrarQuestaoD(String questaoMateria, String perguntaQuestao, String redacao){
			questoesDissertativa.add(new QuestaoDissertativa(questaoMateria, perguntaQuestao, redacao));	
	  
	 }
	
	

	
	
	
	}