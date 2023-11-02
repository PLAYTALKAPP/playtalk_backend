package com.playtalk.playtalkapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "assign_reply")
public class AssignReply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assign_reply_id", nullable = false)
  private Long assignReplyId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false,
      foreignKey = @ForeignKey(name = "FK_assign_reply_user",
          foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE"))
  private User user;

  @ManyToOne
  @JoinColumn(name = "assign_id", nullable = false,
      foreignKey = @ForeignKey(name = "FK_assign_reply_assign",
          foreignKeyDefinition = "FOREIGN KEY (assign_id) REFERENCES assign (assign_id) ON DELETE CASCADE ON UPDATE CASCADE"))
  private Assign assign;

  @Column(name = "post_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp postTime;

  public Long getAssignReplyId() {
    return assignReplyId;
  }

  public void setAssignReplyId(Long assignReplyId) {
    this.assignReplyId = assignReplyId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Assign getAssign() {
    return assign;
  }

  public void setAssign(Assign assign) {
    this.assign = assign;
  }

  public Timestamp getPostTime() {
    return postTime;
  }

  public void setPostTime(Timestamp postTime) {
    this.postTime = postTime;
  }
}
