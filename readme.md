# Close Up

## Address Normalization

### Tecnologias

* Spring Boot 2.1
* Postgres
* Postgis
* Arcgis 100.4.0

### Swagger Ui

La documentacion con las rutas del Api se encuentra en Swagger y para ingresar al mismo se realiza mediante la siguiente direccion `http://{IP}:{PORT}/swagger-ui.html` en el caso de correrlo con perfil dev y sin cambios en el puerto la misma es `http://127.0.0.1:8080/swagger-ui.html`

### JavaDoc

El mismo se encuentra en la carpeta **/javadoc** para renderizarlo utilizar el archivo index.html

### Deploy

Hacer el deploy consta de los siguientes pasos:

#### Configuracion application.conf

En la carpeta **/src/main/resources** se encuentra el archivo application-dev.properties para el ambiente de desarrollo y application-prod.properties para producción.

**El puerto**

* port=`8080`, se encuentra en _server.port_

**Base de datos**

* url=`jdbc:postgresql://{127.0.0.1}:{5432}/address`, se encuentra en _spring.datasource.url_
* username = `closeup`, se encuentra en _spring.datasource.username_
* password = `WkZg2M `, se encuentra en _spring.datasource.password_

**El tamaño maximo de archivo**

* maxFileSize=`200MB`, se encuentra en _spring.servlet.multipart.maxFileSize_
* maxRequestSize=`200MB`, se encuentra en _spring.servlet.multipart.maxRequestSize_

**Credenciales de ArcGis**

* username, se encuentra en _arcgis.username_ 
* password, se encuentra en _arcgis.password_ 

#### Configuracion Postgres y Postgis

**Crear base de datos**

`CREATE DATABASE address;`

**Añadir postgis**

`CREATE SCHEMA postgis;`

`CREATE EXTENSION postgis SCHEMA postgis;`

**Crear usuario**

`create user closeup;`

`alter user closeup with encrypted password 'WkZg2M';`

**Dar privilegios al usuario**

`grant all privileges on database address to closeup;`


#### Deploy Jar
* En el caso de hacer un cambio en el application.conf ejecutar el siguiente comando `mvn package` o `./mvnw package` y ubicar el jar generado en la carpeta **/target** en la misma carpeta que **/resources** y **/jniLibs** ya que contiene los archivos necesarios utilizados por ArcGis 
* Ejecutar `java -jar normalization-1.0.0.jar --spring.profiles.active=prod` para ejecutarlo con perfil producción
* Ejecutar `java -jar normalization-1.0.0.jar --spring.profiles.active=dev` para ejecutarlo con perfil desarrollo   