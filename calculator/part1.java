
package calculator;

import java.util.Stack;
import javax.swing.JOptionPane;
public class part1 {
    private static Stack<Float>st=new Stack<Float>();
    private static Stack<Character>stop=new Stack<>();
    static StringBuilder temp;
    part1(){
        temp=new StringBuilder();
    }
    private static float Precedence(char ch){
        if(ch=='^') return 7;
        if(ch=='/') return 6;
        if(ch=='*') return 5;
        if(ch=='%') return 4;
        if(ch=='+') return 3;
        if(ch=='-') return 2;
        if(ch=='(') return 1;
        return -1;
    }
    private static float Evaluate(float x,char ch,float y){
        if(ch=='+') return x+y;
        if(ch=='-') return x-y;
        if(ch=='/' && y==0){
            JOptionPane.showMessageDialog(null,"Some error occured...","Error",JOptionPane.ERROR_MESSAGE);
            return Float.MAX_VALUE;
        }
        if(ch=='*') return x*y;
        if(ch=='%') return x%y;
        return -1;
    }
    private static void convertFloat(){
        if(temp.toString().length()>0){
            float val=Float.parseFloat(temp.toString());
            temp.setLength(0);
            st.push(val);
        }
    }
    private static void StartSolve(){
        float x=0,y=0;
        if(!st.isEmpty()){
            x=st.peek(); st.pop();
        }else{
            System.err.println("Some error occured...");
            return;
        }
        if(!st.isEmpty()){
            y=st.peek(); st.pop();
        }else{
            System.err.println("Some error occured...");
            return;
        }
        if (stop.isEmpty()) {
            System.err.println("Some error occured...");
            return;
        }
        char op=stop.peek(); stop.pop();
        if(x==0){
            JOptionPane.showMessageDialog(null,"divison by zero not possible...","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        float res = Evaluate(y, op, x);
        st.push(res);
    }
    public static float InfixEvaluate(String str){
        char ch = str.charAt(0);
        if(ch=='/' || ch=='%' || ch=='*' || ch==')'){
            JOptionPane.showMessageDialog(null,"First enter a value !","Warning",JOptionPane.WARNING_MESSAGE);
            return 0.0000f;
            
        }
        str="("+str+")";
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            if(Character.isDigit(ch) || ch=='.'){ // check for digits
                temp.append(ch);
            }else if(ch=='('){
                stop.push('(');
            }else if (ch==')') {
                convertFloat();
                while (stop.peek()!='(') {
                    StartSolve();
                }
                stop.pop();
            }else if(ch==' '){
                convertFloat();
            }else { // operator
                convertFloat(); 
                while (!stop.isEmpty() && (Precedence(ch))<(Precedence(stop.peek()))) { 
                    StartSolve();
                }
                stop.push(ch);
            }
        }
        if(st.isEmpty()){
            System.out.println("Some error occured...|");
            return -1;
        }
        return st.peek();
    }
    public static void main(String args[])
    {
        new part1();
        String str="2.5 + 2.5 - 1.2";
        float res = InfixEvaluate(str); 
        System.err.println(res);
    }
}