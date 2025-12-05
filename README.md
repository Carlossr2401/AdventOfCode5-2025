# Advent of Code 2025 - Día 5: Inventory Management System

Este repositorio contiene la solución para el Día 5 del Advent of Code 2025, implementada en Java. El problema se centra en gestionar un sistema de inventario de ingredientes, determinando cuáles son frescos basándose en rangos de IDs.

## Descripción del Problema

### Parte 1

El objetivo es determinar cuántos de los IDs de ingredientes disponibles son "frescos". Un ID se considera fresco si cae dentro de cualquiera de los rangos de IDs frescos proporcionados en la base de datos.

### Parte 2

El objetivo cambia a calcular el número total de IDs únicos que son considerados frescos por la unión de todos los rangos de IDs frescos, ignorando la lista de IDs disponibles.

## Estructura del Proyecto

El código está organizado en dos paquetes principales dentro de `src/main/java/software/aoc/day05`, correspondiendo a cada parte del problema:

- **`a`**: Contiene la solución para la Parte 1.
- **`b`**: Contiene la solución para la Parte 2.

Esta separación permite mantener independientes las lógicas de cada parte, aunque compartan conceptos similares.

## Principios de Diseño Aplicados

Para asegurar un código limpio, mantenible y escalable, se han aplicado rigurosamente principios de ingeniería de software, destacando la **Modularidad** y el **Principio de Responsabilidad Única (SRP)**.

### 1. Modularidad

El proyecto no es un único script monolítico. En su lugar, la funcionalidad se ha dividido en clases pequeñas y enfocadas, cada una con un propósito claro. Esto facilita la lectura, el testeo y la reutilización del código.

- **Paquetes separados (`a` y `b`)**: Permiten evolucionar la solución de la Parte 2 sin romper o modificar innecesariamente la lógica de la Parte 1.
- **Clases especializadas**: Se han creado clases específicas para lectura de archivos, representación de datos y lógica de negocio.

### 2. Principio de Responsabilidad Única (SRP)

Cada clase tiene una única razón para cambiar, encargándose de una sola parte del proceso:

- **`FileInstructionReader`**:

  - **Responsabilidad**: Su única tarea es leer el archivo de entrada y parsear su contenido. No sabe nada sobre cómo verificar rangos o calcular totales; solo entrega los datos estructurados (`FileOutput`).
  - **Beneficio**: Si cambia el formato del archivo de entrada, solo necesitamos modificar esta clase.

- **`Rank` (Range)**:

  - **Responsabilidad**: Actúa como un modelo de datos (Record) que representa un rango de IDs (inicio y fin). Incluye la lógica básica para saber si un valor individual está dentro de ese rango específico (`withinTheRange`).
  - **Beneficio**: Encapsula la definición de lo que es un rango.

- **`RankVerification`**:

  - **Responsabilidad**: Contiene la lógica de negocio principal.
    - En la **Parte 1**, verifica si un ID dado cae en _cualquiera_ de los rangos de la lista.
    - En la **Parte 2**, maneja la lógica compleja de fusionar rangos superpuestos (`mergeRanges`) y calcular el total de IDs cubiertos (`calculateTotalFreshIds`).
  - **Beneficio**: Separa las reglas de negocio de la lectura de datos y de la ejecución principal.

- **`Main`**:

  - **Responsabilidad**: Es el punto de entrada. Orquesta la ejecución: llama al lector, invoca la verificación y muestra el resultado.
  - **Beneficio**: Mantiene el flujo de alto nivel claro y separado de los detalles de implementación.

- **`FileOutput`**:
  - **Responsabilidad**: Es un DTO (Data Transfer Object) simple para transportar los datos leídos (rangos e IDs) desde el lector hasta el programa principal.
