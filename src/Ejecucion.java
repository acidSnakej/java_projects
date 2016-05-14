
/**
 * Created by jorge on 12/05/16.
 */


public class Ejecucion{
    static Lectura entrada = new Lectura();
    static ListaEstudiante estud = new ListaEstudiante();

    public static void main(String[] args)
    {
        int op;
        boolean validar = true;
        String menu = "Menu de opciones"     + "\n" +
                "1.Ingresar Cola"            + "\n" +
                "2.Ingresar Cabeza"          + "\n" +
                "3.Despliega Lista"          + "\n" +
                "4.Modificar"                + "\n" +
                "5.Modificar Bloque"         + "\n" +
                "6.Eliminar"                 + "\n" +
                "7.Buscar"                   + "\n" +
                "8.Leer Fichero"             + "\n" +
                "9.Guardar Fichero"          + "\n" +
                "10.agregar numeros al nodo" + "\n" +
                "11.Ordenar nodo"            + "\n" +
                "12.Ingresar forma ordnada"  + "\n" +
                "0.Salir";

        do
        {
            op = entrada.entero(menu);
            switch (op)
            {
                case 1: estud.InsertBack();     break;
                case 2: estud.InsertHead();     break;
                case 3: estud.showNodes(); break;
                case 4: estud.Modificar();      break;
                case 5: estud.ModificarB();     break;
                case 6: estud.Eliminar();       break;
                case 7: estud.Buscar();         break;
                case 8: estud.readTest();    break;
                case 9: estud.saveTest(); break;
                case 10: estud.add_node(); break;
                case 11: estud.sort_node(); break;
                case 12: estud.sort_form(); break;
            }//Cierre del switch
        }while(op != 0);
    }// Cierre del metodo main
}

