package br.com.avancard.cursojdevtreinamento.controller;

import br.com.avancard.cursojdevtreinamento.model.Usuario;
import br.com.avancard.cursojdevtreinamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
