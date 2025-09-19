GESTOR DE INVENTARIO

Version 0.0
COMMIT 1 -> Primera version funcional


Se implementó como primera idea, la linea
ArrayList<ArrayList<String>> inventario = new ArrayList<>();
la cual significa la creacion de un ArrayList, cuyos elementos son Arraylist.

Se decidio implementar un menú el cual presente las seis opciones distintas que queremos ofrecer al usuario.
Además, se usará un switch el cual contemplara cada opcion (del uno al seis), y el caso default.

Primera opcion: Agregar un nuevo producto.
Para la funcionalidad de esta opcion, se desarrolló un algoritmo que cuenta con varias partes:
1. Carteles amigables a la vista, con separadores, que indican al usuario lo que debe hacer, o lo que está observando.
2. Los datos solicitados (Nombre, Precio y Cantidad), se leen con un scanner, y se almacenan en variables cuya
funcion es almacenar estos valores temporalmente, para posteriormente (Ln.35-39) crear un nuevo elemento del ArrayList 
principal
ArrayList<String> fila = new ArrayList<>();
Y agregar por medio del metodo .add, nuevos elementos a los sub-ArrayList, a los cuales se les asigna los valores tomados
y almacenados anteriormente en variables.

Segunda opcion: Quitar un producto existente.
Para la seleccion, utiliza un for each, el cual cuenta con un contador que va aumentando cada iteracion, de tal forma 
que podemos colocar un sout al final del bucle, en el que se imprima cada nombre de los productos, y ademas, la variable
contador que genera una especie de indice por medio de la cual el usuario puede ver facilmente que "indice" esta asignado 
a que producto.
Para quitar el producto seleccionado por el usuario, valida lo que ingresó, por medio de un condicional, que se asegura
de que el valor sea positivo, y no sea mayor al tamaño del ArrayList principal, con el metodo .size().
Si esta condicion es superada, se usa el metodo .remove() para eliminar el elemento con el indice seleccionado, del 
ArrayList principal.

Tercera opcion: Cambiar el precio de un producto existente.
Para la seleccion se usa el mismo metodo ya explicado en el anterior caso.
Para la modificacion del valor precio, se lee por teclado el nuevo valor deseado, y valida que sea un numero
en el rango [1,6]. Posteriormente, se utiliza el metodo .set(), el cual permite reasignar un valor a un elemento de un
arreglo.

Cuarta opcion: Cambiar la cantidad de un producto.
Para la seleccion, se usa el mismo metodo ya explicado en el segundo caso.
Se realiza el mismo proceso que para la tercera opcion, reasignando un valor, por medio del metodo .set().

Quinta opcion: Mostrar estado actual del inventario.
Se utiliza un for each para realizar el proceso de "mostrado" de cada elemento del ArrayList principal.
Dentro de este bucle, se crean dos variables nuevas, las cuales reciben los valores tras haber pasado a través de los metodos
Float.parseFloat() y Integer.parseFloat().
Estos metodos convierten los valores que veniamos almacenando como Strings, en su tipo de dato numerico correspondiente, 
esto, con el motivo de que para calcular el total, necesitamos operar con valores numericos.
La razon por la que tenemos que realizar esta conversion obligatoriamente, es que los ArrayList solo admiten un tipo de dato
por lo que no podriamos implementar un Arrey por producto, pues los nombres suelen ser Strings, las cantidades numeros
enteros, y los precios pueden ser decimales. Es por esto que el tipo String es el que nos va a admitir ingresar todo
tipo de dato, y para poder usarlo matematicamente a posteriori, como es el caso, se debe realizar una conversion de tipo.
Para calcular el valor total del inventario, se utiliza una variable que va acumulando cada total de cada producto.

Sexta opcion: Salir del programa.
No implementada.

Version 0.1
Commit 2 -> Agregada funcionalidad de salir del menú


En esta segunda version de nuestro inventario, se implemeto la funcionalidad de la sexta opcion del menú (salir del menú).
Para ello, se utilizo un do-while, el cual permanece en bucle mientras la opcion seleccionada sea distnta de 0, por medio
de la condicion: do - while (seleccion != 0).

Version 0.2
Commit 3 -> Cambios menores.


Se encontró un error por medio del cual, los condicionales que validan la entrada de datos, mas espcificamente esta linea:
if (seleccion >= 0 && seleccion <= inventario.size())
contenia un error, pues el segundo operador logico no deberia ser <=, sino simplemente <.
Se solucionó, y ademas, se agregaron comentarios que aclaraban los indices mas utilizados.

Version 0.3
Commit 4 -> Solucion de excepcion en el menú principal.


Se encontro un problema el cual no teniamos conocimientos para solucionar.
Descripcion del problema:
Al solicitar un dato en el rango [1,6] al principio del menú, era simple solucionar el error que se generaria si se ingresara
un numero fuera del rango, por medio de la opcion default del switch.
Sin embargo, tambien existia la posibilidad de que el usuario no ingresara un valor numerico, sino que el valor ingresado fuese texto.
Esto arrojaba un error con los tipos de dato, que no podiamos solucionar con los conocimientos que teniamos hasta el momento.
Solucion:
Se hizo una breve busqueda de alguna funcion que nos pudiese ayudar, con lo que encontramos el metodo de los scanners ".hasNext()"
el cual puede devolver un boolean, en funcion de si el valor leido por teclado es del tipo de dato que nosotros especifiquemos.
Asi que lo implementamos en la linea 21, por medio de un condicional if, de tal forma que si el tipo de dato no era en este caso, un 
numero entero, se evitaba una excepcion gracias a un else.

Version 0.4
Commit 5 -> Cambios importantes.


En esta version, se agregaron comentarios a todo el codigo para mejorar la legibilidad del mismo.
Además, se realizo un cambio de gran importancia.
La principal forma de almacenar datos hasta este punto era esta:
ArrayList<ArrayList<String>> inventario = new ArrayList<>();
Un ArrayList cuyos elementos eran otros ArrayLists. Sin embargo, se identifico que era innecesario hacer que los sub arreglos
fuesen tambien ArrayLists, pues nunca se iban a ingresar mas de tres elementos (precio, cantidad, nombre).
Por lo que se cambio a un ArrayList cuyos elementos sean Arrays simples.
ArrayList<ArrayList<String>> inventario = new ArrayList<>();
Para la implementacion de esta mejora, se modificaron algunas cosas en todo el codigo, sobre todo en la forma de llamar a lo 
que antes eran ArrayLists, pues ahora, al ser Arrays normales, se simplificaba mucho el codigo.

Version 0.5
Commits 6 y 7 -> Robustez.
El programa funcionaba, cumplia con lo que pedia, sin embargo, era muy facil caer en excepciones, sobre todo, de tipos de datos.
Por lo que hicimos un analisis de todos los posibles errores, obteniendo los siguientes:
POSIBLES ERRORES:
En el caso 1:
Se ingresa un texto al solicitar cantidad, o precio.
Se ingresa un decimal al solicitar cantidad.
Se ingresa un numero negativo al solicitar cantidad o precio.

En el caso 2:
No hay productos.
Se ingresa un texto al solicitar codigo del producto.
Se ingresa un decimal al solicitar codigo del producto.
Se ingresa un numero negativo para solicitar codigo del producto.

En el caso 3:
No hay productos.
Se ingresa un texto al solicitar codigo del producto.
Se ingresa un decimal al solicitar codigo del producto.
Se ingresa un numero negativo para solicitar codigo del producto.
Se ingresa un numero negativo al solicitar el nuevo precio.
Se ingresa un texto al solicitar el nuevo precio.

En el caso 4:
No hay productos.
Se ingresa un texto al solicitar codigo del producto.
Se ingresa un decimal al solicitar codigo del producto.
Se ingresa un numero negativo para solicitar codigo del producto.
Se ingresa un numero negativo al solicitar la nueva cantidad.
Se ingresa un texto al solicitar la nueva cantidad.
Se ingresa un decimal al solicitar la nueva cantidad.

En el caso 5: 
No hay productos.

Todos los errores descritos, fueron solucionados por medio del metodo ".hasNextInt()", ".hasNextFloat()" y el uso de condicionales.
## Authors

- [@Kheyner](https://github.com/kheyy1)
- [@Jerix](https://github.com/jgbaezn-cyber)
- [@Richard](https://github.com/richardmejiagomez45-cmd)


