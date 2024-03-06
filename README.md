# GalaxyCalculator

Prueba técnica de traducción de texto particular a números romanos y posteriormente a números arábicos

Descripción del proyecto:

Decidiste renunciar a la tierra después de que el último colapso financiero dejara al 99,99% de la población mundial con el 0,01% de la riqueza. Por suerte, con la escasa suma de dinero que te queda en tu cuenta, puedes permitirte alquilar una nave espacial, abandonar la Tierra y volar por toda la galaxia para vender metales comunes y tierra (que aparentemente vale mucho).

Comprar y vender en toda la galaxia requiere que conviertas números y unidades, y decidiste escribir un programa para ayudarte.

Los números utilizados para las transacciones intergalácticas siguen una convención similar a la de los números romanos y usted ha recopilado minuciosamente la traducción adecuada entre ellos.

Entrada:

La entrada a su programa consiste en líneas de texto que detallan sus notas sobre la conversión entre unidades intergalácticas y números romanos.

Se espera que maneje las consultas no válidas de manera adecuada.

Entrada de prueba:

globo soy yo

prok es V

pis es X

tegj es L

glob glob Plata cuesta 34 créditos

glob prok Gold cuesta 57800 créditos

pish pish Hierro es 3910 Créditos

¿Cuánto cuesta pish tegj glob glob?

¿Cuántos créditos tiene Glob Prok Silver?

¿Cuántos créditos tiene Glob Prok Gold?

¿Cuántos créditos tiene Glob Prok Iron?

¿Cuánta madera podría arrojar una marmota si una marmota pudiera arrojar madera?

Los números romanos se basan en siete símbolos:

Símbolo

Valor
I = 1
V = 5
X = 10
l = 50
C = 100
D = 500
M = 1000

Los números se forman combinando símbolos y sumando los valores. Por ejemplo, MMVI es 1000 + 1000 + 5 + 1 = 2006. Generalmente, los símbolos se colocan en orden de valor, comenzando con los valores más grandes. Cuando los valores más pequeños preceden a los valores más grandes, los valores más pequeños se restan de los valores más grandes y el resultado se suma al total. Por ejemplo MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.


Proceso:

Los símbolos "I", "X", "C" y "M" se pueden repetir tres veces seguidas, pero no más. (Pueden aparecer cuatro veces si el tercero y el cuarto están separados por un valor menor, como XXXIX). "D", "L" y "V" nunca se pueden repetir.

"I" sólo se puede restar de "V" y "X". "X" sólo se puede restar de "L" y "C". "C" se puede restar de "D" y "M" únicamente. "V", "L" y "D" nunca se pueden restar.

Sólo se puede restar un símbolo de valor pequeño de cualquier símbolo de valor grande.

Un número escrito en números arábigos se puede dividir en dígitos. Por ejemplo, 1903 se compone de 1, 9, 0 y 3. Para escribir el número romano, cada uno de los dígitos distintos de cero debe tratarse por separado. En el ejemplo anterior, 1000 = M, 900 = CM y 3 = III. Por lo tanto, 1903 = MCMIII.


Salida:

La salida debe dar como resultado el texto galáctico y su equivalente en Aravico, si se menciona el metal debe mostrar los créditos equivalentes

Salida de prueba:

pish tegj glob glob es 42
glob prok Silver cuesta 68 créditos
glob prok Gold cuesta 57800 créditos
glob prok Hierro es 782 créditos
No tengo ni idea de lo que estás hablando

El programa debe generar el texto traducido final.


Implementación sugerida


El lenguaje de programación es Java 17.
La interfaz de usuario es por consola.

Instrucciones de ejecución
Clona el repositorio:
git clone https://github.com/Reinel-Steven/GalaxyCalculator/tree/master


Ejecuta el programa:

La interfaz se realizo por consola, por esta razon la mejor forma de correr el proyecto es con un IDE como Eclipse o IntelliJ, etc:

/***********************************************************************/
Instrucciones:
	el proyecto cuenta con un menu por consola ubicado en el main de la clase "CalculatorController" dando run java Aplication nos muestra las siguientes opciones:
		----------------------- Menú ----------------------
1. Insertar Diccionario
2. Traducir Texto
3. Insertar Diccionario Script
4. Calcular número romano
5. Salir

Entonces en: 
1. encontramos la opción de ingresar el diccionario con las traducciones que necesitemos por default  esta la descrita en "entradas" 

2. En esta opción podemos ingresar el texto que queremos traducir con el diccionario definido, también nos da la opción de ingresar los datos de entrada mencionado anteriormente

3. Insertar Diccionario Script aún no está desarrollado, en el momento funciona para restablecer el diccionario test, su funcionalidad será implementar el ingreso de todo el script y lo lea línea a línea como el ejemplo del requerimiento

4. Nos retorna el valor del número romano que ingresamos, o podemos dar la opción "ok" y nos arroja variables estáticas de romanos con su valor o sus validaciones


/***********************************************************************/

Nota: Por el tiempo limitado el proyecto se encuentra con varias anomalías como la mescla de español e inglés, considerando el corto tiempo para el desarrollo del mismo  


Contacto
Ing. Reinel Steven Bolaños Martinez
reinelstevenb@gmail.com
cel: 3184090989
