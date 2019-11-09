package br.com.tt.model;

public abstract class Correntista {

    private String nome;
    private Conta conta;

    public Correntista(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {

        StringBuffer descricao = new StringBuffer();

        descricao.append("Nome: ")
                .append(this.nome)
                .append(". Agencia: ")
                .append(this.conta.getAgencia())
                .append(". Conta NUm: ")
                .append(this.conta.getNumero());

        return descricao.toString();
    }

    protected Conta getConta(){
        return this.conta;
    }


}
