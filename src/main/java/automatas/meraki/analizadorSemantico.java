package automatas.meraki;

import automatas.meraki.analisisSemantico.Asignacion;
import automatas.meraki.analisisSemantico.DeclVar;
import automatas.meraki.analisisSemantico.Expresion;
import automatas.meraki.analisisSemantico.Operaciones.OperacionDivision;
import automatas.meraki.analisisSemantico.Operaciones.OperacionMultiplicacion;
import automatas.meraki.analisisSemantico.Operaciones.OperacionResta;
import automatas.meraki.analisisSemantico.Operaciones.OperacionSuma;
import automatas.meraki.analisisSemantico.Tipos.*;

import java.util.ArrayList;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class analizadorSemantico {

    private ArrayList<DeclVar> declaracionesVar;
    private ArrayList<Asignacion> asignaciones;
    private ArrayList<Expresion> expresiones;

    public void revisarDeclaraciones() {
        for (int i = 0; i < declaracionesVar.size(); i++) {
            DeclVar var1 = declaracionesVar.get(i);

            for (int j = i + 1; j < declaracionesVar.size(); j++) {
                DeclVar var2 = declaracionesVar.get(j);
                if (var1.getIdentificador().equals(var2.getIdentificador())) {
                    error(TipoError.DECLARACION_VAR_MULTIPLE, var1);
                }
            }
        }
    }

    public boolean revisarIdVarExiste(String nombre) {
        for (DeclVar var : declaracionesVar) {
            if (var.getIdentificador().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void revisarAsignaciones() {
        for (Asignacion asign : asignaciones) {
            Expresion exp = asign.getValor();
            String id = asign.getIdentificador();
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


    private Tipo getTipoIdentificador(String name) {
        for (DeclVar dec : declaracionesVar) {
            Tipo id = dec.getTipo();
            if (id.equals(name))
                return dec.getTipo();
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
