package com.musicstore.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    @Column(name = "metodo_pagamento", length = 50)
    private String metodoPagamento;

    // Este campo cria a coluna cliente_id no banco e permite o preenchimento automático
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Venda() {
        this.data = new Date();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}