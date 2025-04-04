package model;

public class Semestre {
	private int idSemestre;
    private NumeroSemestre numero;
    private Double moyenneSemestre;
    private int idAnnee;

    public Semestre(int idSemestre, NumeroSemestre numero, Double moyenneSemestre, int idAnnee) {
        this.idSemestre = idSemestre;
        this.numero = numero;
        this.moyenneSemestre = moyenneSemestre;
        this.idAnnee = idAnnee;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public NumeroSemestre getNumero() {
        return numero;
    }

    public void setNumero(NumeroSemestre numero) {
        this.numero = numero;
    }

    public Double getMoyenneSemestre() {
        return moyenneSemestre;
    }

    public void setMoyenneSemestre(Double moyenneSemestre) {
        this.moyenneSemestre = moyenneSemestre;
    }

    public int getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(int idAnnee) {
        this.idAnnee = idAnnee;
    }

    @Override
    public String toString() {
        return "Semestre{" +
                "idSemestre=" + idSemestre +
                ", numero=" + numero.getValue() +
                ", moyenneSemestre=" + moyenneSemestre +
                ", idAnnee=" + idAnnee +
                '}';
    }
}
