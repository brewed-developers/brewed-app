package com.brewedbros.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
	@Id
	private String id;
	private String title;
	private String city;
	private String description;
	private String url;
	private String imgUrl;

	public Banner(String title, String url, String imgUrl) {
		super();
		this.title = title;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	Banner() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
