package br.com.alura.resource;

import br.com.alura.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    /**
     * {
     * "nome": "Gustavo Carvalho",
     * "cpf": "123.321.456-98",
     * "username": "gusilva",
     * "password": "123456"
     * }
     */
    @POST
    @PermitAll      // Todos podem acessar
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        Usuario.add(usuario);
    }
}