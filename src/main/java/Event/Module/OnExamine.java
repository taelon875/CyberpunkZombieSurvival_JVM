package Event.Module;

import Common.IScriptEventHandler;
import GameSystems.DurabilitySystem;
import GameSystems.MagicSystem;
import NWNX.NWNX_Events;
import org.nwnx.nwnx2.jvm.NWObject;
import org.nwnx.nwnx2.jvm.NWScript;

public class OnExamine implements IScriptEventHandler {
    @Override
    public void runScript(NWObject examiner) {
        NWObject examinedObject = NWNX_Events.OnExamineObject_GetTarget();

        String description = "";
        description = MagicSystem.OnModuleExamine(description, examiner, examinedObject);
        description = DurabilitySystem.OnModuleExamine(description, examinedObject);

        if(description.equals("")) return;
        NWScript.setDescription(examinedObject, description, false);
        NWScript.setDescription(examinedObject, description, true);
    }
}
