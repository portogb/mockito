package mocklab2mvn.mocklab2mvn;

import java.time.LocalDate;

// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static  org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CadastrarPessoaTest {

	@Mock
	private ApiDosCorreios apiDosCorreios;
	
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void validarDadosDeCadastro() {
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ", "Rio de Janeiro", "Rua 14, nr 2", "Apt1321", "Madureira");
		
		Mockito.when(apiDosCorreios.buscaNaBaseDosCorreios("654321"))
		.thenReturn(dadosLocalizacao);
		
		Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Miguel", "123456", LocalDate.now(), "654321");
		
		//Assertions.assertEquals("Miguel", pessoa.getNome());
		assertEquals("Miguel", pessoa.getNome());
		assertEquals("123456", pessoa.getDocumento());
		assertEquals("Madureira", pessoa.getEndereco().getBairro());
	}
}
