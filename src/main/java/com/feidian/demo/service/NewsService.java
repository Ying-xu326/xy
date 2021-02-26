package com.feidian.demo.service;

import com.feidian.demo.enitity.News;

import java.util.List;

public interface NewsService {
    List<News> queryNews();
    List<News> queryNewsByTitle(String newsTitle);
    News queryNewsById(News news);
    News addNews(News news);
    News updateNews(News news);
    News deleteNews(News news);
}
