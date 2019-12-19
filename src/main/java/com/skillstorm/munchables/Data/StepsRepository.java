package com.skillstorm.munchables.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.munchables.beans.Steps;

public interface StepsRepository extends JpaRepository<Steps, Integer> {

}
