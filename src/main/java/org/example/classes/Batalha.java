package org.example.classes;

import java.util.Random;

public class Batalha {
    private Treinador treinador1;
    private Treinador treinador2;
    private int turno = 1;
    private final Random rng = new Random();

    public Batalha(Treinador t1, Treinador t2) {
        this.treinador1 = t1;
        this.treinador2 = t2;
    }

    public String iniciar() {
        if (treinador1.getPokemons().isEmpty() || treinador2.getPokemons().isEmpty()) {
            return "Não é possível iniciar: um dos treinadores não possui Pokémons.";
        }

        Pokemon p1 = treinador1.getPokemons().get(0);
        Pokemon p2 = treinador2.getPokemons().get(0);

        StringBuilder log = new StringBuilder();
        log.append("Batalha iniciada: ").append(treinador1.getNome()).append(" vs ").append(treinador2.getNome()).append("\n");

        while (p1.getVida() > 0 && p2.getVida() > 0) {
            log.append(registrarTurno(p1, p2)).append("\n");
            turno++;
        }

        String vencedor = p1.getVida() > 0 ? treinador1.getNome() : treinador2.getNome();
        log.append("Vencedor: ").append(vencedor);
        return log.toString();
    }

    public String registrarTurno(Pokemon p1, Pokemon p2) {
        StringBuilder sb = new StringBuilder();
        boolean primeiro = rng.nextBoolean();
        if (primeiro) {
            int dano = p1.atacar(p2);
            sb.append("Turno ").append(turno).append(": ").append(p1.getNome()).append(" causou ").append(dano)
                    .append(" em ").append(p2.getNome()).append(" (HP ").append(p2.getVida()).append(")\n");
            if (p2.getVida() > 0) {
                int dano2 = p2.atacar(p1);
                sb.append("Turno ").append(turno).append(": ").append(p2.getNome()).append(" causou ").append(dano2)
                        .append(" em ").append(p1.getNome()).append(" (HP ").append(p1.getVida()).append(")");
            }
        } else {
            int dano = p2.atacar(p1);
            sb.append("Turno ").append(turno).append(": ").append(p2.getNome()).append(" causou ").append(dano)
                    .append(" em ").append(p1.getNome()).append(" (HP ").append(p1.getVida()).append(")\n");
            if (p1.getVida() > 0) {
                int dano2 = p1.atacar(p2);
                sb.append("Turno ").append(turno).append(": ").append(p1.getNome()).append(" causou ").append(dano2)
                        .append(" em ").append(p2.getNome()).append(" (HP ").append(p2.getVida()).append(")");
            }
        }
        return sb.toString();
    }
}
