package com.app.allyworld.website.entity;

public class Post {
	private Integer postId;
	private Integer profileId;
	private String status;
	private String url;
	private String date;
	private Likes likes;
	private Comments comments;

	
	  private static int postIdGenerator;
	  
	  static { postIdGenerator=100; } { postId = postIdGenerator++; }
	  
	 
	public Post() {
		super();
	}

	public Post( /* Integer postId, */Integer profileId, String status, String url/* , LocalDateTime date */, Likes likes,
			Comments comments) {
		super();
		this.profileId = profileId;
		this.status = status;
		this.url = url;
		/* this.date = date; */
		this.likes = likes;
		this.comments = comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", profileId=" + profileId + ", status=" + status + ", url=" + url + ", date="
				+ date + ", likes=" + likes + ", comments=" + comments + "]";
	}

}
