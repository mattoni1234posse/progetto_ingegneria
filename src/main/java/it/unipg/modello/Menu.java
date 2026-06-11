package it.unipg.modello;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * La classe Menu gestisce l'intera collezione di prodotti ordinabili nel ristorante.
 * <p>
 * Fornisce i metodi necessari per l'aggiunta di nuovi piatti al menu e per
 * la ricerca specifica da parte del cliente durante la fase di ordinazione (UC1).
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */
public class Menu {

    /** Elenco dei prodotti del ristorante. */
    private List<Prodotto> prodotti;

    /**
     * Costruttore della classe. Inizializza un nuovo menu vuoto.
     */
    public Menu() {
        this.prodotti = new ArrayList<>();
    }
    
    /**
     * Aggiunge un nuovo prodotto al menu.
     * Utilizzato per inserire i piatti nel menu.
     * * @param prodotto L'istanza dell'oggetto {@link Prodotto} da inserire.
     */
    public void aggiungiProdotto (Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    /**
     * Esegue una ricerca nel menu in base al nome del prodotto.
     * <p>
     * La ricerca funziona anche scrivendo lettere maiuscole o minuscole casualmente,
     * oppure inserendo solo parte del nome del cibo,
     * per facilitare l'esperienza dell'utente.
     * </p>
     * * @param nome Il nome o una parte di esso da ricercare.
     * @return Un {@link Optional} contenente il primo prodotto corrispondente trovato,
     * oppure un Optional vuoto se l'alimento non è sul menu.
     */
    public Optional<Prodotto> cercaProdotto(String nome) {
        return prodotti.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .findFirst();
    }

    /**
     * Restituisce la lista completa di tutti i prodotti presenti nel menu.
     * * @return Una {@link List} contenente tutti i prodotti registrati.
     */
    public List<Prodotto> getTuttiIProdotti() {
        return new ArrayList<>(prodotti);
    }
}