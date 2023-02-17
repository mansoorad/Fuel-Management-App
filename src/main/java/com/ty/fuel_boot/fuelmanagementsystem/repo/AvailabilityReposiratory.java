package com.ty.fuel_boot.fuelmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Availability;

public interface AvailabilityReposiratory extends JpaRepository<Availability, Integer> {

}
