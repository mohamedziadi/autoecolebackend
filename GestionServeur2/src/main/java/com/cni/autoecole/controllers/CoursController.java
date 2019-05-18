package com.cni.autoecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.services.CoursService;


@RestController
@RequestMapping("/cours")
@CrossOrigin("http://localhost:4200")

public class CoursController {
	@Autowired
	private CoursService coursService;
@PostMapping
public Cours save(@RequestBody Cours cours) {
	  coursService.save(cours);
	return cours;
		}

	@PutMapping("/{idCrs}")
	public Cours update(@RequestBody Cours cours,@PathVariable long idCrs ) {
	//{chapitre.setCours(new Cours(id,"ee","ee"));
    return	coursService.update(cours,idCrs);
	 }

	@DeleteMapping("/{idCrs}")
	public ResponseEntity<?> delete(@PathVariable (value = "idCrs") long idCrs){
	    coursService.delete(idCrs);
	    return ResponseEntity.ok().build();
	}

	@GetMapping("/list")
	public List<Cours> findAll(){
		return  coursService.findAll();}


	@GetMapping("/{id}")
	public Cours getCoursById(@PathVariable(value = "id") long idCrs) {
		return coursService.findCoursById(idCrs);

	}

			
		
	}




