# Introducción a Dart

![dart logo](../../../img/Dart-logo.png)

## ¿Qué es Dart?

Dart es un lenguaje de programación relativamente nuevo. Nació, bajo la marca Google, en otoño de 2011, en un evento tecnológico en Aarhus, Dinamarca, bajo el nombre de **Dash**. Aun que pronto sería rebautizado a **Dart**, un nombre elegido para reflejar tanto la velocidad como la precisión que sus creadores aspiraban a imprimir en el mundo de la programación web.

Lars Bak, ingeniero de software de Google y jefe del equipo, tenía una visión muy clara: crear un lenguaje estructurado pero flexible, que ofreciera soluciones robustas y seguras para las crecientes demandas de aplicaciones web modernas pero ese problema ya le cubría Javascript.
Dart se posicionaba no para desplazar a JavaScript, el rey indiscutible de los navegadores, sino para presentarse como una alternativa más moderna y eficiente.

Uno de los primeros proyectos desarrollados en Dart fue Brightly, una herramienta de desarrollo de aplicaciones en línea que destacó el potencial del nuevo lenguaje. Para asegurar su adopción y compatibilidad, Google no solo trabajó en una máquina virtual nativa para integrar Dart en su navegador Chrome, sino que también desarrolló una herramienta capaz de traducir Dart a ECMAScript 3 al instante. Esto aseguraba que las aplicaciones escritas en Dart pudieran funcionar en cualquier navegador, incluso aquellos que no soportaran el lenguaje directamente.

Desde su lanzamiento, Dart ha evolucionado, encontrando un nicho especialmente prominente en el desarrollo de aplicaciones móviles con el lanzamiento de Flutter, un framework de UI que permite la creación de apps nativas tanto para iOS como para Android desde un único código base. Dart se ha transformado en una herramienta indispensable para los desarrolladores que buscan eficiencia, rendimiento y una excelente experiencia de usuario en múltiples plataformas.

### ¿Para qué hace falta un lenguaje nuevo?

A pesar de su dominio, JavaScript tenía sus problemas, especialmente cuando se trataba de manejar proyectos de gran escala y garantizar la seguridad del código. Dart fue diseñado para abordar estos problemas directamente, proporcionando una sintaxis más intuitiva y características avanzadas que prometían facilitar el desarrollo de aplicaciones complejas y su mantenimiento.


## ¿Cómo funciona Dart?

Dart ha sido diseñado para ser tanto flexible como potente, adecuado para una amplia variedad de aplicaciones de desarrollo, desde sitios web hasta aplicaciones móviles y servidores.

### Compilación y ejecución

Dart es único en su capacidad para ser compilado de dos maneras diferentes:

- **Just-In-Time (JIT) Compilation**: Durante el desarrollo, Dart se puede compilar de forma JIT, lo que significa que el código se compila sobre la marcha mientras se está desarrollando. Esto permite a los desarrolladores disfrutar de características como la recarga en caliente (hot reload), donde los cambios en el código pueden ser vistos casi instantáneamente sin necesidad de reiniciar la aplicación completa. Este enfoque es particularmente útil durante el desarrollo de aplicaciones Flutter.
- **Ahead-Of-Time (AOT) Compilation**: Para la producción, Dart puede ser compilado AOT. En este modo, el código Dart se compila en código de máquina nativo (dependiente de la plataforma) antes de que la aplicación se ejecute. Esto resulta en un arranque más rápido y un rendimiento generalmente mejorado, ya que el código ya está compilado a la forma más eficiente antes de la ejecución.

### Ejecución

Dart se ejecuta en la Dart Platform, que incluye la Dart VM con un compilador JIT integrado y una implementación AOT. La plataforma también soporta un amplio conjunto de bibliotecas core que proporcionan funcionalidades comunes necesarias para el desarrollo de aplicaciones modernas.

### Ejecución en navegadores

Para garantizar que las aplicaciones Dart puedan ejecutarse en todos los navegadores modernos, Dart se puede transpilar a ECMAScript, una norma de JavaScript. Esto permite que las aplicaciones escritas en Dart se ejecuten en navegadores que no tienen una máquina virtual Dart nativa.

### Uso con Flutter

Además de su uso en aplicaciones web y de servidor, Dart es quizás más conocido por ser el lenguaje de programación para Flutter, el popular framework de Google para desarrollar interfaces de usuario nativas para móviles, web y desktop desde una única base de código. Dart se integra perfectamente con Flutter debido a su compilación AOT, que facilita el rendimiento de las animaciones y transiciones suaves que son críticas para las aplicaciones móviles modernas.

## ¿Dónde usar Dart?

- **Desarrollo Web**: puede ser utilizado para construir aplicaciones web ricas y de alto rendimiento. Al ser compilado en JavaScript, permite que los programas escritos en Dart se ejecuten en cualquier navegador moderno. Esto es posible gracias a la herramienta Dart2JS, que convierte el código Dart en JavaScript optimizado. Además, Dart ofrece un conjunto de bibliotecas que facilitan la manipulación del DOM, el manejo de eventos, y otras funcionalidades típicas del desarrollo web.
- **Desarrollo de Aplicaciones Móviles**: Uno de los usos más prominentes de Dart es en el desarrollo de aplicaciones móviles a través de Flutter, un framework de UI que permite crear interfaces de usuario nativas para iOS y Android desde un único código base. Dart ofrece características como la compilación AOT para asegurar que las aplicaciones Flutter se ejecuten de manera rápida y fluida en dispositivos móviles.
- **Desarrollo de Aplicaciones de Escritorio**: Flutter y Dart también se extienden al desarrollo de aplicaciones de escritorio. Esto incluye soporte para plataformas como Windows, macOS y Linux. Los desarrolladores pueden aprovechar Dart para crear aplicaciones de escritorio nativas con un rendimiento cercano al del nivel del sistema operativo.
- **Aplicaciones del Lado del Servidor y Backend**: Dart no se limita solo al desarrollo del lado del cliente; también es una excelente opción para el desarrollo del lado del servidor. Con características como la asincronía integrada y un rico conjunto de bibliotecas para operaciones de entrada/salida, Dart es adecuado para construir servidores web y microservicios. Además, herramientas como Aqueduct y Shelf ofrecen frameworks robustos para construir APIs y servicios web en Dart.
- **Internet de las Cosas (IoT)**: Aunque no es el uso más común, Dart también se puede utilizar en aplicaciones de IoT.

## ¿Por qué usar Dart?

1. Optimizado para UI
2. Productividad del Desarrollador
3. Compatibilidad con Todos los Navegadores
4. Alto rendimiento
5. Concurrencia y Asincronía
6. Fuerte Apoyo y Comunidad

## ¿Dónde programo Dart?

Para programar en Dart, puedes utilizar una variedad de entornos y herramientas que facilitan tanto la escritura del código como la prueba y el despliegue de las aplicaciones.

1. [DartPad](https://dartpad.dev/): herramienta en línea desarrollada por Google.
2. [Visual Studio Code (VS Code)](https://code.visualstudio.com/): es uno de los editores de código más populares y versátiles. Para programar en Dart, puedes instalar la extensión oficial de Dart y Flutter.
3. [Android Studio](https://developer.android.com/studio?hl=es-419) e [IntelliJ IDEA](https://www.jetbrains.com/idea/): Para un desarrollo más integrado, especialmente si estás trabajando con Flutter.

## Dart vs Flutter

Antes de nada, Dart y Flutter no nacieron para ser enfrentados si no para formar un equipazo.
Dart es un lenguaje de programación de propósito general. En cambio, Flutter es un framework de UI que utiliza Dart como su lenguaje de programación. 

En resumen, Dart y Flutter trabajan juntos para proporcionar una plataforma robusta para desarrollar aplicaciones móviles, web y de escritorio. Mientras que Dart aporta la base del lenguaje de programación, Flutter amplía esta base con poderosas herramientas de UI que permiten una creación eficiente y efectiva de interfaces de usuario hermosas y funcionales.

## Proyectos que utilizan Dart

Vas a flipar con todos los proyectos que utilizan Dart y no lo sabías, probablemente uses Dart a menudo sin darte cuenta. 

- Google Ads: utiliza Flutter y, por consiguiente, Dart para su aplicación móvil.
- Alibaba: utiliza Flutter (y por lo tanto Dart) para su aplicación móvil Xianyu.
- BMW: ha usado Flutter y Dart para desarrollar su aplicación BMW Connected.
- The New York Times: el famoso periódico utilizó Flutter y Dart para crear su juego de rompecabezas KenKen.
- Hamilton Musical: aplicación oficial del musical de Broadway "Hamilton".
- Rive: herramienta de diseño y animación.
- Philips Hue: la aplicación de Philips para controlar sus productos de iluminación inteligente Hue. 