package com.unla.PedidosYaGrupoF.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.PedidosYaGrupoF.helpers.ViewRouteHelper;
import com.unla.PedidosYaGrupoF.services.IPersonService;
import com.unla.PedidosYaGrupoF.models.PersonModel;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	@Qualifier("personService")
	private IPersonService personService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);
		mAV.addObject("persons", personService.getAlls());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_NEW);
		mAV.addObject("person", new PersonModel());
		return mAV;
	}
	
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("person") PersonModel personModel) {
		personService.insertOrUpdate(personModel);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("person", personService.findById(id));
		return mAV;
	}
	

	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("person") PersonModel personModel) {
		personService.insertOrUpdate(personModel);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		personService.remove(id);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}
}
