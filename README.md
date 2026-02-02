
# Laboratorio 1 - Arquitectura de Software 2026-1

## Descripción

Este laboratorio tiene como objetivo practicar los temas aprendidos en las clases teóricas, incluyendo concurrencia, threads y buenas prácticas en Java. Se implementan soluciones que involucran validación de listas negras, procesamiento concurrente y cálculos matemáticos con múltiples hilos.

## Contenido del Proyecto

- **HostBlackListsValidator**: Validador de direcciones IP contra listas negras con procesamiento multihilo
- **CountThread/CountThreadsMain**: Ejemplo de uso de threads para conteo concurrente
- **HostBlacklistsDataSourceFacade**: Fachada para acceder a fuentes de datos de listas negras
- **PiCalcTest**: Pruebas unitarias para validar la funcionalidad del sistema

## Requisitos Previos

- **Java 8 o superior**
- **Maven 3.6+**

## Instalación

1. Clonar o descargar el proyecto
2. Navegar al directorio del proyecto
3. Construir el proyecto:
   ```bash
   mvn clean install
   ```

## Ejecución

Para compilar y ejecutar el proyecto:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="edu.eci.arsw.blacklistvalidator.Main"
```

## Pruebas

Ejecutar las pruebas unitarias:

```bash
mvn test
```

Para ejecutar una prueba específica:

```bash
mvn test -Dtest=PiCalcTest
```

## Construido con

* **Java 8+** - Lenguaje de programación
* **Maven** - Gestión de dependencias y construcción del proyecto
* **JUnit** - Framework para pruebas unitarias

## Autores

- **Daniel Patiño Mejia** - [github.com/daniel-pm19](https://github.com/daniel-pm19)
- **Nestor David Lopez Castañeda** - [github.com/nestorlop](https://github.com/nestorlop)

## Licencia

Este proyecto está bajo la licencia MIT - ver el archivo [LICENSE](LICENSE.md) para más detalles