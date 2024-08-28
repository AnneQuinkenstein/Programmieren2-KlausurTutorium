package de.htw.aufgabe2;

public class FooBar {

    public String getFooBar(int input) {
        StringBuilder stringBuilder = new StringBuilder();
        checkInput(input, 7, "Let", stringBuilder);
        checkInput(input, 2, "go", stringBuilder);
        checkInput(input, 3, "Foo", stringBuilder);
        checkInput(input, 5, "Bar", stringBuilder);

        if (stringBuilder.isEmpty()) {
            return String.valueOf(input);
        }

        return stringBuilder.toString();
    }

    private void checkInput(int input, int value, String output, StringBuilder stringBuilder) {
        if (input % value == 0) {
            appendSpace(stringBuilder);
            stringBuilder.append(output);
        }
    }

    private void appendSpace(StringBuilder stringBuilder) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append(" ");
        }
    }
}
