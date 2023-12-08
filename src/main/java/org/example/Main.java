package org.example;

import org.example.controller.AgendaController;
import org.example.controller.ClienteController;
import org.example.controller.ImovelController;
import org.example.controller.ServicoController;
import org.example.model.Funcionario;
import org.example.model.Imovel;

import java.util.ArrayList;


import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        ImovelController imovelController = new ImovelController();
        ServicoController servicoController = new ServicoController();
        ClienteController clienteController = new ClienteController();
        AgendaController agendaController = new AgendaController();

        path("/servico", ()-> {
            post("/gerarServico", (request, response) -> {
                ArrayList< Funcionario > funcionarios = new ArrayList<>();
                servicoController.solicServico(new double(),funcionarios);
                return "Serviço solicitado com sucesso!!!!";
            });

            post("/cotacao", (request, response) -> {
                servicoController.solicCotacao(new double(), new Imovel(), new Funcionario());
                return "Serviço solicitado com sucesso!!!";
            });
            get("/emitirFatura/:servico", ((request, response) -> {
                servicoController.fatura();
                return "Fatura processada com sucesso!!!!!";
            }));
        });

        path("/cadastrarCliente", ()->{
            post("/cadastrarCliente", (request, response) -> {
                clienteController.setDadosCliente();
                return "Cliente cadastrado com sucesso!!!!";
            });
        });

        path("/verImovel", ()->{
            post("/imovel", (request, response) -> {
                imovelController.setDadosImovel();
                return "Imovel cadastrado com sucesso!!!!";
            });
        });

        path("/agenda", ()->{
            get("/verificarDiasUteis", (request, response) -> {
                agendaController.verificarDiasUteis();
                return "Dias uteis:";
            });
            get("/diasDisponiveis", ((request, response) -> {
                agendaController.diasDisponiveis(());
                return "Dias que o FUNCIONARIO esta disponivel";
            }));
            get("/Funcionarios", ((request, response) -> {
                agendaController.verificarFuncDisponiveis();
                return "Funcionaros disponiveis:";
            }));
        });

    }
}