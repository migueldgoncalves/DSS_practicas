Esta practica fue realizada con JDK 1.8, Apache Tomcat 9.0 y Eclipse Neon.

Se asume que el servidor escucha en el puerto 9090. Cambiar los enlaces en la práctica si es otro puerto, o cambiar la configuración de Apache Tomcat.

Cambiar si necesario el path donde se colocará la base de datos, en el fichero WebContent/META-INF/persistence.xml. El valor actual es
F:\db-derby-10.12.1.1-bin\basesDatos\relacionesBD

Los siguientes jars fueron incluidos en el build path de la practica y se encuentran en la carpeta WebContent/WEB-INF/lib.
asm-3.1
derby
eclipselink
jackson-core-asl-1.9.2
jackson-jaxrs-1.9.2
jackson-mapper-asl-1.9.2
jackson-xc-1.9.2
javax.persistence_2.2.1.v201807122140
jersey-apache-client-1.17.1
jersey-atom-abdera-1.17.1
jersey-client-1.17.1
jersey-core-1.17.1
jersey-guice-1.17.1
jersey-json-1.17.1
jersey-multipart-1.17.1
jersey-server-1.17.1
jersey-servlet-1.17.1
jersey-simple-server-1.17.1
jersey-spring-1.17.1
jettison-1.1
jsr311-api-1.1.1
oauth-client-1.17.1
oauth-server-1.17.1
oauth-signature-1.17.1

//DESPLIEGUE
1-Descargar y extraer la carpeta con la practica en un directorio cualquier
2-En File>Import>General>Projects from Folder or Archive>Next>Directory... elegir la carpeta con la practica, pulsar Finish y aguardar
3-Correr la practica en un servidor Apache Tomcat 9.0 para acceder a la aplicación web de administración de usuarios
4-Pulsar con el botón derecho del ratón en la carpeta src/ de la practica y ahí en Run As > Java Application para ejecutar el cliente de prueba de la aplicación
(El punto 4 solo se puede hacer con la practica corriendo en el servidor)