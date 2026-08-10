import java.util.ArrayList;
import java.util.Scanner;


class Main {

// 🔹 Trova ID
static Utente trovaID (ArrayList<Utente> utenti, int numeroId) 
    {
        for(int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getID() == numeroId) {
                return utenti.get(i);
            }
        }

        return null;

    }


// 🔹 Aggiungi ID
static int addId (ArrayList<Utente> utenti)
    {
        int maxId = 0;

            for (int i = 0; i < utenti.size(); i++) {
                if (utenti.get(i).getID() > maxId) {

                    maxId = utenti.get(i).getID();

                }
                
            }

        return maxId + 1;

    }


// 🔹 Stampa Media saldo utenti
static double stampaMediaSaldo(ArrayList<Utente> utenti)
    { double tots = stampaSaldoTotale(utenti);
        double mediatot = tots / utenti.size();
        return mediatot;

    }

 // 🔹 Stampa Somma saldo utenti
static double stampaSaldoTotale (ArrayList<Utente> utenti) 
       { double saldotot = 0;
       for (int i = 0; i < utenti.size(); i++) {
            saldotot += utenti.get(i).getSaldo();
            }
        return saldotot;
    }

    // 🔹 Stampa Utente piu povero
    static int stampaUtentiConSaldo (ArrayList<Utente> utenti)
    {   int consaldo = 0;
        for (int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getSaldo() > 0) {
                consaldo += 1;
            }
            
        }
            return consaldo;

    }

    // 🔹 Stampa Utente piu povero
    static Utente stampaUtentePovero(ArrayList<Utente> utenti)
    { Utente min = utenti.get(0);
     for (int i = 0; i < utenti.size(); i++) {
        if (utenti.get(i).getSaldo() < min.getSaldo()) {
            min = utenti.get(i);
        }
         
     }
                return min;
    }

    // 🔹 Stampa Utente piu ricco
    static Utente stampaUtenteRicco(ArrayList<Utente> utenti)
    { Utente max = utenti.get(0);
     for (int i = 0; i < utenti.size(); i++) {
        if (utenti.get(i).getSaldo() > max.getSaldo() ) {
            max = utenti.get(i);
        }
         }

            return max;
    }

    // 🔹 Metodo ricerca utente
    static Utente trovaUtente(
        ArrayList<Utente> utenti,
        String nomeUtente
    ) {

         for (int i = 0; i < utenti.size(); i++) {

            if (
                utenti.get(i).getUsername().equals(nomeUtente)
            ) {

                return utenti.get(i);
            }
        }
        return null;
        
    }

    // 🔹 Metodo mostra saldo
    static void mostraSaldo(Utente loggato) {

        System.out.println(
            "Saldo totale: " +
            loggato.getSaldo()
        );
    }

    // 🔹 Metodo stampa utenti solo ID e NOME
    static void stampaUtentiPrivacy (ArrayList<Utente> utenti) 
    {
        if (utenti.size() == 0) {

            System.out.println("Nessun utente registrato");

        } 
            else {
                for (int i = 0; i < utenti.size(); i++) {
                    System.out.println(" ID: " + utenti.get(i).getID() + " Utente : " + utenti.get(i).getUsername());
                }
            }

    }


    // 🔹 Metodo stampa utenti
    static void stampaUtenti(ArrayList<Utente> utenti) {

        if (utenti.size() == 0) {

            System.out.println("Nessun utente registrato");

        } 
            else {

            for (int i = 0; i < utenti.size(); i++) {

                System.out.println(

                    " ID: " +
                    utenti.get(i).getID() +
                    " | Utente: " +
                    utenti.get(i).getUsername() +
                    " | Saldo: " +
                    utenti.get(i).getSaldo() +
                    " | Blocco: " +
                    utenti.get(i).isBloccato()
                );
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        System.out.println("Ciao Featur");


        ArrayList<Utente> utenti =
        new ArrayList<>();

        Filemanager.caricaUtente(utenti);

        while (true) {

            System.out.println(
                "\n--- MENU PRINCIPALE ---"
            );

            System.out.println(
                "0. Admin Login"
            );

            System.out.println(
                "1. Registrazione"
            );

            System.out.println(
                "2. Login"
            );

            System.out.println(
                "3. Lista utenti"
            );

            System.out.println(
                "4. Ricerca utente"
            );
 
            System.out.println(
                "5. Esci"
            );

            int scelta = sc.nextInt();
            sc.nextLine();


            // 🔹 ADMIN LOGIN
            if (scelta == 0) {
                
                Admin admin = new Admin();

                System.out.println("username:");
                String user = sc.nextLine();

                System.out.println("password:");
                String pass = sc.nextLine();

                    if (admin.login(user, pass)) {
                        while (true) {
                        System.out.println("\n--- MENU ADMIN ---");
                        System.out.println("1. Lista utenti");
                        System.out.println("2. Aggiungi saldo");
                        System.out.println("3. Rimuovi saldo");
                        System.out.println("4. Blocca utente");
                        System.out.println("5. Sblocca utente");
                        System.out.println("6. Elimina utente");
                        System.out.println("7. Cronologia Utente");
                        System.out.println("8. Varie Informazioni");
                        System.out.println("9. Logout");

                        int sceltaA = sc.nextInt();

                        sc.nextLine();


                            // 🔹 LISTA UTENTI
                            if (sceltaA == 1) {
                                stampaUtenti(utenti);
                            }

                            // 🔹 AGGIUNGI SALDO
                            if (sceltaA == 2) {

                                stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();

                                Utente trovato = trovaID(utenti, utenteId);

                                if (trovato != null) {

                                    System.out.println("Importo da aggiungere:");
                                    double importo = sc.nextDouble();
                                    trovato.depositaSaldo(importo);
                                    System.out.println("Operazione riuscita!");
                                    System.out.println("Il saldo di " + trovato.getUsername() + " aggiornato:" + trovato.getSaldo());

                                }

                                else System.out.println("Utente non trovato!");

                                Filemanager.salvaUtente(utenti);

                            }

                            // 🔹 RIMUOVI SALDO
                            if (sceltaA == 3) {

                                stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();

                                Utente trovato = trovaID(utenti, utenteId);

                                if (trovato != null) {

                                    System.out.println("Importo:");
                                    double importo = sc.nextDouble();

                                    if (trovato.removeSaldo(importo)) {
                                        System.out.println("Importo rimosso correttamente!");
                                        System.out.println("Nuovo saldo: " + trovato.getSaldo());
                                    }

                                    else System.out.println("Impossibile rimuovere il saldo!");
                                }

                                else {
                                    System.out.println("Operazione Fallita");
                                }

                                Filemanager.salvaUtente(utenti);
                            }

                           // 🔹 BLOCCA UTENTE
                            if (sceltaA == 4) {
                                
                                stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();

                                Utente trovato = trovaID(utenti, utenteId);

                                if (trovato != null) {
                                    admin.bloccoUtente(trovato);
                                    System.out.println("L'Utente " + trovato.getUsername() + "e' stato bloccato!");
                                }

                                else System.out.println("Utente non trovato!");

                                Filemanager.salvaUtente(utenti);
                                
                            }

                           // 🔹 SBLOCCA UTENTE
                            if (sceltaA == 5) {

                                 stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();

                                Utente trovato = trovaID(utenti, utenteId);

                                if (trovato != null) {
                                    admin.sbloccoUtente(trovato);
                                    System.out.println("L'Utente " + trovato.getUsername() + "e' stato sbloccato!");
                                }

                                else System.out.println("Utente non trovato!");

                                Filemanager.salvaUtente(utenti);
                                
                            }                          

                            // 🔹 ELIMINA UTENTE
                            if (sceltaA == 6) {
                                
                                stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();
                                
                                Utente trovato = trovaID(utenti, utenteId);
                                if (admin.rimuoviUtente(utenti, trovato)) {

                                    System.out.println("Utente " + trovato.getUsername() +  "rimosso correttamente!");
                                }

                                else System.out.println("Operazione fallita!");
                                
                                Filemanager.salvaUtente(utenti);

                            }
                            
                             // 🔹 CRONOLOGIA UTENTE
                            if (sceltaA == 7) {

                                 stampaUtenti(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();
                                
                                Utente trovato = trovaID(utenti, utenteId);

                                

                                if (trovato != null) {

                                    ArrayList<String> storico = trovato.getStorico();

                                    if (storico.isEmpty()) {
                                        System.out.println("Cronologia operazioni vuota!");
                                    }
                                    else {

                                        System.out.println("Cronologia:");
                                            for (int u = 0; u < storico.size(); u++) {
                                                System.out.println("Op:" + storico.get(u));
                                    
                                    }
                                }
                                }

                                else System.out.println("Utente non trovato!");
                                                       
                            }

                            // 🔹 LOGOUT
                            if (sceltaA == 9) {
                                System.out.println("Logout effettuato!");

                                break;
                            }


                            if (sceltaA == 8)  {   

                                System.out.println("-------------------------------");

                                // 🔹 UTENTE PIU POVERO
                                System.out.println("UTENTE CON SALDO INFERIORE:");
                                if (utenti.size() == 0) {
                                    System.out.println("Nessun utente registrato");   
                                   }
                                    else {
                                        Utente povero = stampaUtentePovero(utenti);
                                        System.out.println("Utente: " + povero.getID() + " " + povero.getUsername() + " Saldo : " + povero.getSaldo());
                                        
                                    }
                            
                            System.out.println(" ");

                            // 🔹 UTENTE PIU RICCO
                                System.out.println("UTENTE CON SALDO MAGGIORE");
                                if (utenti.size() == 0) {
                                    System.out.println("Nessun utente registrato");
                                    
                                    }

                                else {

                                    Utente ricco = stampaUtenteRicco(utenti);
                                    System.out.println("Utente: " + ricco.getID() + " " + ricco.getUsername() + " Saldo: " + ricco.getSaldo());
                                
                                 }
                
                            System.out.println("");

                            // 🔹 UTENTI CON SALDO
                                System.out.println("CONTI CON SALDO ATTIVO:");
                                int totalesaldi = stampaUtentiConSaldo(utenti);
                                System.out.println("----> " + totalesaldi);

                             System.out.println(" ");

                            // 🔹 TOTALE SALDO UTENTI
                                System.out.println("TOTALE SALDO COMPLESSIVO:");
                                    if (utenti.size() == 0) {
                                    System.out.println("Non sono presenti Utenti");
                                     }
                                else {
                                    double saldotot = stampaSaldoTotale(utenti);
                                    System.out.println("----> " + saldotot);
                                 }

                            System.out.println(" ");

                            // 🔹 MEDIA SALDO UTENTI
                                System.out.println("MEDIA SALDO UTENTI:");
                                if (utenti.size() == 0) {
                                    System.out.println("Non sono presenti Utenti");
                                }
                                else {
                                    double media = stampaMediaSaldo(utenti);
                                    System.out.println("---->: " + media);

                                }
                            
                            }
                            

                                
                            }

                     
 
                           }

                        else {
                            System.out.println("ACCESSO NEGATO");
                          }
        

            }


            // 🔹 REGISTRAZIONE
            if (scelta == 1) {

                
                    int newID = addId(utenti);

                    System.out.println("Inserisci username:");

                    String username = sc.nextLine();

                    System.out.println("Inserisci password:");

                    String password = sc.nextLine();

                    Utente nuovo = new Utente( newID, username, password);

                    String nomeUtente = nuovo.getUsername();

                    Utente esistente = trovaUtente(utenti, nomeUtente);

                    if (esistente != null) {

                        System.out.println("Utente con lo stesso nome gia pesente!!");

                    }

                    else {
                    utenti.add(nuovo);

                    Filemanager.salvaUtente(utenti);

                    System.out.println(
                        "Utente registrato!"
                    );
                    }
                
                }
            

            // 🔹 LOGIN
            else if (scelta == 2) {

                System.out.println("Inserisci username:");

                String inputUser = sc.nextLine();

                System.out.println("Inserisci password:");

                String inputPass = sc.nextLine();

                boolean trovato = false;

                for (int i = 0; i < utenti.size(); i++) {

                    if (
                        utenti.get(i).login(
                            inputUser,
                            inputPass
                        )
                    ) {

                        trovato = true;



                        if (utenti.get(i).isBloccato()) {
                            System.out.println("Utente BLOCCATO!");
                            System.out.println("Usita in corrso...");
                            break;
                        }

                        Utente loggato =
                            utenti.get(i);

                        System.out.println(
                            "Login riuscito, Benvenuto "
                            + loggato.getUsername()
                        );

                        // 🔹 MENU UTENTE
                        while (true) {

                            System.out.println("\n--- MENU UTENTE ---");
                            System.out.println("1. Aggiungi saldo");
                            System.out.println("2. Trasferisci saldo");
                            System.out.println("3. Mostra saldo");
                            System.out.println("4. Cambia password");
                            System.out.println("5. Cronologia Operazioni");
                            System.out.println("6. Logout");

                            int sceltaU =
                                sc.nextInt();

                            sc.nextLine();

                            // 🔹 AGGIUNGI SALDO
                            if (sceltaU == 1) {

                                System.out.println("Inserisci saldo:");

                                double extraSaldo = sc.nextDouble();

                                sc.nextLine();

                                loggato.depositaSaldo(extraSaldo);

                                System.out.println("Saldo aggiornato!");

                                Filemanager.salvaUtente(utenti);
                            }

                            // 🔹 TRASFERIMENTO
                            else if (sceltaU == 2) {

                                stampaUtentiPrivacy(utenti);

                                System.out.println("/-------------------------------------/");

                                System.out.println("Inserire ID utente:");
                                int utenteId = sc.nextInt();

                                Utente destinatario = trovaID(utenti, utenteId);

                                if (destinatario != null && loggato.getID() != destinatario.getID()) {



                                    System.out.println("Importo da trasferire:");
                                    double importo = sc.nextDouble();

                                    if (importo > 0) {

                                        if (loggato.removeSaldo(importo)) {

                                            destinatario.addSaldo(importo);
                                            System.out.println("Operazione Riuscita!");
                                            System.out.println("Saldo aggiornato:" + loggato.getSaldo());

                                        }
                                    
                                        else System.out.println("Saldo non sufficiente!");
                                    }

                                    else System.out.println("Non sono ammessi numeri negativi!");

                                }


                                else System.out.println("ID utente non valido!");
                               

                                Filemanager.salvaUtente(utenti);
                            }

                            // 🔹 MOSTRA SALDO
                            else if (sceltaU == 3) {

                                mostraSaldo(loggato);
                            }

                            // 🔹 CAMBIO PASSWORD
                            else if (sceltaU == 4) {

                                System.out.println("Inserisci password attuale:");
                                String vecchia = sc.nextLine();

                                System.out.println("Inserisci password nuova:");
                                String nuova = sc.nextLine();

                                if (loggato.changePassword(vecchia, nuova)) {
                                    System.out.println("Password cambiata correttamente!");
                                }

                                else System.out.println("Password inserita non corretta!");

                               
                                Filemanager.salvaUtente(utenti);
                                
                            }

                            // 🔹 STORICO OPERAZIONI
                            else if (sceltaU == 5) {
                                ArrayList<String> storico = loggato.getStorico();


                                 if (storico.isEmpty()) {
                                    System.out.println("Cronologia operazioni vuota!");
                                 }
                                
                                 else {
                                    System.out.println("Cronologia:");
                                    for (int u = 0; u < storico.size(); u++) {
                                        System.out.println("Op:" + storico.get(u));
                                        
                                    }
                                 }
                            }


                            // 🔹 LOGOUT
                            else if (sceltaU == 6) {

                                System.out.println(
                                    "Logout effettuato"
                                );

                                break;
                            }

                            else {

                                System.out.println(
                                    "Scelta non valida"
                                );
                            }
                        }

                        break;
                    }
                }

                if (!trovato) {

                    System.out.println(
                        "Username o password errati"
                    );
                }
            }

            // 🔹 LISTA UTENTI
            else if (scelta == 3) {
                
                stampaUtentiPrivacy(utenti);

            }

            // 🔹 RICERCA UTENTE
            else if (scelta == 4) {
                System.out.println("Inserisci Nome utente da cercare:");

                String nomeUtente = sc.nextLine();


                Utente trovato =
                    trovaUtente(
                        utenti,
                        nomeUtente
                    );

                if (trovato != null) {

                    System.out.println(
                        "Utente trovato: "
                        + trovato.getUsername()
                    );

                } else {

                    System.out.println(
                        "Utente non trovato"
                    );
                }
            }
            

            // 🔹 USCITA
            else if (scelta == 5) {

                System.out.println(
                    "Uscita..."
                );

                break;
            }

            // 🔹 SCELTA NON VALIDA
            else {

                System.out.println(
                    "Scelta non valida"
                );
            }
        }
    }
}