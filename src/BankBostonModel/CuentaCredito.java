/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

/**
 *
 * @author Cristian
 */
public class CuentaCredito extends CuentaBancaria{
    private static final double limiteCredito = 1000000;
    
    public CuentaCredito(String numeroCuenta) {
        super(numeroCuenta,limiteCredito);
    }

    @Override
    public void girar(double monto) {
        if(monto<=saldo){
            saldo -=monto;
            System.out.println("Giro desde Cuenta de Credito: $"+monto);
        }else{
            System.out.println("Saldo insuficiente en Cuenta de Credito.");
        }
    }
    
    @Override
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito realizado en Cuenta de Credito: $" + monto);
    }
}
