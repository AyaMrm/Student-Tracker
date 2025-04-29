package Model;

public enum NumeroSemestre {
	SEMESTRE_1("Semestre 1"),
    SEMESTRE_2("Semestre 2");

    private final String value;

    NumeroSemestre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NumeroSemestre fromString(String text) {
        for (NumeroSemestre num : NumeroSemestre.values()) {
            if (num.value.equalsIgnoreCase(text)) {
                return num;
            }
        }
        throw new IllegalArgumentException("Valeur invalide pour NumeroSemestre: " + text);
    }
}
