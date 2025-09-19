package org.example.classes;

import org.example.enumeradores.EnumTipo;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String nome;
    private EnumTipo tipo;
    private int nivel;
    private int vidaMaxima;
    private int vida;
    private final List<Habilidade> habilidades = new ArrayList<>();

    public Pokemon(String nome, EnumTipo tipo, int nivel, int vidaMaxima) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = Math.max(1, nivel);
        this.vidaMaxima = Math.max(1, vidaMaxima);
        this.vida = this.vidaMaxima;
    }

    public String getNome() { return nome; }
    public EnumTipo getTipo() { return tipo; }
    public int getNivel() { return nivel; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public List<Habilidade> getHabilidades() { return new ArrayList<>(habilidades); }

    public void adicionarHabilidade(Habilidade h) {
        if (h != null) habilidades.add(h);
    }

    public int atacar(Pokemon alvo) {
        int base = 5 + nivel;
        int bonus = habilidades.isEmpty() ? 0 : habilidades.get(0).getPoder() / 10;
        int dano = Math.max(1, base + bonus);
        alvo.receberDano(dano);
        return dano;
    }

    public void receberDano(int dano) {
        vida = Math.max(0, vida - Math.max(0, dano));
    }

    public void curar(int quantidade) {
        vida = Math.min(vidaMaxima, vida + Math.max(0, quantidade));
    }

    public boolean evoluir() {
        nivel++;
        vidaMaxima += 5;
        vida = vidaMaxima;
        nome = nome + " Evo";
        return true;
    }

    @Override
    public String toString() {
        return nome + " [Tipo=" + tipo + ", Nv=" + nivel + ", HP=" + vida + "/" + vidaMaxima + "]";
    }
}
