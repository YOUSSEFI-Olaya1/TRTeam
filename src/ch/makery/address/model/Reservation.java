package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reservation {
	private StringProperty name;
	private StringProperty cardnbr;
	private StringProperty from;
	private StringProperty to;
	private StringProperty contact;
	private StringProperty trainname;
	private StringProperty trainnbr;
	private StringProperty date;
	private FloatProperty amount;

	public Reservation(String name,String cardnbr,String from,String to,String contact,String trainname,String trainnbr,String date,float amount) {
		this.name=new SimpleStringProperty(name);
		this.cardnbr=new SimpleStringProperty(cardnbr);
		this.from = new SimpleStringProperty(from);
		this.to = new SimpleStringProperty(to);
		this.contact = new SimpleStringProperty(contact);
		this.trainname = new SimpleStringProperty(trainname);
		this.trainnbr = new SimpleStringProperty(trainnbr);
		this.date = new SimpleStringProperty(date);
		this.amount = new SimpleFloatProperty(amount);

	}

	public StringProperty departproperty() {
		return from;
	}
	public StringProperty arriveeproperty() {
		return to;
	}
	public StringProperty nameproperty() {
		return name;
	}
	public StringProperty cardnbrproperty() {
		return cardnbr;
	}
	public StringProperty contactproperty() {
		return contact;
	}
	public StringProperty trainnameproperty() {
		return trainname;
	}
	public StringProperty trainnbrproperty() {
		return trainnbr;
	}
	public StringProperty dateproperty() {
		return date;
	}
	public FloatProperty amountproperty() {
		return amount;
	}



}
