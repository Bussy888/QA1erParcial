package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AerolineaTest {
    @ParameterizedTest
    @CsvSource({
            "La Paz, 29, 5, 2023, 2, 'El dia Martes 29 Mayo 2023 existen 2 pasajes para La Paz'",
            "Cochabamba, 2, 1, 2022, 15, 'No existen suficientes pasajes para Cochabamba'",
            "Sucre, 1, 1, 2023, 1, 'No existen suficientes pasajes para Sucre'",
            "Santa Cruz, 5, 12, 2012, 3, 'El dia Jueves 5 Diciembre 2012 existen 3 pasajes para Santa Cruz'"
    })
    public void testReservaVuelo(String destino, int dia, int mes, int gestion, int cantidad, String expectedOutput) {
        Aerolinea aerolinea = new Aerolinea();
        String actualOutput = aerolinea.reservaVuelo(destino, dia, mes, gestion, cantidad);
        assertEquals(expectedOutput, actualOutput);
    }

    DisponibilidadPasajesService disponibilidadService = mock(DisponibilidadPasajesService.class);

    // Crear un mock para el servicio de conversión de fecha a día de la semana
    FechaDiaSemanaService fechaService = mock(FechaDiaSemanaService.class);

    @Test
    public void testReservaVueloExistente() {
        when(disponibilidadService.existenPasajes("La Paz", 2)).thenReturn(true);
        when(fechaService.getDay(29, 5, 2023)).thenReturn("Lunes");

        Aerolinea aerolinea = new Aerolinea();
        String mensaje = aerolinea.reservaVuelo("La Paz", 29, 5, 2023, 2);

        assertEquals("El dia Martes 29 Mayo 2023 existen 2 pasajes para La Paz", mensaje);

        verify(disponibilidadService).existenPasajes("La Paz", 2);

        verify(fechaService).getDay(29, 5, 2023);
    }

    @Test
    public void testReservaVueloNoExistente() {
        when(disponibilidadService.existenPasajes("La Paz", 2)).thenReturn(false);

        Aerolinea aerolinea = new Aerolinea();
        String mensaje = aerolinea.reservaVuelo("La Paz", 29, 5, 2023, 2);

        assertEquals("No existen suficientes pasajes para La Paz", mensaje);

        verify(disponibilidadService).existenPasajes("La Paz", 2);
    }
}
