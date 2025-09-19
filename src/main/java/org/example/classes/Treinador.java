package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Treinador {
    private String nome;
    private int idade;
    private final List<Pokemon> pokemons = new ArrayList<>();

    public Treinador(String nome, int idade) {
        this.nome = nome;
        this.idade = Math.max(0, idade);
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public List<Pokemon> getPokemons() { return new ArrayList<>(pokemons); }

    public void capturarPokemon(Pokemon p) {
        if (p != null) pokemons.add(p);
    }

    public String listarPokemons() {
        StringBuilder sb = new StringBuilder("Pokémons de " + nome + ":\n");
        for (int i = 0; i < pokemons.size(); i++) {
            sb.append(i).append(") ").append(pokemons.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
