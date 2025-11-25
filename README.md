# Proyecto: Consumo de API con HttpClient y Gson en Java

Este proyecto es un ejercicio práctico cuyo objetivo es realizar una petición HTTP a una API externa utilizando Java 11+, y luego procesar la respuesta JSON con Gson para extraer campos específicos.

# Tecnologías utilizadas
* Java 17
* HttpClient, HttpRequest, HttpResponse (integrados en Java desde la versión 11)
* Gson (para parsear JSON)
* API de https://www.fastforex.io/

# Objetivos del ejercicio
* Enviar una solicitud HTTP GET a un endpoint público.
* Recibir la respuesta mediante HttpResponse<String>.
* Convertir el JSON recibido en objetos Java con la librería Gson.
* Extraer campos específicos de la respuesta, por ejemplo:
    extraer el objeto "result" y luego un campo como "name": 0.01.

## Ejemplo de solicitud HTTP
Se crea un cliente HTTP, se construye una solicitud GET y se envía para obtener la respuesta de la API.
```HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.example.com/data"))
        .GET()
        .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
```

## Ejemplo de parseo con Gson
Con una respuesta JSON como:
```{
"status": "ok",
  "result": {
    "name": 0.01
  }
}
```

Primero se convierte el body de la respuesta en un objeto JsonObject. Luego se accede al objeto "result" y a los campos internos como "name".

## Estructura básica del proyecto
src/main/java/... contiene la clase Main (o la estructura que el proyecto haya definido).

## Instrucciones para ejecutar
* Verificar que se utiliza Java 11 o superior.
* Agregar la dependencia de Gson mediante Maven o Gradle.
* Compilar y ejecutar el proyecto. Ejemplo con Maven: mvn compile exec:java

## Notas adicionales
Este ejercicio sirve como introducción al consumo de APIs REST utilizando herramientas nativas de Java y la librería Gson. Si se requiere manejar JSON más complejo, es recomendable definir clases POJO y usar Gson.fromJson para mapear las respuestas de forma más organizada.
