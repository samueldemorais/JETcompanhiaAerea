package com.example.jetcompanhiaaerea.Strategys;

import com.example.jetcompanhiaaerea.interfaces.StrategyNotification;

public class EstrategyPush implements StrategyNotification {
    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando Notificação Push: " + mensagem);
    }
}
