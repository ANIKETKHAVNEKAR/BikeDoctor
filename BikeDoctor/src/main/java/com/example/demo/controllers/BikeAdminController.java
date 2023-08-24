package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BikeAdmin;
import com.example.demo.services.BikeAdminService;

@RestController
@RequestMapping("/admin/bikes")
public class BikeAdminController {

	@Autowired
	private BikeAdminService bikeService;

	@GetMapping
	public List<BikeAdmin> getAllBikes() {
		return bikeService.getAllBikes();
	}

	@GetMapping("/{id}")
	public BikeAdmin getBikeById(@PathVariable int id) {
		return bikeService.getBikeById(id);
	}

	@PostMapping
	public BikeAdmin saveBike(@RequestBody BikeAdmin bike) {
		return bikeService.saveBike(bike);
	}

	@PutMapping("/{id}")
	public BikeAdmin updateBike(@PathVariable int id, @RequestBody BikeAdmin bike) {
		if (bikeService.getBikeById(id) != null) {
			bike.setId(id);
			return bikeService.saveBike(bike);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteBike(@PathVariable int id) {
		bikeService.deleteBike(id);
	}
}
