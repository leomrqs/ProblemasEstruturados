package gerenciadordeatendimentoaocliente;

class Solicitacao {
    String idSolicitacao;    // ID da solicitação
    String descricao;        // Descrição da solicitação
    String dataHora;         // Data e hora da solicitação

    public Solicitacao(String idSolicitacao, String descricao, String dataHora) {
        this.idSolicitacao = idSolicitacao;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "ID: " + idSolicitacao + ", Descrição: " + descricao + ", Data e Hora: " + dataHora;
    }
}
