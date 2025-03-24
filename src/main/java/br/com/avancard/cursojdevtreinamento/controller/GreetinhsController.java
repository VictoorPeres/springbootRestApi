package br.com.avancard.cursojdevtreinamento.controller;

import br.com.avancard.cursojdevtreinamento.model.Usuario;
import br.com.avancard.cursojdevtreinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetinhsController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Curso Spring Boot API: " + name;
    }

    @RequestMapping(value = "/olamundo/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String name) {
        Usuario usuario = new Usuario();
        usuario.setNome(name);
        usuarioRepository.save(usuario);
        return "Ola Mundo, " + name;
    }

    @GetMapping(value = "/listatodos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")/*Mapeia a URL*/
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario user = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete")/*Mapeia a URL*/
    public ResponseEntity<String> deletar(@RequestParam Long id) {
        usuarioRepository.deleteById(id);
        return new ResponseEntity<String>("Exclusão realizada.",HttpStatus.OK);
    }

    @GetMapping(value = "/buscaruserid")/*Mapeia a URL*/
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Long id) {
        Usuario user = usuarioRepository.findById(id).get();
        return new ResponseEntity<Usuario>(user,HttpStatus.OK);
    }

    @PutMapping(value = "/alterar")/*Mapeia a URL*/
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        Usuario user = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(user,HttpStatus.OK);
    }

    @GetMapping(value = "/buscarpornome")/*Mapeia a URL*/
    public ResponseEntity<List<Usuario>> buscarUsuarioPorNome(@RequestParam String name) {
        List<Usuario> usuarios = usuarioRepository.findByName(name.trim());
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
}
