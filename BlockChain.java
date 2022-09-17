import java.util.ArrayList;

public class BlockChain {

    private ArrayList<Block> blockchain;
    public BlockChain(){
        blockchain = new ArrayList<Block>();
        blockchain.add(new Block("0:0", "0"));
    }

    public void addBlock(Block newBlock){
        newBlock.previousHash = blockchain.get(blockchain.size()-1).hash;
        newBlock.hash = newBlock.calculateHash();
        blockchain.add(newBlock);
    }

    public boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i = 1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < blockchain.size(); i++){
            output += blockchain.get(i).hash + " ";
        }
        return output;
    }

    public ArrayList<Block> getBlockChain(){
        return blockchain;
    }
}
