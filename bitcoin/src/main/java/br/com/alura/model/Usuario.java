package br.com.alura.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@UserDefinition // Modelo utilizado para autenticar
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    /**
     * Verifica Username, Senha e Role na autenticação
     * As 3 devem ser String
     */
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static void add(Usuario usuario) {
        usuario.password = BcryptUtil.bcryptHash(usuario.getPassword());
        usuario.role = validarUsername(usuario.getUsername());
        usuario.persist();
    }

    private static String validarUsername(String username) {
        return username.equals("gustavo") ? "admin" : "user";
    }
}