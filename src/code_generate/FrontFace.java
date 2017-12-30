package code_generate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrontFace {
    private Frame frame;
    private Button code39_bt ,ean_bt;
    private TextArea remind_line;
    private Generate_code39 code_39;
    private Generate_ean Ean;
    private TextField input_line;
    private JLabel pic_label;
    private ImageIcon imageicon;

    FrontFace(){
        init();
    }
    public boolean isRightStr(String str){
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(str);
        return m.matches();
    }

    public void init(){

        frame = new Frame("CODE GENERATE");
        frame.setBounds(300,100,750,350);
        frame.setBackground(Color.GRAY);
        frame.setLayout(null);  //采用流式布局


        remind_line = new TextArea();
        remind_line.setFont(new Font("宋体",Font.BOLD,16));
        remind_line.setEditable(false);

        code39_bt = new Button("CODE39");
        ean_bt = new Button("EAN");
        input_line = new TextField();
        pic_label = new JLabel();

        //pic_label.setText("123");


        //将组件添加到 frame中
        frame.add(ean_bt);
        frame.add(code39_bt);
        frame.add(remind_line);
        frame.add(input_line);
        frame.add(pic_label);

        input_line.setBounds(15,50,300,40);
        code39_bt.setBounds(390,50,80,40);
        ean_bt.setBounds(520,50,80,40);
        remind_line.setBounds(15,100,300,200);
        pic_label.setBounds(390,100,800,200);

        input_line.setFont(new Font("宋体",Font.BOLD,20));
        //input_line.setText("please input the number");
        //加载一下窗体上的事件.
        myEvent();
        //显示窗体
        frame.setVisible(true);
    }

    private void myEvent(){

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //添加一个活动监听
        ean_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input_num = input_line.getText().trim();
                if((input_num.length() == 13 || input_num.length() == 12) && !isRightStr(input_num) ){
                    Ean = new Generate_ean(input_num);
                    try{
                        pic_label.setIcon(new ImageIcon(ImageIO.read(new File("D:\\out\\out.png"))));
                    }catch (Exception f){
                        f.printStackTrace();
                    }
                    remind_line.append("generate EAN success!\n");
                }
                else{
                    remind_line.append("invalid input number!\n");
                }

            }
        });
        code39_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input_num = input_line.getText().trim();
                if(input_num.length() == 0 || isRightStr(input_num)){
                    remind_line.append("invalid input number!\n");
                }
                else{
                    code_39 = new Generate_code39(input_num);
                    try{
                        pic_label.setIcon(new ImageIcon(ImageIO.read(new File("D:\\out\\out.png"))));
                    }catch (Exception f){
                        f.printStackTrace();
                    }

                    remind_line.append("generate CODE39 success!\n");
                }

            }
        });
    }
    public static void main(String[] args) {
        FrontFace f = new FrontFace();
    }
}
