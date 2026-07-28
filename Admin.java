
import java.util.ArrayList;

class Admin extends Utente {

     Admin() {
        super(0, "admin", "0000");
    }
    

    public void bloccoUtente (Utente utente) {
 
      utente.setBloccato(true);
        
    }

    public void sbloccoUtente (Utente utente) {
 
      utente.setBloccato(false);
        
    }


    public boolean rimuoviUtente (ArrayList utenti, Utente utente) {
        return utenti.remove(utente);       
    }

    @Override
    boolean login (String u, String p) {
      boolean accesso = super.login(u, p);

      if (accesso) {
        System.out.println("Accesso effettuato come AMMINISTRATORE!");
      }
      return accesso;
    }
    
}