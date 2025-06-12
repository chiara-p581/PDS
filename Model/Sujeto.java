import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observer> observers = new ArrayList<>();

    public void agregarObserver(Observer o) {
        this.observers.add(o);
    }

    public void notificar(LocalTime hora) {
        for(Observer o: observers) {
            o.actualizarHora(hora);
        }
    }
}