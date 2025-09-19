package org.example;

import org.example.classes.*;
import org.example.enumeradores.EnumTipo;

public class Main {
    public static void main(String[] args) {
        // Treinadores
        Treinador ash = new Treinador("Ash", 12);
        Treinador misty = new Treinador("Misty", 14);

        // Encontros de Pokémons "selvagens"
        Pokemon pikachuSelvagem = new Pokemon("Pikachu", EnumTipo.ELETRICO, 5, 35);
        Pokemon staryuSelvagem = new Pokemon("Staryu", EnumTipo.AGUA, 4, 30);

        // Habilidades
        Habilidade choqueDoTrovao = new Habilidade("Choque do Trovão", 40, EnumTipo.ELETRICO);
        Habilidade jatoDAgua = new Habilidade("Jato d'Água", 35, EnumTipo.AGUA);

        pikachuSelvagem.adicionarHabilidade(choqueDoTrovao);
        staryuSelvagem.adicionarHabilidade(jatoDAgua);

        // Fase de captura
        System.out.println("Ash encontrou um " + pikachuSelvagem.getNome() + " e tentou capturar...");
        ash.capturarPokemon(pikachuSelvagem);
        System.out.println("Captura bem-sucedida! " + pikachuSelvagem.getNome() + " agora pertence a " + ash.getNome());

        System.out.println("Misty encontrou um " + staryuSelvagem.getNome() + " e tentou capturar...");
        misty.capturarPokemon(staryuSelvagem);
        System.out.println("Captura bem-sucedida! " + staryuSelvagem.getNome() + " agora pertence a " + misty.getNome());

        // Listagem
        System.out.println(ash.listarPokemons());
        System.out.println(misty.listarPokemons());

        // Itens
        ItemCura pocao = new ItemCura("Poção", 20);
        ItemEvolucao pedraTrovao = new ItemEvolucao("Pedra do Trovão");

        // Aplicar itens
        System.out.println(pocao.aplicar(pikachuSelvagem));
        System.out.println(pedraTrovao.aplicar(pikachuSelvagem));

        // Batalha
        Batalha batalha = new Batalha(ash, misty);
        String log = batalha.iniciar();
        System.out.println(log);
    }
}
