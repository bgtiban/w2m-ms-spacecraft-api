# w2m-ms-spaceships-api.

w2m-ms-spaceships-api es un microservicio que produce mensajes para dejarlos en una cola de RabbitMQ, 
permite administrar nombres de naves espaciales que aparecen en series y peliculas a través de una API REST.
Dockerizada, basado en Springboot 3, con arquitectura hexagonal, uso de OpenApi 3.0 y aproximación Api First.
Para su arranque se ha configurado una BD embebida H2 con una carga inicial. Las distintas URLS de las que dispone el servicio se detallan en el apartado URLS.

## Tecnologías, patrones y metodologías usadas

- Lenguaje: Java 21 LTS sobre un marco SpringBoot 3.3.5
- Maven: maven versión 3.9.9
- OpenApi: OpenApi versión 3.0.2
- Distribución de carpetas: se ha optado por un proyecto maven multimódulo con [arquitectura hexagonal](https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f).
    - w2m-ms-spaceships-api-api-specs/: definición del contrato OpenApi.yaml
    - w2m-ms-spaceships-api-application/: actores primarios que hacen que se ejecute la lógica de negocio, es decir, un API rest, un consumidor de colas, interfaz gráfica, etc...
    - w2m-ms-spaceships-api-boot/: Contiene la clase que permite ejecutar nuestro proyecto SpringBoot
    - w2m-ms-spaceships-api-domain/: contiene toda la lógica de negocio y está totalmente aislado del resto de módulos, expone sus funcionalidades mediante interfaces de servicio que serán usadas por la capa de aplicación y expone puertos que deberán ser "adaptados" por la capa de infraestructura. Es completamente agnóstico del resto de capas.
    - w2m-ms-spaceships-api-infrastructure/: actores secundarios, sistemas de persistencia, conectividad con APIS externas, publicación de mensajes en servicios de colas, etc... Implementa los puertos de la capa dominio.
- Aproximaxión [Api First](https://medium.com/@emilianozublena/api-first-development-c202a61cf3b2): Se trabaja primero en la generación del contrato OpenApi y se desarrolla en base al código autogenerado de dicho contrato.
- [SpringDoc](https://springdoc.org/): plugin de maven que permite la generación de las clases necesarias a partir de un contrato OpenApi 3.0
- swaggger-ui: Permite visualizar e interactuar con la API.
- [Spring AOP](https://docs.spring.io/spring-framework/reference/core/aop.html): Paradigma de programación orientado a aspectos
- [Docker](https://docs.docker.com/manuals/): Herramienta para crear y administrar contenedores
- [RabbitMQ](https://www.rabbitmq.com/tutorials): Broker de mensajería
- [Springboot caching](https://spring.io/guides/gs/caching): Sistema de caché
## Montaje del entorno de desarrollo.

Para la instalación en local del proyecto primero nos aseguraremos de cumplir con los siguientes requisitos:

- Java 21
- Docker V27.3.1 (incluye docker compose)
- Lombok 1.18.34
- Maven 3.9.9
- IDE de libre elección
- puertos libres:
  - 8080 : la app usará este puerto para recibir peticiones
  - 5672: RabbitMQ usará este puerto para admitir la conexión de la app
  - 15672: RabbitMQ usará este puerto para proveer la web de administración del broker

1) Importe el proyecto en su IDE preferido y **NO lo arranque todavía**
2) Abra una consola, ubiquese en la ruta `...\w2m-ms-spaceships-api`
3) Editar fichero `...\w2m-ms-spaceships-api\docker-compose.yml` de la siguiente forma:
  ```YAML
version: '3.9'
services:
#  w2m-spaceships-spaceships:
#    image: bgtibant/w2m-spaceships
#    depends_on:
#      - w2m-spaceships-rabbitmq
#    environment:
#      - RABBITMQ_HOST=w2m-spaceships-rabbitmq
#    ports:
#      - "8080:8080"

  w2m-spaceships-rabbitmq:
    image: rabbitmq:3.10.7-management-alpine
    ports:
      - "5672:5672"
      - "15672:15672"
```
4) ejecute `docker compose up`, debería poder acceder a la consola de administración de 
   rabbitMQ en la url http://localhost:15672/, este paso levanta la cola de rabbit a la cual se contecará la app.
   - User: guest
   - Password: guest
5) Arranque la aplicación springboot.

## Ejemplo de uso

Si no queremos montar el entorno de desarrollo podemos arrancar la aplicación de la siguiente forma, 
para la cual, será imprescindbile tener Docker instalado en su PC.

1. Descargar `...\w2m-ms-spaceships-api\docker-compose.yml`
2. Ubicarse en la ruta de descarga, abrir una consola y ejecutar `docker compose up`

Esto levantará dos contenedores, uno con la Api rest de spaceships y otro con el broker de 
mensajería RabbitMQ.

## URLS
- Swagger-ui: http://localhost:8080/api-docs/contract.html
- RabbitMQ managment: http://localhost:15672/
  - User: guest
  - Password: guest
  
## Autores y menciones
- Creador: Bryan Tibán
- A petición de: W2M



