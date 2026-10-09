package org.example

object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                println("Máquina encendida. Empezando a hacer café...")
                currentState = CoffeeMachineState.HaciendoCafe
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.SirviendoCafe("Café con Leche")
                println("¡Café listo! Estado: $currentState")
            }
            is CoffeeMachineState.HaciendoCafe -> {
                println("La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.SirviendoCafe -> {
                println("Ya hay café servido. Por favor, toma tu café.")
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle
        println("Máquina limpia. Estado: $currentState")
    }
}