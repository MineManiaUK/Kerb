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

package com.github.kerbity.kerb.event;

import com.github.kerbity.kerb.indicator.Cancellable;
import com.github.kerbity.kerb.packet.event.Event;
import org.jetbrains.annotations.NotNull;

public class CompletableTest extends Event implements Cancellable<CompletableTest> {

    boolean cancelled = false;

    @Override
    public @NotNull CompletableTest setCancelled(boolean isCancelled) {
        this.cancelled = isCancelled;
        return this;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}
