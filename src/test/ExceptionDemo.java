package test;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            String l = "11111";
            l.substring(0,6);
        }catch (Exception e){
           e.printStackTrace();
        }

    }

    private static void hehe(){
        try {
            hh();
        }catch (Exception e){
            System.out.println("hehe()报错");
        }

    }
    private static void hh()throws IllegalAccessException{
        try {
            int [] i = null;
            System.out.println(i[1]);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("hh()报错");
        }
    }
}
