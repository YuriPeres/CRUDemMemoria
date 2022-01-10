package crudmaisprati.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

/**
 *
 * @author Yuri Peres
 */
public class Aluno extends Pessoa {
    private Float nota;

    /**
     * @return the nota
     */
    public Float getNota() {
        return this.nota;
    }

    /**
     * @param nota the nota to set
     * @override
     */
    public void setNota(Float nota) {
        this.nota = nota;
    }
    
    @Override
    public String toString() {
        return "\n|Nome: " + this.getNome() 
                + "\n|Telefone: " + this.getTelefone()
                + "\n|Nota: " + this.getNota()
                + "\n|Data de nascimento: " + getDfNascimento().format(getDtNascimento())
                + "\n|Data de cadastro: " + getDfCadastro().format(this.getDtCadastro())
                + "\n|Data da última alteração: " + getDfCadastro().format(this.getDtUltimaAlteracao());
    }
    
}