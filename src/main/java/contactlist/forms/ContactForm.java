package contactlist.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Backs the form used to create a contact
 */
public class ContactForm {

    @NotNull
    @NotBlank
    @Size(min=3, max=25)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min=3, max=25)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s [%s - %s]", this.getClass().getName(), this.firstName, this.lastName);
    }
}
