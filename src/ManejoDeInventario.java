import java.util.Scanner;
import java.util.ArrayList;

public class ManejoDeInventario {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<ArrayList<String>> inventario = new ArrayList<>();
        int seleccion;
        int contador = 0;
        do {
            System.out.println("Menú");
            System.out.println("1. Agregar un producto nuevo al inventario");
            System.out.println("2. Retirar un producto del inventario");
            System.out.println("3. Modificar un precio de un producto");
            System.out.println("4. Modificar cantidad de un producto");
            System.out.println("5. Ver el estado actual del inventario");
            System.out.println("6. Salir del programa");
            System.out.println();
            System.out.println("¿Que desea hacer?");
            System.out.println();
            seleccion = teclado.nextInt();
            teclado.nextLine();
            switch (seleccion){
                case 1:
                    System.out.println("Agregar un producto al inventario");
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese el nombre de su producto");
                    String nombreProducto = teclado.nextLine();
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese el precio del producto " + nombreProducto);
                    String precioProducto = teclado.nextLine();
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese la cantidad de unidades del producto");
                    String cantidadProducto = teclado.nextLine();
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(nombreProducto);
                    fila.add(precioProducto);
                    fila.add(cantidadProducto);
                    inventario.add(fila);
                    break;
                case 2:
                contador = 0;
                    System.out.println("Ingrese el codigo del producto que desea eliminar del inventario");
                    for (ArrayList<String> filaProducto : inventario){
                        System.out.println(contador + ". " + filaProducto.get(0));
                        contador++;
                    }
                    seleccion = teclado.nextInt(); 
                    if (seleccion >= 0 && seleccion <= inventario.size()){
                        inventario.remove(seleccion);
                    }
                    else {
                        System.out.println("Ha ingresado un codigo invalido");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el codigo del producto que desea modificar su precio");
                    contador = 0;
                        for (ArrayList<String> filaProducto : inventario){
                        System.out.println(contador + ". " + filaProducto.get(0));
                        contador++;
                    }
                    seleccion = teclado.nextInt();
                    teclado.nextLine();
                    if (seleccion >= 0 && seleccion <= inventario.size()){
                        System.out.println("Ingrese el nuevo precio para " + inventario.get(seleccion).get(0));
                        String nuevoPrecio = teclado.nextLine();
                        inventario.get(seleccion).set(1, nuevoPrecio);
                        System.out.println("Precio cambiado satisfactoriamente");
                    }
                    else{
                        System.out.println("Ha ingresado un codigo invalido");
                    }
                    break;
                case 4: 
                    System.out.println("Ingrese el codigo del producto que desea modificar su cantidad");
                    contador = 0;
                        for (ArrayList<String> filaProducto : inventario){
                        System.out.println(contador + ". " + filaProducto.get(0));
                        contador++;
                    }
                    seleccion = teclado.nextInt();
                    teclado.nextLine();
                    if (seleccion >= 0 && seleccion <= inventario.size()){
                        System.out.println("Ingrese la nueva cantidad de " + inventario.get(seleccion).get(0));
                        String nuevaCantidad = teclado.nextLine();
                        inventario.get(seleccion).set(2, nuevaCantidad);
                        System.out.println("Cantidad cambiada satisfactoriamente");
                    }
                    else{
                        System.out.println("Ha ingresado un codigo invalido");
                    }
                    break;
                case 5:
                    System.out.println("Inventario actual:");
                    float valorTotalInventario = 0;
                    for (ArrayList<String> filaProducto : inventario) {
                        int cantidad = Integer.parseInt(filaProducto.get(2));
                        float precio = Float.parseFloat(filaProducto.get(1));
                        System.out.println("Nombre: " + filaProducto.get(0) + " | Precio: " + filaProducto.get(1) + " | Cantidad: " + filaProducto.get(2) + " | Total: " + cantidad*precio );
                        valorTotalInventario = valorTotalInventario + cantidad*precio;
                    }
                    System.out.println("Valor total del inventario " + valorTotalInventario);
                    break;
                case 6:
                System.out.println("Saliendo...");
                break;
                default: 
                    System.out.println("Ingresa un valor valido por favor");
                    break;
            }
        }
        while (seleccion != 6);
        teclado.close();
    }
}
