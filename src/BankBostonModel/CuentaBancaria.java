/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;



/**
 *
 * @author Cristian
 */
public abstract class CuentaBancaria {

    // Clase abstracta base
    protected String numeroCuenta;
    protected double saldo;
// Constructor completo (sobrecarga) se usa para la cuenta de credito la cual se establece un monto de credito inicial.
    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
// Constructor con solo numero de cuenta se asume un valor inicial de 0 en su cuenta.
    public CuentaBancaria(String numeroCuenta) {
        this(numeroCuenta, 0.0);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

//Metodos abstracto que se reemplaza en cada tipo de cuenta
    public abstract void depositar(double monto);

    public abstract void girar(double monto);

   

}
