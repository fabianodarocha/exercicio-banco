package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(agencia, conta.agencia) &&
                Objects.equals(numero, conta.numero) &&
                Objects.equals(saldo, conta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
