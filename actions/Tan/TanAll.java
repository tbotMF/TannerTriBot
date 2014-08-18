package scripts.actions.Tan;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.Globals;
import scripts.sbf.action.Action;
import scripts.sbf.skill.SkillGlobals;

public class TanAll extends Action {

	@Override
	public void execute() {
		RSInterface productInterface = Interfaces.get(
				skillManager.getMasterIndex(), skillManager.getChildIndex());
		if (productInterface != null)
			if (productInterface.click("Tan All"))
				if (!Timing.waitCondition(new Condition() {

					@Override
					public boolean active() {
						General.sleep(10, 20);
						return Interfaces.get(skillManager.getMasterIndex()) == null;
					}

				}, General.random(2000, 3000)))
					return;
		SkillGlobals.ARRIVED_AT_DEPOSITORY.setStatus(false);

	}

	@Override
	public boolean isValid() {
		return Globals.TAN_ALL.getStatus();
	}

}
