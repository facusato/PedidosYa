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
import com.unla.PedidosYaGrupoF.services.YDeliveryService;
import com.unla.PedidosYaGrupoF.models.DeliveryModel;


@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	@Qualifier("deliveryService")
	private YDeliveryService deliveryService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DELIVERY_INDEX);
		mAV.addObject("deliverys", deliveryService.getAlls());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DELIVERY_NEW);
		mAV.addObject("delivery", new DeliveryModel());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("delivery") DeliveryModel deliveryModel) {
		deliveryService.insertOrUpdate(deliveryModel);
		return new RedirectView(ViewRouteHelper.DELIVERY_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DELIVERY_UPDATE);
		mAV.addObject("delivery", deliveryService.findById(id));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("delivery") DeliveryModel deliveryModel) {
		deliveryService.insertOrUpdate(deliveryModel);
		return new RedirectView(ViewRouteHelper.DELIVERY_ROOT);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		deliveryService.remove(id);
		return new RedirectView(ViewRouteHelper.DELIVERY_ROOT);
	}
}