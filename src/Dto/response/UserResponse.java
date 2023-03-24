package Dto.response;

public class UserResponse {
    private String email;
    private String phoneNumber;
    private String fullName;
    private int id;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return String.format("""
                email:    %s
                fullName:  %s
                phoneNumber: %s
                account Id: %d""", email,fullName,phoneNumber,id);
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
