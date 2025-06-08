package service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalculadoraPosOrdem {

    public static double calcularExpressao(String exp) throws Exception  {
        Queue <String> expressao = new LinkedList<>(); //fila que vai armazenar a expressao a ser realizada
        for (String e : exp.split(" ")) {
            expressao.add(e);
        }

        Stack <Double> numeros = new Stack<>(); //pilha que vai armazenar os operandos da expressao

        while(!expressao.isEmpty()) {
            String elemento = expressao.poll(); //define elemento como o primeiro elemento da fila

            if(isNumero(elemento)) { //caso o elemento seja um numero ele vai para a pilha
                numeros.push(Double.parseDouble(elemento)); //muda o elemento para double
            }
            else if (isOperador(elemento)){
                if(numeros.size()<2) { //verifica se tem mais de dois elementos na pilha
                    throw new Exception("Expressão inválida: operandos insuficientes.");
                }
                double n1 = numeros.pop(); //define o topo da pilha como a e o retira da pilha
                double n2 = numeros.pop();	//define o topo da pilha como a e o retira da pilha
                double r = calculo(n2,n1,elemento); //faz o calculo entre os dois elementos da pilha com o operador "elemento"
                numeros.push(r); //empilha o resultado na pilha para que possa continuar com as operacoes
            }
            else {
                throw new Exception("Expressão malformada: operador '" + elemento + "' inválido"); //se o elementos nao for nem numero nem operador
            }
        }

        if (numeros.size() != 1) { //verifica se após terminar o loop ainda sobrou algum numero além do resultado
            throw new Exception("Expressão inválida: operandos ou operadores em excesso.");
        }

        return numeros.pop(); //caso tudo ocorra corretamente, retorna o resultado

    }

    //metodo que vai realizar os calculos a depender do operador
    private static double calculo(double a, double b, String op) throws Exception {
        switch(op) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                //verificacao se o numero que esta dividindo é zero
                if(b!=0) {
                    return a/b;
                }
                else {
                    throw new Exception("Divisão por zero.");
                }
            case "%"://verificacao se o numero que esta dividindo é zero
                if(b!=0) {
                    return a%b;
                }
                else {
                    throw new Exception("Divisão por zero.");
                }
            default:
                throw new Exception("Operador inválido: " + op);
        }
    }

    //metodo que verifica se um char da expressao é numero
    private static boolean isNumero(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //metodo que verifica se um char da expressao é operador
    private static boolean isOperador(String elemento) {
        return "+-*/%".contains(elemento);
    }
}
