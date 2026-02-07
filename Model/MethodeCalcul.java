package Model;
public enum MethodeCalcul {
	CLASSIQUE_40_60("40% - 60%", 0.4, 0.6),
    CLASSIQUE_50_50("50% - 50%", 0.5, 0.5),
    PERSONNALISEE("Personnalisée", -1, -1); // -1 indique que les coefficients sont définis manuellement

    private final String label;
    private final double coefControle;
    private final double coefExamen;

    MethodeCalcul(String label, double coefControle, double coefExamen) {
        this.label = label;
        this.coefControle = coefControle;
        this.coefExamen = coefExamen;
    }

    public String getLabel() {
        return label;
    }

    public double getCoefControle() {
        return coefControle;
    }

    public double getCoefExamen() {
        return coefExamen;
    }

    public static MethodeCalcul fromLabel(String label) {
        for (MethodeCalcul m : values()) {
            if (m.label.equals(label)) {
                return m;
            }
        }
        return null; //erreurs 
    }
}
