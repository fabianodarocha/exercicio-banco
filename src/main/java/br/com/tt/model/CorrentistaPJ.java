package br.com.tt.model;

public class CorrentistaPJ extends Correntista {

    private static final String TIPO_CONTA = "PJ";

    public CorrentistaPJ(String nome, Conta conta) {
        super(nome, conta);
    }

    @Override
    public String getDescricao() {

        StringBuffer descricao = new StringBuffer();

        descricao.append("Nome: ")
                .append(super.getNome())
                .append(". Tipo Conta: ")
                .append(TIPO_CONTA)
                .append(". Agencia: ")
                .append(super.getConta().getAgencia())
                .append(". Conta NUm: ")
                .append(this.getConta().getNumero());


        return descricao.toString();
    }

}
