package it.unipg.modello;

/**
 * La classe Cassa rappresenta il mnucleo centrale del sistema.
 * <p>
 * Gestisce i passaggi principali dei casi d'uso, 
 * controllando se i prodotti ci sono (UC1) e gestendo il pagamento con la banca (UC2).
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */
public class Cassa {

    /**
     * UC1: Tenta di inserire un prodotto all'interno di un ordine attraverso la verifica degli ingredienti.
     * <p>
     * Questo metodo controlla in automatico se gli ingredienti sono disponibili.
     * Se il prodotto è esaurito, non viene aggiunto all'ordine per evitare errori nel sistema.
     * </p>
     * * @param ordine   L'oggetto {@link Ordine} in cui inserire il cibo.
     * @param prodotto L'oggetto {@link Prodotto} di cui verificare la disponibilità.
     * @return {@code true} se il prodotto è disponibile e viene aggiunto con successo; 
     * {@code false} se gli ingredienti sono terminati (Flusso di Errore UC1).
     */
    public boolean inserisciProdottoInOrdine(Ordine ordine, Prodotto prodotto) {
        if (prodotto.isDisponibile()) {
            ordine.aggiungiProdotto(prodotto);
            System.out.println("Prodotto " + prodotto.getNome() + " aggiunto all'ordine.");
            return true;
        } else {
            System.out.println("ERRORE UC1: " + prodotto.getNome() + " è esaurito!");
            return false;
        }
    }
    
    /**
     * UC2: Gestisce il pagamento comunicando con la banca.
     * <p>
     * Verifica se i soldi sulla carta del cliente bastano a coprire il totale dell'ordine.
     * In caso positivo l'ordine viene sbloccato per la cucina, altrimenti viene respinto.
     * </p>
     * * @param ordine        L'oggetto {@link Ordine} da pagare.
     * @param budgetCliente Il quantitativo di denaro disponibile sulla carta del Cliente.
     * @return {@code true} se il budget copre il totale e il pagamento è confermato;
     * {@code false} se i fondi sono insufficienti, bloccando la stampa dello scontrino (Flusso di Errore UC2).
     */
    public boolean elaboraPagamento(Ordine ordine, double budgetCliente) {
        double totale = ordine.calcolaTotale();

        if (budgetCliente >= totale) {
            ordine.setPagato(true);
            System.out.println("PAGAMENTO CONFERMATO: Ordine " + ordine.getIdOrdine() + " inviato alla cucina.");
            return true;
        } else {
            System.out.println("ERRORE UC2: Pagamento rifiutato dalla banca. Fondi insufficienti.");
            return false;
        }
    }
}