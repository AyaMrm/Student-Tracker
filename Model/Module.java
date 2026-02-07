package Model;
public class Module {
	 private int idModule;
	    private String nom;
	    private int idProfResponsable;
	    private int idSpecialite ;
	    private MethodeCalcul methodeCalcul;
	    private Double coefControle; // Optionnel si méthode personnalisée
	   private Double coefExamen;   // Optionnel si méthode personnalisée
		private int idSemestre;
	   
	   
	   public Module(int idModule, String nom, int idProfResponsable, int idSpecialite , int idSemestre ,MethodeCalcul methodeCalcul,
				Double coefControle, Double coefExamen) {
			super();
			this.idModule = idModule;
			this.nom = nom;
			this.idProfResponsable = idProfResponsable;
			this.idSpecialite  = idSpecialite ;
			  this.idSemestre = idSemestre;

			this.methodeCalcul = methodeCalcul;
			  this.coefControle = coefControle;
	            this.coefExamen = coefExamen;
		}
		public int getIdModule() {
			return idModule;
		}
		public void setIdModule(int idModule) {
			this.idModule = idModule;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getIdProfResponsable() {
			return idProfResponsable;
		}
		public void setIdProfResponsable(int idProfResponsable) {
			this.idProfResponsable = idProfResponsable;
		}
		public int getidSpecialite () {
			return idSpecialite ;
		}
		public void setidSpecialite (int idSpecialite ) {
			this.idSpecialite  = idSpecialite ;
		}
		public MethodeCalcul getMethodeCalcul() {
			return methodeCalcul;
		}
		public void setMethodeCalcul(MethodeCalcul methodeCalcul) {
			this.methodeCalcul = methodeCalcul;
		}
		
		public Double getCoefControle() {
			return coefControle;
		}
		
		public Double getCoefExamen() {
			return coefExamen;
		}
		
		
		
		public int getIdSemestre() {
			return idSemestre;
		}
		public void setIdSemestre(int idSemestre) {
			this.idSemestre = idSemestre;
		}
		public void setCoeficientsPersonnalises(double coefControle, double coefExamen) {
	        if (this.methodeCalcul == MethodeCalcul.PERSONNALISEE) {
	            this.coefControle = coefControle;
	            this.coefExamen = coefExamen;
	        } else {
	            throw new IllegalArgumentException("Les coefficients ne peuvent être modifiés que pour une méthode personnalisée.");
	        }
	    }

	    public double calculerNoteFinale(double noteControle, double noteExamen) {
	        if (methodeCalcul == MethodeCalcul.PERSONNALISEE) {
	            if (coefControle == null || coefExamen == null) {
	                throw new IllegalStateException("Les coefficients personnalisés ne sont pas définis !");
	            }
	            return (noteControle * coefControle) + (noteExamen * coefExamen);
	        }
	        return (noteControle * methodeCalcul.getCoefControle()) + (noteExamen * methodeCalcul.getCoefExamen());
	    }

	    @Override
	    public String toString() {
	        return "Module{" +
	                "idModule=" + idModule +
	                ", nom='" + nom + '\'' +
	                ", idProfResponsable=" + idProfResponsable +
	                ", idSpecialite ='" + idSpecialite  + '\'' +
	                ", methodeCalcul=" + methodeCalcul.getLabel() +
	                ", coefControle=" + coefControle +
	                ", coefExamen=" + coefExamen +
	                '}';
	    }
	
	

}