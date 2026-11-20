# Diseño y Validación de API REST

El sistema de gestión de préstamos de un banco requiere un recurso REST para gestionar solicitudes de préstamos. El recurso debe validar la entrada del cliente y devolver códigos de estado correctos y respuestas de error uniformes. El sistema actualmente devuelve un error 500 en casos de validación fallida del cliente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño de APIs REST con validación de entrada |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** Spring Boot 3.5
- **Version:** Java 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Definición del Recurso REST

**Objetivo:** Definir y exponer un recurso REST para gestionar solicitudes de préstamos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los campos requeridos para una solicitud de préstamo.
- Definir el recurso REST y sus endpoints.
- Asegurar que el recurso devuelva códigos de estado HTTP correctos.

**Entregable:** Descripción del recurso REST y sus endpoints, incluyendo los campos requeridos y los códigos de estado HTTP.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los diferentes métodos HTTP y su uso apropiado.
- Piensa en la estructura de la URL y cómo reflejará la jerarquía de recursos.

</details>

### Fase 2: Implementación de Validación Declarativa

**Objetivo:** Implementar validación declarativa en el recurso REST para asegurar la integridad de la entrada del cliente.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Aplicar validaciones declarativas en los campos del recurso REST.
- Asegurar que el recurso devuelva respuestas de error uniformes en caso de validación fallida.
- Corregir el comportamiento actual que devuelve un error 500 en casos de validación fallida del cliente.

**Entregable:** Recurso REST con validaciones declarativas implementadas y respuestas de error uniformes.

<details>
<summary>Pistas de conocimiento</summary>

- Explora las anotaciones de validación disponibles en el marco de trabajo del lenguaje principal.
- Considera cómo manejar diferentes tipos de errores de validación.

</details>

### Fase 3: Pruebas de Controlador

**Objetivo:** Cubrir el recurso REST con pruebas de controlador para asegurar su funcionamiento correcto.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribir pruebas unitarias para el controlador del recurso REST.
- Asegurar que las pruebas cubren casos de éxito y de error.
- Verificar que el recurso devuelve los códigos de estado y mensajes de error correctos en todos los casos.

**Entregable:** Conjunto de pruebas unitarias para el controlador del recurso REST, cubriendo casos de éxito y de error.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el marco de trabajo de pruebas del lenguaje principal para escribir las pruebas.
- Considera cómo simular diferentes escenarios de entrada para probar el comportamiento del recurso.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un recurso REST y cuáles son sus componentes principales?
- **paraQueSirve**: ¿Para qué sirve la validación declarativa en un recurso REST?
- **comoSeUsa**: ¿Cómo se implementa la validación declarativa en un recurso REST usando el marco de trabajo del lenguaje principal?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar validaciones en un recurso REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño de un recurso REST con validaciones y pruebas de controlador?

## Criterios de Evaluacion

- Definición clara y correcta del recurso REST y sus endpoints.
- Implementación de validaciones declarativas en el recurso REST.
- Respuestas de error uniformes en casos de validación fallida.
- Corrección del comportamiento que devuelve un error 500 en casos de validación fallida del cliente.
- Pruebas unitarias completas y efectivas para el controlador del recurso REST.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Definición del Recurso REST | Definición de casos de uso para préstamos | `src/main/java/application/service/LoanService.java:LoanService` | El recurso REST expone los endpoints para crear y consultar préstamos con los campos definidos.; Los códigos de estado HTTP son correctos para cada operación.; La estructura de la respuesta incluye los campos requeridos y errores uniformes. | — | — |
| f1 — Definición del Recurso REST | Exposición de endpoints REST con códigos de estado correctos | `src/main/java/infrastructure/controller/LoanController.java:LoanController` | El recurso REST expone los endpoints para crear y consultar préstamos con los campos definidos.; Los códigos de estado HTTP son correctos para cada operación.; La estructura de la respuesta incluye los campos requeridos y errores uniformes. | — | — |
| f2 — Implementación de Validación Declarativa | Validación declarativa de reglas de negocio | `src/main/java/application/service/LoanValidationService.java:LoanValidationService` | Las validaciones declarativas están aplicadas a los campos del recurso.; Los errores de validación devuelven códigos de estado HTTP 400 con mensajes uniformes.; El controlador maneja correctamente los errores de validación sin devolver 500. | — | — |
| f2 — Implementación de Validación Declarativa | Mapeo de excepciones a respuestas de error uniformes | `src/main/java/infrastructure/exception/GlobalExceptionHandler.java:GlobalExceptionHandler` | Las validaciones declarativas están aplicadas a los campos del recurso.; Los errores de validación devuelven códigos de estado HTTP 400 con mensajes uniformes.; El controlador maneja correctamente los errores de validación sin devolver 500. | — | — |
| f3 — Pruebas de Controlador | Construcción de datos de prueba para casos de borde | `src/main/java/application/service/LoanTestDataBuilder.java:LoanTestDataBuilder` | Las pruebas cubren todos los endpoints del recurso con casos de éxito y error.; Las pruebas validan los códigos de estado HTTP y la estructura de las respuestas.; Las pruebas aíslan el controlador de dependencias externas. | — | — |
| f3 — Pruebas de Controlador | Pruebas de integración para controladores REST | `src/main/java/infrastructure/controller/LoanController.java:LoanControllerTest` | Las pruebas cubren todos los endpoints del recurso con casos de éxito y error.; Las pruebas validan los códigos de estado HTTP y la estructura de las respuestas.; Las pruebas aíslan el controlador de dependencias externas. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Conoce Spring pero devuelve 500 en errores de validación del cliente | `src/main/java/infrastructure/controller/LoanController.java:LoanController` | Verificada |
| Conoce Spring pero devuelve 500 en errores de validación del cliente | `src/test/java/acceptance/f1/AcceptanceTest.java` > shouldReturn400WhenLoanRequestIsInvalid | Restriccion no verificada en `src/test/java/acceptance/f1/AcceptanceTest.java` > shouldReturn400WhenLoanRequestIsInvalid |
| Conoce Spring pero devuelve 500 en errores de validación del cliente | chequeo estatico (code): exige `400`, `@Valid`; prohibe `500` | Restriccion no verificada en chequeo estatico (code): exige `400`, `@Valid`; prohibe `500` |

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
