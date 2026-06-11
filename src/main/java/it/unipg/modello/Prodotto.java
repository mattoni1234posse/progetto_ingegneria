package it.unipg.modello;

/**
 * La classe Prodotto rappresenta un singolo alimento o bevanda all'interno del menu.
 * <p>
 * Rispetta il principio SOLID (SRP) gestendo solamente
 * i dati base del cibo e se è disponibile o meno nel ristorante.
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */

public class Prodotto{

    /** Identificativo univoco del prodotto (es. P1, P2). */
    private String idProdotto;

    /** Nome commerciale dell'alimento. */
    private String nome;

    /** Prezzo di vendita. */
    private double prezzo;

    /** Stato di disponibilità degli ingredienti (true se disponibile, false se esaurito). */
    private boolean disponibile;

    /**
     * Costruttore completo della classe Prodotto.
     * Di default, un nuovo prodotto inserito nel menu è impostato come disponibile.
     * * @param idProdotto Il codice identificativo univoco.
     * @param nome       Il nome dell'alimento.
     * @param prezzo     Il prezzo di listino espresso in Euro.
     */
    public Prodotto(String idProdotto, String nome, double prezzo) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.prezzo = prezzo;
        this.disponibile = true; 
    }

    /**
     * Restituisce l'ID univoco del prodotto.
     * * @return String contenente l'identificativo.
     */
    public String getIdProdotto() {return idProdotto; }

    /**
     * Restituisce il nome del prodotto.
     * * @return String con il nome dell'alimento.
     */
    public String getNome() {return nome; }

    /**
     * Restituisce il prezzo del prodotto.
     * * @return double rappresentante il costo.
     */
    public double getPrezzo() {return prezzo; }

    /**
     * Verifica se il prodotto è attualmente disponibile per l'ordinazione (UC1).
     * * @return {@code true} se gli ingredienti sono disponibili, {@code false} altrimenti.
     */
    public boolean isDisponibile() {return disponibile; }

    /**
     * Aggiorna lo stato di disponibilità del prodotto a causa della mancanza delle materie prime in magazzino.
     * * @param disponibile Il nuovo stato di disponibilita da impostare.
     */
    public void setDisponibile (boolean disponibile) {this.disponibile = disponibile; }

    /**
     * Restituisce il nome e il prezzo del prodotto sottoforma di testo.
     * * @return String contenente i dettagli formattati del prodotto.
     */
    @Override
    public String toString() {
        return "Prodotto[ID=" + idProdotto + ", Nome=" + nome + ", Prezzo=" + prezzo + "€]";
    }
}
