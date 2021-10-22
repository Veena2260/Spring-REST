package org.impelsys.SpringBootDemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Likes {
	@Id
	@Column(name="like_id")
	private Integer likeId;
	
	@ManyToMany(mappedBy="likedBy")
	private List<Comment> commentList;

	
	public Integer getLikeId() {
		return likeId;
	}

	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
}
