import javax.swing.JOptionPane;

public class prac {
    public int add (int a, int b){
        return a + b;
    }


    public static void main(String[] args) {
        prac p = new prac();
        try {
            String a = JOptionPane.showInputDialog("enter numb: ");
            String b = JOptionPane.showInputDialog("enter numb: ");

            int aa = Integer.parseInt(a);
            int bb = Integer.parseInt(b);

            int result = p.add(aa,bb);
            JOptionPane.showMessageDialog(null, result);
        }
        catch (NumberFormatException  e) {
            System.out.println(e.getMessage());
        }
    }
}
