import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String[] text= new String[10];
        int c=0;
        for(int i=0;i<text.length;i++)
        {
            System.out.println("Enter some text or type XDONE to exit:");
            String temp;
            temp=input.nextLine();
            text[i]=temp;
            c++;
            if(text[i].equals("XDONE"))
                break;
        }
        for(int j=0;j<c-1;j++)
        {
            System.out.println(text[j]);
        }


    }
}
