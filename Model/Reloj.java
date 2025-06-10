import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reloj extends Sujeto {
    private LocalTime ultimaFechaActualizacion;

    public Reloj() {
        this.ultimaFechaActualizacion = LocalTime.now();
    }

    public void verificarHora() {
        new Thread(() -> {
            while (true) {
                LocalTime fechaActual = LocalTime.now();
                Duration duration = Duration.between(fechaActual, Reloj.this.ultimaFechaActualizacion);
                long diff = Math.abs(duration.toSeconds());
                if (diff >= 1) {
                    Reloj.this.ultimaFechaActualizacion = LocalTime.from(fechaActual);
                    notificar(fechaActual);
                }
            }
        }).run();
    }
}
 