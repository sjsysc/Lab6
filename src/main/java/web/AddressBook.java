package web;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AddressBook class contains a list of BuddyInfo objects
 * @author sarahjaber
 * @version 1.0
 */


@Entity
public class AddressBook  {

    // primary key to uniquely identify the addressbook
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    //name of the addressBook
    private String name;

    //list of buddyinfo objects
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<BuddyInfo>();

    }

    /**
     * constructor of AddressBook initializes the buddyinfo list
     */
    public AddressBook(String name, Long id) {
        this.name = name;
        teamId=id;
        buddies = new ArrayList<BuddyInfo>();
    }

    /**
     * getter for the id of addressbook
     * @return if of the addressbook
     */
    public Long getId(){
        return teamId;
    }

    /**
     * setter for the id of the addressbook
     * @param teamId of the addressbook
     */
    public void setId(Long teamId){
        this.teamId = teamId;
    }

    /**
     * add a buddyinfo to the buddyinfo list in the addressbook
     * @param newbuddy buddyinfo to be added to the buddyinfo list in addressbook
     * @return true if the buddyinfo was added successfully and false otherwise
     */
    public boolean addBuddy(BuddyInfo newbuddy){
        return buddies.add(newbuddy);
    }

    /**
     * remove a buddyinfo from the buddyinfo list in the addressbook
     * @param clearbuddy buddinfo to be removed from the buddyinfo list in the addressbook
     * @return true if the buddyinfo was successfully removed and false otherwise
     */
    public boolean removeBuddy(BuddyInfo clearbuddy){
        return buddies.remove(clearbuddy);
    }

    /**
     * remove a buddy from addressbook using its id
     * @param bID id of the buddyinfo to be removed
     */
    public void removeBuddyById(Long bID){
        for (int i =0; i<buddies.size(); i++){
            if (buddies.get(i).getId() == bID){
                buddies.get(i).setAddressBook(null);
                buddies.remove(buddies.get(i));
            }
        }
    }

    /**
     * set the collection of BuddyInfo objects in addressBook
     * @param buddies collection of buddyInfo objects
     */
    public void setBuddies(List<BuddyInfo> buddies){
        this.buddies =buddies;
    }

    /**
     * getter for the collection of buddyInfo objects in addressBook
     * @return collection of buddyInfo objects in addressBook
     */
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    /**
     * getter for the name of the addressbook
     * @return name of the addressbook
     */
    public String getName(){
        return name;
    }

    /**
     * String representation of AddressBook
     * @return String representation of AddressBook
     */
    public String toString(){
        String addressString="" + name + " " + teamId + "\n";
        /*
        for (int i=0; i< Buddy.size(); i++){
            addressString += Buddy.toArray()[i] + "\n";
        }

         */
        return addressString;
    }

    public BuddyInfo getBuddy(Long bID){
        for (int i =0; i<buddies.size(); i++){
            if (buddies.get(i).getId() == bID){
                return buddies.get(i);
            }
        }
        return null;
    }

}
