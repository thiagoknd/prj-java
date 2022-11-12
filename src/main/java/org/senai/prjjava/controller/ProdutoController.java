package org.senai.prjjava.controller;

import org.senai.prjjava.entity.Produto;
import org.senai.prjjava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/produto")
@CrossOrigin("*")
public class ProdutoController {
    
    @Autowired
    ProdutoRepository prodRepository;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produto ObjProduto){
        prodRepository.save(ObjProduto);
        return ObjProduto.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto> buscarProdutos(){
        return prodRepository.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Produto atualizarProduto(@RequestBody Produto ObjProduto){
        prodRepository.save(ObjProduto);
        return ObjProduto;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarProduto(@PathVariable Integer id){
        prodRepository.deleteById(id);
        return "produto apagado";
    }

}
