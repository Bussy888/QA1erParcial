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

    public Aerolinea() {
        disponibilidadPasajes.put("La Paz", 5);
        disponibilidadPasajes.put("Cochabamaba",10);
        disponibilidadPasajes.put("Santa Cruz",8);
    }

    public String getDay(int dia, int mes, int gestion) {
        // Convierte la fecha dada al día de la semana
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = dateFormat.parse(String.format("%02d.%02d.%d", dia, mes, gestion));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String[] daysOfWeek = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
            return daysOfWeek[dayOfWeek];
        } catch (Exception e) {
            e.printStackTrace();
            return "Día inválido";
        }
    }

    public String obtenerNombreMes(int mes) {
        // Convierte el número de mes al nombre del mes
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        if (mes >= 1 && mes <= 12) {
            return meses[mes - 1];
        } else {
            return "Mes inválido";
        }
    }

    public String reservaVuelo(String destino, int dia, int mes, int gestion, int cantidad) {
        // Convierte el mes de tipo int a String
        String nombreMes = obtenerNombreMes(mes);

        // Verifica si existen suficientes pasajes
        if (existenpasajes(destino, cantidad)) {
            // Obtiene el día de la semana
            String diaSemana = getDay(dia, mes, gestion);

            // Construye el mensaje de reserva exitosa
            return "El dia " + diaSemana + " " + dia + " " + nombreMes + " " + gestion + " existen " + cantidad + " pasajes para " + destino;
        } else {
            // Construye el mensaje de reserva fallida
            return "No existen suficientes pasajes para " + destino;
        }
    }

    public static void main(String[] args) {
        Aerolinea aerolinea = new Aerolinea();
        String mensajeReserva = aerolinea.reservaVuelo("La Paz", 29, 5, 2023, 2);
        System.out.println(mensajeReserva);
    }
}
