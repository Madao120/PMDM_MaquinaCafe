package org.example

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object HaciendoCafe : CoffeeMachineState()
    object Pagando : CoffeeMachineState()
    object RestoPago : CoffeeMachineState()
    data class SirviendoCafe(val brand: String):CoffeeMachineState()
    data class Error(val message: String) : CoffeeMachineState()
}