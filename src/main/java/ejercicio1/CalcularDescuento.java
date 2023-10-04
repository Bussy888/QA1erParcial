package ejercicio1;

public class CalcularDescuento {
    private ServiceCalc serviceCalc;

    public  int calcularDescuento(double salario) throws Exception {
        double salarioBasico = 2000;

        if (salario <= salarioBasico) {
            return (int) salario; // No hay descuento
        } else if (salario <= salarioBasico * 2) {
            return (int) (salario - (salario * 0.05)); // Descuento del 5%
        } else if (salario > (salarioBasico * 2)) {
            return (int) (salario - (salario * 0.15)); // Descuento del 15%
        } else {
            throw new Exception("Salario no válido");
        }
    }
    public static int calcularDescuentoStatic(double salario) throws Exception {
        double salarioBasico = 2000;

        if (salario <= salarioBasico) {
            return 0; // No hay descuento
        } else if (salario <= salarioBasico * 2) {
            return (int) (salario - (salario * 0.05)); // Descuento del 5%
        } else if (salario > (salarioBasico * 2)) {
            return (int) (salario - (salario * 0.15)); // Descuento del 15%
        } else {
            throw new Exception("Salario no válido");
        }
    }

    public  void main(String[] args) {
        try {
            double salario = 2500; // Reemplaza con el salario que desees verificar
            double descuento = calcularDescuento(salario);
            System.out.println("El descuento aplicado es: " + descuento);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public ServiceCalc getServiceCalc() {
        return serviceCalc;
    }

    public void setServiceCalc(ServiceCalc serviceCalc) {
        this.serviceCalc = serviceCalc;
    }
}
