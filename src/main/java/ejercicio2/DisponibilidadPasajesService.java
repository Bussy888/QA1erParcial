package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class DisponibilidadPasajesService {
    private Map<String, Integer> disponibilidadPasajes = new HashMap<>();

    public DisponibilidadPasajesService() {
        disponibilidadPasajes.put("La Paz", 5);
        disponibilidadPasajes.put("Cochabamba", 10);
        disponibilidadPasajes.put("Santa Cruz", 8);
    }

    public boolean existenPasajes(String destino, int cantidad) {
        Integer pasajesDisponibles = disponibilidadPasajes.get(destino);
        return pasajesDisponibles != null && pasajesDisponibles >= cantidad;
    }
}
