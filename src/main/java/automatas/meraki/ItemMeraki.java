package automatas.meraki;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/11/18.
 */
public class ItemMeraki {

    private String nombreRegla;
    private int idContexto;
    private List<Token> tokens;

    public ItemMeraki(String nombreRegla, int id) {
        this.nombreRegla = nombreRegla;
        this.idContexto = id;
    }

    public String getNombreRegla() {
        return nombreRegla;
    }

    public void setNombreRegla(String nombreRegla) {
        this.nombreRegla = nombreRegla;
    }

    public int getIdContexto() {
        return idContexto;
    }

    public void setIdContexto(int idContexto) {
        this.idContexto = idContexto;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
