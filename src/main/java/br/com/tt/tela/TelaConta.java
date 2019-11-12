package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaConta implements Tela{

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaConta(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    @Override
    public void exibeMenu() {

        usuarioUtil.exibeMensagem("Menu Conta\n"
                .concat("Escolha uma opção: \n")
                .concat("1-Criar Conta\n")
                .concat("2-Listar Conta\n")
        );

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarConta();
        } else if (opcao == 2) {
            exibeMenuListarConta();
        }
    }

    public void exibeMenuCriarConta() {
        usuarioUtil.exibeMensagem("informe a agencia da conta: ");
        int agencia = Integer.parseInt(this.scanner.nextLine());
        usuarioUtil.exibeMensagem("Agência cadastrada com sucesso!");

        usuarioUtil.exibeMensagem("informe o numero da conta: ");
        int contaNumero = Integer.parseInt(this.scanner.nextLine());
        usuarioUtil.exibeMensagem("Numero de Conta cadastrada com sucesso!");


        bancoDao.adicionarConta(new Conta(agencia, contaNumero));
        usuarioUtil.exibeMensagem("Adicionado com sucesso!");

    }

    public void exibeMenuListarConta() {
        List<Conta> lista = bancoDao.listarContas();
        usuarioUtil.exibeMensagem("Lista de contas: ");

        for (Conta conta : lista) {
            usuarioUtil.exibeMensagem(conta.getDescricao());
        }

    }


}
