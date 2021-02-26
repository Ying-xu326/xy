package com.feidian.demo.service.impl;


import com.feidian.demo.dao.NewsDao;
import com.feidian.demo.enitity.News;
import com.feidian.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> queryNews() {
        return newsDao.queryNews();
    }

    @Override
    public List<News> queryNewsByTitle(String newsTitle) {
        List<News> list=newsDao.queryNewsByTitle(newsTitle);
        return list;
    }

    @Override
    public News queryNewsById(News news) {
        return newsDao.queryNewsById(news.getNewsId());
    }

    @Override
    public News addNews(News news) {
        news.setNewsCreateTime(new Date());
        news.setNewsLastEditTime(new Date());
        int news1=newsDao.insertNews(news);
        if(news1>0){
            return newsDao.queryNewsById(news.getNewsId());
        }else {
            throw new RuntimeException("添加新闻失败！");
        }
    }

    @Override
    public News updateNews(News news) {
        news.setNewsLastEditTime(new Date());
        int news1=newsDao.updateNews(news);
        if(news1>0){
            return newsDao.queryNewsById(news.getNewsId());
        }else {
            throw new RuntimeException("更新新闻失败！");
        }
    }

    @Override
    public News deleteNews(News news) {
        News news1=news;
        int news2=newsDao.deleteNews(news);
        if(news2>0){
            return news1;
        }else {
            throw new RuntimeException("删除新闻失败！");
        }
    }
}
