/*
 * Copyright (c) 2020, Rían Errity. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.

 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).

 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Rían Errity <rian@paradaux.io> or visit https://paradaux.io
 * if you need additional information or have any questions.
 * See LICENSE.md for more details.
 */

package io.paradaux.csbot.listeners;

import io.paradaux.csbot.api.ConfigurationCache;
import io.paradaux.csbot.api.EmailUtils;
import io.paradaux.csbot.api.Logging;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

/**
 * This event handles the parsing of email addresses within the listener channel, and calls for verification emails to be sent.
 *
 * @author Rían Errity
 * @version Last modified for 0.1.0-SNAPSHOT
 * @since 1/11/2020 DD/MM/YY
 * @see io.paradaux.csbot.CSBot
 * */

public class MessageReceivedListener extends ListenerAdapter {

    ConfigurationCache configurationCache;
    Logger logger;

    public MessageReceivedListener(ConfigurationCache configurationCache) {
        this.configurationCache = configurationCache;
        logger = Logging.getLogger();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        EmailUtils emailutils = new EmailUtils();

        if (!event.getChannel().getId().equals(configurationCache.getListeningChannel())) return;

        Message message = event.getMessage();
        message.delete().queue();
        String email = message.getContentRaw();

        if (!emailutils.isValidEmail(email)) {
            event.getAuthor().openPrivateChannel().queue((channel) -> {
                channel.sendMessage("Your message did not contain an email.").queue();
            });

            return;
        }

        if (!emailutils.getEmailDomain(email).equalsIgnoreCase("tcd.ie")) {
            event.getAuthor().openPrivateChannel().queue((channel) -> {
                channel.sendMessage("The provided email must be of the tcd.ie domain. If you are not a trinity student, please contact a moderator for manual verification").queue();
            });

            return;
        };

        event.getAuthor().openPrivateChannel().queue((channel) -> {
            channel.sendMessage("Please check your email for a verification token. Once you have it, please paste it into this private message channel.").queue();
        });


    }
}
