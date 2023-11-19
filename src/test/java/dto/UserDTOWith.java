package dto;

public class UserDTOWith {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    //------------------------


//    public void setName(String name) {
//        this.name = name;
//    }

    public UserDTOWith withEmail(String email) { // like setter
        this.email = email;
        return this;
    }

    public UserDTOWith withPassword(String password) { // like setter
        this.password = password;
        return this;
    }
}
