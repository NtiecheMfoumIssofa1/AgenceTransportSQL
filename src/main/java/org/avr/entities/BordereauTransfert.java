package org.avr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class BordereauTransfert implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long idBordereau;
    public Date dateEnvoie;
    @ManyToOne
    @JoinColumn(name="idTransfert")
    private Transfert transfert;
    @OneToMany(mappedBy="bordereauTransfert")
    private Collection<Colis> colis;
	@ManyToOne
    @JoinColumn(name="idType")
    private TypeBordereau typeBordereau;
	public BordereauTransfert() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public BordereauTransfert(Date dateEnvoie) {
			super();
			this.dateEnvoie = dateEnvoie;
		}
	public Long getIdBordereau() {
		return idBordereau;
	}
	public void setIdBordereau(Long idBordereau) {
		this.idBordereau = idBordereau;
	}
	public Date getDateEnvoie() {
		return dateEnvoie;
	}
	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}
	public Transfert getTransfert() {
		return transfert;
	}
	public void setTransfert(Transfert transfert) {
		this.transfert = transfert;
	}
	public Collection<Colis> getColis() {
		return colis;
	}
	public void setColis(Collection<Colis> colis) {
		this.colis = colis;
	}
	public TypeBordereau getTypeBordereau() {
		return typeBordereau;
	}
	public void setTypeBordereau(TypeBordereau typeBordereau) {
		this.typeBordereau = typeBordereau;
	}
}
