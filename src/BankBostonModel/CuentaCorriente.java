/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

/**
 *
 * @author Cristian
 */
public class CuentaCorriente extends CuentaBancaria{

    public CuentaCorriente(String numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void girar(double monto) {
        if(monto<=saldo){
            saldo -=monto;
            System.out.println("Giro desde Cuenta Corriente: $"+monto);
        }else{
            System.out.println("Saldo insuficiente en Cuenta Corriente.");
        }
    }
    
    @Override
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito realizado: $" + monto);
    }
}
