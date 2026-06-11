package it.unipg.modello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CassaTest {

    private Cassa cassa;
    private Ordine ordine;
    private Prodotto prodottoDisponibile;
    private Prodotto prodottoEsaurito;

    @BeforeEach
    void setUp() {
        cassa = new Cassa();
        ordine = new Ordine("ORD-01");

        prodottoDisponibile = new Prodotto("P1", "Patatine", 3.00);
        prodottoEsaurito = new Prodotto("P2", "Chicken Nuggets", 5.00);
        prodottoEsaurito.setDisponibile(false);
    }

    @Test 
    void testUC1_InserimentoOrdineSuccesso() {
        boolean inserito = cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile);
        assertTrue(inserito, "Il prodotto disponibile deve essere inserito");
        assertEquals(3.00, ordine.calcolaTotale());
    }

    @Test
    void testUC1_InserimentoOrdineErroreIngredientiEsauriti() {
        boolean inserito = cassa.inserisciProdottoInOrdine(ordine, prodottoEsaurito);
        assertFalse(inserito, "Il sistema deve bloccare l'inserimento se gli ingredienti sono esauriti");
    }

    @Test
    void testUC2_PagamentoSuccesso() {
        cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile); // Totale 3€
        boolean pagato = cassa.elaboraPagamento(ordine, 10.00); // Il cliente ha 10€
        
        assertTrue(pagato, "Il pagamento deve essere autorizzato");
        assertTrue(ordine.isPagato());
    }

    @Test
    void testUC2_PagamentoErroreFondiInsufficienti() {
        cassa.inserisciProdottoInOrdine(ordine, prodottoDisponibile); // Totale 3€
        boolean pagato = cassa.elaboraPagamento(ordine, 1.50); // Il cliente ha solo 1.50€
        
        assertFalse(pagato, "La banca deve rifiutare il pagamento per fondi insufficienti");
        assertFalse(ordine.isPagato());
    }
}
