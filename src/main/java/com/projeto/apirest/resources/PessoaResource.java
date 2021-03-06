package com.projeto.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.apirest.models.Pessoa;
import com.projeto.apirest.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pessoas") //nomeia a API
@CrossOrigin(origins="*") //libera todos os domínios para acesso à API
public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna todas as pessoas cadastradas")
	public List<Pessoa> listaPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoas/{doc}")
	@ApiOperation(value="Busca uma pessoa por documento")
	public Pessoa bus
	(@PathVariable(value="doc") String doc) {
		return pessoaRepository.findByDoc(doc);
	}
	
	@PostMapping("/pessoas")
	@ApiOperation(value="Cadastra uma pessoa")
	public Pessoa cadastraPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoas/{doc}")
	@ApiOperation(value="Deleta uma pessoa cadastrada")
	public void deletePessoa (@PathVariable(value="doc") String doc) {
		Pessoa pessoa;
		pessoa = pessoaRepository.findByDoc(doc);
		
		pessoaRepository.delete(pessoa);
	}
	
	/*@DeleteMapping("/pessoas")
	@ApiOperation(value="Deleta uma pessoa cadastrada")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}*/
	
	@PutMapping("/pessoas")
	@ApiOperation(value="Atualiza uma pessoa cadastrada")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
