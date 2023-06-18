package org.example;

import java.util.List;
import java.util.Optional;
import java.util.ListIterator;

public class Wall implements Structure {
    private List<Block> blocks;

    public Optional<Block> findBlockByColor(String color) {
        boolean found = false;
        List<Block> allBlocks = CompositeBlock.getBlocks();
        ListIterator<Block> allBlocksIterator = allBlocks.listIterator();

        while(allBlocksIterator.hasNext() && !found) {
            if(allBlocksIterator.next().getColor() == color)
                found = true;
        }

        if(found == true)
            return Optional.ofNullable(allBlocksIterator.previous()); // Have to go back 1 index because of ".next" in if statement
        else
            return Optional.empty();

    }

    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new List<Block>();

        List<Block> allBlocks = CompositeBlock.getBlocks();
        ListIterator<Block> allBlocksIterator = allBlocks.listIterator();

        while(allBlocksIterator.hasNext()) {
            if(allBlocksIterator.next().getMaterial() == material)
                matchingBlocks.add(allBlocksIterator.previous());
        }

        return matchingBlocks;
    }

    public int count() {
        return 0;
    }
}