package ejercicio2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Aerolinea {
    private Map<String, Integer> disponibilidadPasajes = new HashMap<>();
    public boolean existenpasajes(String destino, int cantidad){
        int pasajesDisponibles = disponibilidadPasajes.getOrDefault(destino, 0);
        return pasajesDisponibles >= cantidad;
    }

    public Aerolinea(Map<String, Integer> disponibilidadPasajes) {
        disponibilidadPasajes.put("La Paz", 5);
        disponibilidadPasajes.put("Cochabamaba",10);
        disponibilidadPasajes.put("Santa Cruz",8);
    }

    public String getDay(int dia, int mes, int gestion){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = dateFormat.parse(String.format("%02d.%02d.%d", dia,mes,gestion));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        }
    }

}
