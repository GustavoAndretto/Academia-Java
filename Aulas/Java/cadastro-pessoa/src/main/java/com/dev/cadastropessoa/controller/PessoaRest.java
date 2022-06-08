package com.dev.cadastropessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.cadastropessoa.model.Pessoa;
import com.dev.cadastropessoa.model.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaRest {
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    void create(@RequestBody Pessoa pessoa) {
        repository.save(pessoa);
    }

    @GetMapping
    List<Pessoa> read() {
        return repository.findAll();
    }

    @PutMapping
    void update(@RequestBody Pessoa pessoa) {
        if(pessoa.getId() > 0){
            repository.save(pessoa);
        }
    }

    @DeleteMapping("/delete")
    void deleteById(@RequestParam("id") Long id) {
        repository.deleteById(id);
    }
}