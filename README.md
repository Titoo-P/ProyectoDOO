# ProyectoDOO

Nombres:
  -Roberto Cruz Pinto

Enunciado:
  Tema 2: Sistema de reserva de asientos de autobús

Diagrama de clases UML: 
![UML](https://github.com/Titoo-P/ProyectoDOO/assets/132025860/097e3655-1511-4894-a6c1-885e6c21aa88)

Diagrama de casos de uso: 

![DiagramaDeCasos](https://github.com/Titoo-P/ProyectoDOO/assets/132025860/8e954bab-1fce-45bd-88cd-e400661ea3c2)

Imagenes de la GUI del Proyecto:

![Imagen01Proyecto](https://github.com/Titoo-P/ProyectoDOO/assets/132025860/1153acd3-23c3-4dbf-8d75-5300273062bd)
![Imagen02Proyecto](https://github.com/Titoo-P/ProyectoDOO/assets/132025860/99d7e9eb-2ab7-43da-9383-6a7ab6dbaaeb)


Lista y patrones utilizados:

 - Singleton: El patrón Singleton asegura que haya una única instancia de SistemaDeReservas en todo el sistema, permitiendo un punto de acceso global a dicha instancia. Esto es útil para mantener el estado global de las reservas y proporcionar métodos                 centralizados para gestionar los autobuses y sus asientos.
 - Factory Method: SistemaDeReservas para la creación de Autobus. El Factory Method proporciona una interfaz para la creación de objetos Autobus dentro del sistema, permitiendo a las subclases o métodos especializados de SistemaDeReservas crear diferentes tipos de    autobuses sin especificar las clases concretas que se crearán. Esto es útil cuando quieres extender la aplicación para soportar diferentes tipos de autobuses en el futuro.
 - Observer: Comunicación entre BusReservacionGUI y SistemaDeReservas. El patrón Observer se utiliza para notificar a BusReservacionGUI sobre los cambios en el estado de las reservas (como cuando se reserva un asiento). Esto permite que la interfaz gráfica se     
   actualice automáticamente cuando hay cambios en el sistema de reservas.
 - Template Method: Métodos de reservación en SistemaDeReservas. El patrón Template Method define el esqueleto de un algoritmo en una superclase, pero permite a las subclases sobrescribir ciertos pasos del algoritmo sin cambiar su estructura general. En este caso,    puedes tener diferentes estrategias para reservar asientos en función de la categoría del asiento (salón cama o semi cama), mientras reutilizas la estructura general del método de reservación.

Desiciones del Proyecto: 

A primera instancia se habia decidido usar recursos y fondos personalizados hecho en photoshop, pero se cambio a los propios componentes y medios que da JAVA descubriendo el potencial y la facilidad en la Implementacion de estas.
Decidimos implementar el patrón Singleton en la clase SistemaDeReservas para asegurar que haya una única instancia de este sistema a lo largo de toda la aplicación.
Despues Optamos por el patrón Factory Method para la creación de instancias de Autobus dentro del SistemaDeReservas. Esto nos permitió centralizar la lógica de creación y facilitar la extensión futura del sistema para soportar diferentes tipos de autobuses.
lo Siguiente fue usar un patrón Observer del cual se utilizó para mantener la interfaz gráfica (BusReservacionGUI) sincronizada con el estado de las reservas en el SistemaDeReservas. Esta decisión permitió que la interfaz se actualice automáticamente al reservar o cancelar asientos, mejorando la experiencia del usuario y la eficiencia en la actualización de la GUI

Las decisiones tomadas en este proyecto se centraron en construir un sistema de reservas que fuera eficiente, escalable, y fácil de mantener. La aplicación de patrones de diseño bien conocidos, la modularización de la interfaz de usuario y el manejo robusto de recursos y excepciones contribuyeron significativamente a alcanzar estos objetivos. No solo cumple con los requisitos actuales, sino que también proporciona una base sólida para futuras mejoras y extensiones del programa.

Problemas encontrados:

Se empezo tarde en el Proyecto, por lo que falto mayor comunicacion y testeo con el referente.
Tambien con la creacion de las Excepciones, donde la falla de esta tuve que recurrir a ayuda externa para solucionarlo.


//////// CAMBIOS DESPUES DE LA ENTREGA INICIAL /////////

-Implementación de Patrones de Diseño-
Singleton: El patrón Singleton se ha implementado en la clase SistemaDeReservas para asegurar que solo exista una instancia del sistema de reservas en toda la aplicación.

Factory: El patrón Factory se ha implementado en la clase AutobusFactory para crear instancias de diferentes tipos de autobuses basados en un parámetro tipo.
