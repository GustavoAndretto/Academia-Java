package com.aula.produtoh2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.produtoh2.model.Produto;
import com.aula.produtoh2.model.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;
    
    @PostMapping("/cadastrar")
    Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/alterar/{id}")
    void alterar(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> optProd = repository.findById(id);

        if(!optProd.isEmpty()) {
            Produto prod = optProd.get();
            prod.setCategoria(produto.getCategoria());
            prod.setValor(produto.getValor());
            prod.setNome(produto.getNome());
            prod.setQuantidade(produto.getQuantidade());
        }
    }

    @DeleteMapping("/excluir/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Produto> getProduto(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/todos")
    List<Produto> getProdutos() {
        return repository.findAll();
    }
}