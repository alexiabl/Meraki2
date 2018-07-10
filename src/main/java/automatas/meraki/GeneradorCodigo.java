package automatas.meraki;

import automatas.meraki.analisisSemantico.Operaciones.OperacionDivision;
import automatas.meraki.analisisSemantico.Operaciones.OperacionMultiplicacion;
import automatas.meraki.analisisSemantico.Operaciones.OperacionResta;
import automatas.meraki.analisisSemantico.Operaciones.OperacionSuma;
import automatas.meraki.analisisSemantico.Reglas.*;
import automatas.meraki.arbol.Node;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 7/8/18.
 */
public class GeneradorCodigo {

    private EstructuraArbol estructuraArbol;

    public GeneradorCodigo(EstructuraArbol estructuraArbol){
        this.estructuraArbol = estructuraArbol;
    }

    public void generarCodigo(){
        List<Node<Regla>> arbol = this.estructuraArbol.getInDepthTraversal(this.estructuraArbol.getArbol());
        for (Node<Regla> node: arbol) {
           if (node.getLabel() instanceof Asignacion){
               System.out.println("Nodo es una ASIGNACION");
           }
           if (node.getLabel() instanceof Si){
               System.out.println("Nodo es un IF");
           }
           if (node.getLabel() instanceof Sino){
               System.out.println("Nodo es un ELSE");
           }
           if (node.getLabel() instanceof Mientras){
               System.out.println("Nodo es un WHILE");
           }
           if (node.getLabel() instanceof Condicion){
               System.out.println("Nodo es una CONDICION");
           }
           if (node.getLabel() instanceof OperacionResta){
               System.out.println("Nodo es una RESTA");
           }
            if (node.getLabel() instanceof OperacionMultiplicacion) {
                System.out.println("Nodo es una MULTIPLICACION");
            }
            if (node.getLabel() instanceof OperacionSuma){
                System.out.println("Nodo es una SUMA");
            }
            if (node.getLabel() instanceof OperacionDivision){
                System.out.println("Nodo es una DIVISION");
            }
            if (node.getLabel() instanceof Llamado){
                System.out.println("Nodo es un LLAMADO");
            }

        }

    }

    public String generarCodigoAsignacion(){
        return "Codigo Asignacion";
    }

    public String generarCodigoIf(){
        return "Codigo IF";
    }

    public String generarCodigoElse(){
        return "Codigo ELSE";
    }

    public String generarCodigoWhile(){
        return "Codigo WHILE";
    }

    public String generarCodigoResta(){
        return "Codigo RESTA";
    }






}
