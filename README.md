# **TP BATCH**

[diagramas](https://www.lucidchart.com/invitations/accept/be08420c-9d4f-4ae0-8f63-8df0abfdd625)

## Enunciado

Se debe desarrollar un programa genérico que tenga la capacidad de incorporar aplicaciones cuyo procesamiento será delegado en diversos comandos *batch*.

Por ejemplo: utilizando el comando ffmpeg se puede generar un video a partir de un archivo de audio y un archivo de imagen.

`ffmpeg -i video.gif -i audio.m4a -c:v copy -c:a copy output.mp4`

En el ejemplo vemos diferentes *flags* que indican cuál es el parámetro que se está pasando a continuación. Por ejemplo: -i indica que a continuación viene un archivo de *input*.

Toda esta información surge de la documentación del comando ffmpg.

Una posible aplicación sería: **Audio To Video** , que dado un archivo de audio y uno de imagen genera un archivo de video, con la imagen de fondo y la duración y el sonido del archivo de audio proporcionado.

Usando el mismo comando (ffmpeg), podríamos pensar en una aplicación que, dado un archivo de video, una *hora:minuto:segundo desde y una hora:minuto:segundo hasta* genere un extracto del video.

Otra aplicación, siempre con el mismo comando ffmpeg, podría ser: dado un archivo de video y un ángulo, generar un archivo de video idéntico al original pero rotado tantos grados como indica el ángulo proporcionado; negativo o positivo.

Las posibilidades son infinitas y sólo estamos utilizando un único comando.

Existe otro comando llamado *exiftool* que permite acceder a la metadata que está almacenada en los archivos de imagen. Usando este comando podríamos generar una aplicación llamada *Renombrar Fotos* que, dada una carpeta con imágenes, renombre a cada uno de los archivos de la carpeta con la fecha actual, en formato: *aaaa-mm-dd*.

Nuestro programa (el trabajo práctico) debe ser extensible y permitirle al usuario ejecutar cualquier aplicación, previamente desarrollada y *mappeada*, basada en un comando.

## ¿Cómo?

Cada aplicación surge de invocar algún programa en línea de comandos  y pasarle los parámetros adecuados.

Para generar una nueva aplicación debemos representarla a través de una clase Java. Llamaremos *mapping* a una clase que representa a una aplicación.

Usando *annotations* la clase debe indicar la siguiente información:

-   Cuál es el comando (archivo ejecutable, y ruta completa) que se debe invocar.
-   Cuál es el nombre de fantasía de la aplicación (ej. **Audio To Video** ).

La clase debe tener tantos atributos como parámetros vamos a pasarle al comando para que pueda ser el núcleo de nuestra aplicación.

En el ejemplo anterior (que vuelvo a reproducir a continuación):

`ffmpeg -i video.gif -i audio.m4a -c:v copy -c:a copy output.mp4`

La clase podría llamarse AudioToVideo.java . y los atributos serían:

```java
private String videofile;

private String  audioFile;

private String outputFile;
```

Cada atributo debe estar anotado con alguna *annotation* que indique a qué *flag* será aplicado. En los caso de videoFile y audioFile el *flag* es –i. En el caso de outputFile no queda demasiado claro por lo que se deberá recurrir a la documentación de ffmpeg para despejar dudas sobre cómo se invoca y qué opciones al respecto ofrece el comando en cuestión.

El programa debe interpretar dinámicamente las clases que *mappean* cada aplicación y generar, también  dinámicamente, una *interface* gráfica a través de la cual el usuario pueda pasar, amigablemente, los valores para cada uno de estos parámetros. Y, luego, presionar un botón "Procesar" para generar el comando con todos los *flags* y parámetros e invocarlo para dar comienzo al proceso.

Se debe estudiar qué diferentes tipos de parámetros existen. Por ejemplo: videoFile, audioFile y outputFile son cadenas de caracteres que hacen referencia a archivos en el disco.

Pero podría existir un parámetro que indique una fecha, una hora, un valor numérico entero, etcétera.

Cada tipo de parámetro debe estar asociado a un control gráfico. Por ejemplo: un nombre de archivo podría asociarse a un *file chooser*,  una fecha a un *date picker*, etcétera.

Así, la *annotation* que anota datos sobre un atributo no sólo debe indicar a qué *flag* está asociado. Debe indicar también qué control gráfico se debe utilizar para generar la *interface* gráfica de la aplicación.

```java
@Parametro(flag="-i", control="demo.tp.FileChooser")

private String videofile;

@Parametro(flag="-i", control="demo.tp.FileChooser")

private String  audioFile;

@Parametro(flag=" ???", control=" ???")

private String outputFile;
```

## Etapas

Para poder desarrollar el TP de manera ordenada, se propone avanzar sobre las siguientes etapas.

1.  Análisis de las diferentes posibilidades de *flags* y tipos de dato de los parámetros.
2.  Análisis de las posibilidades gráficas para desarrollar controles asociados a cada uno de los tipos de dato del punto anterior.
3.  Análisis de las *annotations* que se van a desarrollar; qué parámetros deben recibir.
4.  Desarrollo de los casos de prueba.
5.  Testeo de cada uno de los casos de prueba.

## Entrega del TP

El trabajo práctico debe poder ejecutar correctamente los casos de prueba proporcionados. El día de la entrega final se propondrá desarrollar un nuevo caso (sorpresa) que pondrá a prueba la flexibilidad y extensibilidad del programa desarrollado.

## Casos de prueba

Aplicación: Audio To Video – genera un video uniendo una imagen y un audio.

Aplicación: Extract Video – extrae un fragmento de un video.

Aplicación: Mute Audio – enmudece el audio de un fragmento de un video.algo2
