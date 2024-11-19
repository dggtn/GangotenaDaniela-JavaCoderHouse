# Sistema de Administración de Ventas

## Descripción del Proyecto

Este proyecto consiste en una aplicación Java para administrar las ventas de un comercio. La aplicación permite gestionar las transacciones de los clientes, calcular el precio total de la venta, el número de productos vendidos, y generar comprobantes de venta. Se integra con un servicio REST externo para obtener la fecha del comprobante y, en caso de fallo, calcula la fecha usando la clase `Date` de Java.

### Actores del Sistema:
- **Cliente**: Realiza las compras de productos.
- **Productos**: Son los elementos que conforman las ventas del comercio.
- **Administrador**: Puede gestionar los productos, clientes y ventas.

## Objetivos Generales

- **Integrar los conocimientos** adquiridos hasta el momento en la creación de una aplicación funcional.
- **Diseñar una solución** que cumpla con las necesidades del sistema de ventas de un comercio.

## Objetivos Específicos

1. **Entendimiento de los cambios de negocio**: La aplicación debe adaptarse a nuevas validaciones y cambios de requerimientos de negocio.
2. **Agregar validaciones**: Se deben validar ciertos datos, como la fecha del comprobante y el cálculo del precio total.
3. **Consumo de servicios externos**: Obtener la fecha del comprobante de un servicio REST (`http://worldclockapi.com/api/json/utc/now`).
4. **Validación del sistema ante nuevos requerimientos**: Si el servicio REST falla, calcular la fecha usando la clase `Date` de Java.
5. **Cálculo de la venta**: La aplicación debe calcular el precio total de la venta y la cantidad de productos vendidos.

## Requisitos

- **Java 8 o superior**: El proyecto fue desarrollado utilizando Java.
- **Postman**: Se incluye una colección de Postman para facilitar las pruebas del proyecto.
- **Base de datos**: Utiliza una base de datos relacional (SQL) para almacenar la información de ventas y productos. Un script de creación de tablas está disponible para su uso.

## Características del Proyecto

- **Generación de comprobantes de venta**.
- **Cálculo del precio total y la cantidad de productos vendidos**.
- **Validaciones de datos de entrada y respuesta**.
- **Integración con un servicio REST para obtener la fecha del comprobante**.
- **Manejo de excepciones**: En caso de error en el servicio REST, se calculará la fecha localmente.

## Instrucciones de Instalación

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

### 1. Clonar el Repositorio

Clona este repositorio usando el siguiente comando:

```bash
git clone https://gitlab.com/tu_usuario/FacturacionEntregaProyectoFinal+Apellido.git
2. Compilar y Empaquetar el Proyecto
Asegúrate de tener Java 8 o superior instalado en tu máquina. Luego, navega al directorio del proyecto y ejecuta el siguiente comando para compilar y empaquetar el proyecto en un archivo .jar ejecutable:

bash
Copiar código
mvn clean package
Este comando generará el archivo ejecutable FacturacionEntregaProyectoFinal+Apellido.jar en el directorio target.

3. Ejecutar el Proyecto
Para ejecutar el archivo .jar, usa el siguiente comando:

bash
Copiar código
java -jar FacturacionEntregaProyectoFinal+Apellido.jar
4. Creación de la Base de Datos
Utiliza el script SQL proporcionado en el proyecto para crear las tablas necesarias en la base de datos. El script se encuentra en el archivo crear_tablas.sql y contiene las instrucciones necesarias para crear las tablas de productos, ventas y clientes.

5. Probar el Proyecto con Postman
La colección de Postman está incluida en el repositorio para probar las funcionalidades del proyecto. Importa la colección y realiza las siguientes pruebas:

POST /venta: Crear una nueva venta con los productos seleccionados.
GET /venta/{id}: Obtener los detalles de una venta.
POST /comprobante: Generar un comprobante de venta con la fecha actual.
Importa la colección de Postman desde el archivo FacturacionEntregaProyectoFinal+Apellido.postman_collection.json.

6. Requisitos de la API
Servicio de fecha: La fecha del comprobante se obtiene del servicio REST: http://worldclockapi.com/api/json/utc/now.
Fallo del servicio: Si el servicio REST no responde, la fecha se calculará localmente con la clase Date de Java.
Estructura del Proyecto
bash
Copiar código
FacturacionEntregaProyectoFinal+Apellido/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tu_empresa/
│   │   │           ├── Main.java            # Clase principal para ejecutar la aplicación
│   │   │           ├── VentaController.java  # Controlador para gestionar ventas
│   │   │           └── VentaService.java     # Lógica de negocio para la gestión de ventas
│   │   └── resources/
│   │       ├── application.properties        # Configuraciones de la base de datos
│   │       └── crear_tablas.sql              # Script de creación de tablas
├── target/
│   └── FacturacionEntregaProyectoFinal+Apellido.jar  # Archivo .jar ejecutable
└── FacturacionEntregaProyectoFinal+Apellido.postman_collection.json  # Colección de Postman
Validaciones Implementadas
Fecha del comprobante: Se obtiene del servicio REST, o se calcula usando Date en caso de error.
Cálculo del precio total de la venta: El precio total se calcula sumando los precios de todos los productos vendidos.
Validación de cantidad de productos: Se asegura que la cantidad de productos no sea negativa o cero.
Enlace al Proyecto GitLab
El proyecto final ha sido subido a GitLab en el siguiente enlace:

Enlace al Proyecto GitLab

Video de Demostración
Aquí puedes ver un video de demostración de cómo funciona la aplicación:

Demostración en Video

Conclusiones
Este proyecto permite aplicar los conocimientos adquiridos durante el curso, integrando la creación de una aplicación de ventas con validaciones, consumo de servicios externos y cálculos automatizados. La solución propuesta cumple con los requisitos del sistema y está lista para ser desplegada en un entorno de producción.

Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
