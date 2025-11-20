# --- Stage 1: Build ---
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app

# 1. Copiamos SOLO los archivos de definición de dependencias
COPY build.gradle settings.gradle ./
# (Opcional) COPY gradle.properties ./

# 2. TRUCO PRO: Descargamos dependencias ANTES de copiar el código.
# Si no tocas el build.gradle, Docker usará la caché de este paso y no bajará nada.
RUN gradle dependencies --no-daemon

# 3. Ahora sí copiamos el código fuente
COPY src ./src

# 4. Compilamos
RUN gradle build --no-daemon -x test

RUN ls -la /app/build/libs/

# --- Stage 2: Runtime ---
FROM eclipse-temurin:17-jre
WORKDIR /app

# 5. Copia SEGURA. Buscamos explícitamente el jar de la aplicación, ignorando el 'plain'.
# Nota: Esto asume que solo se genera un bootJar. Si falla, ajustaremos el nombre.
COPY --from=builder /app/build/libs/app.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]