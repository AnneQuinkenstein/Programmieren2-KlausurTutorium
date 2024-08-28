package de.htw.aufgabe1;

import java.time.LocalDate;
import java.util.Objects;


public class Radfahrt {

    private final FahrtTyp typ;
    private final LocalDate date;
    private final int kilometer;

    public Radfahrt(FahrtTyp typ, LocalDate date, int kilometer) {
        this.typ = typ;
        this.date = date;
        this.kilometer = kilometer;
    }

    public FahrtTyp getTyp() {
        return typ;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getKilometer() {
        return kilometer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Radfahrt radfahrt = (Radfahrt) o;
        return kilometer == radfahrt.kilometer && typ == radfahrt.typ && Objects.equals(date, radfahrt.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typ, date, kilometer);
    }
}
