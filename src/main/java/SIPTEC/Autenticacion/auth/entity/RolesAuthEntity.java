package SIPTEC.Autenticacion.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "ROLES")
public class RolesAuthEntity {

    @Id
    @Column(name = "idrol")
    private Long id;

    @Column(name = "nombrerol")
    private String nombreRol;
}
