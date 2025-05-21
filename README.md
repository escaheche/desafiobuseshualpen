````
# 🚌 Desafío Buses Hualpén

Proyecto de gestión de proyectos y tareas con autenticación de usuarios y administradores.  
Incluye API REST desarrollada con Spring Boot y documentación interactiva en Swagger.

---

## 🚀 Instalación y ejecución rápida

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/escaheche/desafiobuseshualpen.git
   cd desafiobuseshualpen
````

2. **Construye el proyecto**

   ```bash
   ./gradlew clean build
   ```

   > Si usas Windows:
   > `.\gradlew clean build`

3. **Ejecuta la aplicación**

   ```bash
   ./gradlew bootRun
   ```

   > Si usas Windows:
   > `.\gradlew bootRun`

4. **Abre Swagger UI en tu navegador:**
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

5. **Crea la bd "desafiobuses" en postgresql:**
   
   Puede ser a traves de pgadmin , comando
   ```CREATE DATABASE desafiobuses;```

---

## 👤 Creación de usuarios y administradores

### 1. Crear un usuario administrador

1. Ve a la sección `/api/auth/register` en Swagger.
2. Haz una petición **POST** con el siguiente JSON de ejemplo:

   ```json
   {
     "username": "admin",
     "password": "admin123",
     "rol": "ADMINISTRADOR"
   }
   ```
3. El ADMINISTRADOR creado tendrá todos los permisos, respetar la mayúsculas.

### 2. Crear un usuario normal

1. Ve a la sección `/api/auth/register` en Swagger.
2. Haz una petición **POST** con el siguiente JSON:

   ```json
   {
     "username": "usuario",
     "password": "usuario123",
     "rol": "USUARIO"
   }
   ```
3. El USUARIO creado tendrá permisos de ver solamente y no puede crear tareas ni proyectos, también respetar la mayúsculas al crear.

---

## 🔑 Inicio de sesión

1. En `/api/auth/login` realiza un **POST** con tus credenciales:

   ```json
   {
     "username": "admin",
     "password": "admin123"
   }
   ```
2. Recibirás un **token JWT** que debes usar como `Bearer Token` en las peticiones protegidas.

---

## 📚 Uso de las APIs

* Para probar los endpoints protegidos (crear proyectos, tareas, etc), debes estar autenticado con el token JWT.
* Los administradores pueden crear, editar y eliminar proyectos y tareas.
* Los usuarios pueden visualizar los proyectos y tareas.

**Ejemplo de uso en Swagger:**

1. Haz login y copia el JWT.
2. Haz clic en el botón de candado 🔒 en Swagger y pega el token.
3. Ahora puedes probar los endpoints protegidos.

---

## 🌱 Tecnologías utilizadas

* Java 21
* Spring Boot 3
* Spring Security (JWT)
* PostgreSQL 17
* MapStruct
* Gradle
* JPA(Hibernate)

---

## 💡 Notas adicionales

* Recuerda tener **PostgreSQL** corriendo.


---


