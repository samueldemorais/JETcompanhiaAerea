package com.example.jetcompanhiaaerea.model;

import com.example.jetcompanhiaaerea.interfaces.Observador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voo {
    private String codigoVoo;
    private StatusVoo status;
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private LocalDateTime horarioPartidaPrevisto;
    private LocalDateTime horarioChegadaPrevisto;
    private Aeronave aeronave; // Aeronave associada ao voo

    private List<Observador> observadores = new ArrayList<>();

    public Voo(String s, String aeroportoOrigem, String aeroportoDestino, LocalDateTime partidaPrevista, LocalDateTime chegadaPrevista, Aeronave aeronave) {
        this.codigoVoo = s;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.horarioChegadaPrevisto = chegadaPrevista;
        this.horarioPartidaPrevisto = partidaPrevista;
        this.aeronave = aeronave;
    }

    public void adicionarObservador(Passageiro passageiro) {
        if (aeronave != null && observadores.size() < aeronave.getQuantidadeAssentos()) {
            observadores.add(passageiro);
            System.out.println("Passageiro " + passageiro.getNome() +" adicionado ao " + this.getCodigoVoo());
        } else {
            System.out.println("Não foi possível adicionar o observador (Passageiro) ao voo. Capacidade máxima atingida.");
        }
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setStatusNotify(StatusVoo status) {
        this.status = status;
        notificarObservadores();
    }

    public StatusVoo getStatus() {
        return this.status;
    }

    public String getCodigoVoo(){ return this.codigoVoo;}

    public void setAeronave(Aeronave aeronave){ this.aeronave = aeronave;}

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar(this);
        }
    }

}

