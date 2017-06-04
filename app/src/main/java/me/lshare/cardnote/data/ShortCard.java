package me.lshare.cardnote.data;

/**
 * a Card with simple kinds of data.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class ShortCard {
  private String title;
  private String coverImageUrl;
  private String time;

  public ShortCard() {
  }

  public ShortCard(String title, String coverImageUrl, String time) {
    this.title = title;
    this.coverImageUrl = coverImageUrl;
    this.time = time;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCoverImageUrl() {
    return coverImageUrl;
  }

  public void setCoverImageUrl(String coverImageUrl) {
    this.coverImageUrl = coverImageUrl;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
