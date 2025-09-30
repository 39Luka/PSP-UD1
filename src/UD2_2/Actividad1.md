1.¿Qué es visibilidad entre hilos? Pon un ejemplo.
Es la garantía de que cuando un hilo modifica una variable compartida, los demás hilos ven el valor actualizado y no una copia antigua en caché.
Ejemplo: un hilo cambia stop = true, pero otro hilo sigue leyendo false porque no hay garantía de visibilidad.

2.¿En qué se diferencia visibilidad de atomicidad?
Visibilidad: todos los hilos ven el mismo valor actualizado.
Atomicidad: una operación no se interrumpe a medias; se ejecuta completamente o no se ejecuta.

3.¿Qué garantiza volatile y qué no garantiza?
Garantiza visibilidad de los cambios entre hilos.
No garantiza atomicidad en operaciones compuestas (ej. contador++).

4.¿Para qué sirven AtomicInteger y AtomicReference?
Son clases que permiten realizar operaciones atómicas sobre enteros (AtomicInteger) o referencias a objetos (AtomicReference) sin necesidad de usar sincronización explícita.

5.¿Por qué la inmutabilidad reduce o elimina condiciones de carrera?
Porque un objeto inmutable no puede modificarse después de crearse. Si los hilos solo leen datos que nunca cambian, no hay riesgo de que se produzcan escrituras concurrentes inconsistentes.