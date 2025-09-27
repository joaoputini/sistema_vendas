package br.com.aweb.sistema_vendas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_vendas.model.Cliente;
import br.com.aweb.sistema_vendas.service.ClienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("cliente/list", Map.of("clientes", clienteService.listarTodos()));
    }

    @GetMapping("/novo")
    public ModelAndView createForm() {
        return new ModelAndView("cliente/form", Map.of("cliente", new Cliente()));
    }

    @PostMapping("/novo")
    public String create(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/form";
        }
        clienteService.salvar(cliente);
        return "redirect:/clientes"; 
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        var optionalCliente = clienteService.buscarPorId(id);
        if (optionalCliente.isPresent()) {
            return new ModelAndView("cliente/form", Map.of("cliente", optionalCliente.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/form";
        }
        cliente.setId(id); 
        clienteService.salvar(cliente); 

        return "redirect:/clientes";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        var optionalCliente = clienteService.buscarPorId(id);
        if (optionalCliente.isPresent()) {
            return new ModelAndView("cliente/delete", Map.of("cliente", optionalCliente.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { 
        clienteService.excluir(id); 
        return "redirect:/clientes"; 
    }
}