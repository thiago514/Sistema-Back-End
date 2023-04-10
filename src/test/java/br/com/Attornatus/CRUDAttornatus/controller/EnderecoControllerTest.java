package br.com.Attornatus.CRUDAttornatus.controller;

import br.com.Attornatus.CRUDAttornatus.dto.endereco.EnderecoDTO;
import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<EnderecoDTO> enderecoDTO;

    @Autowired
    private JacksonTester<List<EnderecoDTO>> listEnderecoDTO;

    @Autowired
    private JacksonTester<PessoaDTO> pessoaDTO;

    @Autowired
    private JacksonTester<List<PessoaDTO>> listpessoaDTO;
    @BeforeAll
    void cadastroBanco() throws Exception {
        var pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Pedro");
        pessoaDTO.setData_de_nascimento(Calendar.getInstance());
        mvc.perform(post("/pessoa").contentType(MediaType.APPLICATION_JSON).content(this.pessoaDTO.write(pessoaDTO).getJson())).andReturn().getResponse();
        var endereco = new EnderecoDTO();
        endereco.setLogradouro("rua");
        endereco.setCep("00000-000");
        endereco.setPrincipal(true);
        endereco.setNumero(1444);
        endereco.setCidade("Canoinhas");
        endereco.setPessoa_id(1L);
        mvc.perform(post("/endereco").contentType(MediaType.APPLICATION_JSON).content(this.enderecoDTO.write(endereco).getJson()));
    }

    @AfterAll
    void deletarBanco() throws Exception {
        var response = mvc.perform(delete("/endereco/1")).andReturn().getResponse();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 (pessoa já tem endereco principal")
    void cadastro_endereco_principal() throws Exception {
        var enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro("rua");
        enderecoDTO.setCep("00000-000");
        enderecoDTO.setPrincipal(true);
        enderecoDTO.setNumero(1444);
        enderecoDTO.setCidade("Canoinhas");
        enderecoDTO.setPessoa_id(1L);
        var response = mvc.perform(post("/endereco").contentType(MediaType.APPLICATION_JSON).content(this.enderecoDTO.write(enderecoDTO).getJson())).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 (Altaração de endereco)")
    void alterar_endereco() throws Exception {
        var enderecoDTO = new EnderecoDTO();
        enderecoDTO.setEndereco_id(1L);
        enderecoDTO.setLogradouro("casa");
        enderecoDTO.setCep("00000-000");
        enderecoDTO.setPrincipal(false);
        enderecoDTO.setNumero(1444);
        enderecoDTO.setCidade("Canoinhas");
        enderecoDTO.setPessoa_id(1L);
        var response = mvc.perform(put("/endereco").contentType(MediaType.APPLICATION_JSON).content(this.enderecoDTO.write(enderecoDTO).getJson())).andReturn().getResponse();
        assertThat(response.getContentAsString()).isEqualTo(this.enderecoDTO.write(enderecoDTO).getJson());
    }
    
    @Test
    @DisplayName("Deveria devolver codigo http 200 (deletar endereco)")
    void deletar_endereco() throws Exception {
        var response = mvc.perform(delete("/endereco/1")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
