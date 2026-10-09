package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("--- Encendiendo la máquina ---")
    CoffeeMachine.gestorEstados()

    println("\n--- Intentando hacer café de nuevo ---")
    CoffeeMachine.gestorEstados()

    println("\n--- Limpiando la máquina ---")
    CoffeeMachine.reparando()

    println("\n--- Y ahora, otro café ---")
    CoffeeMachine.gestorEstados()
}