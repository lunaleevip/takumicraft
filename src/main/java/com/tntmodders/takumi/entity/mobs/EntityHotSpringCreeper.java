package com.tntmodders.takumi.entity.mobs;

import com.tntmodders.takumi.core.TakumiBlockCore;
import com.tntmodders.takumi.entity.EntityTakumiAbstractCreeper;
import com.tntmodders.takumi.utils.TakumiUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHotSpringCreeper extends EntityTakumiAbstractCreeper {
    public EntityHotSpringCreeper(World worldIn) {
        super(worldIn);
    }

    @Override
    public void takumiExplode() {
        int range = this.getPowered() ? 6 : 2;
        for (int x = ((int) this.posX) - range; x < ((int) this.posX) + range; x++) {
            for (int y = ((int) this.posY) - range; y < ((int) this.posY) + range; y++) {
                for (int z = ((int) this.posZ) - range; z < ((int) this.posZ) + range; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if (TakumiUtils.takumiGetHardness(this.world.getBlockState(pos).getBlock()) != -1) {
                        this.world.setBlockState(pos, TakumiBlockCore.HOT_SPRING.getDefaultState());
                    }
                }
            }
        }
    }

    @Override
    public EnumTakumiRank takumiRank() {
        return EnumTakumiRank.LOW;
    }

    @Override
    public EnumTakumiType takumiType() {
        return EnumTakumiType.WATER;
    }

    @Override
    public int getExplosionPower() {
        return 0;
    }

    @Override
    public int getSecondaryColor() {
        return 16777215;
    }

    @Override
    public boolean isCustomSpawn() {
        return false;
    }

    @Override
    public String getRegisterName() {
        return "hotspringcreeper";
    }

    @Override
    public int getRegisterID() {
        return 13;
    }
}
