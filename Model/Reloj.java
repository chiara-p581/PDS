import java.time.Duration;
import java.time.LocalDateTime;

public class Reloj extends Sujeto {
    private LocalDateTime ultimaFechaActualizacion;

    public Reloj() {
        this.ultimaFechaActualizacion = LocalDateTime.now();
    }

    public void verificarHora() {
        new Thread(() -> {
            while (true) {
                LocalDateTime fechaActual = LocalDateTime.now();
                Duration duration = Duration.between(fechaActual, Reloj.this.ultimaFechaActualizacion);
                long diff = Math.abs(duration.toSeconds());
                if (diff >= 5) {
                    Reloj.this.ultimaFechaActualizacion = fechaActual;
                    notificar(fechaActual);
                }
            }
        }).run();
    }
}

 