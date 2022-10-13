/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class StudiKasus {
    
    public static String[]model = new String[10];
    
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static boolean channel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      //Untuk tes silahkan hapus garingnya
      testViewShowTodoList();
 
    }
    public static void showTodoList(){
      for (int i = 0; i<model.length;i++){
          String todo = model[i];
          int no = i+1;
          
          if(todo!=null){
              System.out.println(no+"."+todo);
          }
      }
    }
    public static void testShowTodoList(){
        showTodoList();
    }
    public static void addTodoList(String todo){
     Boolean isFull = true;
        for (String model1 : model) {
            if (model1 == null) {
                isFull = false;
                break;
            }
        }
     if (isFull){
         String[] temp = model;
       model = new String[model.length * 2];
       //System.arraycopy(temp, 0, model, 0, temp.length);
     }
     for(int i = 0; i < model.length; i ++){
      if (model[i] == null){
          model[i] = todo;
          break;
      }   
     }
    }
    public static void testAddTodoList(){
      for (int i = 1; i < 30; i++){
          addTodoList("Contoh Todo Ke : " + i);
      }  
        showTodoList();
    }
    public static boolean removeTodoList(Integer number){
    if ((number -1) >= model.length){
      return false;  
    } else if(model[number - 1] == null){
      return false;  
    } else {
      for (int i = (number - 1); i < model.length; i++){
      if(i == (model.length - 1)){
        model[i] = null;  
      }  else{
         model[i] = model[i + 1]; 
      }
    } 
     return true; 
    }  
  }
    public static void testRemoveTodoList(){
    addTodoList("satu");    
    addTodoList("Dua");    
    addTodoList("Tiga");    
    addTodoList("Empat");    
    addTodoList("Lima");
    
    Boolean result = removeTodoList(20);
    System.out.println(result);
    
    result = removeTodoList(7);
    System.out.println(result);
   
    result = removeTodoList(2);
    System.out.println(result);
    showTodoList();
    }
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput(){
      String name = input("Nama");
      System.out.println("Hi " + name);
      
      String channel = input("Channel");
      System.out.println(name + " "  + channel);      
    }
    
    public static void viewShowTodoList(){
      while (true){
        showTodoList();
      
        System.out.println("Menu : ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");
        
        String input = input("Pilih");
        if (input.equals("1")){
            viewAddTodoList();
        }else if(input.equals("2")){
            viewRemoveTodoList();
        }else if(input.equals("x")){
            break;
        }else{
            System.out.println("Pilihan tidak dimengerti");
        }
      }  
    }
    public static void testViewShowTodoList(){
    addTodoList("satu");    
    addTodoList("Dua");    
    addTodoList("Tiga");    
    addTodoList("Empat");    
    addTodoList("Lima");
    viewShowTodoList(); 
    }
 

    private static void viewAddTodoList() {
        System.out.println("MENAMBAH TOSOLIST");
        
        String todo;
        todo = input("Todo (x Jika Batal)");
        
        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }
    
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        
        viewAddTodoList();
        
        showTodoList();
    }
    
    private static void viewRemoveTodoList() {
       System.out.println("MENGHAPUS TODOLIST");
       
       String number;
        number = input("Nomor yang Dihapus (x jika batal)");
       
       if (number.equals("x")){
           //batal
    
       } else {
           boolean success = removeTodoList(Integer.valueOf(number));
           if (!success) {
               System.out.println("Gagal menghapus todolist : " + number);
           }
       }
    }
    
     private static void testviewRemoveTodoList() {
          addTodoList("satu");    
          addTodoList("Dua");    
          addTodoList("Tiga");    
          
          showTodoList () ;
          
          viewRemoveTodoList();
          
          showTodoList();
      }
    
}

    
    

