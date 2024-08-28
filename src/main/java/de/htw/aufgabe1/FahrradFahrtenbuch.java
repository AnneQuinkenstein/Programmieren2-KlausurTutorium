package de.htw.aufgabe1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FahrradFahrtenbuch {

    // TODO Nutzen Sie die Streams API um die folgenden Methoden zu implementieren.
    //  Achten Sie darauf, dass alle Tests grün werden.

    public final List<Radfahrt> radfahrten;

    public FahrradFahrtenbuch() {
        radfahrten = new ArrayList<>();
    }

    public void addRadfahrt(Radfahrt radfahrt) {
        radfahrten.add(radfahrt);
    }

    public void addRadfahrt(List<Radfahrt> input) {
        radfahrten.addAll(input);
    }

    // TODO diese Methode soll alle Radfahrten zurückgeben, die an dem als Parameter übergebenen
    //  Tag gemacht wurden
    //  ACHTUNG nutzen Sie STREAMS
    public List<Radfahrt> getRadfahrtenAm(LocalDate date) {
        return radfahrten.stream().filter(element -> element.getDate() == date ).collect(Collectors.toList());
    }

    // TODO Diese Methode soll alle Radfahrten zurückgeben, die mindestens soviele Kilometer haben,
    //  wie der Inputparameter kilometer
    //  ACHTUNG nutzen Sie STREAMS
    public List<Radfahrt> getRadfahrtenMitMindestensKilometern(int kilometer) {
        return radfahrten.stream().filter(element -> element.getKilometer() >= kilometer).collect(Collectors.toList());
    }

    // TODO Diese Methode soll alle Radfahrten zurückgeben, die vom Type des übergebenen
    //  Inputparameter sind
    //  ACHTUNG nutzen Sie STREAMS
    public List<Radfahrt> getRafFahrtenMitTyp(FahrtTyp typ) {
        return radfahrten.stream().filter(element -> element.getTyp() == typ).collect(Collectors.toList());
    }

    // TODO Diese Methode solle die Summe der Kilometer aller gespeicherten Fahrten zurückgeben
    //  ACHTUNG nutzen Sie STREAMS
    public int getAlleGefahrenenKilometer() {

        return radfahrten.stream().mapToInt(i -> i.getKilometer()).sum();
       // return radfahrten.stream().map(e -> e.getKilometer()).reduce(0, (a,b) -> (a + b));
       // return radfahrten.stream().mapToInt(i -> i.getKilometer()).reduce(0, (a,b) -> (a + b));
    }

    // TODO Diese Methode soll ein Set mit den Tyoen der gespeicherten Fahren zurückgeben.
    //  ACHTUNG nutzen Sie STREAMS
    public Set<FahrtTyp> getFahrtenTyp() {
        return radfahrten.stream().map(e -> e.getTyp()).collect(Collectors.toSet());
    }

}
