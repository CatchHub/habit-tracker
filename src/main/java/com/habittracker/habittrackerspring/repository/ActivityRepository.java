package com.habittracker.habittrackerspring.repository;

import com.habittracker.habittrackerspring.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
