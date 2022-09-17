import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
    JPanel jp = new JPanel();
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JTextField jt = new JTextField("", 15);
    JButton jb = new JButton("Submit Vote");
    JButton jb2 = new JButton("Tally Votes");
    JButton jb3 = new JButton("Yes");
    JButton jb4 = new JButton("No");
    BlockChain blockChain = new BlockChain();
    int yes = 0;
    int no = 0;

    public Main(){
        super("BlockChain");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(jp);
        jp.add(new JLabel(new ImageIcon("logo.png")));
        jp.add(jl);
        jp.add(jt);
        jp.add(jb);
        jp.add(jb2);
        jp.add(jl2);
        jl.setText("Enter your SSN and vote. Format: SSN:Vote");
        jb.addActionListener(e -> {
            String ssn = jt.getText();
            jt.setText("");
            blockChain.addBlock(new Block(ssn, ""));
            if(ssn.split(":")[1].equals("yes")){
                yes++;
            }else if(ssn.split(":")[1].equals("no")){
                no++;
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
    public static void main(String args[]){
        new Main();
    } 
}
