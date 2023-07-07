import java.util.*;

public class Admin extends Book
{
    static String username,password,con;
    Admin(int bPrice, String bName, String bAuthor, int bQuant)
    {
        super(bName, bAuthor,bPrice,bQuant);
    }

    public static void main(String[] args)
    {
        int ch;
        System.out.println();
        System.out.print("Please Enter your Username : ");
        username = sc.next();
        System.out.print("Please Enter your Password : ");
        password = sc.next();
        try
        {
            if(username.equals("admin")&&password.equals("admin@123"))
            {
                do
                {
                    System.out.println("Press 1 : To ADD New Book.");
                    System.out.println("Press 2 : To UPDATE Book Data.");
                    System.out.println("Press 3 : To DELETE existing Book.");
                    System.out.println("Press 4 : To VIEW Book Data.");
                    System.out.println("Press 5 : To VIEW Sorted Book Data.");
                    System.out.println("Press 6 : To View as Student");
                    System.out.println("Press 7 : To QUIT");
                    ch = sc.nextInt();
                    switch(ch)
                    {
                        case 1: add();break;
                        case 2: update();break;
                        case 3: delete();break;
                        case 4: view();break;
                        case 5: sortView(map);break;
                        case 6:Student.main(args);
                        case 7:
                            System.out.println("Thankyou!");
                            System.exit(1);
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
                String askValue;
                System.out.println("Incorrect details");
                System.out.print("Do you want to continue (Press-Y) else (Press-Any Key) to discontinue : ");
                askValue = sc.next();
                if(askValue.equalsIgnoreCase("y"))
                {
                    Admin.main(args);
                }
                else if(askValue.equalsIgnoreCase("n"))
                {
                    System.out.println("Thankyou!");
                }
                else
                {
                    System.out.println("Invalid option! Please Re-start the application...");
//                    Admin.main(args);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Oops wrong Entry! Please start again...");
            System.out.println();
            Admin.main(args);
        }
    }
    static void add()
    {
        System.out.println("This System contains "+map.size()+" books.");
        System.out.print("Enter the number of Books to be feed : ");
        int num = sc.nextInt();
        for(int i=0;i<num;i++)
        {

            System.out.print("Enter Book-"+(i+1)+" ID : ");
            int b1Id = sc.nextInt();
            System.out.print("Enter Book-"+(i+1)+" name : ");
            String b1Name = sc.next();
            System.out.print("Enter Book-"+(i+1)+" author : ");
            String b1Author = sc.next();
            System.out.print("Enter Book-"+(i+1)+" quantity : ");
            int b1Quant = sc.nextInt();
            System.out.print("Enter Book-"+(i+1)+" Price : ");
            int b1Price = sc.nextInt();
            System.out.println("***************************************************");
            Book book1 = new Book(b1Name,b1Author,b1Price,b1Quant);
            map.put(b1Id,book1);
        }
    }

    static void view()
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
    static void sortView(Map map1)
    {
        Map<Integer,Object> tMap = new TreeMap(map1);
        if(tMap.size()==0)
        {
            System.out.println("Fields are Empty!");
        }
        else
        {
            System.out.println("Book Data After Sorting are...");
            for(Map.Entry<Integer,Object> entry: tMap.entrySet())
            {
                System.out.println("Book-ID = "+entry.getKey());
                System.out.println(entry.getValue());
            }
        }
            System.out.println("Number of Books available : "+tMap.size());
    }
    static void delete()
    {
        if(map.size()==0)
        {
            System.out.println("Already Empty!");
        }
        else
        {
            System.out.print("Enter the Book-ID to be deleted : ");
            int key = sc.nextInt();
            if(map.containsKey(key))
            {
                map.remove(key);
                System.out.println("Now the Books available : "+map.size());
            }
            else
            {
                System.out.println("Key not present!");
            }
        }
    }
    static void update()
    {
        if(map.size()==0)
        {
            System.out.println("No data found! Please add Book first.");
        }
        else
        {
            System.out.println("You can only perform Update operations on the Price and Quantity of Book. If you want to update other informations then please Delete the BookID first then Add new Book Details Again! ");
            System.out.println("Do you want to Continue, Y/N : ");
            String ch = sc.next();
            if(ch.equalsIgnoreCase("y"))
            {
                System.out.print("Enter the BookID, whose price to be UPDATED : ");
                int key = sc.nextInt();
                if(map.containsKey(key))
                {
                    System.out.print("Enter the new Price of Book : ");
                    int nPrice = sc.nextInt();
                    System.out.print("Enter the updated Quantity of Book : ");
                    int nQuant = sc.nextInt();
                    Book book2 = (Book) map.get(key);
                    String nName = book2.getName();
                    String nAuthor = book2.getAuthor();
                    book2.setPrice(nPrice);
                    book2.setQuant(nQuant);
                    int n1Price = book2.getPrice();
                    int n1Quant = book2.getQuant();
                    new Book(nName,nAuthor,n1Price,n1Quant);
                    map.put(key,book2);
                }
                else
                {
                    System.out.println("No ID found! Please Re-Enter...");
                }
            }
            else if(ch.equalsIgnoreCase("n"))
            {
//            System.out.println("Hold on, Redirecting...");
            }
            else
            {
                System.out.println("Invalid Choice!");
            }
        }
    }
}
