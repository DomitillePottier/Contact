package contactlist.controllers;

import contactlist.forms.ContactForm;
import contactlist.models.Contact;
import contactlist.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController implements WebMvcConfigurer {

    @Autowired
    private ContactService contactService;

    @GetMapping("/put")
    public String addContact(ContactForm contactForm){
        return "contact/form";
    }

    @PostMapping("/put")
    public String submitContact(@Valid ContactForm contactForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "contact/form";
        }
        /*
        Contact contact = new Contact();
        contact.setFirstName(contactForm.getFirstName());
        contact.setLastName(contactForm.getLastName());

         */
        this.contactService.add(contactForm);
        return "contact/form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contacts", this.contactService.getAll());
        return "contact/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value="id", defaultValue = "0") String stringID, Model model) {
        Long id = Long.parseLong(stringID);
        Contact contact = this.contactService.getById(id);

        if(contact != null) {
            System.out.println(contact);
            model.addAttribute("contact", contact); //Anciennes infos
            model.addAttribute("contactForm", new ContactForm()); //Formulaire pour modif
            return "contact/edit";
        }
        return "redirect:/contact/list";
    }

    @PostMapping("/edit")
    public String submitEdit(@Valid ContactForm contactForm, @RequestParam(value="id", defaultValue = "0") String stringID, BindingResult bindingResult) {
        Long id = Long.parseLong(stringID);
        Contact contact = this.contactService.getById(id);

        if(bindingResult.hasErrors()) {
            return "redirect:/contact/edit?id="+id;
        }

        this.contactService.update(contact, contactForm);
        return "redirect:/contact/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value="id", defaultValue = "0") String stringID) {
        Long id = Long.parseLong(stringID);
        this.contactService.deleteById(id);
        return "redirect:/contact/list";
    }

}
