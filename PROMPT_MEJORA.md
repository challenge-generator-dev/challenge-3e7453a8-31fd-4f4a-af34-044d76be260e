# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/application/service/LoanService.java` — La pieza p1 (Definición de casos de uso para préstamos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/controller/LoanController.java` — La pieza p2 (Exposición de endpoints REST con códigos de estado correctos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/service/LoanValidationService.java` — La pieza p3 (Validación declarativa de reglas de negocio, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/exception/GlobalExceptionHandler.java` — La pieza p4 (Mapeo de excepciones a respuestas de error uniformes, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/service/LoanTestDataBuilder.java` — La pieza p5 (Construcción de datos de prueba para casos de borde, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/domain/model/Loan.java` — absorbida: fuga de la pieza p3

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setId`: Se invoca `setId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setCustomerId`: Se invoca `setCustomerId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setAmount`: Se invoca `setAmount` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setInterestRate`: Se invoca `setInterestRate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setStartDate`: Se invoca `setStartDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setEndDate`: Se invoca `setEndDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.setStatus`: Se invoca `setStatus` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getId`: Se invoca `getId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getCustomerId`: Se invoca `getCustomerId` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getAmount`: Se invoca `getAmount` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getInterestRate`: Se invoca `getInterestRate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getStartDate`: Se invoca `getStartDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getEndDate`: Se invoca `getEndDate` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java` — `LoanEntity.getStatus`: Se invoca `getStatus` sobre `LoanEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Advanced L2

### Brecha de conocimiento
Expone recursos REST con validación declarativa de la entrada, códigos de estado correctos y respuestas de error uniformes.

### Reto
- Tema: Diseño de APIs REST con validación de entrada
- Seniority: advanced-l2
- Tipo: practical
- Título: Diseño y Validación de API REST
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del Recurso REST — objetivo: Definir y exponer un recurso REST para gestionar solicitudes de préstamos. — entregable (NO resolver): Descripción del recurso REST y sus endpoints, incluyendo los campos requeridos y los códigos de estado HTTP.
- Fase 2: Implementación de Validación Declarativa — objetivo: Implementar validación declarativa en el recurso REST para asegurar la integridad de la entrada del cliente. — entregable (NO resolver): Recurso REST con validaciones declarativas implementadas y respuestas de error uniformes.
- Fase 3: Pruebas de Controlador — objetivo: Cubrir el recurso REST con pruebas de controlador para asegurar su funcionamiento correcto. — entregable (NO resolver): Conjunto de pruebas unitarias para el controlador del recurso REST, cubriendo casos de éxito y de error.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/model/Loan.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

// Entidad de dominio que representa una solicitud de préstamo.
// No conoce persistencia ni transporte: solo reglas del negocio.
public record Loan(
    UUID id,
    String customerId,
    BigDecimal amount,
    BigDecimal interestRate,
    LocalDate startDate,
    LocalDate endDate,
    LoanStatus status
) {

    public enum LoanStatus {
        PENDING, APPROVED, REJECTED, ACTIVE, PAID
    }

    public Loan {
        if (id == null) {
            throw new IllegalArgumentException("Loan ID cannot be null");
        }
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (interestRate == null || interestRate.signum() < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    public BigDecimal calculateTotalPayment() {
      throw new UnsupportedOperationException("TODO(reto): calculateTotalPayment");
    }

    private BigDecimal interestForTerm() {
      throw new UnsupportedOperationException("TODO(reto): interestForTerm");
    }

    private long termInMonths() {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }
}

// === ARCHIVO: src/main/java/domain/port/LoanRepository.java ===
package domain.port;

import domain.model.Loan;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(UUID id);
    void deleteById(UUID id);
}

// === ARCHIVO: src/main/java/application/dto/CreateLoanRequest.java ===
package application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateLoanRequest(
    @NotNull(message = "Customer ID cannot be null")
    @Size(min = 1, message = "Customer ID cannot be empty")
    String customerId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotNull(message = "Interest rate cannot be null")
    @Positive(message = "Interest rate must be positive")
    BigDecimal interestRate,

    @NotNull(message = "Start date cannot be null")
    LocalDate startDate,

    @NotNull(message = "End date cannot be null")
    LocalDate endDate
) {
    public CreateLoanRequest {
        if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }
}

// === ARCHIVO: src/main/java/application/exception/ValidationError.java ===
package application.exception;

import java.util.List;

public record ValidationError(
    String message,
    List<FieldError> errors
) {
    public record FieldError(
        String field,
        String error
    ) {}
}

// === ARCHIVO: src/main/java/infrastructure/exception/ErrorResponse.java ===
package infrastructure.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path,
    List<ValidationDetail> details
) {
    public record ValidationDetail(
        String field,
        String message
    ) {}
}

// === ARCHIVO: src/main/java/application/service/LoanService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import domain.model.Loan;
import domain.port.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanValidationService validationService;

    public LoanService(LoanRepository loanRepository, LoanValidationService validationService) {
        this.loanRepository = loanRepository;
        this.validationService = validationService;
    }

    public Loan createLoan(CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): createLoan");
    }

    public Loan getLoan(String id) {
      throw new UnsupportedOperationException("TODO(reto): getLoan");
    }

    public static class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/infrastructure/controller/LoanController.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.controller;

import application.dto.CreateLoanRequest;
import application.service.LoanService;
import domain.model.Loan;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody @Valid CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): createLoan");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable String id) {
      throw new UnsupportedOperationException("TODO(reto): GetMapping");
    }
}

// === ARCHIVO: src/main/java/application/service/LoanValidationService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
// src/main/java/application/service/LoanValidationService.java
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import application.exception.ValidationError;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoanValidationService {

    private static final int MAX_TERM_MONTHS = 360;
    private static final BigDecimal MIN_AMOUNT = new BigDecimal("1000");
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("1000000");

    public void validate(CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): validate");
    }

    public static class ValidationException extends RuntimeException {
        private final List<ValidationError.FieldError> errors;

        public ValidationException(String message, List<ValidationError.FieldError> errors) {
            super(message);
            this.errors = errors;
        }

        public List<ValidationError.FieldError> getErrors() {
            return errors;
        }
    }
}

// === ARCHIVO: src/main/java/infrastructure/exception/GlobalExceptionHandler.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLoanNotFoundException(
            LoanNotFoundException ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    public static class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/application/service/LoanTestDataBuilder.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanTestDataBuilder {

    private static final String DEFAULT_CUSTOMER_ID = "CUST-001";
    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal("10000.00");
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal("0.05");
    private static final LocalDate DEFAULT_START_DATE = LocalDate.now();
    private static final LocalDate DEFAULT_END_DATE = LocalDate.now().plusMonths(12);

    public CreateLoanRequest buildValidRequest() {
      throw new UnsupportedOperationException("TODO(reto): buildValidRequest");
    }

    public CreateLoanRequest buildInvalidRequest() {
      throw new UnsupportedOperationException("TODO(reto): buildInvalidRequest");
    }

    public CreateLoanRequest buildInvalidRequest(
            String customerId,
            BigDecimal amount,
            BigDecimal interestRate,
            LocalDate startDate,
            LocalDate endDate) {
              throw new UnsupportedOperationException("TODO(reto): buildInvalidRequest");
            }
}

// === ARCHIVO: src/main/java/infrastructure/persistence/LoanRepositoryAdapter.java ===
package infrastructure.persistence;

import domain.model.Loan;
import domain.port.LoanRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LoanRepositoryAdapter implements LoanRepository {

    private final LoanJpaRepository jpaRepository;

    public LoanRepositoryAdapter(LoanJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Loan save(Loan loan) {
        LoanEntity entity = toEntity(loan);
        LoanEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Loan> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    public Optional<Loan> findByCustomerId(String customerId) {
        return jpaRepository.findByCustomerId(customerId).map(this::toDomain);
    }

    public List<Loan> findByStatus(Loan.LoanStatus status) {
        return jpaRepository.findByStatus(status.name()).stream()
                .map(this::toDomain)
                .toList();
    }

    public List<Loan> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount) {
        return jpaRepository.findByAmountBetween(minAmount, maxAmount).stream()
                .map(this::toDomain)
                .toList();
    }

    private LoanEntity toEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();
        entity.setId(loan.id());
        entity.setCustomerId(loan.customerId());
        entity.setAmount(loan.amount());
        entity.setInterestRate(loan.interestRate());
        entity.setStartDate(loan.startDate());
        entity.setEndDate(loan.endDate());
        entity.setStatus(loan.status().name());
        return entity;
    }

    private Loan toDomain(LoanEntity entity) {
        return new Loan(
                entity.getId(),
                entity.getCustomerId(),
                entity.getAmount(),
                entity.getInterestRate(),
                entity.getStartDate(),
                entity.getEndDate(),
                Loan.LoanStatus.valueOf(entity.getStatus())
        );
    }

    @Entity
    @Table(name = "loans")
    public static class LoanEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        private String customerId;

        private BigDecimal amount;

        private BigDecimal interestRate;

        private LocalDate startDate;

        private LocalDate endDate;

        private String status;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public interface LoanJpaRepository extends JpaRepository<LoanEntity, UUID> {
        
        @Query("SELECT l FROM LoanEntity l WHERE l.customerId = :customerId")
        Optional<LoanEntity> findByCustomerId(@Param("customerId") String customerId);

        @Query("SELECT l FROM LoanEntity l WHERE l.status = :status")
        List<LoanEntity> findByStatus(@Param("status") String status);

        @Query("SELECT l FROM LoanEntity l WHERE l.amount BETWEEN :minAmount AND :maxAmount")
        List<LoanEntity> findByAmountBetween(
                @Param("minAmount") BigDecimal minAmount,
                @Param("maxAmount") BigDecimal maxAmount
        );
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración del servidor
# El contexto raíz es "/" para que las rutas coincidan con el contrato compartido (/loans, /loans/{id}).
server.port=8080

# Nombre de la aplicación
spring.application.name=loan-management-api

# Datasource (H2 en memoria para desarrollo)
spring.datasource.url=jdbc:h2:mem:loandb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Consola H2 (solo desarrollo)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Validación y manejo de rutas no encontradas
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false

# Actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
management.health.defaults.enabled=true

# Logging
logging.level.root=INFO
logging.level.com.example=DEBUG
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Jackson
spring.jackson.serialization.write-dates-as-timestamps=false
spring.jackson.time-zone=UTC

# Tamaño de peticiones multipart
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

// === ARCHIVO: src/main/java/Application.java ===
package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Los componentes viven en los paquetes de nivel superior domain, application e infrastructure.
// Se declaran explícitamente para que el escaneo de Spring los encuentre desde esta clase de arranque.
@SpringBootApplication(scanBasePackages = {"domain", "application", "infrastructure"})
@EntityScan(basePackages = "infrastructure.persistence")
@EnableJpaRepositories(basePackages = "infrastructure.persistence")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
