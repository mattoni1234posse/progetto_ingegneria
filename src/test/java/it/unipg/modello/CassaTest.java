package it.unipg.modello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe di test per {@link Cassa}.
 * <p>
 * Verifica il corretto funzionamento dei casi d'uso principali del sistema:
 * UC1 (Inserimento prodotto in ordine) e UC2 (Elaborazione del pagamento).
 * I test coprono sia i flussi positivi che i flussi di errore.
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */
public class CassaTest {

    private Cassa cassa;
    private Ordine ordine;
    private Prodotto prodottoDisponibile;
    private Prodotto prodottoEsaurito;

    /**
     * Configurazione iniziale eseguita prima di ogni test.
     * Inizializza il sistema di cassa, un ordine vuoto e crea dei prodotti di prova (mock)
     * per simulare le diverse disponibilità di magazzino.
     */
    @BeforeEach
    void setUp() {
        cassa = new Cassa();
        ordine = new Ordine("ORD-01");

        prodottoDisponibile = new Prodotto("P1", "Patatine", 3.00);
        prodottoEsaurito = new Prodotto("P2", "Chicken Nuggets", 5.00);
        prodottoEsaurito.setDisponibile(false);
    }

    /**
     * Test del flusso base per UC1.
     * <p>
     * Verifica che un prodotto che risulta come "disponibile" venga
     * correttamente aggiunto all'ordine e che il totale venga aggiornato.
     * </p>
     */
    @Test 
    void testUC1_InserimentoOrdineSuccesso() {
        boolean inserito = cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile);
        assertTrue(inserito, "Il prodotto disponibile deve essere inserito");
        assertEquals(3.00, ordine.calcolaTotale());
    }

    /**
     * Test del flusso di errore per UC1.
     * <p>
     * Verifica che il sistema rifiuti l'inserimento di un prodotto 
     * i cui ingredienti sono segnalati come esauriti, ritornando false.
     * </p>
     */
    @Test
    void testUC1_InserimentoOrdineErroreIngredientiEsauriti() {
        boolean inserito = cassa.inserisciProdottoInOrdine(ordine, prodottoEsaurito);
        assertFalse(inserito, "Il sistema deve bloccare l'inserimento se gli ingredienti sono esauriti");
    }

    /**
     * Test del flusso base per UC2.
     * <p>
     * Simula un cliente con fondi sufficienti a coprire il totale dell'ordine.
     * Verifica che il pagamento venga approvato e lo stato dell'ordine aggiornato a "pagato".
     * </p>
     */
    @Test
    void testUC2_PagamentoSuccesso() {
        cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile); // Totale 3€
        boolean pagato = cassa.elaboraPagamento(ordine, 10.00); // Il cliente ha 10€
        
        assertTrue(pagato, "Il pagamento deve essere autorizzato");
        assertTrue(ordine.isPagato());
    }

    /**
     * Test del flusso di errore per UC2.
     * <p>
     * Simula un cliente con fondi insufficienti al totale dell'ordine.
     * Verifica che la transazione venga rifiutata e l'ordine rimanga "non pagato".
     * </p>
     */
    @Test
    void testUC2_PagamentoErroreFondiInsufficienti() {
        cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile); // Totale 3€
        boolean pagato = cassa.elaboraPagamento(ordine, 1.50); // Il cliente ha solo 1.50€
        
        assertFalse(pagato, "La banca deve rifiutare il pagamento per fondi insufficienti");
        assertFalse(ordine.isPagato());
    }
}
