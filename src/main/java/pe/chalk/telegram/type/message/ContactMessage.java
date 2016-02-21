package pe.chalk.telegram.type.message;

import org.json.JSONObject;
import pe.chalk.telegram.type.user.Contact;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-14
 */
public class ContactMessage extends Message {
    private final Contact contact;
    private ContactMessage(final JSONObject json){
        super(json);
        this.contact = Contact.create(json.getJSONObject("contact"));
    }

    public static ContactMessage create(final JSONObject json){
        return new ContactMessage(json);
    }

    public Contact getContact(){
        return this.contact;
    }
}
