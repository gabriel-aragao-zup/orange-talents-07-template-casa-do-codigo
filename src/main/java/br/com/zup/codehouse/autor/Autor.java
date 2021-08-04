package br.com.zup.codehouse.autor;



import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    @Column(length = 400)
    private String descricao;
    private LocalDateTime createdAt;

    @Deprecated
    public Autor(){
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @PrePersist
    private void setCreationDateTime() {
        this.createdAt = LocalDateTime.now();
    }

    public DTOAutor toDTO(){
        return new DTOAutor(this.id, this.nome, this.descricao);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
