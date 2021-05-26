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
 * Called when key is held down.
 *
 * @see OnKeyPressedEvent
 */
@SuppressWarnings({ "WeakerAccess", "unused" })
public class OnKeyKeepPressedEvent implements LuaEvent {

	/**
	 * <p>Integer denoting the key being held down.</p>
	 * See {@code org.lwjgl.input.Keyboard} for list of key codes.
	 */
	public final Integer key;

	public OnKeyKeepPressedEvent(Integer key) {
		this.key = key;
	}
}
