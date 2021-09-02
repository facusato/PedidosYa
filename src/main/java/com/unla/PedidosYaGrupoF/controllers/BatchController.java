package com.unla.PedidosYaGrupoF.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.PedidosYaGrupoF.helpers.ViewRouteHelper;
import com.unla.PedidosYaGrupoF.models.BatchModel;
import com.unla.PedidosYaGrupoF.services.IBatchService;
import com.unla.PedidosYaGrupoF.services.IProductService;
import com.unla.PedidosYaGrupoF.services.IStoreService;


@Controller
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_INDEX);
		mV.addObject("batches", batchService.getAlls());
		return mV;
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_NEW);
		mV.addObject("batch", new BatchModel());
		mV.addObject("products", productService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("batch") BatchModel batchModel) {
		batchService.insert(batchModel);
		return new RedirectView(ViewRouteHelper.BATCH_ROOT);
	}
	
	@GetMapping("/{idBatch}")
	public ModelAndView get(@PathVariable("idBatch") long idBatch) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_UPDATE);
		mV.addObject("batch", batchService.findByIdBatch(idBatch));
		mV.addObject("products", productService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("batch") BatchModel batchModel) {
	    batchService.update(batchModel);
	    return new RedirectView(ViewRouteHelper.BATCH_ROOT);
	}
	
	@GetMapping("/store/{store_id}")
	public ModelAndView getByStoreId(@PathVariable("store_id") long storeId) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_INDEX);
		mV.addObject("batches", batchService.findByIdStore(storeId));
		return mV;
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{idBatch}")
	public RedirectView delete(@PathVariable("idBatch") long idBatch) {
	    batchService.remove(idBatch);
		return new RedirectView(ViewRouteHelper.BATCH_ROOT);
		}
}
