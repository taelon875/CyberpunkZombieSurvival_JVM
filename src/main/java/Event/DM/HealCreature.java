package Event.DM;

import Common.IScriptEventHandler;
import NWNX.NWNX_Events;
import org.nwnx.nwnx2.jvm.NWEffect;
import org.nwnx.nwnx2.jvm.NWObject;
import org.nwnx.nwnx2.jvm.NWScript;
import org.nwnx.nwnx2.jvm.constants.DurationType;

@SuppressWarnings("unused")
public class HealCreature implements IScriptEventHandler {
    @Override
    public void runScript(NWObject objSelf) {

        NWNX_Events.BypassEvent();
        NWObject oTarget = NWNX_Events.GetEventTarget();
        int health = NWScript.getMaxHitPoints(oTarget);
        NWEffect effect = NWScript.effectHeal(health);
        NWScript.applyEffectToObject(DurationType.INSTANT, effect, oTarget, 0.0f);

    }
}