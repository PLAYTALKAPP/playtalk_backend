package com.playtalk.playtalkapp.domain;

@Entity
@Table(name = "assign_imgs")
public class Assign_imgs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assign_img_id", nullable = false)
  private Long assignImgId;

  @ManyToOne
  @JoinColumn(name = "assign_id", nullable = false,
      foreignKey = @ForeignKey(name = "FK_assign_imgs_assign",
          foreignKeyDefinition = "FOREIGN KEY (assign_id) REFERENCES assign (assign_id) ON DELETE CASCADE ON UPDATE CASCADE"))
  private Assign assign;

  @Column(name = "img_path", nullable = false)
  private String imgPath;

  @Column(name = "img_main", nullable = false)
  private Boolean imgMain;

  public Long getAssignImgId() {
    return assignImgId;
  }

  public void setAssignImgId(Long assignImgId) {
    this.assignImgId = assignImgId;
  }

  public Assign getAssign() {
    return assign;
  }

  public void setAssign(Assign assign) {
    this.assign = assign;
  }

  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public Boolean getImgMain() {
    return imgMain;
  }

  public void setImgMain(Boolean imgMain) {
    this.imgMain = imgMain;
  }
}
