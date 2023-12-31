/*
 * Kerb
 * Event and request distributor server software.
 *
 * Copyright (C) 2023  Smuddgge
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.kerbity.kerb.event.event;

import com.github.kerbity.kerb.client.registeredclient.RegisteredClient;
import com.github.kerbity.kerb.client.registeredclient.RegisteredClientAdapter;
import com.github.kerbity.kerb.event.SettableEvent;

/**
 * Represents a simple ping event.
 * This is used as an example.
 */
public class PingEvent extends SettableEvent<RegisteredClientAdapter> {
}
