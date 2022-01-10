package crudmaisprati.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import crudmaisprati.model.Aluno;
import crudmaisprati.model.Pessoa;
import crudmaisprati.util.Utilidades;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Yuri Peres
 */
public class BancoDeDados {

    private Pessoa[] Pessoas = new Pessoa[0];
    private int indexPessoas = 0;
    private Aluno[] Alunos = new Aluno[0];
    private int indexAlunos = 0;
    private final Utilidades metodosUteis;

    Scanner sc = new Scanner(System.in);

    public BancoDeDados() {
        this.metodosUteis = new Utilidades();
    }

 
    public void extendendoArray(String qual) {
        if (qual.equals("pessoas")) {
            this.indexPessoas = getPessoas().length;
            this.Pessoas = (Arrays.copyOf(this.getPessoas(), this.indexPessoas + 1));
        }
        if (qual.equals("alunos")) {
            this.indexAlunos = getAlunos().length;
            this.Alunos = Arrays.copyOf(getAlunos(), this.indexAlunos + 1);
        }
    }
    public void inserir(Pessoa pessoa) {
        this.getPessoas()[this.indexPessoas] = pessoa;
        Arrays.sort(getPessoas());
    }
    public void inserir(Aluno aluno) {
        this.getAlunos()[this.indexAlunos] = aluno;
        Arrays.sort(getAlunos());
    }
    public void atualizar(Pessoa pessoa, String qual, int index) {
        this.getPessoas()[this.indexPessoas] = pessoa;
        remover(qual, index);
        Arrays.sort(getPessoas());
    }
    public void atualizar(Aluno aluno, String qual, int index) {
        this.getAlunos()[this.indexAlunos] = aluno;
        remover(qual, index);
        Arrays.sort(getAlunos());
    }

    
    
    public void listar(Pessoa pessoa) {
        System.out.println(" ..............................\n"
                + "| Listando pessoas cadastradas |");
        Pessoa[] listaPessoas = Arrays.copyOf(this.getPessoas(), this.getPessoas().length);
        for (int i = 0; i < listaPessoas.length; i++) {
            System.out.println(
                    ".-----------------------------------------------\n"
                    + "|Indice [" + i + "]: " + listaPessoas[i]);
        }
        System.out.println("'-----------------------------------------------\n");

    }
    public void listar(Aluno aluno) {
        System.out.println("\n .............................\n"
                + "| Listando alunos cadastrados |");
        Aluno[] listaAlunos = Arrays.copyOf(getAlunos(), getAlunos().length);
        for (int i = 0; i < listaAlunos.length; i++) {
            System.out.println(
                    ".-----------------------------------------------\n"
                    + "|Indice [" + i + "]: " + listaAlunos[i]);
        }
        System.out.println("'-----------------------------------------------\n");
    }

   
    
    public void remover(String qual, int index) {

        if (qual.equalsIgnoreCase("pessoas")) {
            // Cria a nova database (array) com uma linha a menos
            Pessoa[] novoPessoas = new Pessoa[this.getPessoas().length - 1];

            // Copia os elementos da array antiga para a nova
            for (int i = 0, j = 0; i < this.getPessoas().length; i++) {
                if (i == index) {
                    continue; //salta para proxima iteracao do for, não pegando o elemento que deve ser excluido
                }
                novoPessoas[j++] = getPessoas()[i];
            }
            this.setPessoas(novoPessoas);
        } else if (qual.equalsIgnoreCase("alunos")) {
            // Cria a nova database (array) com uma linha a menos
            Aluno[] novoAlunos = new Aluno[this.getAlunos().length - 1];

            // Copia os elementos da array antiga para a nova
            for (int i = 0, j = 0; i < this.getAlunos().length; i++) {
                if (i == index) {
                    continue;
                }
                novoAlunos[j++] = getAlunos()[i];
            }
            this.setAlunos(novoAlunos);
        } else {
            System.out.println("Nenhuma opção escolhida.");
        }
    }

    public boolean verificadorRange(String qual, int index) {
        //true para index errado!
        //Se está vazio, ou index fora do range retorna true
        if (qual.equalsIgnoreCase("pessoas")) {
            if (this.getPessoas() == null || index < 0
                    || index >= getPessoas().length) {
                return true;
            }
        } else if (qual.equalsIgnoreCase("alunos")) {
            if (this.getAlunos() == null || index < 0
                    || index >= getAlunos().length) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return the Pessoas
     */
    public Pessoa[] getPessoas() {
        return Pessoas;
    }

    /**
     * @return the Alunos
     */
    public Aluno[] getAlunos() {
        return Alunos;
    }


    /**
     * @param Pessoas the Pessoas to set
     */
    public void setPessoas(Pessoa[] Pessoas) {
        this.Pessoas = Pessoas;
    }

    /**
     * @param Alunos the Alunos to set
     */
    public void setAlunos(Aluno[] Alunos) {
        this.Alunos = Alunos;
    }

}
