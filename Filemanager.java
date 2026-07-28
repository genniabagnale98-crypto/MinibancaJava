import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;




class Filemanager {

// 🔹 Salva Utenti conversione array a stringa
private static String storicoToString (ArrayList<String> storico) {
    String saveStringa = "";

    for (int i = 0; i < storico.size(); i++) {

        saveStringa = saveStringa + storico.get(i) + '|';
        
    }

    return saveStringa;
}

// 🔹 Carica Utenti conversione stringa a array
private static ArrayList<String> stringToStorico(String storicoString) {

    ArrayList<String> storico = new ArrayList<>();

    String[] operazioni = storicoString.split("\\|");

    for (int i = 0; i < operazioni.length; i++) {

        if (!operazioni[i].isEmpty()) {
            storico.add(operazioni[i]);
        }

    }

    return storico;
}



// 🔹 Salva Utenti
static void salvaUtente (ArrayList<Utente> utenti)
    { 
        try {
        FileWriter fw = new FileWriter("C:\\Users\\Genna\\Desktop\\uipegaso\\Java\\Minibancajava 5.0\\utenti.txt");

            for (int i = 0; i < utenti.size(); i++) {
            fw.write(
            utenti.get(i).getID() + ";" +    
            utenti.get(i).getUsername() + ";" +
            utenti.get(i).getPassword() + ";" +
            utenti.get(i).getSaldo() + ";" +
            utenti.get(i).isBloccato() + ";" +
            storicoToString(utenti.get(i).getStorico()) + "\n" 
            );

        }

        fw.close();

        
        System.out.println("Salvataggio...");

        }   

        catch (Exception e) {
            System.out.println("Errore nel salvataggio");
        }
    }

// 🔹 Carica Utenti
static void caricaUtente (ArrayList<Utente> utenti)
    {
        try {

        File file = new File(
            "C:\\Users\\Genna\\Desktop\\uipegaso\\Java\\Minibancajava 5.0\\utenti.txt"
        );

        if (!file.exists()) {

            System.out.println("Nessun file trovato");

            return;
        }

        Scanner lettore = new Scanner(file);

        while (lettore.hasNextLine()) {

            String riga = lettore.nextLine();

            String[] dati = riga.split(";");

            ArrayList<String> storico;

            if (dati.length > 5) {
                storico = stringToStorico(dati[5]);
                } else {
                    storico = new ArrayList<>();
                }

            Utente nuovo = new Utente
            (
            Integer.parseInt(dati[0]),
            dati[1],
            dati[2],
            Double.parseDouble(dati[3]),
            Boolean.parseBoolean(dati[4]),
            storico
            );


            utenti.add(nuovo);
        }

        lettore.close();

        System.out.println(
            "Utenti caricati correttamente!"
        );

    }
    catch (Exception e) {

        System.out.println("Errore nel caricamento");

        System.out.println(e.getMessage());
    }

    }






















}