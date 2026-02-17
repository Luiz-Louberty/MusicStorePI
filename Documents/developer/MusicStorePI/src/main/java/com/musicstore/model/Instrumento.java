package com.musicstore.model;

import jakarta.persistence.*;

/**
 * Classe Instrumento mapeada como uma Entidade JPA.
 * Ajustada para evitar erros de escala em tipos de ponto flutuante.
 */
@Entity
@Table(name = "instrumento")
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String marca;

    @Column(length = 50)
    private String categoria;

    // Removido precision e scale para evitar erro de mapeamento SQL
    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int quantidade;

    // Construtor padrão obrigatório pelo JPA
    public Instrumento() {
    }

    // Construtor completo
    public Instrumento(int id, String nome, String marca, String categoria, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}