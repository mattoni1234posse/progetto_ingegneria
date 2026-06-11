# Ristorazione Rapida - Sistema di ristorazione rapida

Progetto per l'esame assegnato di Ingegneria del Software.
Il sistema è stato progettato seguendo i principi della progettazione OOP, rispettando i criteri SOLID e garantendo una totale tracciabilità tra i casi d'uso e il codice Java.

---

## Requisiti Tecnologici
* **Linguaggio:** Java 21
* **Build Automation Tool:** Maven 3.x
* **Framework di Test:** JUnit 5 (Jupiter)
* **Documentazione:** Javadoc standard

---

## Casi d'Uso Core 
Il sistema gestisce in modo autonomo il flusso *end-to-end* della comanda concentrandosi su due casi principali:

1. **UC1: Inserimento Ordine**
   * **Flusso Positivo:** Il cliente seleziona i prodotti dal menu. Il sistema invoca attiva il sotto-flusso di verifica logistica delle materie prime. Se disponibili, calcola il totale e imposta l'ordine.
   * **Flusso di Errore:** Se un ingrediente è terminato, il sistema blocca l'inserimento mostrando l'errore ed evita l'invio di comande errate alla cucina.
2. **UC2: Elaborazione Pagamento**
   * **Flusso Positivo:** L'ordine viene associato a un'interfaccia di pagamento. Il sistema contatta l'attore esterno (Banca) e, a dopo l'autorizzazione, sposta lo stato dell'ordine in "Pagato" sbloccando la comanda per la cucina.
   * **Flusso di Errore:** Se la banca rifiuta la transazione (es. fondi insufficienti), il sistema interrompe il flusso e annulla l'ordine.
