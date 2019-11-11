package br.com.tt.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveriariaRetornarDescricao() {

        Conta conta = new Conta(2, 100);

        String descricao = conta.getDescricao();

        String expected = "Agencia: 2. Conta: 100";
        Assertions.assertEquals(descricao, expected);


    }
}