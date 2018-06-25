package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenNoTerminal;
import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/25/18.
 */
public class Variable extends Tipo {

    private String identificador;
    private TipoTokenTerminal tipoTokenTerminal = TipoTokenTerminal.N_VAR;
    public String nVariable;

    public Variable(String nombreVariable) {
        this.nVariable = nombreVariable;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public String getNVariable() {
        return this.nVariable;
    }

    public TipoTokenTerminal getTipoReal() {
        return this.tipoTokenTerminal;
    }

    public Object getValorReal() {
        return this.nVariable;
    }


}
