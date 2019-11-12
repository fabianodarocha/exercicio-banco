package br.com.tt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrentistaPFTest {

    @Test
    void deveriariaRetornarDescricao() {

        CorrentistaPF correntistaPF = new CorrentistaPF("Fabiano", new Conta(2,777),"CPF");

        String retornado = correntistaPF.getDescricao();

        String esperado = "Nome: Fabiano. Tipo Conta: PF. Agencia: "
                .concat(String.valueOf(2))
                .concat(". Conta NUm: ")
                .concat(String.valueOf(777))
                .concat(". Documento: CPF");

        Assertions.assertEquals(esperado,retornado);


    }
}