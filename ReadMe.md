# Diagrama de estados de la máquina de café

El estado inicial de la máquina es `Idle`. El diagrama incluye el flujo
principal y las rutas alternativas según la disponibilidad del producto y el
resultado del pago.

```mermaid
stateDiagram-v2
    state "Idle" as Idle
    state "Selección" as Seleccion
    state "No tipo disponible" as NoTipoDisponible
    state "Pago" as Pago
    state "Devolver dinero" as DevolverDinero
    state "Devolver resto" as DevolverResto
    state "Haciendo café" as HaciendoCafe
    state "Servir café" as ServirCafe

    [*] --> Idle

    Idle --> Seleccion : usuario selecciona una opción

    Seleccion --> NoTipoDisponible : producto no disponible
    NoTipoDisponible --> Seleccion : aviso mostrado / elegir otra opción
    Seleccion --> Pago : producto disponible y seleccionado

    Pago --> DevolverDinero : error en el pago
    DevolverDinero --> Seleccion : dinero devuelto
    Pago --> DevolverResto : importe introducido > precio
    DevolverResto --> HaciendoCafe : resto devuelto
    Pago --> HaciendoCafe : importe exacto

    HaciendoCafe --> ServirCafe : café preparado
    ServirCafe --> Idle : operación finalizada
```

El flujo principal es:

`Idle → Selección → Pago → Haciendo café → Servir café → Idle`

Los flujos alternativos son:

- `Selección → No tipo disponible → Selección`
- `Pago → Devolver dinero → Selección`
- `Pago → Devolver resto → Haciendo café`