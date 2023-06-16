package org.example;

import java.util.List;
import java.util.Optional;
import java.util.ListIterator;

public class Wall implements Structure {
    private List<Block> blocks;

    public Optional<Block> findBlockByColor(String color) {
        boolean found = false;
        List<Block> blocksList = CompositeBlock.getBlocks();
        ListIterator<Block> blockListIterator = blocksList.listIterator();

        while(blockListIterator.hasNext() && !found) {
            if(blockListIterator.next().getColor() == color)
                found = true;
        }
        
        if(found == true)
            return Optional.ofNullable(blockListIterator.previous());
        else
            return Optional.empty();

    }

    public List<Block> findBlocksByMaterial(String material) {

        return null;
    }

    public int count() {
        return 0;
    }
}