
package Business;

import java.sql.*;

/**
 *
 * @author Ciro Amaral
 */
public class Appointments {
    
    private int id;
    private int clientId;
    private int cleanerId;
    private String date;
    private String time;
    private String comments;
    private String recurring;
    private String extras;
    private String type;
    private String active;
    
    public Appointments(int id, int clientId, int cleanerId, String comments, String recurring, String extras,
            String type, String active, String date, String time){
        this.id = id;
        this.clientId = clientId;
        this.clientId = cleanerId;
        this.date = date;
        this.time = time;
        this.comments = comments;
        this.recurring = recurring;
        this.extras = extras;
        this.type = type;
        this.active = active;
    }
    
    public Appointments(){
        id = 0;
        clientId = 0;
        cleanerId = 0;
        date = "";
        time = "";
        comments = "";
        recurring = "";
        extras = "";
        type = "";
        active = "";
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRecurring() {
        return recurring;
    }

    public void setRecurring(String recurring) {
        this.recurring = recurring;
    }
    
    public void selectAppointment(int clientId){
        String sql = "Select * from appointments where client_ID = '" + clientId + "'";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cleanersDatabase", "root", "Cc102807");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                setId(rs.getInt(1));
                setClientId(rs.getInt(2));
                setCleanerId(rs.getInt(3));
                setComments(rs.getString(4));
                setRecurring(rs.getString(5));
                setExtras(rs.getString(6));
                setType(rs.getString(7));
                setActive(rs.getString(8));
                setDate(rs.getString(9));
                setTime(rs.getString(10));
            }
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
