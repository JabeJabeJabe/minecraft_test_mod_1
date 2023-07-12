package net.milos.testmod1.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SixtyNineBallItem extends Item {

    public SixtyNineBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player,
                                                  InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND){
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 9);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()){
            components.add(Component.literal("Use this to get a random number xD (something good if you get a good number)"));
        } else {
            components.add(Component.literal("Press SHIFT for mor info")
                    .withStyle(ChatFormatting.STRIKETHROUGH).withStyle(ChatFormatting.DARK_GREEN));
        }
        super.appendHoverText(stack, level, components, flag);
    }

    private void outputRandomNumber(Player player){
        int randomnumber = getRandomNumber();
        if (randomnumber == 69){
            player.sendSystemMessage(Component.literal("leeejjjj dobio si "+ randomnumber));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 10));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 10));
        }
        else {
            player.sendSystemMessage(Component.literal("Your number is "+ randomnumber));
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 10));

        }
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(1, 70);
    }
}
