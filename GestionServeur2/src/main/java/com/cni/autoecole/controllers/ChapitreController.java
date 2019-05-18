package com.cni.autoecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.entities.repositories.ChapitreRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ChapitreService;

@RestController
@RequestMapping("/chapitre")
@CrossOrigin("htp://localhost:4200")
public class ChapitreController{
	@Autowired
	private ChapitreService chapitreService;
	
@PostMapping("/save")
public void save(@RequestBody Chapitre chapitre) {
  // chapitre.setCours(new Cours(id,"ee","ee"));
  chapitreService.save(chapitre);

	}

@PutMapping("/modif/{idChap}")
public void update(@RequestBody Chapitre chapitre,@PathVariable int idChap ) {
//{chapitre.setCours(new Cours(id,"ee","ee"));
 chapitreService.update(chapitre,idChap);
 }

@DeleteMapping("/delete/{idChap}")
public void delete(@PathVariable (value = "idChap") int idChap){
	 chapitreService.delete(idChap);}

@GetMapping
public List<Chapitre> findAll(){
	return  chapitreService.findAll();}
		

	
}
