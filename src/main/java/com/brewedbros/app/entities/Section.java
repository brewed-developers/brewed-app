package com.brewedbros.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Section {

	@Id
	private long id;
	private String title;
	private String description;
	private String image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
