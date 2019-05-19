package com.cni.autoecole.controllers;

import java.util.List;

import com.cni.autoecole.entities.Chapitre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PatchMapping ("/{idCrs}")
	public Chapitre addChapitre(@RequestBody Chapitre chapitre, @PathVariable long idCrs ) {
		//{chapitre.setCours(new Cours(id,"ee","ee"));
		return	coursService.addChapitre(chapitre,idCrs);
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




