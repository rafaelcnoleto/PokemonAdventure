package org.example.classes;

import org.example.enumeradores.EnumTipo;

public class Habilidade {
    private String nome;
    private int poder;
    private EnumTipo tipo;

    public Habilidade(String nome, int poder, EnumTipo tipo) {
        this.nome = nome;
        this.poder = poder;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public int getPoder() { return poder; }
    public EnumTipo getTipo() { return tipo; }

    public String usar() {
        return "Habilidade " + nome + " usada com poder " + poder + " (" + tipo + ")";
    }
}
