package com.app.allyworld.PostService.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comments {

	private List<Integer> CommentProfileId;
	private String comment;
	private LocalDateTime commentTime;
	private Integer likes;

	public Comments() {
		super();
	}

	public Comments(List<Integer> commentProfileId, String comment, LocalDateTime commentTime, Integer likes) {
		super();
		CommentProfileId = commentProfileId;
		this.comment = comment;
		this.commentTime = commentTime;
		this.likes = likes;
	}

	public List<Integer> getCommentProfileId() {
		return CommentProfileId;
	}

	public void setCommentProfileId(List<Integer> commentProfileId) {
		CommentProfileId = commentProfileId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(LocalDateTime commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Comments [CommentProfileId=" + CommentProfileId + ", comment=" + comment + ", commentTime="
				+ commentTime + ", likes=" + likes + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
