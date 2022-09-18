import java.awt.Font;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    JPanel jp = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
        Color blue = new Color(65,105,225);
        Color green = new Color(23,53,24);
        GradientPaint blueToGreen = new GradientPaint(0.0f, 0.0f, blue, 550.0f, 450.0f, green);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(blueToGreen);
        g2d.fillRect(0,0,getWidth(),getHeight());
    }
    };

    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JPasswordField jt = new JPasswordField("", 15);
    JButton jb = new JButton("Submit Vote");
    JButton jb2 = new JButton("Tally Votes");
    JButton jb3 = new JButton("Yes");
    JButton jb4 = new JButton("No");
    BlockChain blockChain = new BlockChain();
    int yes = 0;
    int no = 0;

    public GUI(){
        super("BlockChain");
        setSize(570, 490);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jp);
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jl3.setText("Pineapples belong on pizza.");
        jl3.setFont(new Font("Forte", Font.PLAIN, 40));
        jl.setText("Enter your SSN below. Don't worry, it's encrypted.");
        jl.setForeground(Color.WHITE);
        jl2.setForeground(Color.WHITE);
        jl3.setForeground(Color.WHITE);
        jl2.setText("Chain is valid Yes: " + 0 + " No: " + 0);
        jp.add(new JLabel(new ImageIcon("logo.png")));
        jt.setBackground(Color.WHITE);
        jp.add(jl3);
        jp.add(jl);
        jp.add(jt);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb2);
        jp.add(jl2);
        setVisible(true);
        jb3.addActionListener(e -> {
            String password = new String(jt.getPassword());
            String ssn = password + ":" + "yes";
            String shaSSN = Block.applySha256(ssn.split(":")[0]);
            if (ssn.split(":")[0].equals("") || password.length() != 9){
                jl2.setText("Invalid input");
                return;
            }
            for (Block b : blockChain.getBlockChain()){
                if (b.getData().split(":")[0].equals(shaSSN)){
                    jl2.setText("Thanks for voting!");
                    return;
                }
            }
            jt.setText("");
            blockChain.addBlock(new Block(ssn, ""));
            if (!ssn.split(":")[0].equals("")){
                yes ++;
                jl2.setText("Thanks for voting!");
            }
            else{
                jl2.setText("Invalid input");
            }
        });
        jb4.addActionListener(e -> {
            String password = new String(jt.getPassword());
            String ssn = password + ":" + "no";
            String shaSSN = Block.applySha256(ssn.split(":")[0]);
            if (ssn.split(":")[0].equals("") || password.length() != 9){
                jl2.setText("Invalid input");
                return;
            }
            for (Block b : blockChain.getBlockChain()){
                if (b.getData().split(":")[0].equals(shaSSN)){
                    jl2.setText("Thanks for voting!");
                    return;
                }
            }
            jt.setText("");
            blockChain.addBlock(new Block(ssn, ""));
            if (!ssn.split(":")[0].equals("")){
                jl2.setText("Thanks for voting!");
                no ++;
            }
            else{
                jl2.setText("Invalid input");
            }
        });
        jb2.addActionListener(e -> {
            if (blockChain.isChainValid()){
                jl2.setText("Chain is valid Yes: " + yes + " No: " + no);
            } else {
                jl2.setText("Chain is not valid!");
            }
        });
    }
}
