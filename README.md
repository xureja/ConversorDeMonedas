
# 🌍 Conversor de Monedas

¡Bienvenido a mi proyecto! Este es un sencillo pero útil **conversor de monedas** que permite convertir montos en USD a monedas de Latinoamérica 🌎 y registrar un historial de conversiones.

## 🚀 ¿Qué hace este proyecto?

1. **Consulta de tasas de cambio en tiempo real**  
   Utiliza una API de tasas de cambio para obtener las conversiones más recientes (cortesía de [ExchangeRate-API](https://www.exchangerate-api.com/)).

2. **Conversión entre monedas populares**  
   Convierte montos en USD a monedas como:
   - MXN (Peso Mexicano)
   - COP (Peso Colombiano)
   - BRL (Real Brasileño)
   - ARS (Peso Argentino)
   - CLP (Peso Chileno)
   - PEN (Sol Peruano)
   - UYU (Peso Uruguayo)
   - VEF (Bolívar Venezolano)

3. **Historial de conversiones**  
   Guarda automáticamente las conversiones realizadas en un archivo llamado `conversion_history.json`. ¡Así siempre tendrás un registro de tus cálculos!

---

## 🛠️ ¿Cómo funciona?

### Menú interactivo
El programa te guía paso a paso con un menú muy intuitivo:

1. **Ver lista de monedas disponibles**: Consulta las opciones disponibles para conversión.  
2. **Realizar una conversión**: Ingresa el monto en USD y selecciona una moneda de destino para obtener el resultado.  
3. **Ver historial de conversiones**: Consulta un registro de todas las conversiones realizadas.  
4. **Salir**: Finaliza el programa.

### Tecnologías utilizadas
- **Java**: Lenguaje principal.
- **Gson**: Para manejar los datos en formato JSON.
- **API de ExchangeRate**: Fuente de las tasas de cambio.

---

## 🛠️ Configuración del Proyecto

### Requisitos previos
Asegúrate de tener instalado lo siguiente:
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)  
- Un IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) o [Eclipse](https://www.eclipse.org/).  
- Conexión a Internet para acceder a la API.

### Instalación
1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/conversor-monedas.git
   cd conversor-monedas
   ```
2. Asegúrate de que las dependencias (como Gson) estén configuradas. Si usas Maven o Gradle, agrega la dependencia de Gson en el archivo `pom.xml` o `build.gradle`.

3. Configura la **clave de API**:
   - Ve a [ExchangeRate-API](https://www.exchangerate-api.com/) y obtén una clave gratuita.  
   - Reemplaza la URL en el archivo `Main` por tu clave de API:
     ```java
     private static final String API_URL = "https://v6.exchangerate-api.com/v6/TU_CLAVE_API/latest/USD";
     ```

4. Ejecuta el proyecto desde tu IDE o mediante la línea de comandos:
   ```bash
   javac Main.java
   java Main
   ```

---

## 📋 Uso

1. Al iniciar, verás un menú como este:
   ```
   === Bienvenido al Conversor de Monedas ===
   1. Ver lista de monedas
   2. Realizar conversión
   3. Ver historial de conversiones
   4. Salir
   ```

2. Selecciona la opción que desees y sigue las instrucciones.

3. ¡Disfruta de las conversiones en tiempo real! 🎉

---

## 🏗️ Cómo está organizado el código

El proyecto sigue una estructura modular para que sea fácil de mantener y ampliar:
- **`SupportedCurrencies`**: Lista de monedas disponibles.  
- **`ExchangeRateApiClient`**: Encargada de consumir la API.  
- **`CurrencyConverter`**: Realiza cálculos de conversión.  
- **`ConversionHistory`**: Maneja el historial de conversiones en formato JSON.  
- **`Menu`**: Controla la interacción con el usuario.  
- **`Main`**: Punto de entrada del programa.

---

## 🌟 Inspiración

Este proyecto fue diseñado para ser:
1. Un ejercicio práctico de modularidad en Java.  
2. Una solución útil para quienes trabajan frecuentemente con divisas en Latinoamérica.  
3. Un ejemplo claro de integración de una API externa.

---

## 🙌 Contribuciones

¿Tienes ideas para mejorar el proyecto? ¡Nos encantaría escuchar tus sugerencias! Puedes:
- Crear un **pull request**.  
- Abrir un **issue** para sugerir nuevas funcionalidades o reportar problemas.

---

## 📖 Licencia

Este proyecto es de código abierto y está disponible bajo la [licencia MIT](https://opensource.org/licenses/MIT). Siéntete libre de usarlo y adaptarlo a tus necesidades. 🌱

---

¡Gracias por usar el Conversor de Monedas! Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarme. 😊
