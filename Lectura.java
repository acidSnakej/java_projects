import javax.swing.JOptionPane;

/**
 * la class Lectura tiene tres funciones que muestran una ventana para asignar un numero
 * que nos retornaran entero, decimal y cadena de texto.
 * @author Marcela Ardila
 * @author Jorge Rivera
 *
 */
public class Lectura {

    /**Funcion para ingresar una cadena de texto
     *
     * @param cad
     * @return una cadena de texto
     */
    public String cadena(String cad){
        return( JOptionPane.showInputDialog(null,cad) );
    }
    /**Funcion que muestra una ventana para ingresar un numero decimal
     *
     * @param cad
     * @return un numero decimal
     */

    public double decimal(String cad){
        double n = 0;
        int sw = 0;

        while( sw == 0){
            try{
                n = Double.parseDouble( JOptionPane.showInputDialog(null,cad) );
                sw = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Debe ser un entero");
            }
        }
        return n;
    }

    /**Funcion que muestra una ventana para ingresar un numero entero
     *
     * @param cad
     * @return un numero entero
     */
    public int entero(String cad){
        int n = 0, sw = 0;

        while( sw == 0){
            try{
                n = Integer.parseInt(JOptionPane.showInputDialog(null,cad));
                sw = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Debe ser un entero");
            }
        }
        return n;
    }

    public double notas(String cad){
        double n = 0;
        int sw = 0;
        while( sw == 0){
            try{
                n = Double.parseDouble( JOptionPane.showInputDialog(null,cad) );
                if (n >= 0 && n <=5 )
                    sw = 1;
                else
                    JOptionPane.showMessageDialog(null, "La nota debe ser mayor igual a 0.0 o menor igual que 5.0");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "La nota debe ser mayor igual a 0.0 o menor igual que 5.0");
            }
        }
        return n;
    }

    public int semestre (String cad){
        int n = 0;
        int sw = 0;
        while( sw == 0){
            try{
                n = Integer.parseInt( JOptionPane.showInputDialog(null,cad) );
                if (n > 0 && n <10 )
                    sw = 1;
                else
                    JOptionPane.showMessageDialog(null, "El semestre debe ser mayor que 0 y menor o igual a 10");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "El semestre debe ser mayor que 0 y menor o igual a 10");
            }
        }
        return n;
    }

}

