package blockchain;

import java.util.*;
import java.time.*;




public class Block {
    private int ID;
    private String hashPrev;
    private long timeStamp;
    private String data;
    private String hash;
    private Block prevBlock = null;
    private Block nextBlock = null;

    public Block getNextBlock() {
        return this.nextBlock;
    }

    public Block getPrevBlock() {
        return this.prevBlock;
    }

    public String getHash() {
        return this.hash;
    }

    public String getData(){
        return this.data;
    }



    public int getID(){
        //getter for ID
        return this.ID;
    }

    public String getHashPrev(){
        //getter for hash of prev block
        return this.hashPrev;
    }

    public long getTimestamp(){
        return this.timeStamp;
    }

    public void setTimestamp() {
        this.timeStamp = new Date().getTime();
    }
    public void setData(String data){
        this.data = data;
    }

    public void setHashPrev(String hashPrev) {
        this.hashPrev = hashPrev;
    }


    public void setID(){
        if(this.getPrevBlock() == null){
            this.ID = 0;
        }
        else {
            this.ID = this.getPrevBlock().getID() + 1;
        }
    }

    public void setHash() {
        this.hash = StringUtil.applySha256(this.getData() + this.getHashPrev() );
    }

    public void setPrevBlock(Block block){
        this.prevBlock = block;

    }

    public void setNextBlock(Block block){
        this.nextBlock = block;
    }

    public Block(String hashPrev, String data){
        this.setHashPrev(hashPrev);
        this.setTimestamp();
        this.setData(data);
        this.setHash();


    }
}

