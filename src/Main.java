
import java.util.*;
import java.lang.*;

public class Main
{
    static Map<Integer,Object> map = new HashMap<>() ;
    static Scanner sc = new Scanner(System.in);

//    static HashMap<Integer,String> map = new HashMap<>();
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Press 1 : For Admin");
            System.out.println("Press 2 : For Students");
            System.out.println("Press 3 : To EXIT");
            int value = sc.nextInt();
            if(value == 1)
            {
                Admin.main(args);
            }
            else if(value == 2)
            {
                Student.main(args);
            }
            else if(value==3)
            {
                System.out.print("Thankyou!");
                System.exit(1);
            }
            else
            {
                System.out.println("Invalid! Please make a correct Choice.");
            }
        }
        catch(Exception e)
        {
            System.out.println("ONLY Integer value is Supported!");
            Main.main(args);
        }

    }

}
