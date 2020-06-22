package contactlist.services;

import contactlist.forms.ContactForm;
import contactlist.models.Contact;
import contactlist.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;


    public Collection<Contact> getAll() {
        return (Collection<Contact>) this.repository.findAll();
    }

    /*
    public CrudRepository<Contact, Long> getRepository() {
        return this.repository;
    }
     */

    public Contact getById(Long id) {
        System.out.println("ID : " + id);
        return this.repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        Optional<Contact> optionalContact = this.repository.findById(id);

        if(optionalContact.isPresent()) {
            this.repository.deleteById(id);
        }
    }

    public void add(ContactForm contactForm) {
        Contact contact = new Contact();
        contact.setFirstName(contactForm.getFirstName());
        contact.setLastName(contactForm.getLastName());

        this.repository.save(contact);
    }

    public void update(Contact contact, ContactForm contactForm) {
        contact.setLastName(contactForm.getLastName());
        contact.setFirstName(contactForm.getFirstName());

        this.repository.save(contact);
    }
}
