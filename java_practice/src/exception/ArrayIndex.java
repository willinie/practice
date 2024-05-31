package exception;

public class ArrayIndex {

    public static void main(String[] args) {
        try {
            if(args.length != 2){
                throw new ArrayIndexOutOfBoundsException("Array Index Error");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2);
            System.out.println(res);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Number Format Error");
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Error");
        }
    }
    public static double cal(int n1, int n2) {
        return (double) n1 / n2;
    }
}
