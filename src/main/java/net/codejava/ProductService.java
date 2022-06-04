package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll(){
		
		return repo.findAll();
	}
	
	public void save(Product producto) {
		repo.save(producto);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
public List<Product> findByPriceGreaterThan(float price){
		
		return repo.findByPriceGreaterThan(price);
	}
}
