package web;
import javax.persistence.*;

/**
 * BuddyInfo has a name, phone number and address
 * @author sarahjaber
 * @version 1.0
 */

@Entity
public class BuddyInfo {

    //Id added as primary key to uniquely identify buddyInfo
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //name of BuddyInfo
    private String name;
    //address of BuddyInfo
    private String address;
    //phone number of BuddyInfo
    private String phoneNumber;
    //addressbook that the buddyInfo belongs to
    @ManyToOne
    @JoinColumn(name="address_id")
    private AddressBook addressBook;

    /**
     * Default BuddyInfo constructor
     */
    public BuddyInfo(){
    }

    public BuddyInfo(AddressBook addressBook){
        this.addressBook=addressBook;
    }

    /**
     * BuddyInfo consructor that decalres a buddy info with a name, address and phone number
     * @param name of the buddyinfo
     * @param address of the buddyinfo
     * @param phoneNumber of the buddyinfo
     */
    public BuddyInfo(String name, String address, String phoneNumber){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    /**
     * getter for the buddyInfo id
     * @return id of buddyInfo
     */
    public Long getId(){
        return id;
    }

    /**
     * setter for the buddyinfo id
     * @param id
     */
    public void setId(Long id){
        this.id=id;
    }
    /**
     * getter of the name of the buddyinfo
     * @return name of buddyinfo
     */
    public String getName(){
        return name;
    }

    /**
     * getter of the address of buddyinfo
     * @return address of buddyinfo
     */
    public String getAddress(){
        return address;
    }

    /**
     * getter of phone number of buddyinfo
     * @return phone number of buddyinfo
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * set name of BuddyInfo
     * @param name of buddyinfo
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * set address of BuddyInfo
     * @param address fo buddyInfo
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     * set phone number of buddyInfo
     * @param phoneNumber of buddyInfo
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    /**
     * String of BuddyInfo includes buddy info id, name, phone number and address
     * @return String representation of buddyinfo
     */
    public String toString(){
        return "Id "+ id+ " Name: "+ name + " Phone number: "+ phoneNumber + " Address: " + address;
    }

    /*
     * getter of the addressBook that buddyInfo belongs to
     * @return addressBook buddyInfo belongs to
     */
    public AddressBook getAddressBook(){
        return addressBook;
    }



    /* set the addressBook that buddyInfo belongs to
     * @param addressBook that the buddyInfo belongs to
     */

    public void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }


}
