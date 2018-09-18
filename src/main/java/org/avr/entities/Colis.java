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
public class Colis implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idColis;
	private String refColis;
	private Date dateExpedition;
	@ManyToOne
	@JoinColumn(name="idBordereau")
	private BordereauTransfert bordereauTransfert;
	@OneToMany(mappedBy="colis")
	private Collection<DetailColis> detailColis;
	public Colis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Colis(String refColis, Date dateExpedition) {
		super();
		this.refColis = refColis;
		this.dateExpedition = dateExpedition;
	}
	public Long getIdColis() {
		return idColis;
	}
	public void setIdColis(Long idColis) {
		this.idColis = idColis;
	}
	public String getRefColis() {
		return refColis;
	}
	public void setRefColis(String refColis) {
		this.refColis = refColis;
	}
	public Date getDateExpedition() {
		return dateExpedition;
	}
	public void setDateExpedition(Date dateExpedition) {
		this.dateExpedition = dateExpedition;
	}
	public BordereauTransfert getBordereauTransfert() {
		return bordereauTransfert;
	}
	public void setBordereauTransfert(BordereauTransfert bordereauTransfert) {
		this.bordereauTransfert = bordereauTransfert;
	}
	public Collection<DetailColis> getDetailColis() {
		return detailColis;
	}
	public void setDetailColis(Collection<DetailColis> detailColis) {
		this.detailColis = detailColis;
	}
   
}
