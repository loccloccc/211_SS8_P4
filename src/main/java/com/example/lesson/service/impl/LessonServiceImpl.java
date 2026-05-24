package com.example.lesson.service.impl;

import com.example.lesson.entity.LessonVideo;
import com.example.lesson.exception.AccessDeniedException;
import com.example.lesson.exception.ResourceNotFoundException;
import com.example.lesson.repository.ILessonVideoRepository;
import com.example.lesson.service.ILessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements ILessonService {

    private final ILessonVideoRepository lessonVideoRepository;

    @Override
    public String watchLesson(
            Long lessonId,
            String username
    ) {

        LessonVideo lessonVideo = lessonVideoRepository
                .findById(lessonId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Lesson video not found"
                        )
                );

        if (!lessonVideo.getIsFree()) {

            boolean purchased = false;

            if (!purchased) {
                throw new AccessDeniedException(
                        "You have not purchased this course yet."
                );
            }
        }

        return lessonVideo.getVideoUrl();
    }
}