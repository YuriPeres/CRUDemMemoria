package crudmaisprati;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import crudmaisprati.DAO.BancoDeDados;
import crudmaisprati.controller.DAOcontroller;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yuri Peres
 */
public class CrudMaisPraTi {

    BancoDeDados database = new BancoDeDados();
    DAOcontroller controller = new DAOcontroller();

    public void menu() {
        limparTela();
        System.out.print("\n"
                + ".--------------------------------------------------------------.\n"
                + "| Cadastrar -> 1 | Listar -> 2 | Atualizar -> 3 | Remover -> 4 |\n"
                + "'--------------------------------------------------------------'\n"
                + "| Fechar programa -> 0 |\n"
                + "'----------------------'\n"
                + " -> Escolha qual opcao quer: ");
//            opcao = Integer.parseInt(sc.nextLine());
//            System.out.println("|==============================|");
    }

    public void executeOpcao(int opcao) {
        switch (opcao) {
            case 1: {
                controller.cadastrar();
                //limparTela();
                break;
            }
            case 2: {
                controller.qualListar();
                //limparTela();
                break;

            }
            case 3: {
                controller.atualizarCadastro();
                //limparTela();
                break;
            }
            case 4: {
                controller.deletarCadastro();
                //limparTela();

                break;
            }
        }
    }

    public void limparTela() {
        try {
            //Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
        }
    }

    public static void main(String[] args) {

        CrudMaisPraTi crud = new CrudMaisPraTi();
        int opcao;
        Scanner sc = new Scanner(System.in);
        
        do {
            crud.menu();
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                opcao = 50;
            }
            crud.executeOpcao(opcao);
            System.out.println("\nENTER para seguir");
            sc.nextLine();
            System.out.println("\n");
        } while (opcao != 0);

        System.out.println("\n"
                + ".------------------------------------------.\n"
                + "|Projeto CRUD salvo em memoria finalizado! |\n"
                + "|Autour: Yuri Peres                        |\n"
                + "'------------------------------------------'\n");
        sc.close();
    }

}
