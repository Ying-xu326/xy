package com.feidian.demo.dao;

import com.feidian.demo.enitity.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsDao {
    List<News> queryNews();
    List<News> queryNewsByTitle(String newsTitle);
    News queryNewsById(Integer newsId);
    int insertNews(News news);
    int updateNews(News news);
    int deleteNews(News news);
}
