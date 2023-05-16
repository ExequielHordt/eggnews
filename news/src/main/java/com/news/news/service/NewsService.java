package com.news.news.service;

import com.news.news.entity.News;
import com.news.news.repository.NewsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Exequiel Hordt
 * @version 18 Feb 2023
 */
@Service
public class NewsService {
    
    @Autowired
    private NewsRepository repository;

    //Create news
    @Transactional
    public void create(String tittle, String portrait, String body) throws Exception {
        
        try {
            
            if (tittle.trim().isEmpty() || tittle == null) {
                
                throw new Exception("Debe indicar un titulo");
                
            }
            
            if (portrait.trim().isEmpty() || portrait == null) {
                throw new Exception("Debe indicar una foto");
            }
            
            if (body.trim().isEmpty() || body == null) {
                
                throw new Exception("Debe indicar el contenido");
                
            }
            News news = new News();
            news.setTitle(tittle);
            news.setPortrait(portrait);
            news.setBody(body);
            repository.save(news);
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Find one new
    public News byId(Long id) throws Exception {
        
        try {
            
            if (id == null || id < 1) {
                
                throw new Exception("Debe indicar un id");
                
            }
            
            News news = repository.byId(id);
            
            if(news == null){
            throw new Exception("Sin resultados. Id incorrecto o noticia eliminada");
            }
            
            return news;
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Find all news
    public List<News> findAll() {
        
        try {
            
            List<News> news = new ArrayList<News>();
            news = repository.findAll();
            return news;
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Modify news
    @Transactional
    public void update(Long id, String tittle, String portrait, String body) throws Exception {
        
        try {
            
            if (id == null || id < 1) {
                
                throw new Exception("Debe indicar un id");
                
            }
            
            if (tittle.trim().isEmpty() || tittle == null) {
                
                throw new Exception("Debe indicar un titulo");
                
            }
            
            if (portrait.trim().isEmpty() || portrait == null) {
                throw new Exception("Debe indicar una portada");
            }
            
            if (body.trim().isEmpty() || body == null) {
                
                throw new Exception("Debe indicar un contenido");
                
            }
            Optional<News> answer = repository.findById(id);
            if (answer.isPresent()) {
                
                News news = answer.get();
                news.setId(id);
                news.setTitle(tittle);
                news.setPortrait(portrait);
                news.setBody(body);
                repository.save(news);
                
            }
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Deleted news
    @Transactional
    public void delete(Long id) throws Exception {
        
        try {
            
            if (id == null || id < 1) {
                
                throw new Exception("Debe indicar un id");
                
            }
            Optional<News> answer = repository.findById(id);
            if (answer.isPresent()) {          
                News news = answer.get();
                repository.delete(news);
            }
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }
    
}
