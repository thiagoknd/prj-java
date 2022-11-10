package org.senai.prjjava.controller;

import java.util.Optional;

import org.senai.prjjava.entity.Usuario;
import org.senai.prjjava.repository.UsuarioRepository;
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



// http://localhost:8080/api/usuario/add?nome=thiago&email=thiago@hotmail.com
@Controller
@RequestMapping(path = "/api/usuario")
@CrossOrigin("*")
public class UsuarioController {


    @Autowired
    UsuarioRepository uRepository;

    @PostMapping("/")
    public @ResponseBody Integer addUsuario(@RequestBody Usuario objU){
        uRepository.save(objU);
        return objU.getId();
    }
    /*public @ResponseBody String addUsuario(@RequestParam String nome,@RequestParam String email){

        Usuario objU = new Usuario();
        objU.setNome(nome);
        objU.setEmail(email);
        uRepository.save(objU);
        return "Salvo";
    }*/

    @GetMapping("/")
    public @ResponseBody Iterable<Usuario> buscarUsuarios(){
        return uRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Usuario> buscarUsuario(@PathVariable Integer id){
        return uRepository.findById(id);
    } 

    @PutMapping("/")
    public  @ResponseBody Usuario atualizar(@RequestBody Usuario objU){
        uRepository.save(objU);
        return objU;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id){
        uRepository.deleteById(id);
        return "Usuario apagado";
    }
}
