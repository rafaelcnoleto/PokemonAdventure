package org.example.classes;

import org.example.enumeradores.EnumEfeito;

public class ItemEvolucao extends Item {

    public ItemEvolucao(String nome) {
        super(nome, EnumEfeito.EVOLUIR);
    }

    @Override
    public String aplicar(Pokemon p) {
        p.evoluir();
        return "Aplicado " + getNome() + ": " + p.getNome() + " evoluiu!";
    }
}
