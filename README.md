# 💬 Challenge Foro Hub

![Badge en Desarrollo](https://img.shields.io/badge/STATUS-EN%20DESARROLLO-green)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Token-purple)

---

## 📋 Descripción del Proyecto

API REST para un foro desarrollada con **Spring Boot** como parte del **Challenge de Alura Latam**.  
Permite a los usuarios **crear, listar, actualizar y eliminar tópicos**.

---

# 🚀 Funcionalidades Implementadas

## ✅ Endpoints Disponibles

| Método | Endpoint | Descripción | Status |
|------|------|------|------|
| POST | `/topicos` | Crear un nuevo tópico | ✅ Implementado |
| GET | `/topicos` | Listar todos los tópicos | ✅ Implementado |
| GET | `/topicos/{id}` | Detalle de un tópico específico | ✅ Implementado |
| PUT | `/topicos/{id}` | Actualizar un tópico | ✅ Implementado |
| DELETE | `/topicos/{id}` | Eliminar un tópico | ✅ Implementado |
| GET | `/topicos/paginado` | Listado paginado | ✅ Implementado |
| GET | `/topicos/buscar` | Búsqueda por curso/año | ✅ Implementado |

---

# 📊 Ejemplos de Uso

## Crear un tópico

### Request

```json
POST /topicos

{
  "titulo": "Duda sobre Spring Boot",
  "mensaje": "¿Cómo implementar JWT?",
  "autor": "Juan Pérez",
  "curso": "Spring Framework"
}
```

### Respuesta Exitosa

```json
{
  "id": 1,
  "titulo": "Duda sobre Spring Boot",
  "mensaje": "¿Cómo implementar JWT?",
  "autor": "Juan Pérez",
  "curso": "Spring Framework",
  "fechaCreacion": "2024-03-08T15:30:45",
  "status": "NO_RESPONDIDO"
}
```

---

# 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- Spring Security *(próximamente)*
- PostgreSQL 17
- Flyway Migration
- Lombok
- Maven

---

# 🔧 Configuración del Entorno

## Requisitos Previos

- JDK 17+
- Maven 3.6+
- PostgreSQL 17+

---

## Variables de Entorno (Producción)

```bash
export DB_USER=tu_usuario
export DB_PASSWORD=tu_contraseña
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=foro_hub_db
```

---

# ▶️ Pasos para Ejecutar

```bash
# Clonar repositorio
git clone https://github.com/Eckert11/challenge-foro-hub.git

# Entrar al directorio
cd challenge-foro-hub

# Compilar
./mvnw clean compile

# Ejecutar
./mvnw spring-boot:run
```

---

# 📁 Estructura del Proyecto

```
src/main/java/com/alura/forohub/
├── controller/
│   └── TopicoController.java
├── domain/
│   └── topico/
│       ├── Topico.java
│       ├── TopicoRepository.java
│       ├── TopicoService.java
│       ├── DatosRegistroTopico.java
│       ├── DatosRespuestaTopico.java
│       └── DatosListadoTopico.java
├── infra/
│   └── exception/
│       ├── TratadorDeErrores.java
│       └── TopicoNoEncontradoException.java
└── ForohubApplication.java
```

---

# 👨‍💻 Autor

**Eckert11**

![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

---

# 📄 Licencia

Este proyecto está bajo la **Licencia MIT**.
