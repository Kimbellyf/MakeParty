package com.inovaufrpe.makeparty.servico;

import android.text.TextUtils;
import android.util.Patterns;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class ValidacaoGuiRapida {
    private static final String DATA_COMUM_CB   = "dd/MM/yyyy";
    private static final String DATA_COMUM_SB = "yyyyMMdd";

    private static final int TAMCPF = 11;
    private static final int TAMCNPJ = 14;
    private static final int TAMTEL = 11;
    private static final int ZERO = 0;
    private static final int DOIS = 2;
    private static final int TRES = 3;
    private static final int QUATRO = 4;
    private static final int SEIS = 6;
    private static final int TAMANHO_DATA_CB = 10;
    private static final int TAMANHO_DATA_SB = 8;

    public boolean isCampoVazio(String valor) {
        return (valor.isEmpty());
    }
    public boolean isCampoAceitavel(String valor){
        return ((valor.length() >= TRES));
    }

    public boolean isEmailValido(String email) {
        return ((Patterns.EMAIL_ADDRESS.matcher(email).matches()));
    }

    public boolean isTelefoneValido(String telefone) {
        telefone = String.valueOf(telefone).replace(".","").replace("-","").replace("(","").replace(")","");
        return ((telefone.length() == TAMTEL));
    }

    public boolean isCpfValido(String cpf) {
        cpf = String.valueOf(cpf).replace(".","").replace("-","");
        return ((cpf.length() == TAMCPF) && validaCPF(cpf));
    }

    public boolean isSenhaValida(String senha) {
        return ((senha.length()>=SEIS));
    }

    public boolean isSenhaIgual(String senha, String confirmaSenha) {
        return (senha.equals(confirmaSenha));
    }

    public boolean isCnpjValido(String cnpj) {
        cnpj = String.valueOf(cnpj).replace(".","").replace("-","").replace("/","");
        return ((cnpj.length() == TAMCNPJ) && validaCnpj(cnpj));
    }
    public boolean validaCnpj(String cnpj){
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
                || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
                || cnpj.equals("99999999999999") || (cnpj.length() != 14))
            return (false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
    public boolean validaCPF(String cpf){
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }



    public static boolean dataMenorOuIgualQueAtual(String data) {
        SimpleDateFormat dataFormatada = new SimpleDateFormat(DATA_COMUM_CB);
        dataFormatada.setLenient(false);
        //Testa no formato dd/MM/yyyy
        try {
            Date dataAtual = new Date();
            Date dataCliente = dataFormatada.parse(data);

            if (dataAtual.compareTo(dataCliente) >= ZERO) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    static boolean dataExiste(String data){
        SimpleDateFormat dataFormatada = new SimpleDateFormat (DATA_COMUM_CB);
        dataFormatada.setLenient (false);

        //Testa no formato dd/MM/yyyy
        try {
            dataFormatada.parse(data);
            return true;
        } catch (Exception e) {
        }

        dataFormatada = new SimpleDateFormat (DATA_COMUM_SB);
        dataFormatada.setLenient (false);

        //Testa no formato yyyyMMdd
        try {
            dataFormatada.parse(data);
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean isDataValida(String data){
        return(dataExiste(data) && dataMenorOuIgualQueAtual(data) && (data.length() == TAMANHO_DATA_CB) || data.length() == TAMANHO_DATA_SB);
    }

    public String dataFormatoBanco(String data){
        String dataFormatada;
        if (data.contains("/")){
            // String dataReversa = new StringBuilder(data).reverse().toString();
            String dataNova = data.replace("/","");
            dataFormatada = dataNova.substring(QUATRO,TAMANHO_DATA_SB) + "-" + dataNova.substring(DOIS,QUATRO) + "-" + dataNova.substring(ZERO,DOIS);

        }else{
            dataFormatada = data.substring(QUATRO,TAMANHO_DATA_SB) + "-" + data.substring(DOIS,QUATRO) + "-" + data.substring(ZERO,DOIS);
        }
        return dataFormatada;

    }
    public boolean isDataDoc(String data){
        return(dataExiste(data) && (data.length() == TAMANHO_DATA_CB) || data.length() == TAMANHO_DATA_SB);
    }

    public String dataExibicao(String data) {
        String dataNova = data.replace("-", "");
        String dataFormatada = dataNova.substring(SEIS, TAMANHO_DATA_SB) + "/" + dataNova.substring(QUATRO, SEIS) + "/" + dataNova.substring(ZERO, QUATRO);
        return dataFormatada;
    }
}
