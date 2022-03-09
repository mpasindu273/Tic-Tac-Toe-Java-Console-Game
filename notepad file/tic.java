import java.util.Scanner;
import java.util.Random;

public class tic{
  static char arr[][]={{' ', '|', ' ', '|', ' '},{'-', '+', '-', '+', '-'},{' ', '|' ,' ', '|', ' '},{'-', '+', '-', '+', '-'},{' ', '|', ' ', '|', ' '}};
  static int input;
  static int count;
  
  public void printBoard()
  {
    System.out.println("\n");
    
    for(int i=0;i<5;i++)
    {
      for(int j=0;j<5;j++)
      {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
  
  public int getInput()
  {
    Scanner in=new Scanner(System.in);
    while(true)
    {
      System.out.print("Enter slot number(1 to 9): ");
      input=in.nextInt(); 
      if(input>0 && input<10)
      {  
        return input;
      }
      else
      {
        System.out.println("Invalid input!");
      }
    }   
  }
     
  public boolean addInput()
  {
    boolean status=true;
    int row=0, col=0;
    switch(input)
    {
      case 1:
      row=0;
      col=0;
      break;
      
      case 2:
      row=0;
      col=2;
      break;
      
      case 3:
      row=0;
      col=4;
      break;
      
      case 4:
      row=2;
      col=0;
      break;
      
      case 5:
      row=2;
      col=2;
      break;
      
      case 6:
      row=2;
      col=4;
      break;
      
      case 7:
      row=4;
      col=0;
      break;
      
      case 8:
      row=4;
      col=2;
      break;
      
      case 9:
      row=4;
      col=4;
      break;      
    }
    
    if(arr[row][col]!=' ')
    {       
      System.out.print("This slot is already filled!");
      status=false;      
    }
    else
    {
      arr[row][col]='X';
      count++;
      status=true;
    }
    return status;
  }
  
  public int[] generate_CPU_response()
  {
    int row=0, col=0, randnum;
    Random rand = new Random();
    
    randnum=rand.nextInt(4);
      switch (randnum) {
          case 1:
              row=0;
              break;
          case 2:
              row=2;
              break;
          case 3:
              row=4;
              break;
          default:
              break;
      }
      
      randnum=rand.nextInt(4);
      switch (randnum) {
          case 1:
              col=0;
              break;
          case 2:
              col=2;
              break;
          case 3:
              col=4;
              break;
          default:
              break;
      }   
    return new int[]{row, col};
  }
  
  public boolean check_if_response_exists(int response[])
  {
    int row=response[0];
    int col=response[1];
    
    if(arr[row][col]!=' ')
    {
      return true;
    }
    else
    {
      arr[row][col]='O';
    }
    return false;
  }
  
  public char winningCombos(char symbol)
  {
    if(arr[0][0]==symbol && arr[0][2]==symbol && arr[0][4]==symbol) return symbol;
    else if(arr[2][0]==symbol && arr[2][2]==symbol && arr[2][4]==symbol) return symbol;
    else if(arr[4][0]==symbol && arr[4][2]==symbol && arr[4][4]==symbol) return symbol;
    else if(arr[0][0]==symbol && arr[2][0]==symbol && arr[4][0]==symbol) return symbol;
    else if(arr[0][2]==symbol && arr[2][2]==symbol && arr[4][2]==symbol) return symbol;
    else if(arr[0][4]==symbol && arr[2][4]==symbol && arr[4][4]==symbol) return symbol;
    else if(arr[0][0]==symbol && arr[2][2]==symbol && arr[4][4]==symbol) return symbol;
    else if(arr[0][4]==symbol && arr[2][2]==symbol && arr[4][0]==symbol) return symbol;   
    return 'n';
  }
   
  public void checkWinner(char symbol)
  {
      if(symbol=='X') {
        printBoard();
        System.out.println("\nCongratulations!!! You have Won!!!");
        System.exit(0);
      }
          
      else if(symbol=='O'){
        printBoard();  
        System.out.println("\nSorry! CPU Won. Game over!!!");
        System.exit(0);
      }
      
      else if(count==5){
        printBoard();  
        System.out.println("\nIt's a Draw!!!");
        count=0;
        System.exit(0);
      }
  }
  
  public void gameLoop()
  {
    while(true)
    {
      this.printBoard();
      this.getInput();  
      if(addInput()==true)
      {
        checkWinner(winningCombos('X'));
        while(check_if_response_exists(generate_CPU_response())==true)
        {
        }          
        checkWinner(winningCombos('O'));
      }
    }
  }
  
  public static void main(String[] args) 
  {
      tic obj=new tic();     
      obj.gameLoop();
  }
    
}
