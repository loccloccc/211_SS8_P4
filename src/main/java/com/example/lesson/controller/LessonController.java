package com.example.lesson.controller;

import com.example.lesson.service.ILessonService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lessons")
@Validated
public class LessonController {

    private final ILessonService lessonService;

    @GetMapping("/watch")
    public String watchLesson(

            @RequestHeader("X-User")
            String username,

            @RequestParam
            @Min(value = 1,
                    message = "lessonId must be greater than 0")
            Long lessonId
    ) {

        return lessonService.watchLesson(
                lessonId,
                username
        );
    }
}