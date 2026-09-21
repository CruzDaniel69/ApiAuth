package SIPTEC.Autenticacion.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "USUARIOS")
public class UsuariosAuthEntity {

    @Id
    @Column(name = "idusuario")
    private Long id;

    @Column(name = "nombreusuario")
    private String nombreUsuario;

    @Column(name = "apellidousuario")
    private String apellidoUsuario;

    @Column(name = "correousuario")
    private String correoUsuario;

    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrol", nullable = false)
    private RolesAuthEntity rol;
}
