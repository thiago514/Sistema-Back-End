package br.com.Attornatus.CRUDAttornatus.controller;

import br.com.Attornatus.CRUDAttornatus.dto.pessoa.PessoaDTO;
import br.com.Attornatus.CRUDAttornatus.model.endereco.Endereco;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<PessoaDTO> pessoaDTO;

    @Autowired
    private JacksonTester<List<PessoaDTO>> listpessoaDTO;

    @BeforeAll
    void cadastroBanco() throws Exception {
        var pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Pedro");
        pessoaDTO.setData_de_nascimento(Calendar.getInstance());
        var response = mvc.perform(post("/pessoa").contentType(MediaType.APPLICATION_JSON).content(
                this.pessoaDTO.write(pessoaDTO).getJson())).andReturn().getResponse();
    }

    @AfterAll
    void deletarBanco() throws Exception {
        var response = mvc.perform(delete("/pessoa/1")).andReturn().getResponse();
    }



    @Test

    @DisplayName("Deveria devolvar codigo http 400 (tentando cadastrar pessoa sem dados)")
    void cadastrar_pessoa_vazia() throws Exception {
        var response = mvc.perform(post("/pessoa")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolvar codigo http 201 (cadastrando pessoa)")
    void cadastrar_pessoa() throws Exception {
        var pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Pedro");
        pessoaDTO.setData_de_nascimento(Calendar.getInstance());
        var response = mvc.perform(post("/pessoa").contentType(MediaType.APPLICATION_JSON).content(
                this.pessoaDTO.write(pessoaDTO).getJson())).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var jsonEsperado = this.pessoaDTO.write(
                new PessoaDTO(2L, "Pedro", Calendar.getInstance(), new ArrayList<Endereco>())
        ).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

        mvc.perform(delete("/pessoa/2")).andReturn().getResponse();
    }

    @Test
    @DisplayName("Deveria devolvar codigo http 400 (procurar pessoa que não existe)")
    void procurar_pessoa_nao_existente() throws Exception {
        var response = mvc.perform(get("/pessoa/5")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Deveria devolvar codigo http 400 (Alterar pessoa que não existe)")
    void alterar_pessoa_nao_existente() throws Exception {
        var response = mvc.perform(put("/pessoa").contentType(MediaType.APPLICATION_JSON).content(
                this.pessoaDTO.write(new PessoaDTO(1L, "Pedro", Calendar.getInstance(), new ArrayList<Endereco>())).getJson()
        )).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Deveria devolver codigo http 400 (deletar pessoa não existe)")
    void deletar_pessoa_nao_existe() throws Exception{
        var response = mvc.perform(delete("/pessoa/5")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 (deletar pessoa)")
    void deletar_pessoa() throws Exception{
        var response = mvc.perform(delete("/pessoa/1")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }



}
