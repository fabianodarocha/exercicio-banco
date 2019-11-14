package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TelaContaComMockTest {

    @Mock
    private ScannerInterface scanner;

    @Mock
    private UsuarioUtil usuarioUtil;

    @Mock
    private BancoDao bancoDao;

    @Test
    public void exibeMenuCriarContaComSucesso() {
        //Arranje
        Mockito.doReturn("55").when(scanner).nextLine();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenuCriarConta();

        //Assert
        Mockito.verify(usuarioUtil)
                .exibeMensagem("informe a agencia da conta: ");
        Mockito.verify(usuarioUtil)
                .exibeMensagem("informe o numero da conta: ");
        Mockito.verify(usuarioUtil)
                .exibeMensagem("Adicionado com sucesso!");
        Mockito.verify(scanner, Mockito.times(2))
                .nextLine();
        Mockito.verify(bancoDao)
                .adicionarConta(new Conta(55, 55));

    }

    @Test
    public void exibeMenuListarContaComSucesso() {

        List<Conta> lista = new ArrayList<>();
        lista.add(new Conta(2,7));
        lista.add(new Conta(300,7789));

        //Arranje
        Mockito.doReturn(lista).when(bancoDao).listarContas();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil)
                .exibeMenuListarConta();

        //Assert
        Mockito.verify(bancoDao).listarContas();
        Mockito.verify(usuarioUtil)
                .exibeMensagem("Lista de contas: ");

        for (Conta conta : lista) {
            Mockito.verify(usuarioUtil).exibeMensagem(conta.getDescricao());
        }



    }



}
