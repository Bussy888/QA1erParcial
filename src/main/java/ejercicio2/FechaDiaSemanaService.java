package ejercicio2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaDiaSemanaService {
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
        } catch (ParseException e) {
            e.printStackTrace();
            return "Día inválido";
        }
    }
}
