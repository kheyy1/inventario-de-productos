import java.util.Scanner;
import java.util.ArrayList;

public class ManejoDeInventario {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String[]> inventario = new ArrayList<>(); // Vamos a utilizar un Arraylist cuyos elementos son arrays
                                                            // de Strings
        int seleccion = 0;
        int contador = 0;
        boolean datoEsInvalido = true;
        do { // Implementamos este do-while para poder romper el ciclo si el usuario usa la
             // opcion 6 (salir del menu)
            System.out.println("Menú"); // imprimir el menu con sus seis opciones
            System.out.println("1. Agregar un producto nuevo al inventario");
            System.out.println("2. Retirar un producto del inventario");
            System.out.println("3. Modificar un precio de un producto");
            System.out.println("4. Modificar cantidad de un producto");
            System.out.println("5. Ver el estado actual del inventario");
            System.out.println("6. Salir del programa");
            System.out.println();
            System.out.println("¿Que desea hacer?");
            System.out.println();
            if (teclado.hasNextInt()) { // Para evitar la excepcion InputMismatchException ocasionada por ingresar un
                                        // string, char, o decimal
                seleccion = teclado.nextInt();// cuando el scanner espera un Int, se utiliza el metodo de los scanners
                                              // ".hasNextInt" el cual
                teclado.nextLine(); // devuelve un booleano, true si se lee lo que esperamos (un int), y false si es
                                    // otro tipo de dato, y lo implementamos a un condicional
            } else {
                System.out.println("Ingresa un valor valido por favor");
                teclado.nextLine();
                continue;
            }
            switch (seleccion) { // Switch principal que maneja los diversos casos que se plantean en el menu
                                 // (1-6), y tambien el caso default por si el valor ingresado no es valido
                case 1:
                    System.out.println("Agregar un producto al inventario");
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese el nombre de su producto");
                    String nombreProducto = teclado.nextLine();
                    System.out.println("---------------------------------");
                    String precioProducto = "";
                    while (datoEsInvalido) { // Este bucle while se va a repetir hasta que se ingresa un valor valido, y
                                           // en la linea 51 se detiende gracias a un break
                        System.out.println("Ingrese el precio del producto " + nombreProducto);
                        if (teclado.hasNextFloat()) { // Comprueba que se ingrese un numero y no texto
                            float floatPrecioProducto = teclado.nextFloat(); // Esta es una "variable temporal" que
                                                                             // tiene como funcion almacenar un valor
                                                                             // numerico que posteriormente sera
                                                                             // convertido en String
                            teclado.nextLine();
                            if (floatPrecioProducto > 0) {
                                precioProducto = String.valueOf(floatPrecioProducto); // convierte el valor numerico a
                                                                                      // string para almacenarlo en
                                                                                      // nuestro array
                                break;
                            } else {
                                System.out.println("El precio debe ser mayor a 0");
                            }
                        } else {
                            System.out.println("El valor ingresado no es un número");
                            teclado.nextLine();
                        }
                    }
                    System.out.println("---------------------------------");
                    String cantidadProducto = "";
                    while (datoEsInvalido) {
                        System.out.println("Ingrese la cantidad de unidades del producto");
                        if (teclado.hasNextInt()) {
                            int intCantidadProducto = teclado.nextInt();
                            teclado.nextLine();
                            if (intCantidadProducto > 0) {
                                cantidadProducto = String.valueOf(intCantidadProducto);
                                break;
                            } else {
                                System.out.println("La cantidad debe ser mayor a 0");
                            }
                        } else {
                            System.out.println("El valor ingresado no es un número válido.");
                            teclado.nextLine();
                        }
                    }
                    String[] fila = new String[3];
                    fila[0] = nombreProducto;
                    fila[1] = precioProducto;
                    fila[2] = cantidadProducto;
                    System.out.println(nombreProducto + " ha sido agregado al inventario");
                    System.out.println();
                    inventario.add(fila);// Agrega el array a nuestro Arraylist
                    break;
                case 2:
                    if (inventario.size() != 0) {
                        while (datoEsInvalido) {
                            contador = 0;
                            System.out.println("Ingrese el codigo del producto que desea eliminar del inventario");
                            System.out.println();
                            for (String[] filaProducto : inventario) {
                                System.out.println(contador + ". " + filaProducto[0]);
                                contador++;
                            }
                            if (teclado.hasNextInt()) {
                                seleccion = teclado.nextInt();
                                teclado.nextLine();
                                if (seleccion >= 0 && seleccion < inventario.size()) {
                                    inventario.remove(seleccion); // El metodo remove, elimina un elemento del ArrayList
                                    System.out.println("Se ha eliminado el producto satisfactoriamente");
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ha ingresado un codigo invalido");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Ingresa un numero valido, por favor");
                                teclado.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay ningun producto en el inventario");
                        System.out.println();
                    }
                    break;
                case 3:
                    if (inventario.size() != 0) {
                        while (datoEsInvalido) {
                            System.out.println("Ingrese el codigo del producto que desea modificar su precio");
                            System.out.println();
                            contador = 0; // Este contador genera los indices correspondientes a cada elemento existente
                                          // del ArrayList
                            for (String[] filaProducto : inventario) {
                                System.out.println(contador + ". " + filaProducto[0]);
                                contador++;
                            }
                            if (teclado.hasNextInt()) {
                                seleccion = teclado.nextInt();
                                teclado.nextLine();
                                if (seleccion >= 0 && seleccion < inventario.size()) {
                                    System.out.println("Ingrese el nuevo precio para " + inventario.get(seleccion)[0]);
                                    Float floatNuevoPrecio = teclado.nextFloat();
                                    String nuevoPrecio = String.valueOf(floatNuevoPrecio);
                                    inventario.get(seleccion)[1] = nuevoPrecio;
                                    System.out.println("Precio cambiado satisfactoriamente");
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Ha ingresado un codigo invalido");
                                }
                            } else {
                                System.out.println("Ingresa un numero valido, por favor");
                                teclado.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay ningun producto en el inventario");
                        System.out.println();
                    }
                    break;
                case 4:
                    if (inventario.size() != 0) {
                        while (datoEsInvalido) {
                            System.out.println("Ingrese el codigo del producto que desea modificar su cantidad");
                            contador = 0;
                            for (String[] filaProducto : inventario) {
                                System.out.println(contador + ". " + filaProducto[0]);
                                contador++;
                            }
                            if (teclado.hasNextInt()) {
                                seleccion = teclado.nextInt();
                                teclado.nextLine();
                                if (seleccion >= 0 && seleccion < inventario.size()) {
                                    System.out.println("Ingrese la nueva cantidad de " + inventario.get(seleccion)[0]);
                                    if (teclado.hasNextInt()){
                                    int intNuevaCantidad = teclado.nextInt();
                                    teclado.nextLine();
                                    String nuevaCantidad = String.valueOf(intNuevaCantidad);
                                    inventario.get(seleccion)[2] = nuevaCantidad;
                                    System.out.println("Cantidad cambiada satisfactoriamente");
                                    System.out.println();
                                    break;
                                    } else {
                                        System.out.println("Ha ingresado una cantidad invalida");
                                        teclado.nextLine();
                                        continue;
                                    }
                                } else {
                                    System.out.println("Ha ingresado un codigo invalido");
                                }
                            }else {
                                System.out.println("Ha ingresado un codigo invalido");
                                teclado.nextLine();
                            }
                        }
                    }
                    else {
                        System.out.println("No hay ningun producto en el inventario");
                        System.out.println();
                    }
                    break;
                case 5:
                if (inventario.size() != 0) {
                    System.out.println("Inventario actual:");
                    float valorTotalInventario = 0;
                    for (String[] filaProducto : inventario) {
                        int cantidad = Integer.parseInt(filaProducto[2]); // IMPORTANTE -> Todos los datos se ingresan
                                                                          // como Strings, pues en Java, solo se pueden
                                                                          // poner datos del mismo tiopo en un mismo
                                                                          // array
                        float precio = Float.parseFloat(filaProducto[1]); // Es por eso que en estas dos lineas, se
                                                                          // transforman los Strings a enteros y
                                                                          // decimales, pues en la siguiente linea vamos
                                                                          // a operar con ellos
                        System.out.println("Nombre: " + filaProducto[0] + " | Precio: " + filaProducto[1]
                                + " | Cantidad: " + filaProducto[2] + " | Total: " + cantidad * precio);
                        valorTotalInventario = valorTotalInventario + cantidad * precio; // Variable sumador
                    }
                    System.out.println("Valor total del inventario " + valorTotalInventario);
                } else {
                    System.out.println("El inventario está vacio, usa la opcion 1 para agregar productos");
                    System.out.println();
                }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingresa un valor valido por favor");
                    break;
            }
        } while (seleccion != 6); //Se continua el ciclo mientras no se seleccione la opcion 6
        teclado.close();
    }
}