UltimateDisc
============

lista operazioni da fare per il progetto


Marco

1. classe world...composta dai muri, dall'oggetto disco e dalla funzione update che avrà 
cura di controllare che il disco tocca il muro avversario.
2. classe game manager...nella funz update si dovranno aggiornare le posizioni e i relativi eventi 
di ogni oggetto di interesse...funz start crea e avvia tutti gli oggetti del gioco...inoltre stabilisce
 quando termina la partita...inizializza il tempo di gioco...


Antonio

3. classe Disc...velocità fissa...setdirection stabilisce angolo tiro...update sarà per aggiornare la posizione corrente tramite una run... COMPLETATO

4. classe myplayer..update carica le immagini della posizione corrente del player e sposta il player...setEnergyshot è il set di un array che si incrementa a ogni tiro...setSupershot imposta una variabile boolean che stabilisce se si ha un super tiro o no...shot imposta i parametri di tiro del disco, tramite gameManager...

CORREZIONE SHOT
shot non va nella classe player xk i paramentri di deltaX e deltaY non si ottengono nella classe player ma nel panel che cattura gli eventi da tastiera, quindi dal panel chiameremo una ipotetica funzione che a sua volta imposterà i parametri del tiro.
P.S. -> in questa classe vedremo in futuro se metteremo una variabile che stabilisce la potenza del tiro in modo da distinguere i giocatori. Ad esempio un valore double che moltiplica il valore di shot nella classe panel in pratica se in panel abbiamo un tiro forza 5 e abbiamo un player secondo noi scarso mettiamo la variabile a 0,5 in modo da dimezzare la reale velocità, al contrario se abbiamo un giocatore con tiro potente il coefficiente sarà ad esempio 1,5.

5. classe wallPoint...funzioni di set e get della grandezza (in unità) del muro da difendere e in più i punti da attribuire a quella zona di muro toccata.

data 13/10/2014

NUOVE OPERAZIONI

data 19/11/2014 aggiornamento 27/11/2014

1. disegnare campo da gioco					 					-ok
2. inserire nel campo il disco e farlo girare 					-ok
3. iniziare a inserire nel campo i punteggi 			 		-ok
4. aggiungere al campo il player e tutte le sue funzioni
	4.1 interazione player disco								-ok
	4.2 movimento in diagonale del Player						-ok
	4.3 lancio del disco ( direzione e velocit� )				-ok
	4.4 cambiamento immagini movimenti
5. aggiungere il comPlayer ( IA le varie difficolt� )
6. classe screen per gli attributi del monitor					-ok
7. classe per la gestione delle immagini						-ok
8. pannelli menu												-ok
9. gestione timer												-ok
----ritorna al punto 5 
10. immagini dei vari campi, dei vari muri , frisbee,vari player
11. editor
12. 2player?
13. 3d?
14. rete?





