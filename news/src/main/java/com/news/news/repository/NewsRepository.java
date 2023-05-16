package com.news.news.repository;

import com.news.news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Exequiel Hordt
 * @version 18 Feb 2023
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("Select n FROM news n WHERE n.id = :id")
    public News byId(@Param("id") Long id);
    
}
