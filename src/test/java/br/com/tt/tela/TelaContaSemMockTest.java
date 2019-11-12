package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.dubles.ScannerDuble;
import br.com.tt.dubles.UsuarioUtilDuble;
import br.com.tt.model.Conta;
import br.com.tt.util.MasterUsuarioUtil;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelaContaSemMockTest {

    private static BancoDao bancoDao;
    private static ScannerInterface scanner;
    private static UsuarioUtil usuarioUtil;

    @Test
    void exibeMenuCriarConta() {

        bancoDao = new BancoDao();
        scanner = new ScannerDuble();
        usuarioUtil = new UsuarioUtilDuble();
        TelaConta tela = new TelaConta(bancoDao,scanner,usuarioUtil);

        tela.exibeMenuCriarConta();

        Conta conta =  bancoDao.buscarContaPor(10,10);

        Assertions.assertEquals(conta,new Conta(10,10));

    }
}