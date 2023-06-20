package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ListIterator;

public class Wall implements Structure {
    private List<Block> blocks;

    // Method creates iterator on the list of blocks and loops through it.
    // When match in color is found, the loop stops by setting the "found" flag,
    // then proceeds to return the last iterated block.
    // When no match found, method returns optionals "empty()" value.
    public Optional<Block> findBlockByColor(String color) {
        ListIterator<Block> blocksIterator = blocks.listIterator();
        boolean found = false;

        while(blocksIterator.hasNext() && !found) {
            if(blocksIterator.next().getColor() == color)
                found = true;
        }

        if(found == true)
            return Optional.ofNullable(blocksIterator.previous()); // Has to go back 1 index because of "next()" in if statement
        else
            return Optional.empty();

    }

    // Method creates iterator on the list of blocks and loops through it.
    // Everytime match in material is found, the last matched block is added to list of matching blocks.
    // Method returns an array list, which may be empty if no matches found.
    public List<Block> findBlocksByMaterial(String material) {
        ArrayList<Block> matchingBlocks = new ArrayList<Block>();
        ListIterator<Block> blocksIterator = blocks.listIterator();

        while(blocksIterator.hasNext()) {
            if(blocksIterator.next().getMaterial() == material)
                matchingBlocks.add(blocksIterator.previous());
        }

        return matchingBlocks;
    }

    // Method creates iterator on the list of blocks and loops through it,
    // increasing the counter on every element. Then returns the counter.
    public int count() {
        ListIterator<Block> blocksIterator = blocks.listIterator();
        int blocksCount=0;
        while (blocksIterator.hasNext())
            blocksCount++;

        return blocksCount;
    }
}