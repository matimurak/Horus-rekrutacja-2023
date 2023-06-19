package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ListIterator;

public class Wall implements Structure {
    private List<Block> blocks;

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

    public List<Block> findBlocksByMaterial(String material) {
        ArrayList<Block> matchingBlocks = new ArrayList<Block>();
        ListIterator<Block> blocksIterator = blocks.listIterator();

        while(blocksIterator.hasNext()) {
            if(blocksIterator.next().getMaterial() == material)
                matchingBlocks.add(blocksIterator.previous());
        }

        return matchingBlocks;
    }

    public int count() {
        return 0;
    }
}