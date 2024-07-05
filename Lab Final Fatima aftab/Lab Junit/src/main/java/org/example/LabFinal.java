package org.example;

public class LabFinal {
    public String determineShape(float w1, float h1, float w2, float h2) {
        try {
            if (w1 <= 0 || w2 <= 0 || h1 <= 0 || h2 <= 0) {
                return "Invalid sides. Neither square nor rectangle.";
            } else if ((w1 == w2) && (h1 == h2)) {
                if ((w1 == h1) && (w2 == h2)) {
                    return "Given shape is Square.";
                } else {
                    return "Given shape is Rectangle.";
                }
            } else {
                return "Invalid sides. Neither square nor rectangle.";
            }
        } catch (NumberFormatException e) {
            return "Invalid input";
        }
    }
}
