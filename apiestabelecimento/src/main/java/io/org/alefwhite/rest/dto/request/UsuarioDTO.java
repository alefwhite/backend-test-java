package io.org.alefwhite.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "Campo nome é obrigatório!")
    @Column(name = "nome", length = 100)
    private String nome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    private String email;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @Column(name = "senha", length = 100)
    private String senha;

    @NotNull(message = "Campo admin é obrigatório!")
    private Boolean admin;

    @NotNull(message = "Campo empresa é obrigatório!")
    private Integer empresa_id;

}
