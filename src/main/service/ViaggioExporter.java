package main.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.model.Trip;

public class ViaggioExporter {

    public static void exportViaggiDisponibili(List<Trip> viaggi) {
        // Filtra i viaggi disponibili
        List<Trip> viaggiDisponibili = filterViaggiDisponibili(viaggi);

        // Ottieni la data corrente
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
        Date date = new Date();
        String currentDate = formatter.format(date);

        // Nome del file CSV da creare
        String fileName = "viaggi_" + currentDate + ".csv";

        try {
            // Crea un nuovo file CSV
            FileWriter writer = new FileWriter(fileName);

            // Scrivi l'intestazione del file CSV
            writer.append("ID;Data;Durata (ore);Partenza;Arrivo\n");

            // Scrivi i viaggi disponibili nel file CSV
            for (Trip viaggio : viaggiDisponibili) {
                writer.append(viaggio.getId() + ";");
                writer.append(viaggio.getDate() + ";");
                writer.append(viaggio.getTimeTrip() + ";");
                writer.append(viaggio.getStart() + ";");
                writer.append(viaggio.getDestination() + "\n");
            }

            // Chiudi il writer
            writer.close();

            System.out.println("I viaggi disponibili sono stati esportati correttamente nel file: " + fileName);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante l'esportazione dei viaggi disponibili.");
            e.printStackTrace();
        }
    }

    private static List<Trip> filterViaggiDisponibili(List<Trip> viaggi) {
        // Implementa il filtro dei viaggi disponibili secondo le tue esigenze
        // Ad esempio, potresti controllare il campo "disponibile" del viaggio
        // e includere solo i viaggi con questo campo impostato su true.
        // Qui ti mostro un esempio di filtro che restituisce semplicemente tutti i
        // viaggi:
        List<Trip> viaggiDisponibili = new ArrayList<>();
        for (Trip viaggio : viaggi) {
            if (viaggio.isAvailable()) {
                viaggiDisponibili.add(viaggio);
            }
        }
        return viaggiDisponibili;
    }
}