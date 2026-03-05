package edu.iti;

import java.sql.*;

public class PersonDAO {
    private String url = "jdbc:derby:personDB;create=true";
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public PersonDAO() {
        try {
            con = DriverManager.getConnection(url);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, "PERSON", null);
            if (!tables.next()) {
                stmt.executeUpdate(
                        "CREATE TABLE PERSON (id INT PRIMARY KEY, fname VARCHAR(50), mname VARCHAR(50), lname VARCHAR(50), email VARCHAR(50), phone VARCHAR(20))");
            }
            refreshData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshData() throws SQLException {
        rs = stmt.executeQuery("SELECT * FROM PERSON");
    }

    private Person extractPersonFromRS() throws SQLException {
        return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6));
    }

    public Person next() throws SQLException {
        if (!rs.isLast() && rs.next()) {
            return extractPersonFromRS();
        }
        rs.last();
        return extractPersonFromRS();
    }

    public Person previous() throws SQLException {
        if (!rs.isFirst() && rs.previous()) {
            return extractPersonFromRS();
        }
        rs.first();
        return extractPersonFromRS();
    }

    public Person first() throws SQLException {
        if (rs.first()) {
            return extractPersonFromRS();
        }
        return null;
    }

    public Person last() throws SQLException {
        if (rs.last()) {
            return extractPersonFromRS();
        }
        return null;
    }

    public void insert(Person p) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO PERSON VALUES (?,?,?,?,?,?)");
        pst.setInt(1, p.getId());
        pst.setString(2, p.getFirstName());
        pst.setString(3, p.getMiddleName());
        pst.setString(4, p.getLastName());
        pst.setString(5, p.getEmail());
        pst.setString(6, p.getPhone());
        pst.executeUpdate();
        refreshData();
    }

    public void update(Person p) throws SQLException {
        PreparedStatement pst = con
                .prepareStatement("UPDATE PERSON SET fname=?, mname=?, lname=?, email=?, phone=? WHERE id=?");
        pst.setString(1, p.getFirstName());
        pst.setString(2, p.getMiddleName());
        pst.setString(3, p.getLastName());
        pst.setString(4, p.getEmail());
        pst.setString(5, p.getPhone());
        pst.setInt(6, p.getId());
        pst.executeUpdate();
        refreshData();
    }

    public void delete(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM PERSON WHERE id=" + id);
        refreshData();
    }



    public void debugPrintTable() {
    try (Connection tempCon = DriverManager.getConnection(url);
         Statement tempStmt = tempCon.createStatement();
         ResultSet tempRs = tempStmt.executeQuery("SELECT * FROM PERSON")) {

        System.out.println("\n===============================================================================");
        System.out.println("               (PERSON TABLE)                      ");
        System.out.println("===============================================================================");
        
        System.out.printf("%-5s | %-10s | %-10s | %-20s | %-15s\n", "ID", "FName", "LName", "Email", "Phone");
        System.out.println("-------------------------------------------------------------------------------");

        boolean dataExists = false;
        while (tempRs.next()) {
            dataExists = true;
            System.out.printf("%-5d | %-10s | %-10s | %-20s | %-15s\n", 
                tempRs.getInt("id"), 
                tempRs.getString("fname"), 
                tempRs.getString("lname"), 
                tempRs.getString("email"),
                tempRs.getString("phone"));
        }

        if (!dataExists) {
            System.out.println("                         Table is empty.                         ");
        }
        System.out.println("===============================================================================\n");

    } catch (SQLException e) {
        System.err.println("Error while trying to print the table: " + e.getMessage());
    }
}
}