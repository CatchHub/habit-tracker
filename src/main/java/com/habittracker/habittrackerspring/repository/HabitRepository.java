package com.habittracker.habittrackerspring.repository;

import com.habittracker.habittrackerspring.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit,Integer> {

}
