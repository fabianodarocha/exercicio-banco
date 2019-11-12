package br.com.tt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrentistaPFTest {

    @Test
    void deveriariaRetornarDescricao() {

        CorrentistaPF correntistaPF = new CorrentistaPF("Fabiano", new Conta(2,777),"CPF");

        String retornado = correntistaPF.getDescricao();

        String esperado = new StringBuffer()
                .append("Nome: ")
                .append("Fabiano")
                .append(". Tipo Conta: ")
                .append("PF")
                .append(". Agencia: ")
                .append(String.valueOf(2))
                .append(". Conta NUm: ")
                .append(String.valueOf(777))
                .append(". Documento: ")
                .append("CPF").toString();

        Assertions.assertEquals(esperado,retornado);


    }
}