package pe.chalk.telegram.model.user;

import pe.chalk.telegram.model.Identified;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2016-02-02
 */
public class Contact implements Named, Identified<String> {
    private final String phoneNumber;
    private final String firstName;
    private final String lastName;
    private final String userId;

    private Contact(final String phoneNumber, final String firstName, final String lastName, final String userId){
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName(){
        return this.lastName;
    }

    public String getId(){
        return this.userId;
    }
}
