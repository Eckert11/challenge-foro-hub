# 💬 Challenge Foro Hub

![Status](https://img.shields.io/badge/STATUS-FINALIZADO-green)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Token-purple)
![Tests](https://img.shields.io/badge/tests-passing-brightgreen)
![Coverage](https://img.shields.io/badge/coverage-85%25-yellow)

---

# 📋 Descripción del Proyecto

API REST para un **foro de discusión** desarrollada con **Spring Boot** como parte del **Challenge de Alura Latam**.

La aplicación permite:

- Crear tópicos
- Listar tópicos
- Actualizar tópicos
- Eliminar tópicos
- Buscar tópicos
- Autenticación mediante **JWT**

---

# 🚀 Funcionalidades Implementadas

## 📡 Endpoints Disponibles

| Método | Endpoint | Descripción | Autenticación |
|------|------|------|------|
| POST | `/login` | Obtener token JWT | ❌ Público |
| POST | `/topicos` | Crear un nuevo tópico | ✅ Requiere token |
| GET | `/topicos` | Listar todos los tópicos | ✅ Requiere token |
| GET | `/topicos/{id}` | Detalle de un tópico específico | ✅ Requiere token |
| PUT | `/topicos/{id}` | Actualizar un tópico | ✅ Requiere token |
| DELETE | `/topicos/{id}` | Eliminar un tópico | ✅ Requiere token |
| GET | `/topicos/paginado` | Listado paginado | ✅ Requiere token |
| GET | `/topicos/buscar` | Búsqueda por curso/año | ✅ Requiere token |

---

# 🔐 Autenticación

La API utiliza **JWT (JSON Web Tokens)** para proteger los endpoints.

Para acceder a los endpoints protegidos primero debes **obtener un token**.

## Login

### Request

```http
POST /login
Content-Type: application/json

{
  "login": "admin",
  "password": "123456"
}
```

### Respuesta

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Uso del Token

Incluye el token en el **header Authorization** de cada petición:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

# 📊 Ejemplo de Uso

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

# 🚀 Ejemplo de Flujo Completo

## 1️⃣ Obtener Token

```bash
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/json" \
  -d '{"login":"admin","password":"123456"}'
```

---

## 2️⃣ Usar Token para Crear un Tópico

```bash
curl -X POST http://localhost:8080/topicos \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer TOKEN_AQUI" \
  -d '{
    "titulo": "Mi primer tópico",
    "mensaje": "Probando la API",
    "autor": "Juan Pérez",
    "curso": "Spring Boot"
  }'
```

---

# 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **PostgreSQL 17**
- **Flyway Migration**
- **Lombok**
- **Maven**

---

# ⚙️ Variables de Entorno

El proyecto requiere las siguientes variables de entorno:

| Variable | Descripción | Valor por defecto |
|------|------|------|
| `DB_USER` | Usuario de PostgreSQL | `postgres` |
| `DB_PASSWORD` | Contraseña de PostgreSQL | requerido |
| `JWT_SECRET` | Secreto para firmar tokens | requerido |
| `DB_HOST` | Host de la base de datos | `localhost` |
| `DB_PORT` | Puerto PostgreSQL | `5432` |
| `DB_NAME` | Nombre de la base de datos | `foro_hub_db` |

---

# 🔧 Configuración del Entorno

## Requisitos Previos

- **JDK 17+**
- **Maven 3.6+**
- **PostgreSQL 17+**

---

# ▶️ Pasos para Ejecutar

```bash
# Clonar repositorio
git clone https://github.com/Eckert11/challenge-foro-hub.git

# Entrar al proyecto
cd challenge-foro-hub

# Compilar proyecto
./mvnw clean compile

# Ejecutar aplicación
./mvnw spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
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
