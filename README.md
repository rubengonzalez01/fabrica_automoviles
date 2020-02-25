# fabrica_automoviles
Api Rest CRUD para una fábrica de automóviles.

La Api Rest de la fábrica de automóviles está desarrollada para el Recruitment test de la empresa SysOne.


## CONFIGURACIÓN

La base de datos seleccionada es MySQL 8+ y debe contar con la siguiente estructura de tabla:

CREATE TABLE automovil(
id int NOT NULL AUTO_INCREMENT,
nombre varchar(30),
opcionales JSON,
costo_final int,
primary key(id)
);


Hecho esto, se requiere configurar el fichero application.properties con la conexión a la base de datos que corresponda.
src/main/resources/applicacion.properties


## USO

Funcion: Listar todos automóviles
Descripción: Este método se invocará cuando por una petición GET se llame a la url "http://127.0.0.1:8080/api/autos", Retornará todos los automoviles.
Ejemplo:
URL: http://127.0.0.1:8080/api/autos/


Funcion: Listar un automóvil
Descripción: Este método se invocará cuando por una petición GET se llame a la url "http://127.0.0.1:8080/api/autos/" + el id de un automovil. Retornará al automovil con id pasado en la url.
Ejemplo:
URL: http://127.0.0.1:8080/api/autos/1


Funcion: Agregar un automóvil
Descripción: Este método se invocará cuando por una petición POST se llame a la url	"http://127.0.0.1:8080/api/autos/". Este metodo guardará al automovil enviado.
Ejemplo:
URL: http://127.0.0.1:8080/api/autos/
Objeto enviado: {"nombre":"sedan","opcionales":["TC","AA"]}


Funcion: Actualizar un automóvil
Descripción: Este método se invocará cuando por una petición PUT se llame a la url "http://127.0.0.1:8080/api/autos/" + id del automovil. Este metodo actualizará al automovil enviado según el id.
Ejemplo:
URL: http://127.0.0.1:8080/api/autos/1
Objeto enviado: {"nombre":"sedan","opcionales":["TC","AA"]}


Funcion: Borrar un automóvil
Descripción: Este método se invocará cuando por una petición DELETE se llame a la url "http://127.0.0.1:8080/api/autos/" + id del automovil. Esto método recibira el id de un automovil por URL y se borrará de la bd.
Ejemplo:
URL: http://127.0.0.1:8080/api/autos/1
