package crudmaisprati.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yuri Peres
 */
public class Pessoa implements Comparable<Pessoa>{

    private String nome;
    private String telefone;
    private Date dtNascimento;
    private Date dtCadastro;
    private Date dtUltimaAlteracao;
    private DateFormat dfNascimento = new SimpleDateFormat("dd/MM/yyyy");
    private DateFormat dfCadastro = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\n|Nome: " + getNome()
                + "\n|Telefone: " + this.getTelefone()
                + "\n|Data de nascimento: " + getDfNascimento().format(getDtNascimento())
                + "\n|Data de cadastro: " + getDfCadastro().format(this.getDtCadastro())
                + "\n|Data da última alteração: " + getDfCadastro().format(this.getDtUltimaAlteracao());
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.getNome().compareTo(outraPessoa.getNome());
    }

    /**
     * @return the dtNascimento
     */
    public Date getDtNascimento() {
        return dtNascimento;
    }

    /**
     * @param dtNascimento the dtNascimento to set
     */
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    /**
     * @return the dtCadastro
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro the dtCadastro to set
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * @return the dtUltimaAlteracao
     */
    public Date getDtUltimaAlteracao() {
        return dtUltimaAlteracao;
    }

    /**
     * @param dtUltimaAlteracao the dtUltimaAlteracao to set
     */
    public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
        this.dtUltimaAlteracao = dtUltimaAlteracao;
    }

    /**
     * @return the dfNascimento
     */
    public DateFormat getDfNascimento() {
        return dfNascimento;
    }

    /**
     * @param dfNascimento the dfNascimento to set
     */
    public void setDfNascimento(DateFormat dfNascimento) {
        this.dfNascimento = dfNascimento;
    }

    /**
     * @return the dfCadastro
     */
    public DateFormat getDfCadastro() {
        return dfCadastro;
    }

    /**
     * @param dfCadastro the dfCadastro to set
     */
    public void setDfCadastro(DateFormat dfCadastro) {
        this.dfCadastro = dfCadastro;
    }
}
