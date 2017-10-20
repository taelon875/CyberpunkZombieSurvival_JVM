package Feat;

import Common.IScriptEventHandler;
import NWNX.NWNX_Events;
import GameSystems.CombatSystem;
import org.nwnx.nwnx2.jvm.NWObject;

@SuppressWarnings("UnusedDeclaration")
public class ChangeGunAmmo implements IScriptEventHandler {
    @Override
    public void runScript(NWObject objSelf) {
        CombatSystem combatSystem = new CombatSystem();
        NWObject oWeapon = NWNX_Events.GetEventItem();
        combatSystem.ChangeGunAmmoPriority(oWeapon);
    }
}
