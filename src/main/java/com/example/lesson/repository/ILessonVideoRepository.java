package com.example.lesson.repository;

import com.example.lesson.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonVideoRepository extends JpaRepository<LessonVideo, Long> {
}