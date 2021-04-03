import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class Mysql {

    String t_name,c_taught;
    int dev_id;
    String s_firstname;
    String s_lastname;
    String s_branch;
    String s_gender;
    String s_fingerprint_id;
    String cs_attend_id;
    String fs_id;
    String fs_name;
    String ls_name;
    String sts_branch;
    String sts_gender;
    char attends_status;
    int s_rollno,ds_id,rs_no;
    char s_register;


    public Mysql() {}

    public Mysql(String teacher_name, String course_taught, int device_id)
    {
         t_name=teacher_name;
         c_taught=course_taught;
         dev_id=device_id;
    }

    public Mysql(String stu_firstname, String stu_lastname, int stu_rollno, String stu_branch, String stu_gender,String stu_fingerprint_id, char stu_register)
    {
         s_firstname=stu_firstname;
         s_lastname=stu_lastname;
         s_rollno=stu_rollno;
         s_branch=stu_branch;
         s_gender=stu_gender;
         s_fingerprint_id=stu_fingerprint_id;
         s_register=stu_register;
    }

    public Mysql(int d_id, String c_attend_id, String f_id, String f_name, String l_name, int r_no, String st_branch, String st_gender, char attend_status)
    {
         ds_id=d_id;
         cs_attend_id=c_attend_id;
         fs_id=f_id;
         fs_name=f_name;
         ls_name=l_name;
         rs_no=r_no;
         sts_branch=st_branch;
         sts_gender=st_gender;
         attends_status=attend_status;
    }


    static Vector<Mysql>v=new Vector<Mysql>();
    static Vector<Mysql>vt=new Vector<Mysql>();



    public static void main(String args[])
    {
        int choice;
        Scanner sc=new Scanner(System.in);
        Mysql as=new Mysql();
        do{
            System.out.printf("\n");
            System.out.printf("Welcome to the Attendance Management System\n");
            System.out.printf("--------------------------------------------\n");
            System.out.printf(" 1.Teacher Register\n 2.Student Register\n 3.Student Attendance Sign-In\n 4.Exit\n\n");
            System.out.printf("Enter your choice:");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    as.t_register();
                    System.out.printf("\n");
                    break;
                }
                case 2:
                {
                    as.s_register();
                    System.out.printf("\n");
                    break;
                }
                case 3:
                {
                    as.s_attendance();
                    System.out.printf("\n");
                    break;
                }
                case 4:
                {
                    System.out.printf("Successfully Exited!");
                    System.out.printf("\n");
                    break;
                }
                default:
                {
                    System.out.printf("Please choose a valid option!");
                    System.out.printf("\n");
                }
            }
        }while(choice!=4);
    }


    public void t_register()
    {
        System.out.printf("\n");
        System.out.printf("Welcome to the Teacher Registration Section\n");
        System.out.printf("--------------------------------------------\n");
        Scanner sc=new Scanner(System.in);
        int n;
        int l=1;
        System.out.printf("No. of teacher registration(s):");
        n=sc.nextInt();
        System.out.printf("\n");
        for(int i=0;i<n;i++) {
            System.out.printf("%d.)\n", l);
            l++;
            System.out.printf("Teacher Name:");
            String teacher_name = sc.next();
            teacher_name = teacher_name + sc.nextLine();
            System.out.printf("Course Taught:");
            String course_taught = sc.next();
            course_taught = course_taught + sc.nextLine();
            System.out.printf("Operating Device Id:");
            int device_id=sc.nextInt();
            Mysql my=new Mysql(teacher_name,course_taught,device_id);
            v.add(my);
            System.out.printf("-----------------------------------------------\n");
        }
            boolean answer=Myquery.teacher_query();
            if(answer)
            {
                System.out.printf("Successfully Registered!");
            }
            else
            {
                 System.out.printf("Registration Failed!");
            }
    }


    private void s_register() {

        System.out.printf("\n");
        System.out.printf("Welcome to the Student Registration Section\n");
        System.out.printf("--------------------------------------------\n");
        Scanner sc=new Scanner(System.in);
        int n;
        int l=1;
        System.out.printf("No. of student registration(s):");
        n=sc.nextInt();
        System.out.printf("\n");
        for(int j=0;j<n;j++)
        {
            System.out.printf("%d.)\n", l);
            l++;
            System.out.printf("First Name:");
            String stu_firstname=sc.next();
            stu_firstname=stu_firstname + sc.nextLine();
            System.out.printf("Last Name:");
            String stu_lastname=sc.next();
            stu_lastname=stu_lastname+sc.nextLine();
            System.out.printf("Roll No.:");
            int stu_rollno=sc.nextInt();
            String roll=String.valueOf(stu_rollno);
            System.out.printf("Branch:");
            String stu_branch=sc.next();
            stu_branch=stu_branch + sc.nextLine();
            System.out.printf("Gender(M/F):");
            String stu_gender=sc.next();
            stu_gender=stu_gender + sc.nextLine();
            String p=stu_firstname.substring(0,3);
            String q=roll.substring(roll.length()-3);
            String stu_fingerprint_id=p+q;
            char stu_register='R';
            Mysql sq=new Mysql(stu_firstname,stu_lastname,stu_rollno,stu_branch,stu_gender,
                  stu_fingerprint_id,stu_register);
            vt.add(sq);
            System.out.printf("-----------------------------------------------\n");
        }
           boolean answer=Myquery.student_query();
        if(answer)
        {
            System.out.printf("Successfully Registered!");
        }
        else
        {
            System.out.printf("Registration Failed!");
        }
    }

    private void s_attendance()
    {
        System.out.printf("\n");
        System.out.printf("Welcome to the Student Attendance Sign-In\n");
        System.out.printf("--------------------------------------------\n");
        Scanner sc=new Scanner(System.in);
        int n;
        int l=1;
        System.out.printf("No. of Student sign-in(s) for attendance:");
        n=sc.nextInt();
        System.out.printf("\n");
        for(int k=0;k<n;k++)
        {
            System.out.printf("%d.)\n", l);
            l++;
            System.out.printf("Course to attend:");
            String course=sc.next();
            course=course + sc.nextLine();
            System.out.printf("Teacher in-charge:");
            String teacher=sc.next();
            teacher=teacher+sc.nextLine();
            int d_id = 0,id,r_no = 0;
            String s_course,c_id,c_attend_id = "",f_id = "",f_name = "",l_name = "",st_branch = "",st_gender = "";
            char attend_status = 0;
            try{
                Connection con = Connect_create.create();
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=stmt.executeQuery("select * from teacher");
                int flag=0;
                while(rs.next())
                {
                      if(rs.getString("teacher_name").equalsIgnoreCase(teacher) && rs.getString("course_taught").equalsIgnoreCase(course))
                      {
                                 d_id=rs.getInt("device_id");
                                 s_course=rs.getString("course_taught");
                                 id=s_course.length()+7;
                                 c_id=String.valueOf(id);
                                 c_attend_id=s_course+c_id;
                                 flag=1;
                      }
                }
                    if(flag==1)
                    {
                         System.out.printf("Your fingerprint id:");
                         String finger_id=sc.next();
                         finger_id=finger_id+sc.nextLine();
                         int flag1=0;
                         ResultSet rt= stmt.executeQuery("select * from student_register");
                         while(rt.next())
                         {
                             if(rt.getString("fingerprint_id").equals(finger_id))
                             {
                                        f_id=rt.getString("fingerprint_id");
                                        f_name=rt.getString("first_name");
                                        l_name=rt.getString("last_name");
                                        r_no=rt.getInt("roll_no");
                                        st_branch=rt.getString("branch");
                                        st_gender=rt.getString("gender");
                                        attend_status='P';
                                        flag1=1;
                             }
                         }
                          if(flag1==1)
                          {
                              Mysql ms=new Mysql(d_id,c_attend_id,f_id,f_name,l_name,r_no,st_branch,st_gender,attend_status);
                              boolean answer=Myquery.attendance_query(ms);
                              if(answer)
                              {
                                  System.out.printf("Sign-In successful!Attendance marked!\n");
                              }
                              else
                              {
                                  System.out.printf("Oops!Sign-In failed!\n");
                              }

                          }
                          else
                          {
                              System.out.printf("Oops!fingerprint not matched!Sign-In failed!\n");

                          }
                        System.out.printf("-----------------------------------------------\n");
                    }
                    else
                    {
                        System.out.printf("Oops!course and teacher credentials do not match!Sign-In later!\n");
                        System.out.printf("---------------------------------------------------------------\n");
                    }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }

}
