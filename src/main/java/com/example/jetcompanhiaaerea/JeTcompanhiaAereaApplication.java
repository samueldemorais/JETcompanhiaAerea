package com.example.jetcompanhiaaerea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jetcompanhiaaerea.Strategys.EstrategyEmail;
import com.example.jetcompanhiaaerea.Strategys.EstrategyPush;
import com.example.jetcompanhiaaerea.Strategys.EstrategySMS;
import com.example.jetcompanhiaaerea.interfaces.StrategyNotification;
import com.example.jetcompanhiaaerea.model.Aeronave;
import com.example.jetcompanhiaaerea.model.Passageiro;
import com.example.jetcompanhiaaerea.model.StatusVoo;
import com.example.jetcompanhiaaerea.model.Voo;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JeTcompanhiaAereaApplication {
	// Criando três aeronaves
	private static Aeronave aeronave1 = new Aeronave("Boeing 737", 2);
	private static Aeronave aeronave2 = new Aeronave("Airbus A320", 180);
	private static Aeronave aeronave3 = new Aeronave("Embraer E190", 120);

	// Criando tres tipos de notificação
	private static StrategyNotification email = new EstrategyEmail();
	private static StrategyNotification push = new EstrategyPush();
	private static StrategyNotification sms = new EstrategySMS();

	public static void main(String[] args) {
		SpringApplication.run(JeTcompanhiaAereaApplication.class, args);
		LocalDateTime partida1 = LocalDateTime.now().plusHours(1);
		LocalDateTime chegada1 = partida1.plusHours(3);
		LocalDateTime partida2 = LocalDateTime.now().plusHours(2);
		LocalDateTime chegada2 = partida2.plusHours(3);
		LocalDateTime partida3 = LocalDateTime.now().plusHours(3);
		LocalDateTime chegada3 = partida3.plusHours(3);
		LocalDateTime partida4 = LocalDateTime.now().plusHours(4);
		LocalDateTime chegada4 = partida4.plusHours(3);
		LocalDateTime partida5 = LocalDateTime.now().plusHours(5);
		LocalDateTime chegada5 = partida5.plusHours(3);

		Voo voo1 = new Voo("Voo1", "São Paulo", "Rio de Janeiro", partida1, chegada1, aeronave1);
		Voo voo2 = new Voo("Voo2", "Brasília", "Salvador", partida2, chegada2, aeronave2);
		Voo voo3 = new Voo("Voo3", "Porto Alegre", "Curitiba", partida3, chegada3, aeronave3);
		Voo voo4 = new Voo("Voo4", "Fortaleza", "Recife", partida4, chegada4, aeronave1);
		Voo voo5 = new Voo("Voo5", "Manaus", "Belém", partida5, chegada5, aeronave2);

		// Criando passageiros individualmente para cada voo
		Passageiro passageiro1 = new Passageiro("João", email);
		Passageiro passageiro2 = new Passageiro("Maria", sms);
		Passageiro passageiro11 = new Passageiro("Rafael", email);
		voo1.adicionarObservador(passageiro1);
		voo1.adicionarObservador(passageiro2);
		voo1.adicionarObservador(passageiro11);

		Passageiro passageiro3 = new Passageiro("Pedro", push);
		Passageiro passageiro4 = new Passageiro("Ana", email);
		Passageiro passageiro12 = new Passageiro("Camila", email);
		voo2.adicionarObservador(passageiro3);
		voo2.adicionarObservador(passageiro4);
		voo2.adicionarObservador(passageiro12);

		Passageiro passageiro5 = new Passageiro("Luiz", push);
		Passageiro passageiro6 = new Passageiro("Laura", email);
		Passageiro passageiro13 = new Passageiro("Gustavo", sms);
		voo3.adicionarObservador(passageiro5);
		voo3.adicionarObservador(passageiro6);
		voo3.adicionarObservador(passageiro13);

		Passageiro passageiro7 = new Passageiro("Marcos", sms);
		Passageiro passageiro8 = new Passageiro("Carolina", push);
		Passageiro passageiro14 = new Passageiro("Bianca", sms);
		voo4.adicionarObservador(passageiro7);
		voo4.adicionarObservador(passageiro8);
		voo4.adicionarObservador(passageiro14);

		Passageiro passageiro9 = new Passageiro("Gabriel", sms);
		Passageiro passageiro10 = new Passageiro("Amanda", email);
		Passageiro passageiro15 = new Passageiro("Felipe", push);
		voo5.adicionarObservador(passageiro9);
		voo5.adicionarObservador(passageiro10);
		voo5.adicionarObservador(passageiro15);

		voo1.setStatusNotify(StatusVoo.PROGRAMADO);
		voo2.setStatusNotify(StatusVoo.CANCELADO);
		voo3.setStatusNotify(StatusVoo.CONFIRMADO);
		voo4.setStatusNotify(StatusVoo.MUDANCA_PORTAO);
		voo5.setStatusNotify(StatusVoo.ATRASADO);

	}}


