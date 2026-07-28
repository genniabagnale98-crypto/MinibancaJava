
import java.util.ArrayList;

class Utente {

    private String username;
    private String password;
    private double saldo;
    private boolean bloccato;
    private int id;
    private ArrayList<String> storico;

    // 🔹 Metodo login
    boolean login(String u, String p) {

        return u.equals(username) &&
               p.equals(password);
    }


// 🔹 Costruttore Utente per registrazione
Utente(int id, String username, String password) {

    this.id = id;
    this.username = username;
    this.password = password;


    this.storico = new ArrayList<>();
    saldo = 0;
    bloccato = false;
}

// 🔹 Costruttore Utente per caricamento
    public Utente(int id, String username, String password, double saldo, boolean bloccato, ArrayList<String> storico ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.bloccato = bloccato;
        this.storico = storico;
    }


// 🔹 Cambio password
public boolean changePassword (String vecchia, String nuova) {
    if (password.equals(vecchia)) {

        password = nuova;
        return true;
    }
return false;
}

// 🔹 Aggiungi saldo 
public void depositaSaldo (double importo) {
    setSaldo(getSaldo() + importo);
    aggiungiOperazione("+" + importo + " EURO Deposito");
}

// 🔹 Aggiungi saldo 
public void addSaldo (double importo) {
    setSaldo(getSaldo() + importo);
    aggiungiOperazione("+" + importo + " EURO Entrate");
}

// 🔹 Rimuovi saldo
public boolean  removeSaldo (double importo) {
    if (saldo >= importo) {
        setSaldo(saldo - importo);
        aggiungiOperazione("-" + importo + " EURO Uscite");
        return true;
    }
    return false;
}

// 🔹 Getter di password
public String getPassword () {
    return password;
}

// 🔹 Setter di password
public void setPassword (String password) {
    this.password = password;
}

// 🔹 Getter di password
public String getUsername () {
    return username;
}

// 🔹 Setter di password
public void setUsername (String username) {
    this.username = username;
}

// 🔹 Getter di bloccato
public boolean isBloccato() {
    return bloccato;
}

// 🔹 Setter di bloccato
public void setBloccato(boolean bloccato) {
    this.bloccato = bloccato;
}

// 🔹 Getter di saldo
public double getSaldo() {
    return saldo;
}

// 🔹 Setter di saldo
public void setSaldo (double saldo) {
    if (saldo >= 0) {
        this.saldo = saldo;
    }
}
// 🔹 Getter di ID
public int getID () {
    return id;
}

// 🔹 Aggiungi cronologia operazioni
private void aggiungiOperazione(String operazione) {

    storico.add(operazione);

}

// 🔹 Getter cronologia operazioni
public ArrayList<String> getStorico () {
    return storico;

}


}