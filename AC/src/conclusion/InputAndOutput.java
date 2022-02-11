package conclusion;
import java.util.*;


public class InputAndOutput {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

    }




}




//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String s = sc.next();
//        String s2 = sc.next();
//
//        if(s.endsWith(".java")&&s2.contains("@")&&s2.contains(".")&&s2.indexOf("@")<s2.indexOf(".")){
//            System.out.println("成功");
//        }else {
//            System.out.println("失败");
//        }
//        DateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
//        System.out.println(sd.format(new Date()));
//
//    }
//    static void test1(){
//        Calendar calendar = new GregorianCalendar();
//        System.out.println(calendar.getWeekYear());
//        System.out.println("*欢迎进入注册系统*");
//        System.out.println();
//        System.out.println("请输入用户名:");
//        System.out.println("请输入密码:");
//    }


//class Test {
//    String[] s = new String[10];
//
//    public static void main(String[] args) {
//        int[] arrA = {12, 22, 8, 49, 3};
//        int k = 0;
//        int len = arrA.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (arrA[i] > arrA[j]) {
//                    k = arrA[i];
//                    arrA[i] = arrA[j];
//                    arrA[j] = k;
//                }
//            }
//        }
//        for (int i = 0; i < arrA.length; i++) {
//            System.out.print(arrA[i]);
//            if (i < arrA.length - 1) {
//                System.out.print("，");
//            }
//        }
//    }
//
//}
/**
 * class Test {
 * public void changeString(StringBuffer sb) {
 * sb.append("stringbuffer2");
 * }
 * <p>
 * public static void main(String[] args) {
 * <p>
 * Random rand = new Random();
 * System.out.println(rand .nextInt(10));
 * }
 * }
 * class TestStringBuffer { public static void main(String args[]) { StringBuffer a = new StringBuffer("A"); StringBuffer b = new StringBuffer("B"); mb_operate(a, b); System.out.println(a + "." + b); } static void mb_operate(StringBuffer x, StringBuffer y) { x.append(y); y = x; } }
 * class Student {
 * String stuId;
 * static Student[] students = new Student[10];
 * static HashMap<Integer, Integer> map = new HashMap<>();
 * <p>
 * <p>
 * public static void main(String[] args) {
 * String s = "my name is kitty";
 * System.out.println(s.substring(11));
 * }
 * <p>
 * <p>
 * static void add(Student s) {
 * s.stuId = "sss";
 * }
 * <p>
 * }
 * class Test2 { public static void main(String args[]) { String s1 = new String("bj"); String s2 = new String("bj"); if (s1 == s2) System.out.println("s1 == s2"); if (s1.equals(s2)) System.out.println("s1.equals(s2)"); } }
 * <p>
 * class Example {
 * String str = new String("good");
 * char[] ch = {'a', 'b', 'c'};
 * static Example[] examples = new Example[10];
 * <p>
 * public static void main(String args[]) {
 * System.out.println(examples[0]);
 * Example ex = new Example();
 * ex.change(ex.str, ex.ch);
 * System.out.print(ex.str + "and");
 * System.out.print(ex.ch);
 * }
 * <p>
 * public void change(String str, char ch[]) {
 * str = "test ok";
 * ch[0] = 'g';
 * }}
 */

