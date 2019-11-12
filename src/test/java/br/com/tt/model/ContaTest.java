package br.com.tt.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveriaRetonarDescricaoAgencia01 (){
        deveriariaRetornarDescricao(01, 8881);
    }

    @Test
    public void deveriaRetonarDescricaoAgencia0100(){
        deveriariaRetornarDescricao(01000, 83423432);
    }

    @Test
    private void deveriariaRetornarDescricao(Integer agencia, Integer numConta) {

        Conta conta = new Conta(agencia, numConta);

        String descricao = conta.getDescricao();

        String expected = "Agencia: ".concat(String.valueOf(agencia))
                                     .concat(". Conta: ")
                                     .concat(String.valueOf(numConta));
        Assertions.assertEquals(descricao, expected);

    }







}