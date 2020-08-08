package com.mvc.app.controller;

import com.mvc.app.model.ConvidadoModel;
import com.mvc.app.repository.ConvidadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class convidadosController {

    @Autowired
    private ConvidadoRepository convidados;

    @GetMapping("/convidados")
    public ModelAndView index(){
        final ModelAndView modelAndView = new ModelAndView("ListarConvidados");
        final Long total = convidados.findBySum();

        modelAndView.addObject("convidados", convidados.findAll());
        modelAndView.addObject("total", total);
        modelAndView.addObject("convidado", new ConvidadoModel());
        return modelAndView;
    }  
    
    @PostMapping("/convidado")
    public String  save(@Validated ConvidadoModel convidado, BindingResult result) {
        
        if (result.hasErrors()) {
            return "redirect:/convidados";
        }

        convidados.save(convidado);
        return "redirect:/convidados";
    }

    @GetMapping("/convidado/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") final Long id) {
        final ModelAndView modelAndView = new ModelAndView("ListarConvidados");
        final ConvidadoModel convidao = convidados.findById(id).get();
        modelAndView.addObject("convidado", convidao);
        
        return modelAndView;
    }

    @GetMapping("/convidado/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id) {
        convidados.deleteById(id);
        return "redirect:/convidados";       
    }
}