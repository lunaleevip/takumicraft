package com.tntmodders.takumi.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;

public class EntityAIZombieCreeperSwell extends EntityAIBase {

    /**
     * The creeper that is swelling.
     */
    EntityCreeper swellingCreeper;
    /**
     * The creeper's attack target. This is used for the changing of the creeper's state.
     */
    EntityLivingBase creeperAttackTarget;

    public EntityAIZombieCreeperSwell(EntityCreeper entitycreeperIn) {
        this.swellingCreeper = entitycreeperIn;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getCreeperState() > 0 ||
                entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 25.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    @Override
    public void resetTask() {
        this.creeperAttackTarget = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    @Override
    public void updateTask() {
        if (this.creeperAttackTarget == null) {
            this.swellingCreeper.setCreeperState(-1);
        } else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D) {
            this.swellingCreeper.setCreeperState(-1);
        } else {
            this.swellingCreeper.setCreeperState(1);
        }
    }
}