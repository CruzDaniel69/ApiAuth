package SIPTEC.Autenticacion.auth.repository;

import SIPTEC.Autenticacion.auth.entity.UsuariosAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosAuthRepository extends JpaRepository<UsuariosAuthEntity, Long> {

    Optional<UsuariosAuthEntity> findByCorreoUsuario(String correoUsuario);

}
