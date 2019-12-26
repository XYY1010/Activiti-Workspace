package org.crazyit.activiti.oa.action.bean;

/**
 * @Author: xyy
 * @Date: 2019/12/25 10:32
 */
public class CommentVO {

    // 评论人
    private String userName;

    // 评论内容
    private String content;

    // 评论时间
    private String time;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
