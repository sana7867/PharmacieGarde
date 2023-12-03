package ma.project.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Pharmacie_gardePK implements Serializable{
    
    private Long garde;
    
    private Long pharmacie;

    
    public Pharmacie_gardePK(Long garde, Long pharmacie) {
        this.garde = garde;
        this.pharmacie = pharmacie;
    }

    public Long getGarde() {
        return garde;
    }

    public void setGarde(Long garde) {
        this.garde = garde;
    }

    public Long getpharmacie() {
        return pharmacie;
    }

    public void setpharmacie(Long pharmacie) {
        this.pharmacie = pharmacie;
    }
    
    
    
	

}
