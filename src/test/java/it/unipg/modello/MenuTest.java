package it.unipg.modello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MenuTest {
    
    @Test
    void testRicercaProdottoEsistente() {
        Menu menu = new Menu();
        Prodotto p = new Prodotto("P1", "Burger Classic", 7.50);
        menu.aggiungiProdotto(p);

        assertTrue(menu.cercaProdotto("Burger").isPresent(), "Il prodotto dovrebbe essere trovato nel menu");
    }

    @Test
    void testRicercaProdottoInesistente() {
        Menu menu = new Menu();
        assertFalse(menu.cercaProdotto("Pizza").isPresent(), "Non dovrebbe trovare prodotti non a menu");
    }
}

