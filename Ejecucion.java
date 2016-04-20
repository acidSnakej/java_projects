/**
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejecucion{
    static Lectura entrada = new Lectura();
    static ListaEstudiante estud = new ListaEstudiante();

    public static void main(String[] args)
    {
        int op;
        boolean validar = true;
        String menu = "Menu de opciones"    + "\n" +
                "1.Ingresar Cola"           + "\n" +
                "2.Ingresar Cabeza"         + "\n" +
                "3.Despliega Lista"         + "\n" +
                "4.Modificar"               + "\n" +
                "5.Modificar Bloque"        + "\n" +
                "6.Eliminar"                + "\n" +
                "7.Buscar"                  + "\n" +
                "0.Salir";
        estud.LeerFichero();
        do
        {
            op = entrada.entero(menu);
            switch (op)
            {
                case 1: estud.InsertBack();     break;
                case 2: estud.InsertHead();     break;
                case 3: estud.DespliegaLista(); break;
                case 4: estud.Modificar();      break;
                case 5: estud.ModificarB();     break;
                case 6: estud.Eliminar();     break;
                case 7: estud.Buscar();         break;
            }//Cierre del switch
        }while(op != 0);
        estud.GuardarFichero();
    }// Cierre del metodo main
}
