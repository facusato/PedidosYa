package com.unla.PedidosYaGrupoF.services.implementation;

import java.util.ArrayList;



//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.PedidosYaGrupoF.converters.PedidoConverter;
import com.unla.PedidosYaGrupoF.entities.Pedido;
import com.unla.PedidosYaGrupoF.models.BatchModel;
import com.unla.PedidosYaGrupoF.models.ClientModel;
//import com.unla.PedidosYaGrupoF.models.EmployeeModel;
import com.unla.PedidosYaGrupoF.models.PedidoModel;
import com.unla.PedidosYaGrupoF.models.ProductModel;
//import com.unla.PedidosYaGrupoF.models.RankingProductModel;
import com.unla.PedidosYaGrupoF.models.StoreModel;
import com.unla.PedidosYaGrupoF.repositories.IPedidoRepository;
import com.unla.PedidosYaGrupoF.services.IBatchService;
import com.unla.PedidosYaGrupoF.services.IClientService;
//import com.unla.PedidosYaGrupoF.services.IEmployeeService;
import com.unla.PedidosYaGrupoF.services.IPedidoService;
import com.unla.PedidosYaGrupoF.services.IProductService;
import com.unla.PedidosYaGrupoF.services.IStoreService;


@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("clientService")
	private IClientService clientService;
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}	
	
	@Override
	public void setAttributes(PedidoModel pedidoModel) {
		pedidoModel.setProduct(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()));
		//pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		pedidoModel.setClient(clientService.findById(pedidoModel.getClient().getId()));
	//	pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
		
	}
	
	@Override
	public void setAttributeRequest(PedidoModel pedidoModel,StoreModel storeModel) {
		PedidoModel pedido =this.findByIdPedido(pedidoModel.getIdPedido());
		//StoreModel stores = storeService.findByIdStore(storeModel.getIdStore());
		pedidoModel.setClient(clientService.findById(pedido.getClient().getId()));
		//pedidoModel.setCollaborator(employeeService.findByIdStores(stores.getIdStore()));
		pedidoModel.setProduct(productService.findByIdProduct(pedido.getProduct().getIdProduct()));
		//pedidoModel.setEmployee(employeeService.findById(pedido.getEmployee().getId()));
		//pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedido.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedido.getProduct().getIdProduct()).getPrice() * pedido.getQuantity());
		pedidoModel.setQuantity(pedido.getQuantity());
		pedidoModel.setDate(pedido.getDate());
		pedidoModel.setAccept(pedido.isAccept());
	}
	
	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
		Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
	    Pedido pedido=pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}
	
	@Override
	public PedidoModel findByIdPedido(long idPedido) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(idPedido));
	}
	
	
	
	@Override
	public List<PedidoModel> getAlls() {
		List<PedidoModel> models = new ArrayList<PedidoModel>();
		for (Pedido pedido : pedidoRepository.findAll()) {
			models.add(pedidoConverter.entityToModel(pedido));
		}
		return models;
	}
	
	
	
	@Override
	public List<BatchModel> getActiveBatches(StoreModel storeModel,ProductModel productModel) {
		List<BatchModel> activeBatches = new ArrayList<BatchModel>();
			for (BatchModel b : batchService.getAlls()) {
				if (b.getProduct().getIdProduct() ==productModel.getIdProduct() && b.getStore().getIdStore() ==storeModel.getIdStore() && b.isActive()) {
					activeBatches.add(b);
				}
			}
			return activeBatches;
		}

	@Override
	public int calculateStock(StoreModel storeModel,ProductModel productModel) {
		int total = 0;
			for (BatchModel batchModel : getActiveBatches(storeModel,productModel) ){
				total += batchModel.getQuantities();
			}
			return total;
			
		}
	
	@Override
	public int calculateStockTotal(ProductModel productModel) {
		int total=0;
		for(BatchModel batchModel: batchService.getAlls()) {
			if(batchModel.getProduct().getIdProduct()==productModel.getIdProduct()) {
				total +=batchModel.getQuantities();
			}
			
		}
		return total;
	}
		
    @Override
	public boolean validarConsumo(StoreModel storeModel,ProductModel productModel,int quantity) {
		return (calculateStock(storeModel,productModel) >= quantity) ? true : false; 
		}
		
	@Override
	public void consumoStock(StoreModel storeModel,ProductModel productModel, int quantity) {
			
		 for(BatchModel b: this.getActiveBatches(storeModel, productModel)) {
				if (b.getQuantities() > quantity) {
					b.setQuantities(b.getQuantities()-quantity);
					quantity = 0;
				} else if (b.getQuantities() < quantity) { 
					quantity -= b.getQuantities();
					b.setQuantities(0);	
					b.setActive(false);
				} else if (b.getQuantities() == quantity) {
					quantity = 0;
					b.setQuantities(0);
					b.setActive(false);
				}
				BatchModel bM = batchService.findByIdBatch(b.getIdBatch());
				bM.setQuantities(b.getQuantities());
				bM.setActive(b.isActive());
				batchService.insert(bM);
			}
			
		}
/*
	
	@Override
	public List<RankingProductModel> rankingProduct(List<Pedido> pedidos){
		Map<String,Integer> ranking = new HashMap<String,Integer>();
		List<RankingProductModel> rankingProd = new ArrayList<RankingProductModel>();
		for(Pedido p: pedidos) {
			if(p.isAccept()) {
				if(!ranking.containsKey(p.getProduct().getDescription())) {
					ranking.put(p.getProduct().getDescription(), p.getQuantity());
				}
				else {
					ranking.replace(p.getProduct().getDescription(), ranking.get(p.getProduct().getDescription())+p.getQuantity());
				}
			}
		}
		for(String key : ranking.keySet()) {
			rankingProd.add(new RankingProductModel(key, ranking.get(key)));
		}
		Collections.sort(rankingProd, Collections.reverseOrder(Comparator.comparing(RankingProductModel::getQuantitySold)));
		return rankingProd;
	}	
	
	*/
	
	
	@Override
	public List<PedidoModel> getAllsP(ClientModel clientModel) {
		List<PedidoModel> models = new ArrayList<PedidoModel>();
		for (Pedido pedido : pedidoRepository.findAll()) {
			if(pedido.getClient().getDni()==clientModel.getDni() && pedido.isAccept()) {
			models.add(pedidoConverter.entityToModel(pedido));
			}
		}
		return models;
	}

	
	@Override
	public boolean remove(long idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

 }

