package com.habittracker.habittrackerspring.controller;

import com.habittracker.habittrackerspring.model.Activity;
import com.habittracker.habittrackerspring.model.Habit;
import com.habittracker.habittrackerspring.repository.ActivityRepository;
import com.habittracker.habittrackerspring.repository.HabitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityRepository activityRepository;
    private final HabitRepository habitRepository;

    public ActivityController(ActivityRepository activityRepository, HabitRepository habitRepository) {
        this.activityRepository = activityRepository;
        this.habitRepository = habitRepository;
    }

    @PostMapping
    void createActivity(@RequestBody CreateActivityRequest request) {
        Habit habit = this.habitRepository.findById(request.habitId()).orElseThrow(EntityNotFoundException::new);
        Activity activity = new Activity();
        activity.setHabit(habit);
        this.activityRepository.save(activity);
    }
}
