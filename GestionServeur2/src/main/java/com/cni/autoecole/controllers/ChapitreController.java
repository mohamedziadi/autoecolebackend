package com.cni.autoecole.controllers;

import java.util.List;

import com.cni.autoecole.entities.ChapitreAndCoursId;
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
	
@PostMapping
public Chapitre save(@RequestBody ChapitreAndCoursId chapitreAndCoursId) {
    Chapitre chapitre = chapitreAndCoursId.getChapitre();
    Cours cours = new Cours();
    cours.setIdCrs(chapitreAndCoursId.getIdCrs());
    chapitre.setCours(cours);
 return chapitreService.save(chapitre);

	}

@PutMapping("/{idChap}")
public Chapitre update(@RequestBody Chapitre chapitre,@PathVariable int idChap ) {
//{chapitre.setCours(new Cours(id,"ee","ee"));
return chapitreService.update(chapitre,idChap);
 }

@DeleteMapping("/delete/{idChap}")
public void delete(@PathVariable (value = "idChap") int idChap){
	 chapitreService.delete(idChap);}

@GetMapping
public List<Chapitre> findAll(){
	return  chapitreService.findAll();}


@GetMapping("/get-by-id-cours/{idCrs}")
public List<Chapitre> findAllByIdCours(@PathVariable long idCrs){
    return chapitreService.getAllByIdCours(idCrs);
}


}
