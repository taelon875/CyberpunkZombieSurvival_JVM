package Abilities.Crafting;

import Abilities.IAbility;
import org.nwnx.nwnx2.jvm.NWObject;

public class ToolExpertMining implements IAbility {
    @Override
    public boolean CanCastSpell(NWObject oPC) {
        return false;
    }

    @Override
    public String CannotCastSpellMessage() {
        return null;
    }

    @Override
    public int ManaCost(NWObject oPC, int baseManaCost) {
        return baseManaCost;
    }

    @Override
    public float CastingTime(NWObject oPC, float baseCastingTime) {
        return baseCastingTime;
    }

    @Override
    public float CooldownTime(NWObject oPC, float baseCooldownTime) {
        return baseCooldownTime;
    }


    @Override
    public void OnImpact(NWObject oPC, NWObject oTarget) {
    }

    @Override
    public void OnEquip(NWObject oPC) {
    }

    @Override
    public void OnUnequip(NWObject oPC) {
    }

    @Override
    public boolean IsHostile() {
        return false;
    }
}
