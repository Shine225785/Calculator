package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ButtonGroup;


public class Calculator extends JFrame implements ActionListener{
    JPanel mainPanel,btnPanel1,btnPanel2,radioPanel,tfPanel;
    JButton copy,paste,c,mod,sqrtbtn,divide,del;
    JButton seven,eight,nine,multiply,square;
    JButton four,five,six,minus;
    JButton one,two,three,plus,reciprocal;
    JButton plusminus,zero,dot,equalto;
    JButton openBracket,closebracket,factorial,pie;
    ArrayList<JButton>arr,btnpanel2arr;
    JTextField tf;
    JRadioButton on,off;
    
    Calculator(){
        setBounds(100,100,300,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        arr = new ArrayList<>();

        btnPanel1 = new JPanel();
        btnPanel1.setLayout(new GridLayout(6,4,10,10));
        btnPanel1.setBackground(Color.BLACK);
        
        
        radioPanel=new JPanel();
        radioPanel.setLayout(new GridLayout(2,1));
        ButtonGroup btngrp=new ButtonGroup();
        on = new JRadioButton("on");    btngrp.add(on);
        off = new JRadioButton("off");  btngrp.add(off);
        radioPanel.setPreferredSize(new Dimension(70, 35)); 
        
        radioPanel.add(on);  
        radioPanel.add(off); 
        
        on.addActionListener(this);
        off.addActionListener(this);
        btnPanel1.add(radioPanel);

        c=new JButton("C");  arr.add(c);     btnPanel1.add(c);
        del=new JButton("DEL");    arr.add(del);  btnPanel1.add(del);
        divide=new JButton("/");    arr.add(divide);  btnPanel1.add(divide);
        

        openBracket=new JButton("(");   arr.add(openBracket);   btnPanel1.add(openBracket);
        closebracket=new JButton(")");   arr.add(closebracket);     btnPanel1.add(closebracket);
        factorial=new JButton("!");      arr.add(factorial);        btnPanel1.add(factorial);
        pie=new JButton("\u03C0");       arr.add(pie);          btnPanel1.add(pie);
        // pie.setBackground(Color.decode("#F1C40F"));
        
        sqrtbtn=new JButton("\u221A");       arr.add(sqrtbtn);       btnPanel1.add(sqrtbtn);
        square  = new JButton("x²");         arr.add(square);        btnPanel1.add(square);
        reciprocal  = new JButton("1/x");    arr.add(reciprocal);    btnPanel1.add(reciprocal);
        minus = new JButton("-");            arr.add(minus);         btnPanel1.add(minus);



        seven=new JButton("7");      arr.add(seven);    btnPanel1.add(seven);
        eight=new JButton("8");      arr.add(eight);         btnPanel1.add(eight);
        nine=new JButton("9");       arr.add(nine);          btnPanel1.add(nine);
        multiply=new JButton("X");      arr.add(multiply);       btnPanel1.add(multiply);
        
        
        four=new JButton("4");       arr.add(four);     btnPanel1.add(four);
        five=new JButton("5");       arr.add(five);     btnPanel1.add(five);
        six=new JButton("6");        arr.add(six);      btnPanel1.add(six);
        plus=new JButton("+");       arr.add(plus);     btnPanel1.add(plus);
        
        one=new JButton("1");        arr.add(one);      btnPanel1.add(one);
        two=new JButton("2");        arr.add(two);      btnPanel1.add(two);
        three=new JButton("3");      arr.add(three);   btnPanel1.add(three);
        mod=new JButton("%");        arr.add(mod);    btnPanel1.add(mod);

        mainPanel.add(btnPanel1);

        btnPanel2 = new JPanel();
        btnPanel2.setBorder(BorderFactory.createEmptyBorder(2,0,2,0));
        btnPanel2.setBackground(Color.BLACK);
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,2,2,2);
        gbc.weightx=1;gbc.weighty=1;
        gbc.fill = GridBagConstraints.BOTH;
        btnPanel2.setLayout(g);



        btnpanel2arr = new ArrayList<>();

        plusminus = new JButton("+/-");     btnpanel2arr.add(plusminus);  arr.add(plusminus);
        gbc.gridx = 0;  gbc.gridy = 0;  gbc.gridwidth = 1;  gbc.gridheight = 1;
        btnPanel2.add(plusminus, gbc);

        zero = new JButton("0");        btnpanel2arr.add(zero);     arr.add(zero);
        gbc.gridx = 1;  gbc.gridy = 0;  gbc.gridwidth = 1;  gbc.gridheight = 1;
        btnPanel2.add(zero, gbc);

        dot = new JButton(".");      btnpanel2arr.add(dot);      arr.add(dot);
        gbc.gridx = 2;  gbc.gridy = 0;  gbc.gridwidth = 1;  gbc.gridheight = 1;
        btnPanel2.add(dot, gbc);

        equalto = new JButton("=");     btnpanel2arr.add(equalto);  arr.add(equalto);
        gbc.gridx = 3;  gbc.gridy = 0;  gbc.gridheight = 2;
        btnPanel2.add(equalto, gbc);

        gbc.gridheight = 1;

        copy = new JButton("COPY");      btnpanel2arr.add(copy);    arr.add(copy);
        gbc.gridx = 0;  gbc.gridy = 1;  gbc.gridwidth = 2;
        btnPanel2.add(copy, gbc);


        paste = new JButton("PASTE");    btnpanel2arr.add(paste);   arr.add(paste);
        gbc.gridx = 2;  gbc.gridwidth = 1;
        btnPanel2.add(paste, gbc);

        for (JButton btn : btnpanel2arr) {
            btn.setPreferredSize(new Dimension(90,30));
        }


        tfPanel = new JPanel(new BorderLayout());
        tfPanel.setBackground(Color.black);
        tfPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        tf = new JTextField();
        tf.setFont(new Font("Arail",Font.BOLD,20));
        tf.setPreferredSize(new Dimension(0, 40)); 
        // Set preferred height (width will be expanded automatically)
        tfPanel.add(tf, BorderLayout.CENTER);

        mainPanel.add(tfPanel,BorderLayout.NORTH);
        mainPanel.add(btnPanel1,BorderLayout.CENTER);
        mainPanel.add(btnPanel2,BorderLayout.SOUTH);

       for (int i=0;i<arr.size();i++) {
            arr.get(i).addActionListener(this);
            arr.get(i).setEnabled(false);
       }

        add(mainPanel);
        setColors();
       on.setEnabled(true);

    }
    private void setColors(){
        for(int i=0;i<arr.size();i++){
            String str=arr.get(i).getActionCommand();
            if(str.equals("DEL") || str.equals("C")){
                arr.get(i).setBackground(Color.decode("#E74C3C"));
                arr.get(i).setForeground(Color.WHITE);
            }else if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") ||
                str.equals("5") || str.equals("6") || str.equals("7") || str.equals("8") || str.equals("9") ){
                arr.get(i).setBackground(Color.decode("#ECF0F1"));
            }else if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("%")
                    || str.equals("X") || (str.equals("+/-"))  || (str.equals("("))  || (str.equals(")"))
                     || (str.equals("!")) || (str.equals("\u03C0"))){
                arr.get(i).setBackground(Color.decode("#F1C40F"));
            }else if(str.equals("COPY") || str.equals("PASTE")||str.equals(".")){
                arr.get(i).setBackground(Color.PINK);
            }else if(str.equals("=")){
                arr.get(i).setBackground(Color.decode("#1245A8"));
                arr.get(i).setForeground(Color.WHITE);
                arr.get(i).setFont(new Font("Arial",Font.BOLD,20));
            }
        }
    }
    public void invertResult(){
        try{
            float res = Float.parseFloat(tf.getText());
            res = - res;
            tf.setText(String.valueOf(res));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Enter a valid number ! ","Error",JOptionPane.ERROR_MESSAGE);
            tf.setText(null);
            System.out.println("error");
        }
    }
    private boolean  isOperator(char ch){
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%'){
            return true;
        }
        return false;
    }
    private void calcFactorial(){
        int num;
         long ans = 1;
        StringBuffer sb  = new StringBuffer();
         String txt = "";
        if(tf.getText().length()!=0){
             txt = tf.getText();
        }else{
            JOptionPane.showMessageDialog(this,"First enter a value !","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int i =txt.length()-1;
        txt.trim();
        int dotidx=-1;
        for(i = txt.length()-1;i>=0;i--) {
            char ch = txt.charAt(i);
            if(ch==' ' || ch=='(' || ch==')' || isOperator(ch) ){
                break;
            }
            if (ch=='.') {
                dotidx=i;    
            }
            sb.append(txt.charAt(i));
        }
        String s = "";
        if (i!=-1) {
            s = tf.getText().substring(0,i+1);
        }
       
        System.out.println(sb.toString());
        sb.reverse();
        System.err.println(sb.toString());
        if(dotidx==-1){
             num = Integer.parseInt(sb.toString());
             System.out.println(num);
        }else{
            StringBuffer st =new StringBuffer();
            for(i = 0;i<sb.length();i++){
                if(sb.charAt(i)=='.'){
                    break;
                }
                st.append(sb.charAt(i));
                System.out.println(sb.charAt(i));
            }
            num = Integer.parseInt(st.toString());
        }
      
        for(i=1;i<=num;i++){
            ans = ans*i;
        }
        tf.setText(s+String.valueOf(ans));
    }
    private void calculateReciprocal(){
        float num;
        StringBuffer sb  = new StringBuffer();
        int i=0;
         String txt = "";
        if(tf.getText().length()!=0){
             txt = tf.getText();
        }else{
            JOptionPane.showMessageDialog(this,"First enter a value !","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(i = txt.length()-1;i>=0;i--){
            char ch = txt.charAt(i);
            if(ch==' ' || ch=='(' || ch==')'){
                break;
            }
            sb.append(txt.charAt(i));
        }
        String s = tf.getText().substring(0,i+1); 
        System.err.println(sb.toString());
        sb.reverse();
        System.err.println(sb.toString());
        num = Float.parseFloat(sb.toString());
        if(num==0){
            JOptionPane.showMessageDialog(null,"some error occued...","Error",JOptionPane.ERROR_MESSAGE);
        }
        double val = 1.0/num;
        tf.setText(s+String.valueOf(val));
    }
    private void calculateSquare(){
        float num;
        StringBuffer sb  = new StringBuffer();
        int i=0;
        String txt = "";
        if(tf.getText().length()!=0){
             txt = tf.getText();
        }else{
            JOptionPane.showMessageDialog(this,"First enter a value !","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        
        for(i = txt.length()-1;i>=0;i--){
            char ch = txt.charAt(i);
            if(ch==' ' || !Character.isDigit(ch) || ch=='(' || ch==')'){
                break;
            }
            sb.append(txt.charAt(i));
        }
        String s = tf.getText().substring(0,i+1); 
        sb.reverse();
        num = Float.parseFloat(sb.toString());
        float val =num*num;
        tf.setText(s+String.valueOf(val));
    
    }
    private void calcSquareRoot(){
         float num;
        StringBuffer sb  = new StringBuffer();
        int i=0;
        
         String txt = "";
        if(tf.getText().length()!=0){
             txt = tf.getText();
        }else{
            JOptionPane.showMessageDialog(this,"First enter a value !","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(i = txt.length()-1;i>=0;i--){
            char ch = txt.charAt(i);
            if(ch==' ' ||  ch=='(' || ch==')'){
                break;
            }
            sb.append(txt.charAt(i));
        }
        String s = tf.getText().substring(0,i+1); 
        sb.reverse();
        num = Float.parseFloat(sb.toString());
        double val =Math.sqrt(num);
        tf.setText(s+String.valueOf(val));
    }
    public void actionPerformed(ActionEvent e){
        StringBuilder text=new StringBuilder("");
        if(e.getSource()==on){
            for (int i=0;i<arr.size();i++) {
                arr.get(i).setEnabled(true);
            }
        }else if(e.getSource()==off){
            for (int i=0;i<arr.size();i++) {
                arr.get(i).setEnabled(false);
            }
            on.setEnabled(true);
        }
        
        if(e.getActionCommand().equals("C")){
            if(tf.getText().length()>=1){
                tf.setText(null);
            }
        }else if(e.getActionCommand().equals("DEL")){
            String str=tf.getText();
            if(str.length()>=1)
            tf.setText(str.substring(0,str.length()-1));
        }else if(e.getActionCommand().equals("/")) {
            text.append("/");
        }else if(e.getActionCommand().equals("(")){
            text.append("(");
        }else if(e.getActionCommand().equals(")")){
            text.append(")");
        }else if(e.getActionCommand().equals("!")){
            calcFactorial();
        }else if(e.getSource()==pie){
            text.append("3.14");
        }else if(e.getSource()==square){
            calculateSquare();
        }else if(e.getSource()==reciprocal){
            calculateReciprocal();
        }else if(e.getActionCommand().equals("-")){
            text.append("-");
        }else if(e.getActionCommand().equals("7")){
            text.append("7");
        }else if(e.getActionCommand().equals("8")){
            text.append("8");
        }else if(e.getActionCommand().equals("9")){
            text.append("9");
        }else if(e.getActionCommand().equals("X")){
            text.append("*");
        }else if(e.getActionCommand().equals("4")){
            text.append("4");
        }else if(e.getActionCommand().equals("5")){
            text.append("5");
        }else if(e.getActionCommand().equals("6")){
            text.append("6");
        }else if(e.getActionCommand().equals("+")){
            text.append("+");
        }else if(e.getActionCommand().equals("1")){
            text.append("1");
        }else if(e.getActionCommand().equals("2")){
            text.append("2");
        }else if(e.getActionCommand().equals("3")){
            text.append("3");
        }else if(e.getActionCommand().equals("%")){
            text.append("%");
        }else if(e.getActionCommand().equals("+/-")){
            invertResult();
        }else if(e.getActionCommand().equals("0")){
            text.append("0");
        }else if(e.getActionCommand().equals(".")){
            if(tf.getText().length()==0){
                return;
            }
            text.append(".");
        }else if(e.getActionCommand().equals("=")){
            if(tf.getText().length()==0){
                return;
            }
            
            part1 obj = new part1();
            float res = obj.InfixEvaluate(tf.getText());
            tf.setText(String.valueOf(res));
        }else if(e.getSource()==sqrtbtn){
            calcSquareRoot();
        }else if(e.getSource()==copy){
                tf.selectAll();
                tf.copy();
        }else if(e.getSource()==paste){
            tf.paste();
        }else if(e.getSource()==on){
            for(int i=0;i<arr.size();i++){
                arr.get(i).setEnabled(true);
            }
            tf.setEditable(true);
            on.setEnabled(false);
        }else if(e.getSource()==off){
            for(int i=0;i<arr.size();i++){
                arr.get(i).setEnabled(false);
            }
            tf.setText(null);
            tf.setEditable(false);
            on.setEnabled(true);
        }
        tf.setText(tf.getText()+text.toString());
    }
    public static void main(String args[]){
        new Calculator().setVisible(true);
    }
}


