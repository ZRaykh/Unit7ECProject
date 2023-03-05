public class Address {
    private String house;
    private String stName;
    private String aptNum;
    private String city;
    private String state;
    private String zipCode;

    // precondition: aptN is a blank "" string if nothing is entered.
    public Address(String hauz, String st, String aptN, String c, String s, String z)
    {
        house = hauz;
        stName =st;
        aptNum = aptN;
        city = c;
        state = s;
        zipCode = z;
    }
    public Address(Address a)
    {
        house = getHouse();
        stName = a.getStName();
        aptNum = a.getAptNum();
        city = a.getCity();
        state = a.getState();
        zipCode = a.getZipCode();
    }

    //Format must be address format ie: Number Street Apt Number (optional), City, State Zip
    public Address(String address)
    {
        zipCode = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ") + 1);
        if (address.toLowerCase().contains("apt"))
        {
            stName = address.substring(0, address.toLowerCase().indexOf("apt"));
            address = address.substring(address.toLowerCase().indexOf("apt"));
            aptNum = address.substring(0, address.indexOf(","));
        }
        else
        {
            stName = address.substring(0, address.indexOf(","));
            aptNum = " ";
        }
        address = address.substring(address.indexOf(",") +  2);
        city = address.substring(0, address.indexOf(","));
        address = address.substring(address.indexOf(",") + 2);
        state = address.substring(0, address.length() - 6);
        zipCode = address.substring(address.length() - 6);
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString()
    {
        return house + " " + stName + " " + aptNum + ", " + city + ", " + state + " " + zipCode;
    }
}
