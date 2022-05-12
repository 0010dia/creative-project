package persistence;

import persistence.DAO.AdminDAO;
import persistence.DAO.UserDAO;
import persistence.dto.AdminDTO;
import persistence.dto.UserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static UserDTO userDTO = new UserDTO();
    private static AdminDTO adminDTO = new AdminDTO();

    public static UserDTO setUserDTO(){
        String id, password, name, email;

        Scanner sc = new Scanner(System.in);
        userDTO.setUser_id(id=sc.next());
        userDTO.setUser_password(password = sc.next());
        userDTO.setUser_name(name = sc.next());
        userDTO.setUser_email(email = sc.next());
        return userDTO;
    }
    public static AdminDTO setAdminDTO(){
        String id, password, name;

        Scanner sc = new Scanner(System.in);
        adminDTO.setAdmin_id(id=sc.next());
        adminDTO.setAdmin_password(password = sc.next());
        adminDTO.setAdmin_name(name = sc.next());
        return adminDTO;
    }

    public static void main(String args[]) throws SQLException {
        Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/database?", "root", "1031324na");
        UserDAO userDAO = new UserDAO(conn);
        AdminDAO adminDAO = new AdminDAO(conn);
        Scanner sc = new Scanner(System.in);
        int a ;

        while(true) {
            switch (a= sc.nextInt()) {
                case 1:
                    System.out.println(userDAO.findApart_info());
                    break;
                case 2:
                    userDAO.insertUser(setUserDTO());
                    break;
                case 3:
                    String b = sc.next();
                    userDAO.deleteUser(b);
                    break;
                case 4:
                    userDAO.updateUser(setUserDTO());
                    break;
                case 5:
                    System.out.println(adminDAO.findAdmin());
                    break;
                case 6:
                    adminDAO.insertAdmin(setAdminDTO());
                    userDTO.setUser_id(adminDTO.getAdmin_id());
                    userDTO.setUser_name(adminDTO.getAdmin_name());
                    userDTO.setUser_password(adminDTO.getAdmin_password());
                    userDTO.setUser_email("  ");
                    userDAO.insertUser(userDTO);
                    break;
                case 7:
                    String c = sc.next();
                    adminDAO.deleteAdmin(c);
                    break;
                case 8:
                    adminDAO.updateAdmin(setAdminDTO());
                    break;
                default:
                    break;
            }
        }



    }
}