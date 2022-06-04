package net.codejava;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
    private ProductService service;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
	    service.save(product);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = service.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return "redirect:/";
	    
	}
	
	@RequestMapping(value = "/brand/{Bran}", method=RequestMethod.GET)
	@ResponseBody
	public Product findBrand( @PathVariable(name ="Bran")String Bra) {
		Product p=new Product();
		 List<Product> listProducts = service.listAll();
		 for(int i=0;i<listProducts.size();i++) {
			 if(listProducts.get(i).getBrand().equals(Bra)) {
				 p=listProducts.get(i);
			 }
		 }
		 
	    return p;      
	}
	@RequestMapping(value ="/pricefind/{price}",method=RequestMethod.GET)
	public String viewHomePage2(Model model,@PathVariable(name ="price")float price) {
		
	    List<Product> listProducts = service.findByPriceGreaterThan(price);
	    model.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}
	
	@GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
	
}
