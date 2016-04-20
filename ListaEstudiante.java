
import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;

public class ListaEstudiante {
    NodoEstudiante Primero, ultimo, aux, nuevo, ant, post;
    static Lectura entrada = new Lectura();

    // Constructor
    public ListaEstudiante() { Primero = ultimo = aux = nuevo = ant = post = null; }

    public void Buscar()
    {
        String cadena = "";
        int ident = entrada.entero("Digite el numero de identificacion del estudiante: ");
        int codigo = entrada.entero("Digite el numero de codigo del estudiante: ");
        boolean validar = validarIdCod(ident,codigo,"b");
        if ( validar == false ) {
            cadena += "Identificacion: "  + aux.id        + "\n" +
                    "Codigo: "          + aux.codigo    + "\n" +
                    "Nombres: "         + aux.nombres   + "\n" +
                    "Direccion: "       + aux.direccion + "\n" +
                    "Telefono: "        + aux.telefono  + "\n" +
                    "Programa: "        + aux.programa  + "\n" +
                    "Semestre: "        + aux.semestre  + "\n" +
                    "Nota 1: "          + aux.nota1     + "\n" +
                    "Nota 2: "          + aux.nota2     + "\n" +
                    "Nota 3: "          + aux.nota3     + "\n" +
                    "Promedio: "        + aux.notFinal;
            JOptionPane.showMessageDialog(null, cadena); // vamos bien por ahora
        }


    }// Cierre del metodo Buscar

    public void DespliegaLista(){
        String cad =  "";
        String cad1 = "";
        int pag = 0;
        aux = Primero;
        if(aux == null)
            JOptionPane.showMessageDialog(null, "no hay datos en la lista");
        else
        {
            while (aux != null) {
                pag++;
                if ( pag <= 3)
                {
                    cad += "Identificacion: " + aux.id          +   "\n" +
                            "Codigo: "        + aux.codigo      +   "\n" +
                            "Nombres: "       + aux.nombres     +   "\n" +
                            "Direccion: "     + aux.direccion   +   "\n" +
                            "Telefono: "      + aux.telefono    +   "\n" +
                            "Programa: "      + aux.programa    +   "\n" +
                            "Semestre: "      + aux.semestre    +   "\n" +
                            "Nota 1: "        + aux.nota1       +   "\n" +
                            "Nota 2: "        + aux.nota2       +   "\n" +
                            "Nota 3: "        + aux.nota3       +   "\n" +
                            "Promedio: "      + aux.notFinal    +   "\n";
                    aux = aux.sig;
                }else
                {
                    cad1 += "Identificacion: " + aux.id          +   "\n" +
                            "Codigo: "        + aux.codigo      +   "\n" +
                            "Nombres: "       + aux.nombres     +   "\n" +
                            "Direccion: "     + aux.direccion   +   "\n" +
                            "Telefono: "      + aux.telefono    +   "\n" +
                            "Programa: "      + aux.programa    +   "\n" +
                            "Semestre: "      + aux.semestre    +   "\n" +
                            "Nota 1: "        + aux.nota1       +   "\n" +
                            "Nota 2: "        + aux.nota2       +   "\n" +
                            "Nota 3: "        + aux.nota3       +   "\n" +
                            "Promedio: "      + aux.notFinal    +   "\n";
                    aux = aux.sig;
                }
            }
            int pag2 = 1;
            JOptionPane.showMessageDialog( null, cad + "pagina " + pag2); // PaginaciÃ³n sencilla no automatizada
            pag2++;
            if ( !cad1.equals("")) // muestra datos si hay mas de 3 datos
                JOptionPane.showMessageDialog( null, cad1 + "pagina " + pag2);
        }

    }// Cierre de metodo DespliegaLista

    public void Eliminar()
    {
        int op = 0;
        do
        {
            String menu = "Menu de Eliminacion "      + "\n" +
                    "¿Desea Eliminar por bloque?" + "\n" +
                    "1.Si" + "\n" + "2.No" +"\n"+ "0.Retornar";
            op = entrada.entero(menu);
            if ( op == 1)
            {

                String menu2 = "¿Que desea Eliminar? " + "\n" +
                        "1.Por programa " + "\n" + "2.Por semestre\n"+"0.retornar";
                int op2 = entrada.entero(menu2);
                switch ( op2 )
                {

                    case 1:
                        aux = Primero;
                        String nwProg = entrada.cadena("Digite el programa").toLowerCase();
                        boolean primerLugar = true;

                        aux = Primero;
                        boolean validar = true;
                        int posiciones2 = 1;
                        while ( aux != null ){

                            if ( aux.programa.equals(nwProg) && posiciones2 == 1) {
                                primerLugar = false;
                                if (!primerLugar){
                                    Primero = aux.sig;
                                    aux = Primero;
                                    System.out.println("pase por aqui");
                                    posiciones2 = 1;
                                }
                            }
                            else
                                posiciones2++;
                            aux = aux.sig;
                        }

                        break;
                    case 2:
                        int nwSemt = entrada.entero("Digite el nuevo semestre");
                        while ( aux != null )
                        {
                            aux.semestre = nwSemt;
                            aux = aux.sig;
                        }
                        break;
                }
            }
        }while(op!=0);



    }// Cierre de Eliminar


    public  void GuardarFichero(){
        int i;
        File archivo = new File("~\\Documents\\juan.txt");
        aux = Primero;
        try{
            FileWriter w = new FileWriter( archivo );
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            while ( aux != null)
            {
                String cadena = "";
                cadena += aux.id      + "," + aux.codigo   + "," + aux.nombres  + "," +
                        aux.direccion + "," + aux.telefono + "," + aux.programa + "," +
                        aux.semestre  + "," + aux.nota1    + "," + aux.nota2    + "," +
                        aux.nota3     + "," + aux.notFinal + "\n";
                aux = aux.sig;
                wr.append( cadena );
            }
            wr.close();
            bw.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog( null, "No se encontra el archivo!" );
        }
    } // fin metodo guardarFichero



    public void InsertBack()
    {
        DecimalFormat decimal = new DecimalFormat("0.0");
        if ( Primero == null )
        {

            int ident    = entrada.entero("Ingrese el numero de identificacion: ");
            int cod      = entrada.entero("Ingrese el codigo del estudiante: ");
            String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
            double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
            double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
            double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
            String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
            int sem = entrada.entero("Ingrese el semestre del estudiante " + nom);
            String dir = entrada.cadena("Ingrese la direccion del estudiante " + nom).toLowerCase();
            String tel = entrada.cadena("Ingrese el telefono " + nom);
            double calculo = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
            double promedio = (double) Math.round( calculo * 100) / 100; // Redondamos el decimal a 0.0
            Primero = new NodoEstudiante(ident,cod,nom,nota1,nota2,nota3,promedio,prog,sem,dir,tel);
            ultimo = Primero;
        }else
        {
            int val = -1;
            do
            {
                int ident    = entrada.entero("Ingrese el numero de identificacion: ");
                int cod      = entrada.entero("Ingrese el codigo del estudiante: ");
                boolean validar = validarIdCod(ident,cod,"i"); // valida si false si la id o cod se repiten.
                if ( validar )
                {
                    String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
                    double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
                    double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
                    double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
                    String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
                    int sem = entrada.entero("Ingrese el semestre del estudiante " + nom);
                    String dir = entrada.cadena("Ingrese la direccion del estudiante " + nom).toLowerCase();
                    String tel = entrada.cadena("Ingrese el telefono " + nom);
                    double calculo = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
                    double promedio = (double) Math.round( calculo * 100) / 100; // Redondamos el decimal a 0.0
                    nuevo = new NodoEstudiante(ident,cod,nom,nota1,nota2,nota3,promedio,prog,sem,dir,tel);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                    val++;
                }
                else
                    JOptionPane.showMessageDialog(null, "Error identifiacion y/o codigo registrados!!!");
            }while(val<0);

        }DespliegaLista();
    }// Cierre de metodo InsertBack

    public void InsertHead()
    {
        if (Primero == null){
            int ident    = entrada.entero("Ingrese el numero de identificacion: ");
            int cod      = entrada.entero("Ingrese el codigo del estudiante: ");
            String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
            double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
            double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
            double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
            String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
            int sem = entrada.entero("Ingrese el semestre del estudiante " + nom);
            String dir = entrada.cadena("Ingrese la direccion del estudiante " + nom).toLowerCase();
            String tel = entrada.cadena("Ingrese el telefono " + nom);
            double calculo = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
            double promedio = (double) Math.round( calculo * 100) / 100; // Redondamos el decimal a 0.0
            Primero = new NodoEstudiante(ident,cod,nom,nota1,nota2,nota3,promedio,prog,sem,dir,tel);
            ultimo = Primero;

        }else{
            int val = -1;
            do
            {
                int ident    = entrada.entero("Ingrese el numero de identificacion: ");
                int cod      = entrada.entero("Ingrese el codigo del estudiante: ");
                boolean validar = validarIdCod(ident,cod,"i"); // valida si false si la id o cod se repiten.
                if ( validar )
                {
                    String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
                    double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
                    double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
                    double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
                    String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
                    int sem = entrada.entero("Ingrese el semestre del estudiante " + nom);
                    String dir = entrada.cadena("Ingrese la direccion del estudiante " + nom).toLowerCase();
                    String tel = entrada.cadena("Ingrese el telefono " + nom);
                    double calculo = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
                    double promedio = (double) Math.round( calculo * 100) / 100; // Redondamos el decimal a 0.0
                    nuevo = new NodoEstudiante(ident,cod,nom,nota1,nota2,nota3,promedio,prog,sem,dir,tel,Primero);
                    Primero = nuevo;
                    val++;
                }
                else
                    JOptionPane.showMessageDialog(null, "Error identifiacion y/o codigo registrados!!!");
            }while(val<0);

        }DespliegaLista();
    }// Cierre del metodo InsertHead


    public void LeerFichero(){
        int n=0;  String[] sep; String registro = "";
       // File archivo = new File("/home/acidSnake/Repositories/projects_java/test.txt")
       
        try{
            BufferedReader in = new BufferedReader( new FileReader(archivo) );
            registro = in.readLine();
            while( registro != null ){
                n++;
                sep = registro.split(",");
                int ident        = Integer.parseInt(sep[0]);
                int codigo       = Integer.parseInt(sep[1]);
                String nombres   = sep[2];
                String direccion = sep[3];
                String telefono  = sep[4];
                String programa  = sep[5];
                int semestre     = Integer.parseInt(sep[6]);
                double nota1     = Double.parseDouble(sep[7]);
                double nota2     = Double.parseDouble(sep[8]);
                double nota3     = Double.parseDouble(sep[9]);
                double notFinal  = Double.parseDouble(sep[10]);
                if ( Primero == null ) {
                    Primero = new NodoEstudiante(ident,codigo,nombres,nota1,nota2,nota3,notFinal,programa,semestre,direccion,telefono);
                    ultimo  = Primero;
                }
                else{
                    nuevo = new NodoEstudiante(ident,codigo,nombres,nota1,nota2,nota3,notFinal,programa,semestre,direccion,telefono);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                }
                registro = in.readLine(); // leer el siguiente registro
            }
            // System.out.println("Cantidad String: "+ n ); Para saber la cantidad de lineas que hay en el archivo
            in.close();
        }
        catch( IOException e ){
            JOptionPane.showMessageDialog( null, "No se encontra el archivo!" );
        }

    } //fin metodo leerFichero

    public void Modificar()
    {
        String cadena = " === Datos del estudiante === \n";
        aux = Primero;
        if (aux == null)
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        /*
        while ( aux != null)
        {
            int ident = entrada.entero("Digite el nÃºmero de identificaciÃ³n del estudiante: ");
            int codigo = entrada.entero("Digite el nÃºmero de cÃ³digo del estudiante: ");
            if ( aux.id.equals(ident) && aux.codigo.equals(codigo) )
                break;
            aux = aux.sig;
        }
        */ // Validacion para encontrar el de modifcar.
        else
        {
            int ident = entrada.entero("Digite el nÃºmero de identificaciÃ³n del estudiante: ");
            int codigo = entrada.entero("Digite el nÃºmero de cÃ³digo del estudiante: ");
            boolean validar = validarIdCod(ident,codigo,"m");
            if ( !validar  )
            {
                int op = 0;
                cadena += "Identificacion: "  + aux.id        + "\n" +
                        "CÃ³digo: "          + aux.codigo    + "\n" +
                        "Nombres: "         + aux.nombres   + "\n" +
                        "Direccion: "       + aux.direccion + "\n" +
                        "Telefono: "        + aux.telefono  + "\n" +
                        "Programa: "        + aux.programa  + "\n" +
                        "Semestre: "        + aux.semestre  + "\n" +
                        "Nota 1: "          + aux.nota1     + "\n" +
                        "Nota 2: "          + aux.nota2     + "\n" +
                        "Nota 3: "          + aux.nota3     + "\n" +
                        "Promedio: "        + aux.notFinal;
                JOptionPane.showMessageDialog(null, cadena); // vamos bien por ahora
                do {
                    String menu = "¿Que desea modificar?" + "\n" +
                            "1.Nombres"   + "\n" +
                            "2.Direccion" + "\n" +
                            "3.Telefono"  + "\n" +
                            "4.Programa"  + "\n" +
                            "5.Semestre"  + "\n" +
                            "6.Nota 1"    + "\n" +
                            "7.Nota 2"    + "\n" +
                            "8.Nota 3"    + "\n" +
                            "0.Retornar";
                    op = entrada.entero(menu);
                    switch (op)
                    {
                        case 1:
                            String op1   = "Nombres: "+ aux.nombres + "\n"+ "Ingrese el nuevo nombre por favor";
                            String nwNom = entrada.cadena(op1);
                            aux.nombres = nwNom;
                            break;
                        case 2:
                            String op2   = "Direccion: "+ aux.direccion + "\n"+ "Ingrese la nueva direccion por favor";
                            String nwDir = entrada.cadena(op2);
                            aux.direccion = nwDir;
                            break;
                        case 3:
                            String op3   = "Telefono: "+ aux.telefono + "\n"+ "Ingrese el nuevo telefono por favor";
                            String nwTel = entrada.cadena(op3);
                            aux.telefono = nwTel;
                            break;
                        case 4:
                            String op4   = "Programa: "+ aux.programa + "\n"+ "Ingrese el nuevo programa por favor";
                            String nwProg = entrada.cadena(op4);
                            aux.programa = nwProg;
                            break;
                        case 5:
                            String op5   = "Semestre: "+ aux.semestre + "\n"+ "Ingrese el nuevo semestre por favor";
                            int nwSemt = entrada.entero(op5);
                            aux.semestre = nwSemt;
                            break;
                        case 6:
                            String op6   = "Nota 1: "+ aux.nota1 + "\n"+ "Ingrese la nueva nota 1 por favor";
                            double nwNot1 = entrada.notas(op6);
                            aux.nota1 = nwNot1;
                            break;
                        case 7:
                            String op7   = "Nota 2: "+ aux.nota2 + "\n"+ "Ingrese la nueva nota 2 por favor";
                            double nwNot2 = entrada.notas(op7);
                            aux.nota2 = nwNot2;
                            break;
                        case 8:
                            String op8   = "Nota 3: "+ aux.nota3 + "\n"+ "Ingrese la nueva nota 3 por favor";
                            double nwNot3 = entrada.notas(op8);
                            aux.nota3 = nwNot3;
                            break;
                        case 0:break;
                    }

                }while (op!=0);
                double calculo = ( (Double.parseDouble(aux.nota1.toString()) * 0.3) + (Double.parseDouble(aux.nota2.toString()) * 0.3) +
                        (Double.parseDouble(aux.nota3.toString()) * 0.4) );
                double promedio = (double) Math.round(calculo * 100) / 100;
                aux.notFinal = promedio;

            }else
                JOptionPane.showMessageDialog(null, "Error  identificacion y/o codigo incorrectos");
        }
    }// Cierre del metodo modificar.

    public void ModificarB()
    {
        int op = 0;
        do
        {
            String menu = "Menu de modifcacion por bloques"      + "\n" +
                    "Desea modificar todos los registros?" + "\n" +
                    "1.Si" + "\n" + "2.No" +"\n"+ "0.Retornar";
            op = entrada.entero(menu);
            if ( op == 1)
            {
                aux = Primero;
                String menu2 = "Que desea modificar? " + "\n" +
                        "1.Programa " + "\n" + "2.Semestre\n"+"0.retornar";
                int op2 = entrada.entero(menu2);
                switch ( op2 )
                {
                    case 1:
                        String nwProg = entrada.cadena("Digite el nuevo programa").toLowerCase();
                        while ( aux != null )
                        {
                            aux.programa = nwProg;
                            aux = aux.sig;
                        }
                        break;
                    case 2:
                        int nwSemt = entrada.entero("Digite el nuevo semestre");
                        while ( aux != null )
                        {
                            aux.semestre = nwSemt;
                            aux = aux.sig;
                        }
                        break;
                }
            }else if ( op == 2 ){
                String menu2 = "Opciones de modificacion? " + "\n" +
                        "1.Antes de " + "\n" + "2.Despues de\n"+"0.retornar";
                String cadena = "";
                int op2 = entrada.entero(menu2);
                switch ( op2 )
                {
                    case 1:
                        int ident = entrada.entero("Digite el numero de identificacion: ");
                        int cod   = entrada.entero("Digite el codigo: ");
                        boolean validar = validarIdCod(ident,cod,"l");
                        if ( !validar ) {
                            ModificarAnt();
                        }
                        break;
                    case 2:
                        int ident1 = entrada.entero("Digite el numero de identificacion: ");
                        int cod1   = entrada.entero("Digite el codigo: ");
                        boolean validar1 = validarIdCod(ident1,cod1,"l");
                        if ( !validar1 ) {
                            ModificarDesp();
                        }
                        break;

                }


            }
        }while(op!=0);

    }// Cierre de ModificarB (bloque)

    public void ModificarAnt() // tipo es si es semestre o programa
    {
        ant = Primero;
        String cadena = "";
        int op = 0;

        do{
            String menu = "Que desea modificar?\n"       +
                    "1.Programa\n" +"2.Semestre\n" +
                    "0.retornar";
            op = entrada.entero(menu);
            switch ( op )
            {
                case 1:
                    String nwProg = entrada.cadena("Digite el nuevo programa: ");
                    while (ant!=null)
                    {
                        if ( ant.id.equals(aux.id) )
                            break;
                        cadena += ant.id;
                        ant.programa = nwProg;
                        ant = ant.sig;
                    }
                    System.out.println(cadena);
                    break;
            } // falta arreglar la modificaciones
        }while(op!=0);

        /*
        aux = Primero;

        int op = 0;
        do {
            String menu = "Que cambios desea realizar al "+tipo+" de "+opcion+"?\n" +
                    "1.Programa" + "\n" + "2.Semestre\n" +
                    "0.retornar";
            op = entrada.entero(menu);
            switch ( op )
            {
                case 1:
                    String nwProg = entrada.cadena("Digite el nuevo programa ").toLowerCase();
                    while (aux!=null)
                    {
                        if( aux.programa.equals(opcion) || aux.semestre.toString().equals(opcion) )
                            aux.programa = nwProg;
                        aux = aux.sig;
                    }
                    break;
                case 2:
                    int nwSemt = entrada.entero("Digite el nuevo semestre ");
                    while (aux!=null)
                    {
                        if( aux.semestre.toString().equals(opcion) )
                            aux.semestre = nwSemt ;
                        aux = aux.sig;
                    }
                    break;
            }
        }while(op!=0);
        */

    }// Ciere ModificarE

    public void ModificarDesp()
    {
        post = aux;
        String cadena = "";
        int op = 0;

        do{
            String menu = "Que desea modificar?\n"       +
                    "1.Programa\n" +"2.Semestre\n" +
                    "0.retornar";
            op = entrada.entero(menu);
            switch ( op )
            {
                case 1:
                    String nwProg = entrada.cadena("Digite el nuevo programa: ");
                    while (post!=null)
                    {
                        if ( post.id.equals(aux.id) )
                            post = post.sig;
                        cadena += post.id;
                        post.programa = nwProg;
                        post = post.sig;
                    }
                    System.out.println(cadena);
                    break;
            } // falta arreglar la modificaciones
        }while(op!=0);


    }// Cierre de ModificarDesp


    public boolean validarIdCod(int ident, int cod, String buscar)
    {
        boolean validar = true;
        aux = Primero;
        while (aux != null)
        {
            if ( aux.id.equals(ident) && aux.codigo.equals(cod) || aux.id.equals(ident) && buscar.equals("b")|| aux.codigo.equals(cod) && buscar.equals("b") ) {
                validar = false;
                break;
            }
            aux = aux.sig;
        }
        return validar;
    }//Cierre de la funcion validaIdCod

}// Cierre ListaEstudiante
