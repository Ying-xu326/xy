package com.feidian.demo.enitity;

import java.util.Date;

public class News {

    //新闻标题
    private String newsTitle;
    //新闻内容
    private String newsContent;
    //新闻序号
    private Integer newsId;
    //新闻类型
    private String newsType;
    //新闻创建时间
    private Date newsCreateTime;
    //新闻最后修改时间
    private Date newsLastEditTime;


    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsType(){return newsType;}

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getNewsCreateTime() {
        return newsCreateTime;
    }

    public void setNewsCreateTime(Date newsCreateTime) {
        this.newsCreateTime = newsCreateTime;
    }

    public Date getNewsLastEditTime() {
        return newsLastEditTime;
    }

    public void setNewsLastEditTime(Date newsLastEditTime) {
        this.newsLastEditTime = newsLastEditTime;
    }
}
