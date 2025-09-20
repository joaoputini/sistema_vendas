package sistema.sistema_de_venda.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import sistema.sistema_de_venda.model.Produto;
import sistema.sistema_de_venda.service.ProdutoService;


@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

   @GetMapping("/novo")
   public ModelAndView create(){
    return new ModelAndView("produto/form", Map.of("produto", new Produto()));
   }

   @PostMapping("/novo")
   public String create(@Valid Produto produto, BindingResult result){
    System.out.println("mikael viado passou aqui 2.0");
    if (result.hasErrors()) {
        return "produto/form";
    }
    produtoService.salvar(produto);
    return "redirect:/produtos";
   }
}
