package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingredient;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.IngredientRepository;
import org.lessons.java.spring_la_mia_pizzeria_crud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String index(Model model) {
        List<Ingredient> ingredients = ingredientService.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredients/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "ingredients/create-or-edit";
        }

        ingredientService.save(formIngredient);

        return "redirect:/ingredients";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model ) {
        model.addAttribute("ingredient", ingredientService.findById(id));
        model.addAttribute("edit",true);
        
        return "ingredients/create-or-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "ingredients/create-or-edit";
        }

        ingredientService.save(formIngredient);
        return "redirect:/ingredients";
    }

    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
    
        ingredientService.deleteById(id);
     
        return "redirect:/ingredients";
    }
    
}
