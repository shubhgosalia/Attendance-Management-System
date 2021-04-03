import java.sql.*;

public class Myquery extends Mysql {

    public static boolean teacher_query() {

        boolean f=false;
        try
        {
        for (int i = 0; i < v.size(); i++) {
            Connection con = Connect_create.create();
            String q = "insert into teacher(device_id,teacher_name,course_taught) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, v.elementAt(i).dev_id);
            pstmt.setString(2, v.elementAt(i).t_name);
            pstmt.setString(3, v.elementAt(i).c_taught);

            pstmt.executeUpdate();
        }
           f=true;
       }
            catch(Exception e)
            {
                e.printStackTrace();
            }
             return f;
    }

      public static boolean student_query()
      {
          boolean f=false;
          try
          {
               for(int j=0;j<vt.size();j++)
               {
                   Connection con = Connect_create.create();
                   String p="insert into student_register(fingerprint_id,first_name,last_name,roll_no,branch,gender,register_status) " +
                           "values(?,?,?,?,?,?,?)";
                   PreparedStatement pstmt = con.prepareStatement(p);
                   pstmt.setString(1, vt.elementAt(j).s_fingerprint_id);
                   pstmt.setString(2, vt.elementAt(j).s_firstname);
                   pstmt.setString(3, vt.elementAt(j).s_lastname);
                   pstmt.setInt(4, vt.elementAt(j).s_rollno);
                   pstmt.setString(5, vt.elementAt(j).s_branch);
                   pstmt.setString(6, vt.elementAt(j).s_gender);
                   pstmt.setString(7, String.valueOf(vt.elementAt(j).s_register));

                   pstmt.executeUpdate();


               }
              f=true;
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          return f;

      }

    public static boolean attendance_query(Mysql ms)
    {
         boolean f=false;
         try
         {
             Connection con = Connect_create.create();
               String r="insert into student(fingerprint_id,first_name,last_name,roll_no,branch,gender,course_attend_id,attendance_status)" +
                       "values(?,?,?,?,?,?,?,?)";
             PreparedStatement pstmt = con.prepareStatement(r);
             pstmt.setString(1,ms.fs_id);
             pstmt.setString(2,ms.fs_name);
             pstmt.setString(3,ms.ls_name);
             pstmt.setInt(4,ms.rs_no);
             pstmt.setString(5,ms.sts_branch);
             pstmt.setString(6,ms.sts_gender);
             pstmt.setString(7,ms.cs_attend_id);
             pstmt.setString(8, String.valueOf(ms.attends_status));
             pstmt.executeUpdate();

             String s="insert into marks_attendance_of(teacher_device_id,student_fingerprint_id,student_course_attend_id)" +
                     "values(?,?,?)";
             PreparedStatement pst = con.prepareStatement(s);
             pst.setInt(1,ms.ds_id);
             pst.setString(2,ms.fs_id);
             pst.setString(3,ms.cs_attend_id);
             pst.executeUpdate();

             String t="insert into attendance_information(student_fingerprint_id,student_course_attend_id,attend_date,attend_time)" +
                     "values(?,?,?,?)";
             PreparedStatement mt = con.prepareStatement(t);
             mt.setString(1,ms.fs_id);
             mt.setString(2,ms.cs_attend_id);
             mt.setDate(3, Date.valueOf(java.time.LocalDate.now()));
             mt.setTime(4, Time.valueOf(java.time.LocalTime.now()));
             mt.executeUpdate();

             f=true;

         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return f;

    }
}
