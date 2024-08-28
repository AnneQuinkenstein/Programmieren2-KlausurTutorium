package de.htw.aufgabe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;


import static de.htw.aufgabe1.FahrtTyp.*;
import static org.junit.jupiter.api.Assertions.*;

class FahrradFahrtenbuchTest {

    private FahrradFahrtenbuch fahrtenbuch;

    @BeforeEach
    void setUp() {
        fahrtenbuch = new FahrradFahrtenbuch();
    }

    @Test
    public void getAllKilometerEineFahrt() {
        fahrtenbuch.addRadfahrt(new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20));
        int result = fahrtenbuch.getAlleGefahrenenKilometer();
        assertEquals(20, result);
    }

    @Test
    public void getAllKilometerZweiFahrt() {
        fahrtenbuch.addRadfahrt(new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20));
        fahrtenbuch.addRadfahrt(new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 1), 50));
        int result = fahrtenbuch.getAlleGefahrenenKilometer();
        assertEquals(70, result);
    }

    @Test
    public void getAllKilometerMehrereFahrten() {
        List<Radfahrt> list = Arrays.asList(
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20),
                new Radfahrt(STRASSE, LocalDate.of(2024, 6, 1), 10),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 30), 15),
                new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60),
                new Radfahrt(SPINNING, LocalDate.of(2024, 5, 4), 100),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 17), 5));
        fahrtenbuch.addRadfahrt(list);
        int result = fahrtenbuch.getAlleGefahrenenKilometer();
        assertEquals(210, result);
    }

    @Test
    public void getEineFahrtAnEinemTag() {
        LocalDate testDate = LocalDate.of(2024, 4, 15);
        Radfahrt radfahrt = new Radfahrt(GRAVEl, testDate, 20);
        fahrtenbuch.addRadfahrt(radfahrt);
        fahrtenbuch.addRadfahrt(new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 16), 20));

        List<Radfahrt> radfahrtenAm = fahrtenbuch.getRadfahrtenAm(testDate);
        List<Radfahrt> result = radfahrtenAm;
        assertEquals(1, result.size());
        assertTrue(result.contains(radfahrt));
    }

    @Test
    public void getZweiFahrtAnEinemTag() {
        LocalDate testDate = LocalDate.of(2024, 4, 15);
        Radfahrt radfahrt1 = new Radfahrt(GRAVEl, testDate, 20);
        Radfahrt radfahrt2 = new Radfahrt(STRASSE, testDate, 25);
        fahrtenbuch.addRadfahrt(radfahrt1);
        fahrtenbuch.addRadfahrt(radfahrt2);
        fahrtenbuch.addRadfahrt(new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 16), 20));

        List<Radfahrt> radfahrtenAm = fahrtenbuch.getRadfahrtenAm(testDate);
        List<Radfahrt> result = radfahrtenAm;
        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList(radfahrt1, radfahrt2)));
    }

    @Test
    public void getAllRadfahrtenMitMindestens50Kilometern() {
        Radfahrt radfahrt1 = new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60);
        Radfahrt radfahrt2 = new Radfahrt(SPINNING, LocalDate.of(2024, 5, 4), 100);
        List<Radfahrt> list = Arrays.asList(
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20),
                new Radfahrt(STRASSE, LocalDate.of(2024, 6, 1), 10),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 30), 15),
                radfahrt1,
                radfahrt2,
                new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 17), 5));
        fahrtenbuch.addRadfahrt(list);
        List<Radfahrt> result = fahrtenbuch.getRadfahrtenMitMindestensKilometern(50);
        assertEquals(Arrays.asList(radfahrt1, radfahrt2), result);
    }

    @Test
    public void getAllRadfahrtenMitMindestens60Kilometern() {
        Radfahrt radfahrt1 = new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60);
        Radfahrt radfahrt2 = new Radfahrt(SPINNING, LocalDate.of(2024, 5, 4), 100);
        List<Radfahrt> list = Arrays.asList(
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20),
                new Radfahrt(STRASSE, LocalDate.of(2024, 6, 1), 10),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 30), 15),
                radfahrt1,
                radfahrt2,
                new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 17), 5));
        fahrtenbuch.addRadfahrt(list);
        List<Radfahrt> result = fahrtenbuch.getRadfahrtenMitMindestensKilometern(60);
        assertEquals(Arrays.asList(radfahrt1, radfahrt2), result);
    }

    @Test
    public void getAllRadfahrtenMitMindestens200KilometernLeereListe() {
        Radfahrt radfahrt1 = new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60);
        Radfahrt radfahrt2 = new Radfahrt(SPINNING, LocalDate.of(2024, 5, 4), 100);
        List<Radfahrt> list = Arrays.asList(
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20),
                new Radfahrt(STRASSE, LocalDate.of(2024, 6, 1), 10),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 30), 15),
                radfahrt1,
                radfahrt2,
                new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 17), 5));
        fahrtenbuch.addRadfahrt(list);
        List<Radfahrt> result = fahrtenbuch.getRadfahrtenMitMindestensKilometern(200);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void getAllRadfahrtenVomTypGravel() {
        Radfahrt radfahrt1 = new Radfahrt(GRAVEl, LocalDate.of(2024, 7, 12), 60);
        fahrtenbuch.addRadfahrt(radfahrt1);
        List<Radfahrt> result = fahrtenbuch.getRafFahrtenMitTyp(GRAVEl);
        assertEquals(Arrays.asList(radfahrt1), result);
    }

    @Test
    public void getAllRadfahrtenVomTypStrasseMehrereFahrten() {
        Radfahrt radfahrt1 = new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60);
        Radfahrt radfahrt2 = new Radfahrt(STRASSE, LocalDate.of(2024, 5, 4), 100);
        List<Radfahrt> list = Arrays.asList(
                radfahrt1,
                radfahrt2,
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 15), 20),
                new Radfahrt(SPINNING, LocalDate.of(2024, 6, 1), 10),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 4, 30), 15),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 3, 17), 5));
        fahrtenbuch.addRadfahrt(list);
        List<Radfahrt> result = fahrtenbuch.getRafFahrtenMitTyp(STRASSE);
        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList(radfahrt1, radfahrt2)));
    }

    @Test
    public void getAllRadfahrtenVomTypGravelLeereListe() {
        Radfahrt radfahrt1 = new Radfahrt(SPINNING, LocalDate.of(2024, 7, 12), 60);
        fahrtenbuch.addRadfahrt(radfahrt1);
        List<Radfahrt> result = fahrtenbuch.getRafFahrtenMitTyp(GRAVEl);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void getTypenVonRadfahrtenEinTyp() {
        Radfahrt radfahrt1 = new Radfahrt(SPINNING, LocalDate.of(2024, 7, 12), 60);
        fahrtenbuch.addRadfahrt(radfahrt1);
        Set<FahrtTyp> result = fahrtenbuch.getFahrtenTyp();
        assertEquals(Set.of(SPINNING), result);
    }

    @Test
    public void getTypenVonRadfahrtenAlleTyp() {
        List<Radfahrt> list = Arrays.asList(
                new Radfahrt(SPINNING, LocalDate.of(2024, 7, 12), 60),
                new Radfahrt(GRAVEl, LocalDate.of(2024, 7, 12), 60),
                new Radfahrt(STRASSE, LocalDate.of(2024, 7, 12), 60),
                new Radfahrt(MOUNTAIN_BIKE, LocalDate.of(2024, 7, 12), 60)
        );
        fahrtenbuch.addRadfahrt(list);
        Set<FahrtTyp> result = fahrtenbuch.getFahrtenTyp();
        assertEquals(Set.of(FahrtTyp.values()), result);
    }

    @Test
    public void getTypenVonRadfahrtenLeeresSet() {
        Set<FahrtTyp> result = fahrtenbuch.getFahrtenTyp();
        assertEquals(Collections.emptySet(), result);
    }

}