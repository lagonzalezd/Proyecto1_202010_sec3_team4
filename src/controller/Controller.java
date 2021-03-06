package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

    /* Instancia del Modelo*/
    private Modelo modelo;

    /* Instancia de la Vista*/
    private View view;

    /**
     * Crear la vista y el modelo del proyecto
     */
    public Controller() {
        view = new View();
        modelo = new Modelo();
    }


    /**
     * Función que primero se ejecuta en el main.java
     */
    public void run() {
        Scanner lector = new Scanner(System.in);
        boolean fin = false;
        String dato = "";
        String respuesta = "";

        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();
            switch (option) {
                case 1:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 1. Cargar Stack ");
                    modelo = new Modelo();
                    Queue datos = modelo.cargarDatos();
                    try {
                        view.printMessage("          | El primer comparendo de la pila es: " + "\n" + "          | " + datos.peek().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    view.printMessage("          | Numero actual de elementos cargados " + modelo.darDatosCargadosCola());
                    view.printMessage("          |___________________________________________________________________________________________");
                    break;

                case 2:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 1. Cargar Queue ");
                    modelo = new Modelo();
                    Queue datos2 = modelo.cargarDatos();
                    view.printMessage("          | El primer comparendo de la cola es: " + "\n" + "          | " + datos2.peek().toString());
                    view.printMessage("          | Numero actual de elementos cargados " + modelo.darDatosCargadosCola());
                    view.printMessage("          |___________________________________________________________________________________________");
                    break;
                case 7:
                    view.printMessage("           _________");
                    view.printMessage("          |_¡Adios!_|");
                    lector.close();
                    fin = true;
                    break;
                case 3:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 3. Buscar grupo cosecutivo mas grande en Queue ");
                    modelo = new Modelo();
                    Queue datos3 = modelo.cargarDatos();
                    Queue datosDevueltos1 = modelo.buscarGrupoMasGrandeCola(datos3);
                    boolean finCiclo5 = false;
                    while (!finCiclo5) {
                        if (datosDevueltos1.peek() != null) {
                            try {
                                view.printMessage("          |  " + datosDevueltos1.deQueue().toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            finCiclo5 = true;
                        }
                    }
                    view.printMessage("          |_____________________________________________________________________________________________ ");
                    break;
                case 4:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 4. Buscar los ultimos N comparendos por codigo en Stack ");
                    view.printMessage("          | -> Ingrese la cantidad de comparendos que desea buscar (ej. 2 ) , seguida de Enter: ");
                    int N = lector.nextInt();
                    view.printMessage("          | -> Ingrese e codigo de comparendo que desea buscar (ej. C02), seguido de Enter: ");
                    String codigo = lector.next();
                    modelo = new Modelo();
                    Queue datos4 = modelo.cargarDatos();
                    Queue datosDevueltos2 = modelo.buscarUltimosNPila(datos4, N, codigo);
                    if (!datosDevueltos2.estaVacia()) {
                        boolean finCiclo4 = false;
                        while (!finCiclo4) {
                            if (datosDevueltos2.peek() != null) {
                                try {
                                    view.printMessage("          |" + datosDevueltos2.deQueue().toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                finCiclo4 = true;
                            }
                        }
                    } else {
                        view.printMessage("          | No se encontraron comparendos con ese código ");
                    }
                    view.printMessage("          |_____________________________________________________________________________________________________");
                    break;
                case 5:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 5. Imprimir Stack ");
                    datos = modelo.cargarDatos();
                    if (!datos.estaVacia()) {
                        boolean finCiclo4 = false;
                        while (!finCiclo4) {
                            if (datos.peek() != null) {
                                try {
                                    view.printMessage("          |" + datos.deQueue().toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                finCiclo4 = true;
                            }
                        }
                    } else {
                        view.printMessage("          | No se encontraron comparendos en el Stack ");
                    }
                    view.printMessage("          |_____________________________________________________________________________________________________");
                    break;
                case 6:
                    view.printMessage("           ____________________________________________________________________________________________");
                    view.printMessage("          | 5. Imprimir Queue ");
                    datos = modelo.cargarDatos();
                    if (!datos.estaVacia()) {
                        boolean finCiclo4 = false;
                        while (!finCiclo4) {
                            if (datos.peek() != null) {
                                try {
                                    view.printMessage("          |" + datos.deQueue().toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                finCiclo4 = true;
                            }
                        }
                    } else {
                        view.printMessage("          | No se encontraron comparendos en el Stack ");
                    }
                    view.printMessage("          |_____________________________________________________________________________________________________");
                    break;
                default:
                    view.printMessage("           ______________________________               ");
                    view.printMessage("          |     Opcion Invalida          |              ");
                    view.printMessage("          |_Ingrese un numero del 1 al 5_|");
                    break;
            }
        }

    }
}