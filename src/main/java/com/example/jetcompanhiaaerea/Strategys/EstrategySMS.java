package com.example.jetcompanhiaaerea.Strategys;

import com.example.jetcompanhiaaerea.interfaces.StrategyNotification;

public class EstrategySMS implements StrategyNotification {
    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}