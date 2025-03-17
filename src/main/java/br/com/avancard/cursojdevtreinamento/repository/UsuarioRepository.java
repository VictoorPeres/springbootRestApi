package br.com.avancard.cursojdevtreinamento.repository;

import br.com.avancard.cursojdevtreinamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
