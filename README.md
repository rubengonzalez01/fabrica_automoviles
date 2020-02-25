# fabrica_automoviles
Api Rest CRUD para una fábrica de automóviles.

La Api Rest de la fábrica de automóviles está desarrollada para el Recruitment test de la empresa SysOne.


### CONFIGURACIÓN

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


### USO

_Funcion_: Listar todos automóviles

_Descripción_: Este método se invocará cuando por una petición GET se llame a la url "http://127.0.0.1:8080/api/autos", Retornará todos los automoviles.

_Ejemplo_:

_URL_: http://127.0.0.1:8080/api/autos/

***

_Funcion_: Listar un automóvil

_Descripción_: Este método se invocará cuando por una petición GET se llame a la url "http://127.0.0.1:8080/api/autos/" + el id de un automovil. Retornará al automovil con id pasado en la url.

_Ejemplo_:

_URL_: http://127.0.0.1:8080/api/autos/1

***

_Funcion_: Agregar un automóvil

Descripción: Este método se invocará cuando por una petición POST se llame a la url	"http://127.0.0.1:8080/api/autos/". Este metodo guardará al automovil enviado.

_Ejemplo_:

_URL_: http://127.0.0.1:8080/api/autos/

_Objeto enviado_: {"nombre":"sedan","opcionales":["TC","AA"]}

***

_Funcion_: Actualizar un automóvil

_Descripción_: Este método se invocará cuando por una petición PUT se llame a la url "http://127.0.0.1:8080/api/autos/" + id del automovil. Este metodo actualizará al automovil enviado según el id.

_Ejemplo_:

_URL_: http://127.0.0.1:8080/api/autos/1

_Objeto enviado_: {"nombre":"sedan","opcionales":["TC","AA"]}

***

_Funcion_: Borrar un automóvil

_Descripción_: Este método se invocará cuando por una petición DELETE se llame a la url "http://127.0.0.1:8080/api/autos/" + id del automovil. Esto método recibira el id de un automovil por URL y se borrará de la bd.

_Ejemplo_:

_URL_: http://127.0.0.1:8080/api/autos/1
