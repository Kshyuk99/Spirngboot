package edu.du.shop.controller;

import edu.du.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class ShopController {

   @Autowired
   private ShopRepository shopRepository;

   @GetMapping
   public String users(Model model) {
      model.addAttribute("users", shopRepository.findAll());
      return "users/list";
   }

   @GetMapping("/new")
   public String newUserForm(Model model) {
      model.addAttribute("users", this.shopRepository.findAll());
      return "users/form";
   }

   @PostMapping("/edit/{id}")
   public String editproduct(@PathVariable Long id, Model model) {
      model.addAttribute("users", this.shopRepository.findAll());
      return "users/form";
   }

   @GetMapping("/delete/{id}")
   public String deleteproduct(@PathVariable Long id) {
      shopRepository.deleteById(id);
      return "redirect:/users";
   }

}
