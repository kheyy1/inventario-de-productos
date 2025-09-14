GESTOR DE INVENTARIO

Version 0.0
COMMIT 1 -> Primera version funcional

Se implementó como primera idea, la linea
        ArrayList<ArrayList<String>> inventario = new ArrayList<>();
la cual significa la creacion de un ArrayList, cuyos elementos son Arraylist.

Se decidio implementar un menú el cual presente las seis opciones distintas que queremos ofrecer al usuario.
Además, se usará un switch el cual contemplara cada opcion (del uno al seis), y el caso default.
La opcion seis (6) es para finalizar con la ejecucion del codigo. Para implementar su funcionalidad, se utilizó un
do-while, el cual repite el bucle de todo el programa, mientras la seleccion sea distinta a 6.

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

