package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.CorrentistaPF;
import br.com.tt.model.CorrentistaPJ;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaCorrentista implements Tela{

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaCorrentista(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    public void imprime() {
        usuarioUtil.exibeMensagem("Imprimi");

    }

    @Override
    public void exibeMenu() {

        usuarioUtil.exibeMensagem("Menu Correntista\n"
                .concat("Escolha uma opção: \n")
                .concat("1-Criar Correntista\n")
                .concat("2-Listar Correntistas\n")
        );

        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarCorrentista();
        } else if (opcao == 2) {
            exibeMenuListarCorrentista();
        }

    }

    private void exibeMenuCriarCorrentista() {

        usuarioUtil.exibeMensagem(" 1-PF ou 2-PJ ");
        int tipoCorrentista = Integer.parseInt(this.scanner.nextLine());

        usuarioUtil.exibeMensagem("informe o nome do Correntista: ");
        String nome = scanner.nextLine();

        usuarioUtil.exibeMensagem("Segue lista de contas disponíveis:");
        List<Conta> listaContas = this.bancoDao.listarContas();
        int posicao = 0;
        for (Conta conta : listaContas) {
            posicao++;
            usuarioUtil.exibeMensagem(posicao + "-" + conta.getDescricao());
        }

        usuarioUtil.exibeMensagem("Escolha o número da lista:");
        int posicaoEscolhida = Integer.parseInt(this.scanner.nextLine());

        if (tipoCorrentista == 1) {
            usuarioUtil.exibeMensagem("informe o tipo Documento: ");
            String tipoDocumento = scanner.nextLine();
            bancoDao.adicionarCorrentista(new CorrentistaPF(nome, listaContas.get(posicaoEscolhida - 1),tipoDocumento));
        } else if (tipoCorrentista == 2) {
            bancoDao.adicionarCorrentista(new CorrentistaPJ(nome, listaContas.get(posicaoEscolhida - 1)));
        } else {
            throw  new IllegalArgumentException("Informe um tipo válido");
        }
        usuarioUtil.exibeMensagem("Correntista cadastrado com sucesso!");
    }

    private void exibeMenuListarCorrentista() {
        List<Correntista> lista = bancoDao.listarCorrentistas();
        usuarioUtil.exibeMensagem("Lista de Correntistas: ");
        for (Correntista correntista : lista) {
            usuarioUtil.exibeMensagem(" - ".concat(correntista.getDescricao()));
            //usuarioUtil.exibeMensagem( correntista.getConta().getDescricao().concat("\n"));
        }
    }


}
