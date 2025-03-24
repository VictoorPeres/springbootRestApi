package br.com.avancard.cursojdevtreinamento.repository;

import br.com.avancard.cursojdevtreinamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   @Query(value = "SELECT u FROM Usuario u WHERE u.nome like %?1%")
    List<Usuario> findByName(String name);
}
