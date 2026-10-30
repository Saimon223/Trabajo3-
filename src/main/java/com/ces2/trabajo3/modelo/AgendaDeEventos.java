package com.ces2.trabajo3.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class AgendaDeEventos {

    private String nombre;
    private String responsable;
    private EnumEvento tipo;
    private Categoria categoria;
    private Deque<Evento> eventos = new ArrayDeque<>();  // guarda objetos Evento

    public AgendaDeEventos() {
    }

    public AgendaDeEventos(String nombre, String responsable, EnumEvento tipo, Categoria categoria) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void agregarEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
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

    public Deque<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Deque<Evento> eventos) {
        this.eventos = eventos;
    }
}