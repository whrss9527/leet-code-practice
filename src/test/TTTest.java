package test;

/**
 * @author wuhao
 * @date 2020/11/20 11:08
 */
public class TTTest {
    public static void main(String[] args) {
        String date = "2020-01-01";
        date=date.replaceAll("-", "/");
        System.out.println(date);
    }
}
