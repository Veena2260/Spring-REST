package org.impelsys.SpringBootDemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="User")
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	@XmlAttribute(name="userId")
	private Integer id;
	
	
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_mail")
	private String userMail;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="User_Message",joinColumns={
		@JoinColumn(name="user_id",referencedColumnName="user_id")},
		inverseJoinColumns= {@JoinColumn(name="comment_id",referencedColumnName="comment_id")})
		
	private List<Comment> commentList;
	

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userMail=" + userMail + "]";
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
