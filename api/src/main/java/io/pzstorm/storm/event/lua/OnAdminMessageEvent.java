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

package io.pzstorm.storm.event.lua;

/**
 * Triggers when a player receives an admin message.
 */
@SuppressWarnings({ "WeakerAccess", "unused" })
public class OnAdminMessageEvent implements LuaEvent {

	public final String message;
	public final Integer var1, var2, var3;

	public OnAdminMessageEvent(String message, Integer var1, Integer var2, Integer var3) {

		this.message = message;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}
}
