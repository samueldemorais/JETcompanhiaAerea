package com.example.jetcompanhiaaerea.model;

import com.example.jetcompanhiaaerea.interfaces.Observador;
import com.example.jetcompanhiaaerea.interfaces.StrategyNotification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passageiro implements Observador {
    private String nome;
    private StrategyNotification preferenciaNotificacao;

    public Passageiro(String nome, StrategyNotification preferenciaNotificacao) {
        this.nome = nome;
        this.preferenciaNotificacao = preferenciaNotificacao;
    }

    @Override
    public void atualizar(Voo voo) {
        System.out.println("Notificando " + nome + " sobre o status do voo: " + voo.getStatus());
        preferenciaNotificacao.enviarNotificacao("Alteração no Estado no VOO");
    }
}