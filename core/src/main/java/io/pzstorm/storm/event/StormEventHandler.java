/*
 * Zomboid Storm - Java modding toolchain for Project Zomboid
 * Copyright (C) 2021 Matthew Cain
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.pzstorm.storm.event;

import io.pzstorm.storm.event.lua.LuaEvent;
import io.pzstorm.storm.event.lua.OnGameWindowInitEvent;
import se.krka.kahlua.j2se.KahluaTableImpl;
import se.krka.kahlua.vm.KahluaTable;
import zombie.core.Core;
import zombie.ui.TextManager;
import zombie.ui.UIFont;

/**
 * This class responds to all events needed for Storm to implement custom features.
 * Note that not all functionality implementations that are weaved into game bytecode is handled here.
 * Sometimes subscribing to events is not enough to alter game behavior and more invasive
 * actions need to be preformed, like editing or removing lines from game code.
 */
@SuppressWarnings("unused")
public class StormEventHandler {

	@SubscribeEvent
	public static void handleUIElementRenderEvent(OnUIElementPreRenderEvent event) {

		if (event.element.Parent != null)
		{
			KahluaTable table = event.element.Parent.table;
			if (table instanceof KahluaTableImpl)
			{
				Object internal = ((KahluaTableImpl) table).delegate.get("internal");
				if (internal instanceof String && internal.equals("VERSIONDETAIL"))
				{
					String text = "Storm version 0.1.1-alpha";
					TextManager.instance.DrawString(UIFont.Small, Core.width - 235.0,
							Core.height - 50.0, text, 1.0, 1.0, 1.0, 0.7);
				}
			}
		}
	}

	@SubscribeEvent
	public static void handleLuaEventTrigger(OnTriggerLuaEvent event) {

		LuaEvent luaEvent = LuaEventFactory.constructLuaEvent(
				event.luaEvent.name, event.args.toArray(new Object[0])
		);
		StormEventDispatcher.dispatchEvent(luaEvent);
	}
	@SubscribeEvent
	public static void handleOnGameWindowInit(OnGameWindowInitEvent event) {
	}
}
