package de.htw.aufgabe4;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeheimspracheEncoder {

    // TODO Diese Klasse hat eine Methode encode, die Wörter in eine Geheimsprache übersetzt.
    //  Bekommen Sie anhand der vorhanden Tests die Regeln heraus und implementieren Sie
    //  diese.

    // TODO Implementieren Sie die Methode encode, so dass alle vorhandenen Testcases
    //  funktionieren.
    //  Sie können die Tests optional erweitern, wenn Ihnen Cases bei der Implemetierung
    //  helfen


    public String encode(String input) {
        String result = "";

        // nur Großbuchstaben
        // Character umwandeln, um ASCII benutzen zu können (65 - 90) 26Buchenst
        // ((65+23) % 90 + 64 für über C
        // für A-C -> + 23
        // für D- Z -> + 23 (wenn > 90 dann -26 )
        //mapping für jeden Buchstaben


        char[] kapitalCharacters = input.toUpperCase().toCharArray();
            char[] encoded = new char[kapitalCharacters.length];
 /*            for(int i =0; i< kapitalCharacters.length; i++) {
                    if (kapitalCharacters[i] > 25){
                        char newletter = (char) (kapitalCharacters[i] + 23 - 26);
                    } else {
                        char newletter = (char) (kapitalCharacters[i] + 23);
                    }
                     encoded[i] =  newletter;
                }*/

        for(int i =0; i< kapitalCharacters.length; i++) {
            char newletter = (char) (kapitalCharacters[i] + 23);
            if (kapitalCharacters[i] > 90){  // oder if(kapitalCharacters[i] > 'Z)
                 newletter = (char) (newletter - 26);
            }
            encoded[i] =  newletter;

        }

        result = new String(encoded);

        return result;
    }

}
