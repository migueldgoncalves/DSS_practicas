Utilizar JDK 1.8 y Apache Tomcat 9.0.

Practica creada utilizando tanto Eclipse 2018-09 como Eclipse Neon.

DESPLIEGUE

1-Garantizar que el JRE por defecto es el JDK 1.8.
2-Importar como Existing Maven Project la carpeta con la practica
3-Correr la practica (con "Run As") con Maven clean (innecesario si se corre la practica por primera vez)
4-Correr la practica con Maven install
5-Correr la practica con Run on Server, creando si necesario un servidor Apache Tomcat 9.0
6-Si la página web no aparecer automáticamente, abrir un navegador y poner el enlace:
http://localhost:9090/practica1/home.jsf