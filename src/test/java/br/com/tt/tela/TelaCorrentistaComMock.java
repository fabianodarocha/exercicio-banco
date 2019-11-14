package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
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
public class TelaCorrentistaComMock {

    @Mock
    private ScannerInterface scanner;

    @Mock
    private UsuarioUtil usuarioUtil;

    @Mock
    private BancoDao bancoDao;

    @Test
    public void exibeMenuListarCorrentistaComSucesso() {

        List<Correntista> lista = new ArrayList<>();
        lista.add(new Correntista("Fabiano", new Conta(2,777)));

        //Arranje
        Mockito.doReturn("2").when(scanner).nextLine();
        Mockito.doReturn(lista).when(bancoDao).listarCorrentistas();

        //Act
        new TelaCorrentista(bancoDao, scanner, usuarioUtil).exibeMenu();

        //Assert
        Mockito.verify(usuarioUtil)
                .exibeMensagem("Menu Correntista\n"
                        .concat("Escolha uma opção: \n")
                        .concat("1-Criar Correntista\n")
                        .concat("2-Listar Correntistas\n"));

        Mockito.verify(scanner).nextLine();
        Mockito.verify(bancoDao).listarCorrentistas();
        Mockito.verify(usuarioUtil).exibeMensagem("Lista de Correntistas: ");

        for (Correntista correntista : lista) {
            Mockito.verify(usuarioUtil).exibeMensagem(" - ".concat(correntista.getDescricao()));
        }

    }


}
