package com.ces2.trabajo3.repositories;

import com.ces2.trabajo3.modelo.AgendaDeEventos;
import com.ces2.trabajo3.modelo.Evento;

import java.util.Stack;

// Aquí se crean los datos (así no hay nada en el main).
public class EventoRepository {

    // TODO (Punto 1): crear 5 objetos Evento, todos con el MISMO EnumEvento y la MISMA Categoria,
    //                 y agregarle varios enteros al Stack conteo de cada uno.
    public Stack<Evento> getEventos() {
        Stack<Evento> eventos = new Stack<>();
        return eventos;
    }

    // TODO (Punto 1): crear el objeto AgendaDeEventos (con los mismos dos enum de los 5 eventos)
    //                 y agregarle los 5 eventos usando su método agregarEvento.
    public AgendaDeEventos getAgenda() {
        return new AgendaDeEventos();
    }
}
