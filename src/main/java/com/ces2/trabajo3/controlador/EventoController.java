package com.ces2.trabajo3.controlador;

import com.ces2.trabajo3.modelo.AgendaDeEventos;
import com.ces2.trabajo3.modelo.Categoria;
import com.ces2.trabajo3.modelo.EnumEvento;
import com.ces2.trabajo3.modelo.Evento;
import com.ces2.trabajo3.repositories.EventoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;

@Controller
public class EventoController {

    private EventoRepository repository = new EventoRepository();

    private Map<String, Object> crearEstructuraBase() {
        EnumEvento tipoComun = EnumEvento.CONCIERTO;
        Categoria categoriaComun = Categoria.CULTURAL;

        Evento e1 = new Evento("Rock Fest", "Estadio", 500, tipoComun, categoriaComun);
        e1.agregarConteo(10); e1.agregarConteo(20);

        Evento e2 = new Evento("Jazz Night", "Teatro", 150, tipoComun, categoriaComun);
        e2.agregarConteo(5); e2.agregarConteo(15); e2.agregarConteo(25);

        Evento e3 = new Evento("Pop Live", "Arena", 300, tipoComun, categoriaComun);
        e3.agregarConteo(30);

        Evento e4 = new Evento("Salsa Beat", "Club", 200, tipoComun, categoriaComun);
        e4.agregarConteo(12); e4.agregarConteo(8);

        Evento e5 = new Evento("Indie Session", "Parque", 100, tipoComun, categoriaComun);
        e5.agregarConteo(50); e5.agregarConteo(100);

        Stack<Evento> stackEventos = new Stack<>();
        stackEventos.push(e1);
        stackEventos.push(e2);
        stackEventos.push(e3);
        stackEventos.push(e4);
        stackEventos.push(e5);

        AgendaDeEventos agenda = new AgendaDeEventos("Agenda Cultural", "Carlos Pérez", tipoComun, categoriaComun);
        for (Evento e : stackEventos) {
            agenda.agregarEvento(e);
        }

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("stack", stackEventos);
        resultado.put("agenda", agenda);
        return resultado;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/vista1")
    public String punto1(Model model) {
        List<String> lineas = new ArrayList<>();
        Map<String, Object> base = crearEstructuraBase();
        Stack<Evento> stack = (Stack<Evento>) base.get("stack");
        AgendaDeEventos agenda = (AgendaDeEventos) base.get("agenda");

        for (Evento e : stack) {
            lineas.add(e.toString());
        }

        lineas.add("Agenda: " + agenda.getNombre() + " | Responsable: " + agenda.getResponsable() +
                " | Tipo: " + agenda.getTipo() + " | Categoría: " + agenda.getCategoria());
        lineas.add("Total elementos en Deque: " + agenda.getEventos().size());

        model.addAttribute("titulo", "Punto 1: objetos creados");
        model.addAttribute("lineas", lineas);
        return "vista1";
    }

    @GetMapping("/vista2")
    public String punto2(Model model) {
        List<String> lineas = new ArrayList<>();
        Map<String, Object> base = crearEstructuraBase();
        Stack<Evento> stack = (Stack<Evento>) base.get("stack");
        AgendaDeEventos agenda = (AgendaDeEventos) base.get("agenda");

        ListIterator<Evento> listIterator = stack.listIterator();
        while (listIterator.hasNext()) {
            Evento e = listIterator.next();
            lineas.add("Evento: " + e.getNombre() + " | Tipo: " + e.getTipo() + " | Categoría: " + e.getCategoria() + " | Conteo: " + e.getConteo());
        }

        Iterator<Evento> iterator = agenda.getEventos().iterator();
        while (iterator.hasNext()) {
            Evento e = iterator.next();
            lineas.add("Evento: " + e.getNombre() + " | Tipo: " + e.getTipo() + " | Categoría: " + e.getCategoria() + " | Conteo: " + e.getConteo());
        }

        // Título de la página no tan técnico
        model.addAttribute("titulo", "Punto 2: Visualización de Eventos");
        model.addAttribute("lineas", lineas);
        return "vista2";
    }

    @GetMapping("/vista3")
    public String punto3(Model model) {
        List<String> lineas = new ArrayList<>();
        Map<String, Object> base = crearEstructuraBase();
        AgendaDeEventos agenda = (AgendaDeEventos) base.get("agenda");

        Deque<Evento> dequeAgenda = agenda.getEventos();

        EnumEvento enumBuscado = EnumEvento.CONCIERTO;

        dequeAgenda.stream()
                .filter(e -> e.getTipo() == enumBuscado)
                .forEach(e -> lineas.add(e.toString()));

        model.addAttribute("titulo", "Punto 3: programación funcional");
        model.addAttribute("lineas", lineas);
        return "vista3";
    }

    @GetMapping("/vista4")
    public String punto4(Model model) {
        List<String> lineas = new ArrayList<>();

        Evento e = new Evento("Rock Fest", "Estadio", 500, EnumEvento.CONCIERTO, Categoria.CULTURAL);
        e.agregarConteo(10);
        e.agregarConteo(25);
        e.agregarConteo(35);

        Function<Evento, Integer> funcionSuma = evento -> evento.getConteo().stream().mapToInt(Integer::intValue).sum();

        int totalSuma = funcionSuma.apply(e);

        lineas.add("Evento procesado: " + e.getNombre());
        lineas.add("Datos en el Stack conteo: " + e.getConteo());
        lineas.add("Resultado devuelto por Function<Evento, Integer>: " + totalSuma);

        model.addAttribute("titulo", "Punto 4: Total Datos Del Evento");
        model.addAttribute("lineas", lineas);
        return "vista4";
    }

    @GetMapping("/vista5")
    public String punto5(Model model) {
        List<String> lineas = new ArrayList<>();

        Evento e = new Evento("Festival de Teatro", "Plaza Principal", 800, EnumEvento.CONCIERTO, Categoria.CULTURAL);
        e.agregarConteo(40);
        e.agregarConteo(60);
        e.agregarConteo(100);

        Function<Evento, Integer> funcionSuma = evento -> evento.getConteo().stream().mapToInt(Integer::intValue).sum();

        int total = e.verTotales(funcionSuma);

        lineas.add(e.getNombre());
        lineas.add("Stack de enteros: " + e.getConteo());
        lineas.add("Total calculado por verTotales: " + total);

        model.addAttribute("titulo", "Punto 5: verTotales");
        model.addAttribute("lineas", lineas);
        return "vista5";
    }
}