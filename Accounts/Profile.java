import java.util.Random;
package Accounts;


public class Profile {
    private String name;
    private String dob;
    private String profileid;

    Profile(String name, String dob, String username) {
        this.name = name;
        this.dob = dob;
        this.profileid = username;
        createAccount();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @return the profileid
     */
    public String getProfileId() {
        return profileid;
    }
    
}