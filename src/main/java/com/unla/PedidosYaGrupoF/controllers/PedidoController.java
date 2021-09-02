package com.unla.PedidosYaGrupoF.controllers;

import java.time.LocalDate;




import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.PedidosYaGrupoF.helpers.ViewRouteHelper;
import com.unla.PedidosYaGrupoF.models.PedidoModel;
import com.unla.PedidosYaGrupoF.services.IBatchService;
import com.unla.PedidosYaGrupoF.services.IClientService;
import com.unla.PedidosYaGrupoF.services.IPedidoService;
import com.unla.PedidosYaGrupoF.services.IProductService;
import com.unla.PedidosYaGrupoF.services.IStoreService;



@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	
	@Autowired
	@Qualifier("clientService")
	private IClientService clientService;

	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mV.addObject("pedidos", pedidoService.getAlls());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_NEW);
		mV.addObject("pedido", new PedidoModel());
		mV.addObject("clients", clientService.getAlls());
		mV.addObject("products", productService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		pedidoService.insert(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mAV.addObject("pedido", pedidoService.findByIdPedido(id));
		mAV.addObject("clients", clientService.getAlls());
		mAV.addObject("products", productService.getAlls());
		mAV.addObject("stores", storeService.getAlls());
		
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		pedidoService.update(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		pedidoService.remove(id);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	
}