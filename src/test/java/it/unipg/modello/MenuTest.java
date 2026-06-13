package it.unipg.modello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe di test per {@link Menu}.
 * <p>
 * Verifica il funzionamento delle funzionalità di gestione e 
 * ricerca dei prodotti all'interno del menù del ristorante, a supporto dell'UC1.
 * </p>
 * * @author Marco Mattioni
 * @version 1.0.0
 */
public class MenuTest {
    
    /**
     * Test della funzionalità di ricerca con esito positivo.
     * <p>
     * Aggiunge un prodotto al menù e verifica che la ricerca tramite 
     * una porzione del nome del prodotto restituisca un risultato valido.
     * </p>
     */
    @Test
    void testRicercaProdottoEsistente() {
        Menu menu = new Menu();
        Prodotto p = new Prodotto("P1", "Burger Classic", 7.50);
        menu.aggiungiProdotto(p);

        assertTrue(menu.cercaProdotto("Burger").isPresent(), "Il prodotto dovrebbe essere trovato nel menu");
    }

    /**
     * Test della funzionalità di ricerca con esito negativo.
     * <p>
     * Verifica che la ricerca di una stringa non associata ad alcun 
     * prodotto in catalogo non restituisca un risultato.
     * </p>
     */
    @Test
    void testRicercaProdottoInesistente() {
        Menu menu = new Menu();
        assertFalse(menu.cercaProdotto("Pizza").isPresent(), "Non dovrebbe trovare prodotti non a menu");
    }
}

