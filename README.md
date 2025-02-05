# LAB2_CVDS
## INTEGRANTES
-Juan David Zambrano 
-Allan Contreras 


## EJERCICIO DE LAS FUGURAS 

### 1. Investigamos como crear un proyecto en Maven con la ayuda de arquetipos, para esto nos guiamos del contenido del documento (Maven in five minutes).

![alt text](resources/image-6.png)

![alt text](resources/image-7.png)

    Haciendo uso de la estructura que se presenta en la primera imagen, agregamos los parametros solicitados y creamos el proyecto.


![alt text](resources/image.png)

![alt text](resources/image-1.png)

    Usando :  
    ```sh
    $ tree
    ```
    Verificamos la estructura del proyecto.

![alt text](resources/image-2.png)

    Comparamos con la estructura solicitada y verificamos que esta correcta.

### 2. AJUSTAR ALGUNAS CONFIGURACIONES DEL PROYECTO
    Agreagamos la version Java 8 del compilador.
    
![alt text](resources/image-8.png)

   - ### cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando mvn.


        El parámetro "package" en el comando mvn package se usa en Apache Maven para compilar el código fuente de un proyecto, ejecutar pruebas y ensamblar los archivos resultantes en un paquete distribuible, como un JAR o WAR, dependiendo del empaquetado definido en el archivo pom.xml.


        

        ## Parámetros útiles para `mvn`
        | Comando               | Descripción |
        |-----------------------|-------------|
        | `mvn clean`          | Borra el directorio `target/` y archivos generados. |
        | `mvn validate`       | Valida la configuración del proyecto y las dependencias. |
        | `mvn compile`        | Compila el código fuente. |
        | `mvn test`           | Ejecuta las pruebas unitarias. |
        | `mvn package`        | Compila y empaqueta el proyecto en un artefacto (`JAR`, `WAR`, etc.). |
        | `mvn install`        | Instala el artefacto en el repositorio local . |
        | `mvn deploy`         | Sube el artefacto a un repositorio remoto. |

- ### Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en "mainClass".

    Primero nos aseguramos que tengamos un metodo Main:

    ![alt text](resources/image-9.png)

    luego modificamos el pom.xml añadiendole un plugin de ejecucion.

    ![alt text](resources/image-3.png)

    Ahora ejecutamos el proyecto usando:
    ```sh
    exec:exec -Dexec.executable="maven" [-Dexec.workingdir="/tmp"] -Dexec.args="-X pattern:dist"
    ```

    ![alt text](resources/image-4.png)


    Modificamos para generar un saludo peersonalizado:

    ![alt text](resources/image-10.png)

    y configuramos pom.xml

    ![alt text](resources/image-11.png)

    Volvemos a ejecutar y obtenemos

    ![alt text](resources/image-12.png)
    ![alt text](resources/image-13.png)

    Ahora ejecutamos con un nombre como parametro

    ```sh
    mvn clean compile exec:java -Dexec.args="Juan"
    ```

    ![alt text](resources/image-14.png)

    ![alt text](resources/image-15.png)

    
    Ahora ejecutamos nombre y apellido como parametros y miramos que sucede

    ```sh
    mvn clean compile exec:java -Dexec.args="Juan Zambrano"
    ```
    ![alt text](resources/image-16.png)

    ![alt text](resources/image-17.png)

    Observamos que al ingresar nombre y apellido como parametros al ejecutar solo obtenemos el nombre.

    Para solucionar esto debemos modificar el codigo y asi  asegurarnos de que todos los argumentos se impriman correctamente, para que Maven pase argumentos compuestos es necesario encerrar las cadenas entre comillas simples dentro de comillas dobles y en el código, usamos String.join(" ", args) para manejar múltiples palabras.

    ![alt text](resources/image-18.png)

    Ejecutamos de nuevo y obtenemos:

    ```sh
    mvn clean compile exec:java -Dexec.args='"Juan Zambrano"'
    ```

    ![alt text](resources/image-19.png)
    ![alt text](resources/image-20.png)

# HACER EL ESQUELETO DE LA APLICACIÓN    

    Creamos los paqutes Shapes y concrete


![alt text](resources/image-21.png)

    Creamos los siguientes archivos:
- Shape.java
- RegularShapeType.java 
- Triangle.java
- Quadrilateral.java 
- Pentagon.java 
- Hexagon.java
- ShapeMain.java 
- ShapeFactory.java

    ![alt text](resources/image-22.png)


# ¿Cuál fábrica hiciste?  

      implementamos el patrón fábrica  Simple Factory, ya que hay una única clase ShapeFactory encargada de crear 
       instancias de Shape, No usamos herencia ni una interfaz para definir la creación de objetos,
       En este caso Simple Factory es suficiente porque solo estamos creando diferentes figuras geométricas sin que haya 
       muchas variaciones en el proceso de creación. hicimos  uso de la instrucción switch-case de Java y usando las 
      enumeraciones.
      
#  ¿Cuál es mejor?

         Depende del caso de uso. Aquí una comparación:


 | Comando               | Descripción                                                                                |
 |-----------------------|--------------------------------------------------------------------------------------------|
 | `Simple Factory`      | Fácil de implementar y entender                                                            |
 |                       | No es muy flexible si queremos extender las clases en el  futuro                           |     
 |                       | mejor para problemas pequeños con pocas variaciones en la creación de objetos.             |     
 |                       |                                                                                            |      |                       |                                                                                            |
 |                       |                                                                                            |
 |                       |                                                                                            |
 |                       |                                                                                            |      |                       |                                                                                            |
 |                       |                                                                                            |
 | `Factory Method`      | Usa herencia para definir la creación en subclases                                         |
 |                       | Mayor flexibilidad si hay muchas variaciones en la creación                                |
 |                       | Más complejo, requiere definir clases abstractas y subclases                               |   
 |                       | Mejor si cada subclase tiene una forma diferente de construir los objetos.                 |
 |                       |                                                                                            |      |                       |                                                                                            |
 |                       |                                                                                            |
 | `Abstract Factory`    | Permite crear familias de objetos relacionados sin especificar sus clases concretas        |
 |                       | Útil  cuando hay múltiples variantes de objetos que deben funcionar juntos                 |
 |                       | es Mucho más complejo  de implementar                                                      | 
 |                       | Mejor si hay muchas familias de objetos que deben cambiar juntas                           |
 |                       |                                                                                            |
 |                       |                                     
 |                       |                                                                                            |
         










  
