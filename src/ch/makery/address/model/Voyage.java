package ch.makery.address.model;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Voyage {
	private StringProperty depart;
	private StringProperty arrive;
	private StringProperty numtrain;
	private StringProperty Hdepart;
	private StringProperty Harrive;
	private IntegerProperty nbrplace;
	private FloatProperty prix;
	private StringProperty nomdutrain;
	private ObjectProperty<LocalDate> datedepart;
	private IntegerProperty id;

	public Voyage(int id,String depart,String arrive,String numtrain,String Hdepart,String Harrive,int nbrplace,float prix,String nomdutrain,LocalDate datedepart) {
		this.depart=new SimpleStringProperty(depart);
		this.arrive=new SimpleStringProperty(arrive);
		this.numtrain=new SimpleStringProperty(numtrain);
		this.Harrive=new SimpleStringProperty(Harrive);
		this.Hdepart=new SimpleStringProperty(Hdepart);
		this.nbrplace=new SimpleIntegerProperty(nbrplace);
		this.prix=new SimpleFloatProperty(prix);
		this.nomdutrain=new SimpleStringProperty(nomdutrain);
		this.datedepart=new SimpleObjectProperty<LocalDate>(datedepart);
		this.id=new SimpleIntegerProperty(id);
	}
	public Voyage(String depart,String arrive,String numtrain,String Hdepart,String Harrive,int nbrplace,float prix,String nomdutrain) {
		this.depart=new SimpleStringProperty(depart);
		this.arrive=new SimpleStringProperty(arrive);
		this.numtrain=new SimpleStringProperty(numtrain);
		this.Harrive=new SimpleStringProperty(Harrive);
		this.Hdepart=new SimpleStringProperty(Hdepart);
		this.nbrplace=new SimpleIntegerProperty(nbrplace);
		this.prix=new SimpleFloatProperty(prix);
		this.nomdutrain=new SimpleStringProperty(nomdutrain);
	}
	public Voyage(int id,String depart,String arrive,String numtrain,String Hdepart,String Harrive,int nbrplace,float prix,String nomdutrain) {
		this.depart=new SimpleStringProperty(depart);
		this.arrive=new SimpleStringProperty(arrive);
		this.numtrain=new SimpleStringProperty(numtrain);
		this.Harrive=new SimpleStringProperty(Harrive);
		this.Hdepart=new SimpleStringProperty(Hdepart);
		this.nbrplace=new SimpleIntegerProperty(nbrplace);
		this.prix=new SimpleFloatProperty(prix);
		this.nomdutrain=new SimpleStringProperty(nomdutrain);
		this.id=new SimpleIntegerProperty(id);
	}

	public StringProperty departproperty() {
		return depart;
	}
	public StringProperty arriveproperty() {
		return arrive;
	}
	public StringProperty numtrainproperty() {
		return numtrain;
	}
	public StringProperty Hdepartproperty() {
		return Hdepart;
	}
	public StringProperty Harriveproperty() {
		return Harrive;
	}
	public IntegerProperty nbrplaceproperty() {
		return nbrplace;
	}
	public FloatProperty prixproperty() {
		return prix;
	}
	public StringProperty nomtrainproperty() {
		return nomdutrain;
	}
	public ObjectProperty<LocalDate> departDateProperty() {
        return datedepart;
    }
	public IntegerProperty idproperty() {
		return id;
	}




}
