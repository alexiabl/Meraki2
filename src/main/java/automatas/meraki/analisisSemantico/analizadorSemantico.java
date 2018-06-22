package automatas.meraki.analisisSemantico;

import automatas.meraki.EstructuraArbol;
import automatas.meraki.analisisSemantico.Reglas.Regla;

import java.util.List;

import static automatas.meraki.analisisSemantico.TipoTokenTerminal.*;
import static automatas.meraki.analisisSemantico.TipoTokenTerminal.FALSO;
import static automatas.meraki.analisisSemantico.TipoTokenTerminal.VERDADERO;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class analizadorSemantico {

    private List<Regla> declaracionesVar;
    private List<Regla> asignaciones;
    private List<Regla> funciones;
    private EstructuraArbol estructuraArbol;

    public analizadorSemantico(EstructuraArbol estructuraArbol) {
        this.estructuraArbol = estructuraArbol;
        this.declaracionesVar = estructuraArbol.getDeclaraciones();
        this.asignaciones = estructuraArbol.getAsignaciones();
        this.funciones = estructuraArbol.getFunciones();
    }

    //para las asignaciones reviso el arbol
    //para las declaraciones reviso tabla de simbolos


    //nueva función para verificar concordancia en asignaciones del mismo tipo
    //las asignaciones deben ser entre tipos compatibles

    public boolean verificarTipos(TipoTokenTerminal tok0, TipoTokenTerminal tok3) {
        //TIPONUM -> NUMERO
        //TIPOTEXTO -> TEXTO
        //TIPOCAR -> CARACTER
        //TIPOBOOL -> VERDADERO || FALSO
        boolean tipoCorrecto = false;
        //Token token = (Token) tok0;
       // Token token2 = (Token) tok3;
        if (tok0 == TIPONUM && tok3 == NUMERO) {
            tipoCorrecto = true;
        } else if (tok0 == TIPOTEXTO && tok3 == TEXTO) {
            tipoCorrecto = true;
        } else if (tok0== TIPOCAR && tok3 == CARACTER) {
            tipoCorrecto = true;
        } else if (tok0 == TIPOBOOL && (tok3 == VERDADERO || tok3 == FALSO)) {
            tipoCorrecto = true;
        } else {
            System.out.println("tipos diferentes " + tok0 + " y " + tok3);
            System.out.println("Mae, esa asignacion esta incorrecta, fijate en el tipo: ");
        }
        if (tipoCorrecto) {
            System.out.println("tipos iguales " + tok0 + " y " + tok3);
        }
        return tipoCorrecto;
    }

    public boolean revisarDevoluciones( TipoTokenTerminal devolucion, TipoTokenTerminal original) //devolver el tipo de dato que indican
    {

        if(original == devolucion)
        {
            System.out.println("tipos iguales " + devolucion + " y " + original);
            return true;
        } else {
            System.out.println("tipos diferentes " + devolucion + " y " + original);
            System.out.println("Oh no! Esto no es lo que deberia devolver: " + original);
            return false;
        }

    }


/*
    public void revisarAsignaciones() {


               List<Node<Regla>> reglas = this.estructuraArbol.getInDepthTraversal(this.estructuraArbol.getArbol());
           for (int i=0; i<reglas.size(); i++){
               Regla reglaActual = reglas.get(i).getLabel();
               if (reglaActual.getNombre().equals("Asignacion")){
                   List<Token> tokens = reglaActual.getTokens();
                   TipoTokenTerminal tipo = (TipoTokenTerminal)tokens.get(0).getTipo();
                   if (tipo.equals(TipoTokenTerminal.NUMERO)){
                   }
               }
           }


        for (Regla asign : this.estructuraArbol.getAsignaciones()) {
            String id = asign.getNombre();

            Tipo tipo = getTipoIdentificador(id);
            if (tipo != null && tipo instanceof NumeroTipo) {
                if (!(exp instanceof NumEntero || exp instanceof OperacionResta || exp instanceof OperacionMultiplicacion || exp instanceof OperacionDivision || exp instanceof OperacionSuma)) {
                    error(TipoError.ASIGNACION_TIPO_INCORRECTA, tipo);
                }
            } else if (tipo != null && tipo instanceof BooleanoTipo) {
                if (!(exp instanceof Falso || exp instanceof Verdadero)) {
                    error(TipoError.ASIGNACION_TIPO_INCORRECTA, tipo);
                }
            } else if (tipo != null && tipo instanceof TextoTipo) {
                if (!(exp instanceof Texto)) {
                    error(TipoError.ASIGNACION_TIPO_INCORRECTA, tipo);
                }
            } else if (tipo != null && tipo instanceof CaracterTipo) {
                if (!(exp instanceof Car)) {
                    error(TipoError.ASIGNACION_TIPO_INCORRECTA, tipo);
                }
            }
        }
    }
*/

    private Object getTipoIdentificador(String name) {
        for (Regla dec : declaracionesVar) {
            Object id = dec.getIdentificador();
            if (id.equals(name))
                return dec.getIdentificador();
        }
        return null;
    }

    public void error(TipoError tipoError, Object item) {
        switch (tipoError) {
            case DEVOLUCION_NO_ACEPTADA:
                System.out.println("Oh no! Esto no es lo que deberia devolver: " + item.toString());
                break;
            case DECLARACION_VAR_MULTIPLE:
                System.out.println("Diay Mae!, Ya declaraste esta variable: " + item.toString());
                break;
            case DECLARACION_METODO_MULTIPLE:
                System.out.println("Diay Mae!, Ya declaraste esta funcion: " + item.toString());
                break;
            case ASIGNACION_TIPO_INCORRECTA:
                System.out.println("Mae, esa asignacion esta incorrecta, fijate en el tipo: " + item.toString());
        }
    }
}
