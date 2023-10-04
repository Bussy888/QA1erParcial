package ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;


public class CalcularDescuentoTest {
    @ParameterizedTest
    @CsvSource({
            "2000, 2000.0",          // Sueldo igual al salario básico
            "2500, 2375.0",      // (5% de descuento)
            "4000, 3400.0",      // (15% de descuento)
            "1500, '0.0'"  // Sueldo no válido
    })
    public void testCalcularDescuento(double salario, String expectedDescuento) {
        try {
            double actualDescuento = CalcularDescuento.calcularDescuentoStatic(salario);
            Assertions.assertEquals(expectedDescuento, actualDescuento);
        } catch (Exception e) {
            Assertions.assertEquals(expectedDescuento, "Valor Incorrecto");
        }
    }
    ServiceCalc serviceCalcMock = Mockito.mock(String.valueOf(CalcularDescuento.class));

    @Test
    public void verificarDescuento() throws Exception {
        // Configurar el comportamiento del mock para diferentes casos
        Mockito.when(serviceCalcMock.multiplicar(1, 1)).thenReturn(1);
        Mockito.when(serviceCalcMock.multiplicar(1, 2)).thenReturn(2);
        Mockito.when(serviceCalcMock.multiplicar(2, 3)).thenReturn(6);

        // Usar el objeto mockeado
        CalcularDescuento calculadora = new CalcularDescuento();
        calculadora.setServiceCalc(serviceCalcMock);

        double salario1 = 1500; // No se aplica descuento
        double salario2 = 2100; // 5% de descuento
        double salario3 = 4000; // 15% de descuento

        double descuento1 = calculadora.calcularDescuento(salario1);
        double descuento2 = calculadora.calcularDescuento(salario2);
        double descuento3 = calculadora.calcularDescuento(salario3);

        // Verificar que los cálculos de descuento son correctos
        Assertions.assertEquals(1500, descuento1, 0.001); // Tolerancia de 0.001 para números de punto flotante
        Assertions.assertEquals(1995, descuento2, 0.001);
        Assertions.assertEquals(3800, descuento3, 0.001);
    }

}















/*
    @Test
    public void testSueldoMenorOIgualAlBasico() {
        CalcularDescuento calculadora = new CalcularDescuento();
        try {
            int sueldo = calculadora.devDescuento(2000);
            assertEquals(2000, sueldo);
        } catch (Exception e) {
            fail("No se esperaba una excepción aquí");
        }
    }

    @Test
    public void testSueldoMayorAlBasico() {
        CalcularDescuento calculadora = new CalcularDescuento();
        try {
            CalcularDescuento calculadoraSpy = spy(calculadora);
            doReturn(2500).when(calculadoraSpy).devDescuento(2500);

            int sueldo = calculadoraSpy.devDescuento(2500);
            assertEquals(2375, sueldo); // 5% de descuento
        } catch (Exception e) {
            fail("No se esperaba una excepción aquí");
        }
    }

    @Test
    public void testSueldoMayorAlDobleDelBasico() {
        CalcularDescuento calculadora = new CalcularDescuento();
        try {
            CalcularDescuento calculadoraSpy = spy(calculadora);
            doReturn(5000).when(calculadoraSpy).devDescuento(5000);

            int sueldo = calculadoraSpy.devDescuento(5000);
            assertEquals(4250, sueldo); // 15% de descuento
        } catch (Exception e) {
            fail("No se esperaba una excepción aquí");
        }
    }

    @Test(expected = Exception.class)
    public void testSueldoInvalido() throws Exception {
        CalcularDescuento calculadora = new CalcularDescuento();
        calculadora.devDescuento(-1000); // Debería lanzar una excepción
    }
}*/