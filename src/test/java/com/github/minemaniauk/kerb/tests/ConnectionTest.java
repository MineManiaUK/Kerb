/*
 * Kerb
 * Event and request distributor server software.
 *
 * Copyright (C) 2023  MineManiaUK Staff
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

package com.github.minemaniauk.kerb.tests;

import com.github.minemaniauk.developertools.testing.ResultChecker;
import com.github.minemaniauk.kerb.client.KerbClient;
import com.github.minemaniauk.kerb.client.listener.EventListener;
import com.github.minemaniauk.kerb.creator.ClientCreator;
import com.github.minemaniauk.kerb.creator.ServerCreator;
import com.github.minemaniauk.kerb.event.event.PingEvent;
import com.github.minemaniauk.kerb.server.Server;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.concurrent.atomic.AtomicBoolean;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConnectionTest {

    @Test
    @Order(0)
    public void testValidation() throws InterruptedException {
        Server server = ServerCreator.createAndStart();

        // Wait for server to load.
        Thread.sleep(1000);

        // Create a client connection.
        KerbClient client = ClientCreator.create(server.getPort(), server.getAddress());
        client.connect();

        // Wait for validation.
        Thread.sleep(1000);

        new ResultChecker()
                .expect(client.isValid());
    }

    @Test
    @Order(0)
    public void testPingEvent() throws InterruptedException {
        Server server = ServerCreator.createAndStart();

        // Wait for server to load.
        Thread.sleep(1000);

        // Create a client connection.
        KerbClient client = ClientCreator.create(server.getPort(), server.getAddress());
        client.connect();

        // Wait for validation.
        Thread.sleep(1000);

        // Set up the flag.
        AtomicBoolean flag = new AtomicBoolean(false);

        // Set up an event listener for the ping event.
        client.registerListener((EventListener<PingEvent>) event -> {
            flag.set(true);
        });

        // Call the ping event.
        client.callEvent(new PingEvent("Test"));

        // Wait for event.
        Thread.sleep(1000);

        // Expect the ping event to change the flag.
        new ResultChecker()
                .expect(flag.get());
    }
}
