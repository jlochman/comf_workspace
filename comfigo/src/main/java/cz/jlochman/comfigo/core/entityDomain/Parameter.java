package cz.jlochman.comfigo.core.entityDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends PersistenceObject {

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHAIR_ID")
	private Chair chair;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Chair getChair() {
		return chair;
	}

	public void setChair(Chair chair) {
		this.chair = chair;
	}

}
