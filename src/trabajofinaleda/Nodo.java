package trabajofinaleda;

//import java.util.ArrayList;

public class Nodo {
    private String valor;                        
    private Nodo izq;
    private Nodo der;

    public Nodo(String valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    public boolean esHoja(){
        return (izq==null && der==null);
    }
}
