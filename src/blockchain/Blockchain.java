package blockchain;




public class Blockchain {
    private Block firstBlock;
    private Block currentBlock;

    public Block getCurrentBlock() {
        return this.currentBlock;
    }

    public Block generateBlock(String data) {
        Block newBlock = new Block(currentBlock.getHash(), data);
        newBlock.setPrevBlock(currentBlock);
        currentBlock.setNextBlock(newBlock);
        this.currentBlock = newBlock;
        currentBlock.setID();

        return newBlock;
    }

        public Blockchain(Block genesisBlock){
            this.currentBlock = genesisBlock;
            this.firstBlock = genesisBlock;

        }






    public boolean verify(){
        Block block = this.firstBlock;
        while (block.getNextBlock() != null) {
            if (block.getNextBlock().getHashPrev() != block.getHash()){
                return false;
            }
            block = block.getNextBlock();

        }

    return true;
    }
}
