

public class coinFlip
{
  public static void main(String[] args) 
  {
    
   int randomNum = (int)(Math.random()*100);
   
      
  if (randomNum > 50) 
  {
  System.out.println("Heads");    
  }

  if (randomNum < 50) 
  {
   System.out.println("Tails");
  }
  
  }
}
