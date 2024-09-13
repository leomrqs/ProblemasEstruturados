package gerenciadordeatendimentoaocliente;

public class Cliente {
    String idCliente;        // ID do cliente
    String nome;             // Nome do cliente
    String motivoAtendimento; // Motivo do atendimento

    public Cliente(String idCliente, String nome, String motivoAtendimento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.motivoAtendimento = motivoAtendimento;
    }

    @Override
    public String toString() {
        return "ID: " + idCliente + ", Nome: " + nome + ", Motivo: " + motivoAtendimento;
    }
} 
    
