package com.example.jetcompanhiaaerea.model;


import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Aeronave {
    private String modelo;
    private int quantidadeAssentos;
    private List<Voo> voos; // Lista de voos associados a esta aeronave

    public Aeronave(String modelo, int quantidadeAssentos) {
        this.modelo = modelo;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    // Getters e Setters
    // ...

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    public String getModelo() {
        return modelo;
    }
    public void adicionarVoo(Voo voo) {
        if (voos.contains(voo)) {
            System.out.println("Este voo já está associado à aeronave.");
        } else {
            voos.add(voo);
            voo.setAeronave(this);
        }
    }

    public void removerVoo(Voo voo) {
        if (voos.contains(voo)) {
            voos.remove(voo);
            voo.setAeronave(null);
        } else {
            System.out.println("Este voo não está associado à aeronave.");
        }
    }

    public Integer getQuantidadeAssentos(){
        return this.quantidadeAssentos;
    }
}
