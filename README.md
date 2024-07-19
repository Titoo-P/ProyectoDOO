# ProyectoDOO
Nombres:
  -Roberto Cruz Pinto

Enunciado:
  Tema 2: Sistema de reserva de asientos de autobús

//////// Nuevos cambios Para ENTREGA 19/07/2024 /////////

-Implementación de Patrones de Diseño-

Singleton: El patrón Singleton se ha implementado en la clase SistemaDeReservas para asegurar que solo exista una instancia del sistema de reservas en toda la aplicación.
Factory: El patrón Factory se ha implementado en la clase AutobusFactory para crear instancias de diferentes tipos de autobuses basados en un parámetro tipo.

-- Cambio Generales --
-Se modifico la logica para que se pudiera retroceder y ordenar asientos para diferentes buses al mismo tiempo.
-Tambien se modifico para que al cerrar el Proyecto, cree un Reporte_reservas.txt donde se detalla todos los asientos comprados y el nombre del usuario.
-se Agrego un icono para el programa, se agrego un enum para las direcciones de las imagenes y se arreglo gran parte del UML
-Se agrego herencias para autobuses. extendiendolo a BiopioAutobus y PullwomanAutobus
-Se agrego Javadoc

Diagrama de clases UML Actualizado: 
![Untitled (1)](https://github.com/user-attachments/assets/231ba45c-e40b-48b7-bf0b-cb59b6e2fbbd)

Diagrama de casos de uso: 

![DiagramaDeCasos](https://github.com/user-attachments/assets/524b9a4c-7be5-482a-8bd2-d266258d0e94)


Imagenes de la Gui del Proyecto Actualizado:

![fotoproyecto1](https://github.com/user-attachments/assets/7d2c2a84-ba3a-47fa-8312-1b87922b8ff9)
![Fotoproyecto2](https://github.com/user-attachments/assets/1008d70a-cba4-4b08-83dd-eb754b5aef34)

///////////  Informe entrega 8/7/2024   ////////////

Lista y patrones utilizados:

 - Singleton: El patrón Singleton asegura que haya una única instancia de SistemaDeReservas en todo el sistema, permitiendo un punto de acceso global a dicha instancia. Esto es útil para mantener el estado global de las reservas y proporcionar métodos                 centralizados para gestionar los autobuses y sus asientos.
 - Factory Method: SistemaDeReservas para la creación de Autobus. El Factory Method proporciona una interfaz para la creación de objetos Autobus dentro del sistema, permitiendo a las subclases o métodos especializados de SistemaDeReservas crear diferentes tipos de    autobuses sin especificar las clases concretas que se crearán. Esto es útil cuando quieres extender la aplicación para soportar diferentes tipos de autobuses en el futuro.

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
