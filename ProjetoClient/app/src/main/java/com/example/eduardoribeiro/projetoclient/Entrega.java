package com.example.eduardoribeiro.projetoclient;

/**
 * Created by Eduardo Ribeiro on 29/06/2016.
 */
public class Entrega {
    private int id;
    private String endereco;
    private String descricao;
    private int entregador_id;
    private String status;

    public Entrega() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEntregador_id() {
        return entregador_id;
    }

    public void setEntregador_id(int entregador_id) {
        this.entregador_id = entregador_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", endereco='" + endereco+ '\'' +
                ", descricao='" + descricao+ '\'' +
                ", entregador_id='"+ entregador_id+ '\''+
                ", status='"+ status+ '\''+
                '}';
    }
}
