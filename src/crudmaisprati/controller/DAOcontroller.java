/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmaisprati.controller;

import crudmaisprati.DAO.BancoDeDados;
import crudmaisprati.model.Aluno;
import crudmaisprati.model.Pessoa;
import crudmaisprati.util.Utilidades;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Essa liga a parte visivel ao usuario ao banco de dados
 *
 * @author Yuri Peres
 */
public class DAOcontroller {

    BancoDeDados database = new BancoDeDados();
    Utilidades metodosUteis = new Utilidades();
    Scanner sc = new Scanner(System.in);

    public void cadastrar() {
        try {

            //Pegando dados em Strings
            System.out.println("Nome: ");
            String nome = sc.nextLine().toUpperCase();
            System.out.println("Telefone: ");
            String telefone = metodosUteis.retornarTelefone(sc.nextLine());
            //Datas
            System.out.println("Data de nascimento: ");
            String dtNascimento = metodosUteis.formatadorStringNum(metodosUteis.apenasNumero(sc.nextLine()), "##/##/####");
            if (!metodosUteis.verificadorData(dtNascimento)) {
                System.out.println("Data invalida!");
                metodosUteis.forcarErro();
            }
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = df.parse(dtNascimento);

            Date agora = new Date();

            System.out.println("Caso seja um Aluno, digite a nota. Se nao, cadastrara Pessoa: ");
            String nota = sc.nextLine().replaceAll(",", ".");
            Float notaF ;
            //Verificando se é aluno
            try {
                notaF = metodosUteis.formatarNota(Float.parseFloat(nota));
            } catch (NumberFormatException ex) {
                notaF = null;
            }
            //É Pessoa
            if (notaF == null) {
                //Extendendo Array
                database.extendendoArray("pessoas");

                //Adicionando em Pessoas
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setTelefone(telefone);
                pessoa.setDtNascimento(dataNascimento);
                pessoa.setDtCadastro(agora);
                pessoa.setDtUltimaAlteracao(agora);
                database.inserir(pessoa);

            } else { //É Aluno 
                //Extendendo Array
                database.extendendoArray("alunos");

                //Adicionando em Alunos
                Aluno aluno = new Aluno();
                aluno.setNome(nome);
                aluno.setTelefone(telefone);
                aluno.setNota(notaF);
                aluno.setDtNascimento(dataNascimento);
                aluno.setDtCadastro(agora);
                aluno.setDtUltimaAlteracao(agora);
                database.inserir(aluno);
            }
        } catch (NumberFormatException | ParseException ex) {
            avisoErro(ex);
        }
    }

    public void atualizarCadastro() {
        String qual = qualListar();
        int index;
        if ((qual.equalsIgnoreCase("pessoas") || qual.equalsIgnoreCase("alunos"))) {
            index = qualIndex();
            if (database.verificadorRange(qual, index)) {
                System.out.println("Opcao inexistente na lista.");
            } else {
                try {

                    //Pegando dados em Strings
                    System.out.println("Nome: ");
                    String nome = sc.nextLine().toUpperCase();
                    System.out.println("Telefone: ");
                    String telefone = metodosUteis.retornarTelefone(sc.nextLine());
                    //Datas
                    System.out.println("Data de nascimento: ");
                    String dtNascimento = metodosUteis.formatadorStringNum(metodosUteis.apenasNumero(sc.nextLine()), "##/##/####");
                    if (!metodosUteis.verificadorData(dtNascimento)) {
                        System.out.println("Data invalida!");
                        metodosUteis.forcarErro();
                    }
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataNascimento = df.parse(dtNascimento);

                    Date agora = new Date();

                    //É Pessoa
                    if (qual.equalsIgnoreCase("pessoas")) {
                        //Extendendo Array
                        database.extendendoArray("pessoas");

                        //Adicionando em Pessoas
                        Pessoa pessoa = new Pessoa();
                        pessoa.setNome(nome);
                        pessoa.setTelefone(telefone);
                        pessoa.setDtNascimento(dataNascimento);
                        pessoa.setDtCadastro(agora);
                        pessoa.setDtUltimaAlteracao(agora);
                        database.atualizar(pessoa, qual, index);

                    } else { //É Aluno 
                        System.out.println("Nota: ");
                        Float notaF = metodosUteis.formatarNota(Float.parseFloat(sc.nextLine().replaceAll(",",".")));
                        //Extendendo Array
                        database.extendendoArray("alunos");

                        //Adicionando em Alunos
                        Aluno aluno = new Aluno();
                        aluno.setNome(nome);
                        aluno.setTelefone(telefone);
                        aluno.setNota(notaF);
                        aluno.setDtNascimento(dataNascimento);
                        aluno.setDtCadastro(agora);
                        aluno.setDtUltimaAlteracao(agora);
                        database.atualizar(aluno, qual, index);
                    }
                } catch (NumberFormatException | ParseException ex) {
                    avisoErro(ex);
                }
            }
        } else {
            //so volta
        }

    }

    public String qualListar() {
        System.out.println("Escolha a lista:\n"
                + "Opcoes: Pessoas | Alunos | Voltar\n");
        String qual = sc.nextLine();
        if (qual.equalsIgnoreCase("pessoas")) {
            Pessoa pessoa = new Pessoa();
            database.listar(pessoa);
        } else if (qual.equalsIgnoreCase("alunos")) {
            Aluno aluno = new Aluno();
            database.listar(aluno);
        } else {
            System.out.println("Nenhuma opcao selecionado, voltando ao menu inicial.");

        }
        return qual;
    }

    public int qualIndex() {
        System.out.println("Qual o indice referente a acao? ");
        int index = Integer.parseInt(sc.nextLine());
        return index;
    }

    public void deletarCadastro() {
        String qual = qualListar();
        if ((qual.equalsIgnoreCase("pessoas") || qual.equalsIgnoreCase("alunos"))) {
            int index = qualIndex();
            if (database.verificadorRange(qual, index)) {
                System.out.println("Opcao inexistente na lista.");
            } else {
                database.remover(qual, index);
            }
        } else {
            //so volta
        }
    }

    public static void avisoErro(Exception ex) {

        System.out.println("\n"
                + "!-------------------------------------------------------!\n"
                + "!->Atencao: Dado informado incorretamente!              !\n"
                + "!.......................................................!\n"
                + "!->Modelo correto de preenchimento:                     !\n"
                + "!   Nome: Seu Nome                                      !\n"
                + "!   Telefone: 51912345678                               !\n"
                + "!   Data de nascimento: dd/mm/yyyy (com ou sem barras)  !\n"
                + "!   Nota: (somente numeros ou deixar vazio)             !\n"
                + "!-------------------------------------------------------!\n");
    }

}
