package Helper;

import Common.IScriptEventHandler;
import org.nwnx.nwnx2.jvm.NWObject;
import org.nwnx.nwnx2.jvm.Scheduler;

public class ScriptHelper {

    public static void RunJavaScript(NWObject target, String className)
    {
        try
        {
            Class scriptClass = Class.forName(className);
            IScriptEventHandler script = (IScriptEventHandler)scriptClass.newInstance();
            script.runScript(target);
            Scheduler.flushQueues();
        }
        catch (Exception ex)
        {
            ErrorHelper.HandleException(ex, "Unable to execute class method: " + className + ".runScript()");
        }
    }

}
