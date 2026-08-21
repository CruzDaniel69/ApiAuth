package SIPTEC.Autenticacion.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private Long id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private Long idRol;
    private String nombreRol;
}
