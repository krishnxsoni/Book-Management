import java.util.*;
public class Student extends Main
{
//    static HashMap<Integer,String> map = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int ch;
        String con;
        System.out.println("Welcome Student!");
        System.out.print("Please Enter your Username : ");
        String usernameSt = sc.next();
        System.out.print("Please Enter your Password : ");
        String passwordSt = sc.next();
        try
        {
            if(usernameSt.equals("student")&&passwordSt.equals("student@123"))
            {
                do
                {
                    System.out.println("Press 1 : To VIEW Books.");
                    System.out.println("Press 2 : To PURCHASE Book.");
                    System.out.println("Press 3 : To Switch User.");
                    System.out.println("Press 4 : To QUIT");
                    ch = sc.nextInt();
                    switch(ch)
                    {
                        case 1: view();break;
                        case 2: purchase();break;
                        case 3: Main.main(args);break;
                        case 4: System.exit(1);
                        default:
                            System.out.println("Invalid Choice!");
                    }
                    System.out.println("\nPRESS 'ANY KEY' to Continue OR 'N' to Terminate.");
                    con = sc.next();
                }
                while(!con.equalsIgnoreCase("n"));
            }
            else
            {
                System.out.println("Incorrect details");
                System.out.print("Do you want to continue (Press-Y) else (Press-Any Key) to discontinue : ");
                String askValue = sc.next();
                if(askValue.equalsIgnoreCase("y"))
                {
                    Admin.main(args);
                }
                else if(askValue.equalsIgnoreCase("n"))
                {
                    System.out.println("Thank-you!");
                }
                else
                {
                    System.out.println("Invalid option! Please make a correct choice.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Oops something went wrong! Please Re-Start again :(");

        }
    }
    public static void view()
    {
        if(map.size()==0)
        {
            System.out.println("Fields are Empty!");
        }
        else
        {
            System.out.println("Book Data are...");
            for(Map.Entry<Integer,Object> entry: map.entrySet())
            {
                System.out.println("Book-ID = "+entry.getKey());
                System.out.println(entry.getValue());
            }
            System.out.println("Number of Books available : "+map.size());
        }
    }
    public static void purchase()
    {
        if(map.size()==0)
        {
            System.out.println("No Data found!");
        }
        else
        {
            try
            {
                System.out.print("Enter the Book-ID : ");
                int key = sc.nextInt();
                Book book3 = (Book)map.get(key);
                if(map.containsKey(key))
                {
                    int oldQuant = book3.getQuant();
                    System.out.print("Enter the Quantity of book : ");
                    int quant = sc.nextInt();
                    int pQuant = book3.getQuant();

                    if(quant>pQuant)
                    {
                        System.out.println("Invalid Quantity!");
                    }
                    else
                    {
                        book3.setQuant(quant);
                        int pPrice = book3.getPrice();
                        String pName = book3.getName();
                        String pAuthor = book3.getAuthor();
                        int newQuant = oldQuant-quant;
                        book3 = new Book(pName,pAuthor,pPrice,newQuant);
                        map.put(key,book3);
                        System.out.println("Your total fare is : "+quant*pPrice);
                        System.out.print("Press 'Y' to purchase or 'N' to Cancel : ");
                        String ch = sc.next();
                        if(ch.equalsIgnoreCase("y"))
                        {
                            System.out.println("Thank-you for purchasing..."+"\n"+"Visit again :)");
                        }
                        else if(ch.equalsIgnoreCase("n"))
                        {
                            System.out.println("Kindly rate us...");
                        }
                        else
                        {
                            System.out.println("Invalid Choice!");
                        }
                    }
                }
                else
                {
                    System.out.println("Book-ID not found!");
                }
            }
            catch(Exception e)
            {
                System.out.println("Book not present!");
            }
        }
    }
}
