package model;



import java.util.Date;

public class User {

    private int userid;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String height;
    private String weight;
    private String category;
    private String arms;
    private int rating;
    
    public void setRating(String height, String weight)
    {
    	this.rating = Integer.parseInt(weight)/Integer.parseInt(height)*2;
    }
    
    public int getRating(){
    	return rating;
    }
    
    public String getArms(){
    	return arms;
    }
    public void setArms(String arms){
    	this.arms = arms;
    }
    
    public String getCategory(){
    	return category;
    }
    public void setCategory(String category){
    	this.category = category;
    }
    
    public String getWeight(){
    	return weight;
    }
    public void setWeight(String weight){
    	this.weight = weight;
    }
    
    public String getHeight(){
    	return height;
    }
    public void setHeight(String height){
    	this.height = height;
    }
        
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
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
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", firstName=" + firstName
                + ", lastName=" + lastName + ", dob=" + dob + ", email="
                + email + ",height=" + height + ",weight=" + weight + ",category=" + category + ",arms=" + arms + "]";
    }    
}