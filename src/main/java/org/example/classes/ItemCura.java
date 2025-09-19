package org.example.classes;

import org.example.enumeradores.EnumEfeito;

public class ItemCura extends Item {
    private int quantidadeCura;

    public ItemCura(String nome, int quantidadeCura) {
        super(nome, EnumEfeito.CURA);
        this.quantidadeCura = Math.max(1, quantidadeCura);
    }

    public int getQuantidadeCura() { return quantidadeCura; }

    @Override
    public String aplicar(Pokemon p) {
        int antes = p.getVida();
        p.curar(quantidadeCura);
        int curado = p.getVida() - antes;
        return "Aplicado " + getNome() + ": curou " + curado + " HP";
    }
}
