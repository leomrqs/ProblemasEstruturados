package gerenciadordeatendimentoaocliente;

import java.util.Scanner;

public class SistemaAtendimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha historicoSolicitacoes = new Pilha();
        Fila filaAtendimento = new Fila();

        // Inicializando a fila de atendimento com os dados fornecidos
        Cliente[] clientes = {
            new Cliente("CLI001", "Maria Silva", "Dúvida sobre produto"),
            new Cliente("CLI002", "João Souza", "Reclamação de serviço"),
            new Cliente("CLI003", "Ana Costa", "Solicitação de reembolso"),
            new Cliente("CLI004", "Pedro Alves", "Informações de entrega"),
            new Cliente("CLI005", "Carla Dias", "Agendamento de visita"),
            new Cliente("CLI006", "Lucas Martins", "Alteração de pedido"),
            new Cliente("CLI007", "Patrícia Rocha", "Cancelamento de contrato"),
            new Cliente("CLI008", "Rafael Lima", "Renovação de assinatura"),
            new Cliente("CLI009", "Fernanda Gomes", "Suporte para instalação"),
            new Cliente("CLI010", "Carlos Eduardo", "Pedido de orçamento")
        };

        for (Cliente cliente : clientes) {
            filaAtendimento.adicionarClienteNaFila(cliente); 
        }

        // Inicializando o histórico de solicitações com os dados fornecidos
        Solicitacao[] historico = {
            new Solicitacao("REQ001", "Instalação de software", "2024-08-20 10:30"),
            new Solicitacao("REQ002", "Manutenção preventiva", "2024-08-20 11:00"),
            new Solicitacao("REQ003", "Atualização de sistema", "2024-08-20 11:30"),
            new Solicitacao("REQ004", "Suporte técnico", "2024-08-20 12:00"),
            new Solicitacao("REQ005", "Troca de equipamento", "2024-08-20 12:30"),
            new Solicitacao("REQ006", "Consulta de garantia", "2024-08-20 13:00"),
            new Solicitacao("REQ007", "Reparo de impressora", "2024-08-20 13:30"),
            new Solicitacao("REQ008", "Configuração de rede", "2024-08-20 14:00"),
            new Solicitacao("REQ009", "Restauração de dados", "2024-08-20 14:30"),
            new Solicitacao("REQ010", "Consulta técnica", "2024-08-20 15:00")
        };

        for (Solicitacao solicitacao : historico) {
            historicoSolicitacoes.push(solicitacao);
        }

        int opcao;
        do {
            System.out.println("Sistema de Gerenciamento de Atendimento ao Cliente");
            System.out.println("1. Registrar nova solicitação no histórico");  
            System.out.println("2. Remover a última solicitação do histórico");  
            System.out.println("3. Exibir histórico de solicitações");
            System.out.println("4. Registrar novo cliente na fila de atendimento");  
            System.out.println("5. Atender próximo cliente");
            System.out.println("6. Exibir fila de atendimento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    // Adicionar solicitação ao histórico
                    System.out.print("Digite o ID da solicitação: ");
                    String idSolicitacao = scanner.nextLine();
                    System.out.print("Digite a descrição da solicitação: ");
                    String descricaoSolicitacao = scanner.nextLine();
                    System.out.print("Digite a data e hora da solicitação (formato: dd/MM/yyyy HH:mm:ss): ");
                    String dataHoraSolicitacao = scanner.nextLine();
                    historicoSolicitacoes.push(new Solicitacao(idSolicitacao, descricaoSolicitacao, dataHoraSolicitacao));
                    System.out.println("Solicitação adicionada ao histórico.");
                    break;

                case 2:
                    // Remover solicitação do histórico
                    Solicitacao solicitacaoRemovida = historicoSolicitacoes.pop();
                    if (solicitacaoRemovida != null) {
                        System.out.println("Solicitação removida: " + solicitacaoRemovida);
                    } else {
                        System.out.println("Histórico vazio!");
                    }
                    break;

                case 3:
                    // Exibir histórico de solicitações
                    System.out.println("Histórico de solicitações:");
                    historicoSolicitacoes.mostrarHistorico();
                    break;

                case 4:
                    // Adicionar cliente à fila de atendimento
                    System.out.print("Digite o ID do cliente: ");
                    String idCliente = scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o motivo do atendimento: ");
                    String motivoAtendimento = scanner.nextLine();
                    filaAtendimento.adicionarClienteNaFila(new Cliente(idCliente, nomeCliente, motivoAtendimento));
                    System.out.println("Cliente adicionado à fila de atendimento.");
                    break;

                case 5:
                    // Atender próximo cliente
                    Cliente clienteAtendido = filaAtendimento.atenderProximoCliente();  
                    if (clienteAtendido != null) {
                        System.out.println("Cliente atendido: " + clienteAtendido);
                    } else {
                        System.out.println("Fila de atendimento vazia!");
                    }
                    break;

                case 6:
                    // Exibir fila de atendimento
                    System.out.println("Fila de atendimento:");
                    filaAtendimento.exibirFila();  
                    break;

                case 0:
                    // Sair do sistema
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
