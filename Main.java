import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        BlockChain blockChain = new BlockChain();
        Scanner s = new Scanner(System.in);
        int yes = 0, no = 0;
        for(;;){
            System.out.println("Name:");
            String name = s.nextLine();
            if(name.equals("exit")){
                if(blockChain.isChainValid()){
                    for (int i = 1; i < blockChain.getBlockChain().size(); i++) {
                        if (blockChain.getBlockChain().get(i).getData().split(":")[1].equals("yes")){
                            yes ++;
                        }
                        else{
                            no ++;
                        }
                    }
                }
                else{
                    System.out.println("The chain is not valid");
                    return;
                }
                break;
            }
            System.out.println("Yes or No");
            String answer = s.nextLine();
            blockChain.addBlock(new Block(name + ":" + answer, ""));

        }
        System.out.println(yes + " " + no);
        }
}
