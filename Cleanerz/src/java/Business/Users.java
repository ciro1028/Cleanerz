package Business;

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Users {
    
    private int ID;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String date;
    private String username;
    private String password;
    private String type;
    
    public Users(int ID, String firstName, String lastName, String street,
            String city, String state, String phone, String email, String date,
            String username, String password, String type){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    public Users(){
        ID = 0;
        firstName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        phone = "";
        email = "";
        date = "";
        username = "";
        password = "";
        type = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void selectDB(String username){
        
        String sql = "select * from users where username = '" + username + "'";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cleanersDatabase", "root", "Cc102807");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                setID(rs.getInt(1));
                setFirstName(rs.getString(2));
                setLastName(rs.getString(3));
                setStreet(rs.getString(4));
                setCity(rs.getString(5));
                setState(rs.getString(6));
                setPhone(rs.getString(7));
                setEmail(rs.getString(8));
                setDate(rs.getString(9));
                setUsername(rs.getString(10));
                setPassword(rs.getString(11));
                setType(rs.getString(12));
            }
            conn.close();
            
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void insertDB(String firstName, String lastName, String street,
            String city, String state, String phone, String email,
            String username, String password, String type){
        
        String sql = "insert into users (id, first, last, street, city, "
                + "state, phone, email, client_since, username, password, type) values (?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/cleanersDatabase", "root", "Cc102807");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, street);
            ps.setString(5, city);
            ps.setString(6, state);
            ps.setString(7, phone);
            ps.setString(8, email);
            ps.setDate(9, date);
            ps.setString(10, username);
            ps.setString(11, password);
            ps.setString(12, type);
            
            ps.execute();
            conn.close();
            
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }  
    }
    
    public void display(){
        System.out.println("Welcome " + getFirstName() + " " + getLastName());  
    }
    
    public static void main (String[] args){
        Users user = new Users();
        user.selectDB("admin");
        user.display();
    }
}

