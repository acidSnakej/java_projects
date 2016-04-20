import java.util.Objects;

public  class NodoEstudiante {

    Integer id, codigo;
    Object nombres,nota1,nota2,nota3,notFinal, programa, semestre, direccion, telefono;
    NodoEstudiante sig;

    // Constructor que insertBack
    public NodoEstudiante
    (int ident,int cod, Object nom, Object not1, Object not2, Object not3, Object notF, Object prog, Object sem, Object dir, Object tel)
    {
        id        = ident;
        codigo    = cod;
        nombres   = nom;
        nota1     = not1;
        nota2     = not2;
        nota3     = not3;
        notFinal  = notF;
        programa  = prog;
        semestre  = sem;
        direccion = dir;
        telefono  = tel;
    }

    // Constructor que insertFront

    public NodoEstudiante
            (int ident, int cod,Object nom, Object not1, Object not2, Object not3, Object notF, Object prog, Object sem, Object dir, Object tel,NodoEstudiante liga)
    {
        id        = ident;
        codigo    = cod;
        nombres   = nom;
        nota1     = not1;
        nota2     = not2;
        nota3     = not3;
        notFinal  = notF;
        programa  = prog;
        semestre  = sem;
        direccion = dir;
        telefono  = tel;
        this.sig  = liga;
    }

    public String getPrograma()
    {
        return "";
    }

}
