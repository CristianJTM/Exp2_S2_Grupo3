/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankbostonapp;

/**
 *
 * @author Cristian
 */
import java.util.Scanner;
import BankBostonModel.Cliente;
import java.util.ArrayList;
import java.util.Random;

public class BankBostonApp {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {
        // TODO code application logic here
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        //Clientes de Prueba
        //clientes.add(new Cliente("11.111.111-1", "Juan", "Perez", "Gomez", "Calle falsa 123", "Temuco", 123456789));
        //clientes.add(new Cliente("22.222.222-2", "Juan", "Perez", "Gomez", "Calle falsa 123", "Temuco", 123456789));
        int opcion;
        do {
            System.out.println("Bienvenido a Bank Boston");
            System.out.println("Menu Principal");
            System.out.println("1.-Registrar Cliente");
            System.out.println("2.-Iniciar Sesion Cliente");
            System.out.println("3.-Salir");
            opcion = valorValido(1, 3);

            switch (opcion) {
                case 1: {
                    String rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna;
                    do {
                        System.out.print("RUT (Ej:11.111.111-1): ");
                        rut = scanner.nextLine().trim();
                        if (rut.length() < 11 || rut.length() > 12) {
                            System.out.println("RUT invalido. Debe tener entre 11 y 12 caracteres incluyendo puntos y guion.");
                        }
                    } while (rut.length() < 11 || rut.length() > 12);
                    Cliente duplicado = buscarClienteRut(rut);
                    if (duplicado != null) {
                        System.out.println("El cliente ya tiene una cuenta contratada: " + duplicado.getCuenta().getNumeroCuenta());
                    } else {
                        nombre = textoNoVacio("Nombre: ");
                        apellidoPaterno = textoNoVacio("Apellido Paterno: ");
                        apellidoMaterno = textoNoVacio("Apellido Materno: ");
                        domicilio = textoNoVacio("Domicilio: ");
                        comuna = textoNoVacio("Comuna: ");
                        System.out.print("Telefono: ");
                        int telefono = valorValido(0, -1);
                        clientes.add(new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono));
                    }

                    break;
                }
                case 2: {
                    Cliente encontrado = buscarClienteCuenta();
                    if (encontrado != null) {
                        do {
                            System.out.println("Sesion Iniciada. N°Cuenta: " + encontrado.getCuenta().getNumeroCuenta());
                            System.out.println("1.-Ver datos del Cliente");
                            System.out.println("2.-Depositar");
                            System.out.println("3.-Girar");
                            System.out.println("4.-Consultar Saldo");
                            System.out.println("5.-Salir");
                            opcion = valorValido(1, 5);
                            switch (opcion) {
                                case 1:
                                    encontrado.mostrarDatos();
                                    break;
                                case 2: {
                                    int monto = 0;
                                    do {
                                        System.out.print("Ingrese el monto a depositar: ");
                                        monto = valorValido(1, -1);
                                    } while (monto <= 0);
                                    encontrado.getCuenta().depositar(monto);
                                    break;
                                }
                                case 3: {
                                    int monto = 0;
                                    if (encontrado.getCuenta().getSaldo() == 0) {
                                        System.out.println("No se puede realizar giros. Tiene un saldo de 0 pesos");
                                    } else {
                                        do {
                                            System.out.print("Ingrese el monto a girar: ");
                                            monto = valorValido(1, -1);
                                        } while (monto <= 0);
                                        encontrado.getCuenta().girar(monto);
                                    }
                                    break;
                                }
                                case 4:
                                    int saldo = encontrado.getCuenta().getSaldo();
                                    System.out.println("Saldo actual: " + saldo + " pesos.");
                                    break;
                                case 5:
                                    System.out.println("Sesion cerrada");
                                    break;
                            }

                        } while (opcion != 5);
                    } else {
                        System.out.println("El numero de cuenta no se encuentra registrado");
                    }

                    break;
                }
                case 3:
                    System.out.println("Gracias por su preferencia");
                    break;
            }
        } while (opcion != 3);
    }

    public static int valorValido(int min, int max) {
        int opcion;
        boolean valido = false;
        while (!valido) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (max < min) {
                    if (opcion >= min) {
                        valido = true;
                        return opcion;
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                } else {
                    if (opcion >= min && opcion <= max) {
                        valido = true;
                        return opcion;
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                }
            } else {
                System.out.println("Debe ingresar un número.");
                scanner.nextLine();
            }
        }
        return 0;
    }

    public static String textoNoVacio(String mensaje) {
        String texto;
        do{
            System.out.print(mensaje);
            texto=scanner.nextLine().trim();
            if(texto.isEmpty()){
                System.out.println("El campo no puede estar vacio.");
            }
        }while(texto.isEmpty());
        return texto;
    }

    public static Cliente buscarClienteCuenta() {
        int numeroCuenta;
        do {
            System.out.print("Numero de Cuenta (9 digitos): ");
            numeroCuenta = valorValido(100000000, 999999999);
        } while (numeroCuenta < 100000000 || numeroCuenta > 999999999);

        for (Cliente cliente : clientes) {
            if (cliente.getCuenta().getNumeroCuenta() == numeroCuenta) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente buscarClienteRut(String rut) {
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equalsIgnoreCase(rut)) {
                return cliente;
            }
        }
        return null;
    }
    

}
