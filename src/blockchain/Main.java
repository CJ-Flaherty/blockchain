package blockchain;

import java.util.*;
import java.time.*;

public class Main{
    public static void main(String[] args) {

        Block genesisBlock = new Block("0", "This is the first block.");
        Blockchain test = new Blockchain(genesisBlock);

        for (int i = 0; i <5 ; i++) {
            test.generateBlock("This is block number" + i);
            }


        Block block = genesisBlock;
        while(block.getNextBlock() != null){
            System.out.println("Block:");
            System.out.println("Id: " +block.getID());
            System.out.println("Timestamp: "+ block.getTimestamp());
            System.out.println("Hash of the previous block: "+ "\n"+ block.getHashPrev());
            System.out.println("Hash of the block: " + "\n" +block.getHash());
            System.out.println("\n");
            block = block.getNextBlock();
        }



    }
}



