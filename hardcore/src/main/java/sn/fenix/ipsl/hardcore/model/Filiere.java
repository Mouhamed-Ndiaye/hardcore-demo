package sn.fenix.ipsl.hardcore.model;

public enum Filiere {
    GIT("Génie Informatique"),
    GC("Génie Civil"),
    GEM("Génie Électromécanique"),
    CPI("Classe préparatoire intégrée");

    private String libelle;

    Filiere(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    // Filiere genieInformatique = Filiere.GENIE_INFORMATIQUE;
    //String libelleGenieInformatique = genieInformatique.getLibelle(); // Cela donnerait "Génie Informatique"

}
