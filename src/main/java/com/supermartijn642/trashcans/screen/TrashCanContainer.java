package com.supermartijn642.trashcans.screen;

import com.supermartijn642.core.gui.TileEntityBaseContainer;
import com.supermartijn642.trashcans.TrashCanTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.math.BlockPos;

/**
 * Created 7/11/2020 by SuperMartijn642
 */
public abstract class TrashCanContainer extends TileEntityBaseContainer<TrashCanTile> {

    public final int width, height;

    public TrashCanContainer(ContainerType<?> type, int id, PlayerEntity player, BlockPos pos, int width, int height){
        super(type, id, player, player.level, pos);
        this.width = width;
        this.height = height;

        this.addSlots();
        this.addPlayerSlots();
    }

    private void addPlayerSlots(){
        // player
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 9; column++){
                this.addSlot(new Slot(this.player.inventory, row * 9 + column + 9, 21 + 18 * column, this.height - 82 + 18 * row));
            }
        }

        // hot bar
        for(int column = 0; column < 9; column++)
            this.addSlot(new Slot(this.player.inventory, column, 21 + 18 * column, this.height - 24));
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn){
        return true;
    }

    @Override
    public TrashCanTile getObjectOrClose(){
        return super.getObjectOrClose();
    }

    public BlockPos getTilePos(){
        return this.tilePos;
    }
}
