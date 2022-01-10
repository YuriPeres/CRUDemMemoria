package crudmaisprati.util;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Yuri Peres
 */
public class Utilidades {

    public String formatadorStringNum(String txt, String modelo) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(modelo);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(txt);
        } catch (ParseException ex) {
            return txt;
        }
        //String telefone = formatarString("55911223344","(##) #####-####");
    }

    public String apenasNumero(String txt) {
        boolean aN = txt.matches("[0-9]*");

        if (aN) {
            return txt;
        }
        return txt.replaceAll("[^0-9]", "");
    }

    public String retornarTelefone(String txt) {
        if (apenasNumero(txt).length() != 11) {
            forcarErro();
            return null;
        }
        return formatadorStringNum(apenasNumero(txt), "(##) #####-####");
    }

    public Float formatarNota(Float nota) {
        if(nota >100 || nota < 0) {
            System.out.println("Erro: Nota deve ser de 0 (zero) a 100 (cem).\n");
            forcarErro();
        } 
        return nota;
    }

    public boolean verificadorData(String data) {
        try {
            
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            
            df.setLenient(false); //false quer dizer que NÃO aceito datas falsas
            df.parse(data);
            //Agora para trabalhar com o LocalDate usarei DateTimeFormatter
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf);
            LocalDate hoje = LocalDate.now();
            
            //Quando a dataVerificada é menor retorna -1, quando é maior retorna 1, e quando é igual retorna 0
            return dataVerificada.compareTo(hoje) <= 0;
        } catch (ParseException ex) {
            return false;
        }
    }

    public void forcarErro() {
        //forçar erro
        String xyz = "Caiu no forcarErro()";
        int erro = Integer.parseInt(xyz);
        System.out.print(erro);
    }
}
