package com.lord.titanicworkbench.blocks;

import com.lord.titanicworkbench.MyMod;
import com.lord.titanicworkbench.tileentity.TileEntityTitanicWorkbench;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTitanicWorkbench extends BlockContainer {

    public BlockTitanicWorkbench() {
        super(Material.WOOD);
        setHardness(2.5F);
        setTranslationKey("titanic_workbench");
        setRegistryName(MyMod.MODID, "titanic_workbench");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTitanicWorkbench();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(MyMod.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
}