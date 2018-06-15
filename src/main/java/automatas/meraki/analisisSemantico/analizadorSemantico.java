package automatas.meraki.analisisSemantico;

import automatas.meraki.EstructuraArbol;

import java.util.List;

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


    public void revisarDeclaraciones() {
        /*
        for (int i = 0; i < declaracionesVar.size(); i++) {
            List<Token> tokens = declaracionesVar.get(i).getTokens();

            for (int j = i + 1; j < declaracionesVar.size(); j++) {
                Token var2 = declaracionesVar.get(j);
                if (var1.getValor().equals(var2.getValor())) {
                    error(TipoError.DECLARACION_VAR_MULTIPLE, var1);
                }
            }
        }*/
    }

    public void revisarAsignacionesArbol() {

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
