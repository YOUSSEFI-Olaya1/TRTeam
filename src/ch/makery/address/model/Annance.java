package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Annance {
	private IntegerProperty id;
	private StringProperty depart;
	private StringProperty arrive;
	private StringProperty numtrain;
	private StringProperty nomdutrain;
	private StringProperty Hdepart;
	private StringProperty Harrive;
	private StringProperty reason;
	private StringProperty duration;

	public Annance(int id,String depart,String arrivee,String numtrain,String nomtrain,String hdepart,String harrivee,String reason,String duration) {
		this.id=new SimpleIntegerProperty(id);
		this.depart=new SimpleStringProperty(depart);
	    this.arrive=new SimpleStringProperty(arrivee);
	    this.numtrain = new SimpleStringProperty(numtrain);
	    this.nomdutrain = new SimpleStringProperty(nomtrain);
	    this.Hdepart = new SimpleStringProperty(hdepart);
	    this.Harrive = new SimpleStringProperty(harrivee);
	    this.reason = new SimpleStringProperty(reason);
	    this.duration = new SimpleStringProperty(duration);
	}

	public IntegerProperty idProperty() {
		return this.id;

	}
	public StringProperty departProperty() {
		return this.depart;
	}

	public StringProperty arriveeProperty() {
		return this.arrive;
	}
	public StringProperty Hdepartproperty() {
		return Hdepart;
	}
	public StringProperty Harriveproperty() {
		return Harrive;
	}

	public StringProperty nomtrainproperty() {
		return nomdutrain;
	}

	public StringProperty numtrainproperty() {
		return numtrain;
	}
	public StringProperty reasonproperty() {
		return this.reason;
	}

	public StringProperty durationproperty() {
		return this.duration;
	}
}
