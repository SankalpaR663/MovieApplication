package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ShowEntity;
import com.example.demo.service.ShowService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/shows")
public class ShowController {
	@Autowired
	ShowService service;

	@PostMapping("/addshow")
	public ResponseEntity<ShowEntity> addShow(@Valid @RequestBody ShowEntity show) {

		return new ResponseEntity<ShowEntity>(service.addShow(show), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public List<ShowEntity> getAllShow() {
		return service.getAllShow();
	}

	@GetMapping("find/{showid}")
	public ResponseEntity<ShowEntity> getShowById(@PathVariable("showid") int showid) {
		return new ResponseEntity<ShowEntity>(service.getShowById(showid), HttpStatus.OK);
	}

	@PutMapping("update/{showid}")
	public ResponseEntity<ShowEntity> updateShow(@PathVariable("showid") int showid, @Valid @RequestBody ShowEntity show) {
		return new ResponseEntity<ShowEntity>(service.updateShow(show, showid), HttpStatus.OK);
	}

	@DeleteMapping("delete/{showid}")
	public ResponseEntity<Boolean> deleteShow(@PathVariable("showid") int showid) {
		service.deleteShow(showid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
