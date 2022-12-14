package mocklab2mvn.mocklab2mvn;

import java.time.LocalDate;

public class CadastrarPessoa { 
	
	private ApiDosCorreios apiDosCorreios;
	
	public CadastrarPessoa(final ApiDosCorreios apiDosCorreios) {
		this.apiDosCorreios = apiDosCorreios;
	}
	
	public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
		Pessoa pessoa = new Pessoa(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaNaBaseDosCorreios(cep);
		pessoa.adicionaDadosEndereco(dadosLocalizacao);
		return pessoa;
	}
}
