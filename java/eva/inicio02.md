# Configuración del entorno de desarrollo de Java

Ya sabemos la teoría de qué es Java, su uso y algunas cosas curiosas, ahora vamos a ver como podemos configurar nuestro equipo para hacer nuestro primer 'hola skilly' en Java.

![meme java](../../img/meme-java3.jpg)

## Entorno para desarrollar Java

> :warning: **ADVERTENCIA** Vamos a crear un entorno de desarrollo minimalista y ajustado a las necesidades de un 'junior'. Si necesitas configurar tu entorno para desarrollo avanzado en Java o tienes alguna característica concreta en tu equipo escríbenos a soporte@skilly.es y te ayudaremos.

Empezaremos por lo básico, aquí tienes una pequeña receta de elementos imprescindibles:

- Un ordenador, no tiene que ser gran cosa, con un chromebook nos vale como mínimo
- Sistema operativo Windows, Ubuntu/Debian o MacOS
- Acceso a internet, el que tengas, sólo queremos descargar Java y el JDK.
- Apuntes

¿Lo tienes todo? ¡Al lío!

## Instalación de Java y JDK

Antes de instalar, necesitamos entender que es el JDK o Java Development Kit, es un conjunto de herramientas, bibliotecas y archivos necesarios para desarrollar aplicaciones en el lenguaje de programación Java. En esencia, el JDK proporciona todo lo que un desarrollador necesita para escribir, compilar, depurar y ejecutar programas Java.

Es importante mencionar que existe una diferencia entre el JDK y el JRE (Java Runtime Environment). El JRE incluye solo la JVM y las bibliotecas estándar de Java, pero no las herramientas de desarrollo. Los usuarios finales que solo desean ejecutar aplicaciones Java necesitan el JRE, mientras que los desarrolladores necesitan el JDK para escribir y compilar código Java.

Con esto claro, ahora sí, podemos seguir este tutorial dependiendo del sistema operativo que tengamos en nuestro equipo.

### Windows

[Manual oficial de Oracle](https://docs.oracle.com/en/java/javase/20/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)

#### Descargar JDK

Podemos descargar directamente el ejecutable .exe a través de [este enlace](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe) o si quieres elegir la versión comprimida o el .msi lo puedes encontrar en [este otro enlace](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)

#### Instalar JDK.exe

> :warning: Es necesario tener permisos de administrador

1. Doble click en la descarga con el nombre 'jdk20.exe'
2. Seguir el asistente de instalación
   > :white_check_mark: **RECOMENDADO** recomendamos dejar las opciones por defecto para evitar futuros problemas o incompatibilidades
3. Borrar la descarga con el nombre 'jdk20.exe'

### Linux

[Manual oficial de Oracle](https://docs.oracle.com/en/java/javase/20/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)

> :warning: **ADVERTENCIA** en este ejemplo realizaremos la instalación del JDK sobre Ubuntu22 con .tar.gz. Echa un vistazo en el manual para otras formas de instalar.

#### Descargar JDK

Podemos descargar directamente el ejecutable .tar.gz a través de [este enlace](https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.tar.gz) o si quieres elegir la versión comprimida o el .msi lo puedes encontrar en [este otro enlace](https://www.oracle.com/java/technologies/downloads/)

```sh
wget https://www.oracle.com/java/technologies/downloads/
```

#### Instalar JDK.exe

> :warning: Es necesario tener permisos de administrador

1. Extraer el .tar.gz

### MacOS

[Manual oficial de Oracle]()

#### Descargar JDK

#### Instalar JDK.exe

### Elección de un IDE o editor de código

## gestion de memoria

## sistema de construccion de proyecto, maven, gradel
