package ua.com.persistence;

public class Persons {
  private Long personid;
  private String lastname;
  private String firstname;
  private String address;
  private String city;

  public Long getPersonid() {
    return personid;
  }

  public void setPersonid(Long personid) {
    this.personid = personid;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
