package SIPTEC.Autenticacion.auth.service;

import SIPTEC.Autenticacion.auth.dto.LoginRequestDTO;
import SIPTEC.Autenticacion.auth.dto.LoginResponseDTO;
import SIPTEC.Autenticacion.auth.entity.UsuariosAuthEntity;
import SIPTEC.Autenticacion.auth.repository.UsuariosAuthRepository;
import SIPTEC.Autenticacion.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuariosAuthRepository repo;
    private final PasswordUtil passwordUtil;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        Optional<UsuariosAuthEntity> usuarioOpcional = repo.findByCorreoUsuario(dto.getCorreo());

        if (usuarioOpcional.isEmpty()) {
            log.warn("Intento de login con correo no registrado: " + dto.getCorreo());
            return null;
        }

        UsuariosAuthEntity usuario = usuarioOpcional.get();

        if (!passwordUtil.coincidence(dto.getClave(), usuario.getPasswordHash())) {
            log.warn("Contraseña incorrecta para: " + dto.getCorreo());
            return null;
        }
        log.info("Login exitoso: " + dto.getCorreo());
        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getApellidoUsuario(),
                usuario.getCorreoUsuario(),
                usuario.getRol().getId(),
                usuario.getRol().getNombreRol()
        );
    }
}
