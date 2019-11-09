package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;

public class Conta {

    private Integer agencia;
    private Integer numero;
    private BigDecimal saldo;
    private List<Movimento> movimentos;

    public Conta (Integer agencia, Integer conta) {
        this.agencia = agencia;
        this.numero = conta;
    }


    public Integer getAgencia() {
        return this.agencia;
    }

    public Integer getNumero() {
        return  this.numero;
    }

    public String getDescricao() {

        StringBuffer descricao = new StringBuffer();

        descricao.append("Agencia: ")
                 .append(this.getAgencia())
                 .append(". Conta: ")
                 .append(this.getNumero());

        return descricao.toString();
    }


}
