package org.example.classes;

import org.example.enumeradores.EnumEfeito;

public abstract class Item {
    private String nome;
    private EnumEfeito efeito;

    public Item(String nome, EnumEfeito efeito) {
        this.nome = nome;
        this.efeito = efeito;
    }

    public String getNome() { return nome; }
    public EnumEfeito getEfeito() { return efeito; }

    public abstract String aplicar(Pokemon p);
}
