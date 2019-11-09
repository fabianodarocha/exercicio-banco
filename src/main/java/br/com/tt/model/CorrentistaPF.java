package br.com.tt.model;

public class CorrentistaPF extends Correntista{

    private String tipoDocumento;
    private static final String TIPO_CONTA = "PF";

    public CorrentistaPF(String nome, Conta conta, String tipoDocumento) {
        super(nome, conta);
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public String gettipoDocumento() {
        return tipoDocumento;
    }

    @Override
    public String getDescricao() {

        StringBuffer descricao = new StringBuffer();

        descricao.append("Nome: ")
                .append(this.getNome())
                .append(". Tipo Conta: ")
                .append(TIPO_CONTA)
                .append(". Agencia: ")
                .append(this.getConta().getAgencia())
                .append(". Conta NUm: ")
                .append(this.getConta().getNumero())
                .append(". Documento: ")
                .append(this.getTipoDocumento());


        return descricao.toString();
    }


}
