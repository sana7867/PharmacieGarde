package ma.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pharmacie_garde implements Serializable {
	
	@EmbeddedId
	 private Pharmacie_gardePK id;

    @Temporal(TemporalType.DATE)
    private Date dateDubut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    
    @ManyToOne()
    @JoinColumn(name="garde",referencedColumnName="id",insertable = false,updatable = false)
    private Garde garde;

    @ManyToOne()
    @JoinColumn(name="pharmacie",referencedColumnName="id",insertable = false,updatable = false)
    private Pharmacie pharmacie;

   
    
    public Garde getGarde() {
		return garde;
	}


	public void setGarde(Garde garde) {
		this.garde = garde;
	}


	public Pharmacie getPharmacie() {
		return pharmacie;
	}


	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}


	public Pharmacie_garde () {
        super();
    }

   
    public Pharmacie_gardePK getId() {
		return id;
	}

	public void setId(Pharmacie_gardePK id) {
		this.id = id;
	}

	public Date getDateDubut() {
        return dateDubut;
    }

    public void setDateDubut(Date dateDubut) {
        this.dateDubut = dateDubut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
