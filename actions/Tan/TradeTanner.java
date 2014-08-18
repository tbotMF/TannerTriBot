package scripts.actions.Tan;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;

import scripts.Globals;
import scripts.sbf.action.Action;

public class TradeTanner extends Action {

	@Override
	public void execute() {
		RSNPC[] tanner = NPCs.find("Ellis", "Sbott");

		if (tanner.length > 0 && tanner[0] != null
				&& DynamicClicking.clickRSNPC(tanner[0], "Trade"))
			Timing.waitCondition(new Condition() {

				@Override
				public boolean active() {
					General.sleep(100, 200);
					return Interfaces.get(skillManager.getMasterIndex()) != null;
				}
			}, General.random(5000, 6000));

	}

	@Override
	public boolean isValid() {
		return Globals.TRADE_TANNER.getStatus();
	}

}
