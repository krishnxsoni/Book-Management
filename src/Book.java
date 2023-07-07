import java.util.Comparator;

public class Book extends Main
{
    int bPrice,bQuant;
     String bName,bAuthor;
    @Override
    public String toString()
    {
        return ("Book name : "+this.bName+"\n"+"Book Author : "+this.bAuthor+"\n"+"Book Quantity : "+this.bQuant+"\n"+"Book Price : "+this.bPrice+"\n");
    }
//    @Override
//    public int compare(Object bP1, Object bp2)
//    {
//        Book b1 = (Book)bP1;
//        Book b2 = (Book)bp2;
//        if(b1.bName==b2.bName)
//        {
//
//        }
//        return 0;
//    }

    public Book(String bName, String bAuthor, int bPrice, int bQuant)
    {
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bQuant = bQuant;
        this.bPrice = bPrice;
//        Collections.sort(map,new Book());
    }

    public int getQuant() {
        return bQuant;
    }
    public void setQuant(int bQuant) {
        this.bQuant = bQuant;
    }
    public int getPrice()
    {
        return this.bPrice;
    }
    public void setPrice(int bPrice)
    {
        this.bPrice = bPrice;
    }
    public String getName()
    {
        return this.bName;
    }
    public void setName(String newbName)
    {
        this.bName = newbName;
    }
    public String getAuthor()
    {
        return this.bAuthor;
    }
    public void setAuthor(String bAuthor)
    {
        this.bAuthor = bAuthor;
    }

}
