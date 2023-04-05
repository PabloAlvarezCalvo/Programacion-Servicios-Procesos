# Programacion de Servicios y Procesos
___
La asignatura de _Programación de servicios y procesos_ recoge los fundamentos de la creación y gestión de procesos, la programación multihilo, así como la programación de comunicaciones y servicios en red.

Los programas contenidos se desarrollarán sobre lenguaje Java, distribuídos en paquetes correspondientes a las diferentes unidades didácticas del curso.

## [UD01 - Programación de procesos](src/ud01)
Durante la primera unidad didáctica se desarrolla la programación de procesos capaces de generar subprocesos mediante la clase [ProcessBuilder](https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html).

Cada paquete contiene un ejercicio o ejemplo con el código del proceso padre y el subproceso hijo, así como los archivos necesarios, de haberlos.

En los ejercicios se utilizará la entrada estándar por teclado para la introducción de parámetros, o bien se leerán cadenas de texto desde ficheros mediante el uso de pipes. En el ejercicio [Ej8_Palindromo](src/ud01/ejercicios/ej8_Palindromo) pueden verse ambas opciones de funcionamiento.

## [UD02 - Programación de hilos](src/ud02)
En esta unidad didáctica se ve la programación multihilo, generando hilos mediante implementación de la [interfaz Runnable](https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html), o mediante herencia de la [clase Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html).

## [UD03 - Programación de comunicaciones en red](src/ud03)

## [UD04 - Generación de servicios en red](src/ud04)

## [UD05 - Técnicas de programación segura](src/ud05)