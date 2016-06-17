package cz.jlochman.comfigo.core.entityDomain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHAIR")
public class Product extends PersistenceObject {

	@Column(name = "URL")
	private String url;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DOWNLOAD_DATE")
	private Date downloadDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chair", fetch = FetchType.EAGER)
	private List<Parameter> parameters;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chair", fetch = FetchType.EAGER)
	private List<Figure> figures;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<Figure> getFigures() {
		return figures;
	}

	public void setFigures(List<Figure> figures) {
		this.figures = figures;
	}
	
}
