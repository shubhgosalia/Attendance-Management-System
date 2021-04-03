import java.sql.*;
public class Connect_create {

    static Connection con=null;

    public static Connection create()
     {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_manage","root","Shubh@2001");
         }
         catch(ClassNotFoundException e)
         {
             System.out.println("Exception:"+e.getMessage());
         }
         catch(SQLException e)
         {
             System.out.println("SQL Exception:"+e.getMessage());
         }
         try
         {
             Statement st=con.createStatement();
         }
         catch(SQLException e)
         {
             System.out.println("SQL Exception:"+e.getMessage());
         }

         return con;

     }
}
