package com.ces2.trabajo3.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Evento {

    private String nombre;
    private String lugar;
    private int numeroInvitados;
    private EnumEvento tipo;
    private Categoria categoria;
    private Stack<Integer> conteo = new Stack<>();

    public Evento() {
    }

    public Evento(String nombre, String lugar, int numeroInvitados, EnumEvento tipo, Categoria categoria) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.numeroInvitados = numeroInvitados;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void agregarConteo(int dato) {
        this.conteo.push(dato);
    }

    public int verTotales(Function<Evento, Integer> funcion) {
        return funcion.apply(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getNumeroInvitados() {
        return numeroInvitados;
    }

    public void setNumeroInvitados(int numeroInvitados) {
        this.numeroInvitados = numeroInvitados;
    }

    public EnumEvento getTipo() {
        return tipo;
    }

    public void setTipo(EnumEvento tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + " | Lugar: " + lugar + " | Invitados: " + numeroInvitados +
                " | Tipo: " + tipo + " | Categoría: " + categoria + " | Stack Conteo: " + conteo;
    }
}