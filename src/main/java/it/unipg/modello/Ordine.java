package it.unipg.modello;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Ordine rappresenta la comanda attuale compilata dal cliente.
 * <p>
 * Memorizza i prodotti scelti dal cliente un po' alla volta e
 * calcola il prezzo totale da pagare.
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */
public class Ordine {

    /** Identificativo alfanumerico univoco dell'ordine. */
    private String idOrdine;

    /** Tutti i prodotti inseriti nel carrello dal cliente. */
    private List<Prodotto> prodottiSelezionati;

    /** Stato del pagamento dell'ordine (true se accettato, false se in attesa). */
    private boolean pagato;

    /**
     * Costruttore della classe Ordine.
     * Configura l'ID e inizializza un carrello vuoto contrassegnato come non pagato.
     * * @param idOrdine L'identificativo univoco da assegnare alla comanda.
     */
    public Ordine(String idOrdine){
        this.idOrdine = idOrdine;
        this.prodottiSelezionati = new ArrayList<>();
        this.pagato = false;
    }

    /**
     * Inserisce un prodotto all'interno della comanda attuale.
     * * @param p L'istanza dell'oggetto {@link Prodotto} da aggiungere.
     */
    public void aggiungiProdotto(Prodotto p) {
        prodottiSelezionati.add(p);
    }
    
    /**
     * Calcola la somma aritmetica dei prezzi di tutti i prodotti inseriti nell'ordine.
     * * @return double corrispondente al totale complessivo da pagare.
     */
    public double calcolaTotale() {
        return prodottiSelezionati.stream().mapToDouble(Prodotto::getPrezzo).sum();
    }

    /**
     * Restituisce l'identificativo dell'ordine.
     * * @return String contenente l'ID.
     */
    public String getIdOrdine() { return idOrdine; }

    /**
     * Verifica se l'ordine è stato completato con successo (UC2).
     * * @return {@code true} se pagato, {@code false} se è ancora da pagare.
     */
    public boolean isPagato() { return pagato; }

    /**
     * Aggiorna lo stato del pagamento dell'ordine successivamente alla transazione bancaria.
     * * @param pagato {@code true} per confermare l'avvenuto pagamento.
     */
    public void setPagato(boolean pagato) { this.pagato = pagato; }
}

