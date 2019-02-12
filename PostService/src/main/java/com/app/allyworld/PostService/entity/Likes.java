package com.app.allyworld.PostService.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Likes {

	private Integer likes;
	private List<Integer> likesProfileId;

	public Likes() {
		super();
	}

	public Likes(Integer likes, List<Integer> likesProfileId) {
		super();
		this.likes = likes;
		this.likesProfileId = likesProfileId;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Integer> getLikesProfileId() {
		return likesProfileId;
	}

	public void setLikesProfileId(List<Integer> likesProfileId) {
		this.likesProfileId = likesProfileId;
	}

	@Override
	public String toString() {
		return "Likes [likes=" + likes + ", likesProfileId=" + likesProfileId + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}