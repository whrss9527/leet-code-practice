package medium;

/**
 *
 */
public class _537_复数乘法 {
    public static String complexNumberMultiply(String a, String b) {
        String aa[] = a.split("\\+");
        String bb[] = b.split("\\+");
        int A = Integer.parseInt(aa[0]);
        int B = Integer.parseInt(aa[1].split("i")[0]);
        int C = Integer.parseInt(bb[0]);
        int D = Integer.parseInt(bb[1].split("i")[0]);
        return (A*C+B*D*(-1))+"+"+(A*D+B*C)+"i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i","1+1i"));

    }
}
