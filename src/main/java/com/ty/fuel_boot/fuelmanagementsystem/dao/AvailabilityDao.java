package com.ty.fuel_boot.fuelmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Availability;
import com.ty.fuel_boot.fuelmanagementsystem.repo.AvailabilityReposiratory;

@Repository
public class AvailabilityDao {
	@Autowired
	AvailabilityReposiratory reposiratory;

	public Availability saveAvailability(Availability availability) {
		return reposiratory.save(availability);
	}

	public Availability updateAvailability(Availability availability) {
		return reposiratory.save(availability);
	}

	public Optional<Availability> getAvailabilityById(int id) {
		return reposiratory.findById(id);
	}

	public void deleteAvailability(Availability availability) {
		reposiratory.delete(availability);
	}
}
