import javax.swing.JOptionPane;
import java.io.*;
public class ListaEstudiante {
    int tmp,tmp2,tmp3;
    NodoEstudiante Primero, ultimo, aux,aux2,aux3,nuevo, ant, post,temporal,temporal2, temporalLEL;
    static Lectura entrada = new Lectura();

    // Constructor
    public ListaEstudiante() { Primero = ultimo = aux = nuevo = ant = post = null; }

    public void Buscar()
    {
        if (Primero == null)
            JOptionPane.showMessageDialog( null, "No existen registros");
        else {
            String cadena = "";
            int ident = entrada.entero("Digite el número de identificación del estudiante: ");
            int codigo = entrada.entero("Digite el número de código del estudiante: ");
            boolean validar = validarIdCod(ident, codigo);
            if (validar == false) {
                cadena += "Identificacion: " + aux.id + "\n" +
                        "Código: " + aux.codigo + "\n" +
                        "Nombres: " + aux.nombres + "\n" +
                        "Direccion: " + aux.direccion + "\n" +
                        "Telefono: " + aux.telefono + "\n" +
                        "Programa: " + aux.programa + "\n" +
                        "Semestre: " + aux.semestre + "\n" +
                        "Nota 1: " + aux.nota1 + "\n" +
                        "Nota 2: " + aux.nota2 + "\n" +
                        "Nota 3: " + aux.nota3 + "\n" +
                        "Promedio: " + aux.notFinal;

                JOptionPane.showMessageDialog(null, cadena); // vamos bien por ahora
            } else
                JOptionPane.showMessageDialog(null, "Error el codigo y/o Identificacion no coinciden o no existen!!!!"); // vamos bien por ahora


        }
    }// Cierre del método Buscar

    public void DespliegaLista(){
        String cad =  "";
        String cad1 = "";
        String cad2 = "";
        int pag = 0;
        int size = 0;
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
                            "Promedio: "      + aux.notFinal    +   "\n"+"\n";
                    aux = aux.sig;
                }else if ( pag >=3 && pag <=5)
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
                            "Promedio: "      + aux.notFinal    +   "\n" +"\n";
                    aux = aux.sig;
                }
                else
                {
                    cad2 += "Identificacion: " + aux.id          +   "\n" +
                            "Codigo: "        + aux.codigo      +   "\n" +
                            "Nombres: "       + aux.nombres     +   "\n" +
                            "Direccion: "     + aux.direccion   +   "\n" +
                            "Telefono: "      + aux.telefono    +   "\n" +
                            "Programa: "      + aux.programa    +   "\n" +
                            "Semestre: "      + aux.semestre    +   "\n" +
                            "Nota 1: "        + aux.nota1       +   "\n" +
                            "Nota 2: "        + aux.nota2       +   "\n" +
                            "Nota 3: "        + aux.nota3       +   "\n" +
                            "Promedio: "      + aux.notFinal    +   "\n"+"\n";
                    aux = aux.sig;
                }
                size++;
            }
            int pag2 = 1;
            JOptionPane.showMessageDialog( null, cad + "pagina " + pag2); // Paginación sencilla no automatizada
            pag2++;
            if ( !cad1.equals("")) // muestra datos si hay mas de 3 datos
                JOptionPane.showMessageDialog( null, cad1 + "pagina " + pag2);
            pag2++;
            if (!cad2.equals(""))
                JOptionPane.showMessageDialog( null, cad2 + "pagina " + pag2);

            JOptionPane.showMessageDialog( null, "Cantidad de elementos "+size);
        }

    }// Cierre de metodo DespliegaLista

    public void Eliminar()
    {
        int op  = 0;
        int op2 = 0;
        if (Primero == null)
            JOptionPane.showMessageDialog( null, "No existen registros");
        else {
            do {
                String menu = "Menu de Eliminación " + "\n" +
                        "¿Desea Eliminar registros por bloques?" + "\n" +
                        "1.Si" + "\n" + "2.No" + "\n" + "0.Retornar";
                op = entrada.entero(menu);
                if (op == 1) {
                    String criterio = entrada.cadena("Por favor ingrese el programa que desea eliminar");
                    boolean validar = validarPrograma(criterio);

                    if (!validar)
                        JOptionPane.showMessageDialog(null, "No existe el programa en la lista");
                    else
                    {
                        aux = Primero;
                        aux2 = Primero;
                        aux3 = Primero;

                        while (aux != null)
                        {

                            aux2 = aux2.sig;
                            if (aux.programa.equals(criterio) && aux2 != null)
                            {
                                Primero = aux2;
                                Primero.sig = aux2.sig;
                                System.out.println("Vamos a ver cuantos programas encontre.");
                            }

                            if (aux2.programa.equals(criterio) && aux.sig!=null)
                            {
                                System.out.println("Controlar ulimto nodo");
                                System.out.println(ultimo.programa);
                                aux.sig = null;
                            }
                            if(aux.programa.equals(criterio) && aux.sig==null)
                            {
                                boolean validar1 = nodosIguales(criterio);
                                if (validar1)
                                {
                                    aux = aux3;
                                    Primero = null;
                                    ultimo = Primero;
                                }
                            }

                            aux = aux.sig;
                            aux3 = aux3.sig;

                            if (aux==null)
                                System.out.println("Aqui termina el ciclo");
                        }

                    }

                }

                else if (op == 2) {

                    String menu2 = "Menu de Eliminación Especifica " + "\n" +
                            "¿Cómo desea Eliminar?" + "\n" +
                            "1.Antes de" + "\n" + "2.Despues de" + "\n"+
                            "0.retornar";
                    op2 = entrada.entero(menu2);

                    switch (op2) {
                        case 1:
                            int ident1 = entrada.entero("Digite la identificacion: ");
                            int cod1 = entrada.entero("Digite el código: ");
                            boolean validar1 = validarIdCod(ident1, cod1);
                            if (!validar1) {
                                EliminarAnt();
                            } else
                                JOptionPane.showMessageDialog(null, "Error la identificación y/o el código no coinciden");
                            break;

                        case 2:
                            int ident2 = entrada.entero("Digite la identificacion: ");
                            int cod2 = entrada.entero("Digite el código: ");
                            boolean validar2 = validarIdCod(ident2, cod2);
                            if (!validar2) {
                                EliminarDesp();
                            } else
                                JOptionPane.showMessageDialog(null, "Error la identificación y/o el código no coinciden");
                            break;

                    }
                }
            } while (op != 0);
        }
    }// Cierre de Eliminar

    public void EliminarAnt()
    {

        if ( aux.id.equals(Primero.id) )
        {
            Primero = aux.sig;
            aux = Primero;
        }else
            Primero = aux;
        JOptionPane.showMessageDialog( null, "Registros eliminados correctamente" );
    }//Cierre del Método EliminarAnt

    public void EliminarDesp()
    {
        if ( aux.id.equals(Primero.id) )
        {
            Primero.sig = ultimo.sig;
            Primero = ultimo;
        }else if ( aux.id.equals(ultimo.id) ) {
            JOptionPane.showMessageDialog(null, "Error no existen nodos que eliminar"); // vamos bien por ahora
        }else{
            aux.sig = null;
        }
        JOptionPane.showMessageDialog( null, "Registros eliminados correctamente" );
    }//Cierre del Método EliminarDesp

    public void EliminarEsp()
    {
    }// Cierre de EliminarEsp

    public  void GuardarFichero(){
        int i;
        String fichero = entrada.cadena("Escriba el nombre el fichero").toLowerCase();
        File archivo = new File("D://"+fichero+".txt");
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
            JOptionPane.showMessageDialog( null, "Se ha guardado correctamente el fichero" );
        }catch(IOException e){
            JOptionPane.showMessageDialog( null, "No se encontró el archivo!" );
        }
    } // fin metodo guardarFichero

    public void InsertBack()
    {
        if ( Primero == null )
        {

            int ident    = entrada.entero("Ingrese el numero de identificacion: ");
            int cod      = entrada.entero("Ingrese el codigo del estudiante: ");
            String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
            double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
            double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
            double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
            String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
            int sem = entrada.semestre("Ingrese el semestre del estudiante " + nom);
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
                boolean validar = validarInsert(ident,cod); // valida si false si la id o cod se repiten.
                if ( validar )
                {
                    String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
                    double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
                    double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
                    double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
                    String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
                    int sem = entrada.semestre("Ingrese el semestre del estudiante " + nom);
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
            int sem = entrada.semestre("Ingrese el semestre del estudiante " + nom);
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
                boolean validar = validarInsert(ident,cod); // valida si false si la id o cod se repiten.
                if ( validar )
                {
                    String nom = entrada.cadena("Ingrese el nombre del estudiante: ").toLowerCase();
                    double nota1 = entrada.notas("Ingrese la primera nota del estudiante " + nom);
                    double nota2 = entrada.notas("Ingrese la segunda nota del estudiante " + nom);
                    double nota3 = entrada.notas("Ingrese la tercera nota del estudiante " + nom);
                    String prog = entrada.cadena("Ingrese el programa del estudiante " + nom).toLowerCase();
                    int sem = entrada.semestre("Ingrese el semestre del estudiante " + nom);
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
        String fichero = entrada.cadena("Digite el nombre del fichero").toLowerCase();
        File archivo = new File( "D://"+(fichero)+".txt");
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
            JOptionPane.showMessageDialog( null, "Se ha cargado el archivo correctamente" );
            in.close();
        }
        catch( IOException e ){
            JOptionPane.showMessageDialog( null, "No se encontró el archivo!" );
        }

    } //fin metodo leerFichero

    public void Modificar()
    {
        String cadena = " === Datos del estudiante === \n";
        aux = Primero;
        if (aux == null)
            JOptionPane.showMessageDialog(null, "La lista esta vacía");
        /*
        while ( aux != null)
        {
            int ident = entrada.entero("Digite el número de identificación del estudiante: ");
            int codigo = entrada.entero("Digite el número de código del estudiante: ");
            if ( aux.id.equals(ident) && aux.codigo.equals(codigo) )
                break;
            aux = aux.sig;
        }
        */ // Validacion para encontrar el de modifcar.
        else
        {
            int ident = entrada.entero("Digite el número de identificación del estudiante: ");
            int codigo = entrada.entero("Digite el número de código del estudiante: ");
            boolean validar = validarIdCod(ident,codigo);
            if ( !validar  )
            {
                int op = 0;
                cadena += "Identificacion: "  + aux.id        + "\n" +
                        "Código: "          + aux.codigo    + "\n" +
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
                    String menu = "¿Qué desea modificar?" + "\n" +
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
                            String op2   = "Dirección: "+ aux.direccion + "\n"+ "Ingrese la nueva dirección por favor";
                            String nwDir = entrada.cadena(op2);
                            aux.direccion = nwDir;
                            break;
                        case 3:
                            String op3   = "Teléfono: "+ aux.telefono + "\n"+ "Ingrese el nuevo teléfono por favor";
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
                JOptionPane.showMessageDialog(null, "Error  identificación y/o código incorrectos");
        }
    }// Cierre del metodo modificar.

    public void ModificarB()
    {
        int op = 0;
        if (Primero == null)
            JOptionPane.showMessageDialog( null, "No existen registros");
        else {
            do {
                String menu = "Menu de modifcacion por bloques" + "\n" +
                        "Desea modificar todos los registros?" + "\n" +
                        "1.Si" + "\n" + "2.No" + "\n" + "0.Retornar";
                op = entrada.entero(menu);
                if (op == 1) {
                    aux = Primero;
                    String menu2 = "Que desea modificar? " + "\n" +
                            "1.Programa " + "\n" + "2.Semestre\n" + "0.retornar";
                    int op2 = entrada.entero(menu2);
                    switch (op2) {
                        case 1:
                            String criterio = entrada.cadena("Por favor escriba que programa desea modificar");
                            boolean validar = validarPrograma(criterio);
                            aux = Primero;
                            if (!validar)
                                JOptionPane.showMessageDialog(null, "Error  no existe el programa en la lista");


                            else
                            {

                                String nwProg = entrada.cadena("Digite el nuevo programa").toLowerCase();

                                while (aux != null) {
                                    if (aux.programa.equals(criterio)){
                                        aux.programa = nwProg;
                                    }
                                    aux = aux.sig;
                                }
                                JOptionPane.showMessageDialog(null, "Modificacion completada");

                            }
                            break;
                        case 2:
                            int nwSemt = entrada.entero("Digite el nuevo semestre");
                            while (aux != null) {
                                aux.semestre = nwSemt;
                                aux = aux.sig;
                            }
                            break;
                    }
                } else if (op == 2) {
                    String menu2 = "Opciones de modificacion? " + "\n" +
                            "1.Antes de " + "\n" + "2.Despues de\n" + "0.retornar";
                    String cadena = "";
                    int op2 = entrada.entero(menu2);
                    switch (op2) {
                        case 1:
                            int ident = entrada.entero("Digite el numero de identificacion: ");
                            int cod = entrada.entero("Digite el codigo: ");
                            boolean validar = validarIdCod(ident, cod);
                            if (!validar) {
                                ModificarAnt();

                            } else
                                JOptionPane.showMessageDialog(null, "Error  identificación y/o código incorrectos");
                            break;
                        case 2:
                            int ident1 = entrada.entero("Digite el numero de identificacion: ");
                            int cod1 = entrada.entero("Digite el codigo: ");
                            boolean validar1 = validarIdCod(ident1, cod1);
                            if (!validar1) {
                                ModificarDesp();

                            } else
                                JOptionPane.showMessageDialog(null, "Error  identificación y/o código incorrectos");
                            break;
                    }
                }
            } while (op != 0);
        }
    }// Cierre de ModificarB (bloque)

    public void ModificarAnt() // tipo es si es semestre o programa
    {
        ant = Primero;
        String cadena = "";
        int op = 0;
        if ( aux.id.equals(Primero.id) )
            JOptionPane.showMessageDialog( null, "No se puede modificar, porque no existen registro antes del primero" );
        else{
            do{
                String menu = "Que desea modificar?\n"       +
                        "1.Programa\n" +"2.Semestre\n" +
                        "0.retornar";
                op = entrada.entero(menu);
                switch ( op )
                {
                    case 1:
                        String nwProg = entrada.cadena("Digite el nuevo programa: ").toLowerCase();
                        while (ant!=null)
                        {
                            if ( ant.id.equals(aux.id) )
                                break;

                            ant.programa = nwProg;
                            ant = ant.sig;
                        }
                        break;
                } // falta arreglar la modificaciones
            }while(op!=0);
            JOptionPane.showMessageDialog( null, "Se han modificado correctamente!" );
        }
    }// Ciere ModificarE

    public void ModificarDesp()
    {
        post = aux;
        String cadena = "";
        int op = 0;
        if( aux.id.equals(ultimo.id) )
            JOptionPane.showMessageDialog( null, "No se puede modificar, porque no existen registros después del ultimo" );
        else {
            do {
                String menu = "Que desea modificar?\n" +
                        "1.Programa\n" + "2.Semestre\n" +
                        "0.retornar";
                op = entrada.entero(menu);
                switch (op) {
                    case 1:
                        String nwProg = entrada.cadena("Digite el nuevo programa: ").toLowerCase();
                        while (post != null) {
                            if (post.id.equals(aux.id))
                                post = post.sig;
                            post.programa = nwProg;
                            post = post.sig;
                        }
                        break;
                } // falta arreglar la modificaciones
            } while (op != 0);
            JOptionPane.showMessageDialog( null, "Se han modificado correctamente!" );
        }
    }// Cierre de ModificarDesp

    public void ModificarSecret()
    {
        validarSecrect();
    }// Cierre del método ModificarSecret

    public boolean validarSecrect()
    {

        return true;
    }// Cierre del método validarSecret


    public boolean validarIdCod(int ident, int cod)
    {
        boolean validar = true;
        aux = Primero;
        while (aux != null)
        {
            if ( aux.id.equals(ident) && aux.codigo.equals(cod))
            {
                validar = false;
                break;
            }
            aux = aux.sig;
        }
        return validar;
    }//Cierre de la funcion validaIdCod

    public boolean validarInsert(int ident, int cod)
    {
        boolean validar = true;
        aux = Primero;
        while (aux != null)
        {
            if ( aux.id.equals(ident) && aux.codigo.equals(cod) || aux.id.equals(ident) || aux.codigo.equals(cod) )
            {
                validar = false;
                break;
            }

            aux = aux.sig;
        }
        return validar;
    }//Cierre de la funcion validaInsert

    public boolean validarPrograma(String prog)
    {
        boolean validar = false;
        aux = Primero;
        while (aux != null)
        {
            if (aux.programa.equals(prog))
                validar = true;
            aux = aux.sig;
        }
        return validar;
    }

    public boolean nodosIguales(String prog)
    {
        boolean validar = true;
        aux = Primero;
        while (aux != null)
        {
            if (!aux.programa.equals(prog))
                validar = false;
            aux = aux.sig;

        }
        return validar;
    }

    public void add_node()
    {
        int number = entrada.entero("Ingrese el numero para el nodo");
        if (Primero==null)
        {
            Primero = new NodoEstudiante(number);
            ultimo = Primero;
        }
        else
        {
            nuevo = new NodoEstudiante(number);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        aux = Primero;
        /*
        Impresion de nodos
        while (aux!=null)

        {
            System.out.println(aux.numb);

            aux = aux.sig;
        }
        */

    }// cierre de add_node

    public void sort_form()
    {
        int number = entrada.entero("Ingrese el numero para el nodo");
        if (Primero==null)
        {
            Primero = new NodoEstudiante(number);
            ultimo = Primero;
        }
        else
        {
            nuevo = new NodoEstudiante(number);
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        aux = Primero;
        while (aux.sig!=null)
        {
            if (aux.numb > aux.sig.numb)
            {
                tmp = aux.sig.numb;
                aux.sig.numb = aux.numb;
                aux.numb = tmp;
            }
            aux = aux.sig;
        }
    } // Cierre de sort_node
    public void sort_node()
    {
        aux = Primero;
        aux3 = Primero;

        while (aux!=null)
        {
            aux2 = Primero;
            while (aux2.sig!=null)
            {
                if (aux2.numb > aux2.sig.numb)
                {
                    tmp = aux2.sig.numb;
                    aux2.sig.numb = aux2.numb;
                    aux2.numb = tmp;

                }
                aux2 = aux2.sig;
            }
            aux = aux.sig;
        }
    }

    public void saveTest()
    {
        String fichero = entrada.cadena("Escriba el nombre del fichero").toLowerCase();
        File archivo = new File("D://"+fichero+".txt");
        aux = Primero;
        try{
            FileWriter w = new FileWriter( archivo );
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            while ( aux != null)
            {
                String cadena = "";
                cadena += aux.numb + "," +"\n";
                aux = aux.sig;
                wr.append( cadena );
            }
            wr.close();
            bw.close();
            JOptionPane.showMessageDialog( null, "Se ha guardado correctamente el fichero" );
        }catch(IOException e){
            JOptionPane.showMessageDialog( null, "No se encontró el archivo!" );
        }
    }
    public void readTest()
    {

        int n=0;  String[] sep; String registro = "";
        String fichero = entrada.cadena("Digite el nombre del fichero").toLowerCase();
        File archivo = new File( "D://"+(fichero)+".txt");
        try{
            BufferedReader in = new BufferedReader( new FileReader(archivo) );
            registro = in.readLine();
            while( registro != null ){
                n++;
                sep = registro.split(",");
                int numb        = Integer.parseInt(sep[0]);
                if ( Primero == null ) {
                    Primero = new NodoEstudiante(numb);
                    ultimo  = Primero;
                }
                else{
                    nuevo = new NodoEstudiante(numb);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                }
                registro = in.readLine(); // leer el siguiente registro
            }
            // System.out.println("Cantidad String: "+ n ); Para saber la cantidad de lineas que hay en el archivo
            JOptionPane.showMessageDialog( null, "Se ha cargado el archivo correctamente" );
            in.close();
        }
        catch( IOException e ){
            JOptionPane.showMessageDialog( null, "No se encontró el archivo!" );
        }
    }

    public void showNodes()
    {
        aux = Primero;
        while (aux!=null)
        {
            System.out.println(aux.numb);
            aux = aux.sig;
        }
    }
}// Cierre ListaEstudiante
